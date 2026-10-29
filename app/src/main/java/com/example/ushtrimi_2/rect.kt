package com.example.ushtrimi_2

class Rect(
    private val width: Double,
    private val height: Double
) : Shape() {
    override fun area(): Double {
        return width * height
    }
}