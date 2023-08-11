class Friend {
    internal val name = "Anna"

}

open class Friend1 {
    protected fun greeting(name: String) = "Hello $name"
}

open class Friend2 {
    protected val name = "Anna"
}

class Friend3 {
    private val name = "Anna"
}

class Friend4 private constructor() {
    private var name: String = "Alex"

    constructor(name: String) : this() {
        this.name = name
    }
}