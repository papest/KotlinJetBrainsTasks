package repeat

import Orders.entityId
import initDatabase
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object Users : IntIdTable() {
    val name = varchar("name", 50)
}

object Orders : IntIdTable() {
    val user = reference("user", Users)
}

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var name by Users.name
    val orders by Order referrersOn Orders.user
    override fun toString(): String {
        return "User(id=${id} name='$name')"
    }

}

class Order(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Order>(Orders)

    var user by User referencedOn Orders.user
    override fun toString(): String {
        return "Order(id=$id, user='$user)"
    }

}

fun main() {
    initDatabase()
    transaction {
        SchemaUtils.create(Users)
        SchemaUtils.create(Orders)
        val user1 = User.new { name = "Kathy"}
        println(user1)
        Order.new { user = user1}
        Order.new { user = user1}
        val orders = user1
            .orders
            .toList()
        println(orders)
        Order
            .find { Orders.user.entityId() eq user1.id }
            .toList()
            .let { println(it) }
        User
            .findById(1)?.orders
            .run { println(orders) }
        println(User[1].orders.toList())
        User.forEntityIds(listOf(user1.id))
            .toList()
            .forEach {println(it.orders.toList())}
    }
}
