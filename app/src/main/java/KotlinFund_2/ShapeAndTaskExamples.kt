package KotlinFund_2

abstract class Shape {
    abstract fun area(): Double
}

class Circle(private val radius: Double) : Shape() {
    override fun area(): Double = Math.PI * radius * radius
}

class Rect(private val width: Double, private val height: Double) : Shape() {
    override fun area(): Double = width * height
}

enum class Pririty {
    Low,
    Medium,
    High
}

data class Task(val title: String, val priority: Pririty)

fun demonstrateStudentShapesAndTasks() {
    Student(name = "Armend", grade = 10).printSummary()

    val shapes: List<Shape> = listOf(Circle(radius = 5.0), Rect(width = 4.0, height = 6.0))
    shapes.forEach { shape ->
        println("Area: ${shape.area()}")
    }

    val tasks = listOf(
        Task(title = "Review notes", priority = Pririty.Low),
        Task(title = "Finish assignment", priority = Pririty.High),
        Task(title = "Prepare presentation", priority = Pririty.Medium),
        Task(title = "Submit project", priority = Pririty.High)
    )

    tasks.filter { it.priority == Pririty.High }
        .forEach { task -> println(task.title) }

    tasks.groupBy { it.priority }
        .forEach { (priority, groupedTasks) -> println("$priority: ${groupedTasks.size}") }
}
