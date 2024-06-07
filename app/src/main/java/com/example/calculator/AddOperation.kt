package com.example.calculator

class AddOperation():AbstractOperation() {
    override fun operation(num1:Int, num2:Int):Int {
        return num1 + num2
    }
}