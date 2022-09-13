import validate

fun main() {
    println("Enter an equation (like a + b = c): ")
    val eqInput = readln()
    println(validate(eqInput))
}