annotation class NoTesting
annotation class Delete

class LocalData(@get:NoTesting @get:Delete var data: String)
