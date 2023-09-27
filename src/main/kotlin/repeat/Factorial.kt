package repeat

import java.math.BigInteger

fun factorial(n: Int): BigInteger = if (n == 0) BigInteger.ONE else BigInteger.valueOf(n.toLong()) * factorial(n - 1)
