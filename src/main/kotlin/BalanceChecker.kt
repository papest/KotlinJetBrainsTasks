import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    var balance = readln().toInt()
    var payments = 0
    while (sc.hasNextInt()) {
        val payment = sc.nextInt()
        if ((balance - payment) > -1) {
            balance -= payment
            continue
        }
        payments = payment
        break
    }
    println(payments)
    println(if (payments > 0) "Error, insufficient funds for the purchase. Your balance is $balance, but you need $payments." else "Thank you for choosing us to manage your account! Your balance is $balance.")

}