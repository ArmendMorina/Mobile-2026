package practice_1

import kotlin.math.PI

// 1. Student(name, grade) with a summary method
class Student(val name: String, val grade: Int) {
    fun printSummary() {
        println("Student: $name, grade: $grade")
    }
}

// 2. Abstract class Shape with Circle and Rect
abstract class Shape {
    abstract fun area(): Double
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double = PI * radius * radius
}

class Rect(val width: Double, val height: Double) : Shape() {
    override fun area(): Double = width * height
}

// 3. Enum class Priority and data class Task
enum class Priority { LOW, MEDIUM, HIGH }

data class Task(val title: String, val priority: Priority)

fun runPractice() {
    // 1
    Student("Armend", 10).printSummary()

    // 2
    val shapes: List<Shape> = listOf(Circle(2.0), Rect(3.0, 4.0))
    shapes.forEach { println("${it::class.simpleName} area: ${it.area()}") }

    // 4
    val tasks: List<Task> = listOf(
        Task("Write report", Priority.HIGH),
        Task("Buy milk", Priority.LOW),
        Task("Fix bug", Priority.HIGH),
        Task("Call John", Priority.MEDIUM),
        Task("Read book", Priority.LOW)
    )
    tasks.filter { it.priority == Priority.HIGH }
        .forEach { println("HIGH task: ${it.title}") }

    // 5
    tasks.groupBy { it.priority }
        .forEach { (priority, group) -> println("$priority: ${group.size}") }
}
