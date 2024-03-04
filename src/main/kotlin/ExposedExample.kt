import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object Cities : Table() {
    private val id = integer("id").autoIncrement()
    val name = varchar("name", 50)
    override val primaryKey = this.PrimaryKey(id)
}

fun main() {
    Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver")
    transaction {
        SchemaUtils.create(Cities)
        Cities.insert {
            it[name] = "Prague"
        }
        val result = Cities.selectAll()
        result.forEach { println(it) }
    }
}
