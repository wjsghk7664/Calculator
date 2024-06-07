package com.example.calculator

import java.util.Stack

/*
fun main() {
    var tmp=""
    var num1:Int
    var num2:Int
    var op:String
    val cal=Calculator()
    println("숫자를 입력하세요")
    num1= readLine()!!.toInt()
    do {
        op="0"
        while(op=="0"){
            println("원하는 연산을 입력하세요(1 +, 2 -, 3 *, 4 /, 5 %, -1 종료). ")
            op= readLine().toString()
            op=when(op){
                "1" -> "+"
                "2" -> "-"
                "3" -> "*"
                "4" -> "/"
                "5" -> "%"
                "-1" -> "종료"
                else -> "0"
            }
            if(op=="0"){
                println("잘못된 입력입니다.")
            }
        }
        if(op=="종료") break

        println("숫자를 입력하세요")
        num2= readLine()!!.toInt()

        num1=cal.operation(num1, num2, op)
        println("결과:${num1}")

    }while(true)
    println("종료되었습니다.")
}
*/


//아래는 최종형태

fun main(){
    while(true){
        println("수식을 입력해 주세요(종료하려면 -1입력)")
        var exp= readLine().toString()
        if(exp=="-1"){
            break
        }
        val calculator=Calculator()
        println("결과: ${calculator.calculation(exp)}")
    }
    println("종료되었습니다")
}