fun main() {
    val numRooms = readln().toInt()
    val scareFactor = hauntedHouseTour(numRooms)
    println("Scare Factor: $scareFactor")
}

// Function to simulate haunted house tour
// Calculate and return the total scare factor
fun hauntedHouseTour(
    numRooms: Int, ghosts: Int = 30, multiplier: Int = 1
    // Add parameters with default values for ghosts per room and special effects multiplier
) = numRooms * ghosts * multiplier