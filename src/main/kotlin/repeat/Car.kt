package repeat

interface Speed {
    fun increaseSpeed()
    fun decreaseSpeed()
}

interface Fuel {
    fun consumeFuel()
    fun addFuel()
}

class SpeedHandler(private val car: Car) : Speed {
    override fun increaseSpeed() {
        car.speed += 10
    }

    override fun decreaseSpeed() {
        if (car.speed - 10 >= 0) {
            car.speed -= 10
        } else {
            car.speed = 0
        }
    }
}

class FuelHandler(private val car: Car) : Fuel {
    override fun consumeFuel() {
        if (car.fuel - 5 >= 0) {
            car.fuel -= 5
        } else {
            car.fuel = 0
        }
    }

    override fun addFuel() {
        if (car.fuel + 10 <= 100) {
            car.fuel += 10
        } else {
            car.fuel = 100
        }
    }
}

class Car(var speed: Int, var fuel: Int) : Fuel, Speed {

    val speedDelegate = SpeedHandler(this)
    val fuelDelegate = FuelHandler(this)

    override fun increaseSpeed() {
        speedDelegate.increaseSpeed()
    }

    override fun decreaseSpeed() {
        speedDelegate.decreaseSpeed()
    }

    override fun consumeFuel() {
        fuelDelegate.consumeFuel()
    }

    override fun addFuel() {
        fuelDelegate.addFuel()
    }
}