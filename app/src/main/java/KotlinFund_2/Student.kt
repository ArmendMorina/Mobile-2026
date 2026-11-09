package KotlinFund_2

class Student(val name: String, val grade: Int) {
    fun printSummary() {
        println("Student: $name, Grade: $grade")
    }
}
