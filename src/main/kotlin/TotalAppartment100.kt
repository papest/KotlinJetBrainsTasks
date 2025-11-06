class John {
    class JohnApartment(sizeOfRoom: Int) {
        val size: Int = sizeOfRoom
    }
}

class Nick {
    class NickApartment(sizeOfRoom: Int) {
        val size: Int = sizeOfRoom
    }
}

typealias NickArea = Nick.NickApartment
typealias JohnArea = John.JohnApartment

fun findTotalArea(): Int {
    return JohnArea(40).size + NickArea(60).size
}