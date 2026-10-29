package com.example.ushtrimi_2

class Student(
    val name: String,
    val grade: Double
) {
    fun printSummary() {
        println("Studenti: $name, Nota: $grade")
    }
}