package repeat

data class Item(val price: Double, val quantity: Int)

class ShoppingCart {
    private val items = mutableListOf<Item>()

    fun addItem(item: Item) {
        check(item.price > 0) { "Price must be positive" }
        items.add(item)
    }

    fun calculateTax(tax: Double): Double {
        require(tax >= 0) { "Tax rate must not be negative" }
        val total = items.sumOf { it.price * it.quantity }
        val calculatedTax = total * tax

        // Use assert to verify the tax calculation
        assert(calculatedTax == total * tax) { "Error in tax calculation" }

        return calculatedTax
    }

    fun printInvoice() {
        check(items.isNotEmpty()) { "Cannot print invoice, shopping cart is empty" }
        val total = items.sumByDouble { it.price * it.quantity }
        println("Invoice:")
        items.forEach { println("Item: ${it.quantity} x $${it.price}") }
        println("Total: $${"%.2f".format(total)}")
    }
}

fun main() {
    val shoppingCart = ShoppingCart()
    shoppingCart.printInvoice()
}