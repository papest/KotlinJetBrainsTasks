package repeat

open class Circle(open var radius: Double)
class Cylinder(radius: Double = 1.0, var height: Double = 1.0) : Circle(radius)