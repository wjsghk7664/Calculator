package com.example.calculator

class MultiplyOperation():AbstractOperation() {
    override fun operation(num1:Int, num2:Int): Int {
        return num1*num2
    }
}