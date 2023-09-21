@Target(AnnotationTarget.FILE, AnnotationTarget.LOCAL_VARIABLE)
annotation class Null

@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class Get(val parameter: String)

@Repeatable
annotation class Schedule(val time: String)

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.EXPRESSION)
annotation class Special(val why: String)