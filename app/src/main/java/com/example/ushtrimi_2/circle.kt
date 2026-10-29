package com.example.ushtrimi_2

import kotlin.math.PI

class Circle(
    private val radius: Double
) : Shape() {
    override fun area(): Double {
        return PI * radius * radius
    }
}