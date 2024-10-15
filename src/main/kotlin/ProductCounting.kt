class ProductCounting {
    var productCount = 0

    @Synchronized fun addProduct() {
        productCount++
    }
}
const val REPEAT_COUNT = 20
fun main() {
    with(ProductCounting()) {
        repeat(REPEAT_COUNT) {
            Thread {
                this.addProduct()
                println(this.productCount)
            }.start()
        }
    }
}
