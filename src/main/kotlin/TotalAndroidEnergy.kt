fun calculateTotalEnergy(androids: List<Android>): Int {
    var totalEnergy = 0
    check(androids.isNotEmpty()) { "List of androids cannot be empty" }


    for (android in androids) {
        require(android.energy >= 0) { "Android energy must be greater than or equal to zero" }
        totalEnergy += android.energy
    }

    return totalEnergy
}

data class Android(val id: Int, val energy: Int)

