import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object Books : IntIdTable() {
    val title = varchar("title", 100)
    val yearPublished = integer("yearPublished")
}

class Book(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Book>(Books)

    var title by Books.title
    var yearPublished by Books.yearPublished
}

fun addBook(title: String, yearPublished: Int) {
    transaction {
        Book.new {
            this.title = title
            this.yearPublished = yearPublished
        }
    }
}

fun getAllBooks(): List<Book> = transaction {
    Book.all().toList()
}

fun main() {
    Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;", driver = "org.h2.Driver")

    transaction {
        SchemaUtils.create(Books)
        addBook("Kotlin Programming", 2017)
        addBook("Exposed Framework Essential", 2021)
        val books = getAllBooks()
        books.forEach { book ->
            println("${book.id}: ${book.title} published in ${book.yearPublished}")
        }
    }
}

