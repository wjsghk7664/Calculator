package com.example.calculator

import java.util.*

class Calculator() {
    val add=AddOperation()
    val sub=SubstractOperation()
    val mul=MultiplyOperation()
    val div=DivideOperation()

    fun operation(num1:Int,num2:Int,op:String):Int{
        if(op=="%"){
            return num1%num2
        }
        else{
            val obj=when(op){
                "+" ->add
                "-" ->sub
                "*" ->mul
                else -> div
            }
            return obj.operation(num1, num2)
        }
    }

    fun postfix(exp:String):Array<Any>{
        val stack= Stack<String>()
        var arr= arrayOf<Any>()

        var order=mapOf<String,Int>("(" to 0,"+" to 1, "-" to 1, "*" to 2, "/" to 2, "%" to 2)

        //수식을 피연산자와 연산자들의 배열로 변환
        val oplist=arrayOf<String>("+","-","*","/","%","(",")")
        val expArr=exp.toCharArray()
        var explist= arrayOf<String>()
        var tmp=StringBuilder()
        for(i in expArr){
            val tmpi=i.toString()
            if(oplist.contains(tmpi)){
                if(!tmp.isEmpty()){
                    explist+=tmp.toString()
                    tmp.clear()
                }
                explist+=tmpi
            }
            else{
                tmp.append(i)
            }
        }
        //마지막 남은 숫자들 있으면 추가
        if(!tmp.isEmpty()){
            explist+=tmp.toString()
        }



        for(i in explist){
            if(oplist.contains(i)){
                if(stack.empty()){
                    stack.push(i)
                }else if(i=="("){
                    stack.push(i)
                }
                else if(i==")"){
                    while(stack.peek()!="("){
                        arr+=stack.pop()
                    }
                    stack.pop()
                }
                else if(order[stack.peek()]!!>=order[i]!!){
                    while (order[stack.peek()]!!>=order[i]!!){
                        arr+=stack.pop()
                        if(stack.isEmpty()){
                            break
                        }
                    }
                    stack.push(i)
                }
                else{
                    stack.push(i)
                }
            }
            else{
                arr+=i.toInt()
            }
        }
        while(!stack.empty()){
            arr+=stack.pop()
        }
        return arr
    }

    fun calculation(s:String):Int{
        var stack= Stack<Int>()
        val arg=postfix(s)

        for(i in arg){
            if(i is Int){
                stack.push(i)
            }
            else{
                val post=stack.pop()
                val pre=stack.pop()
                stack.push(operation(pre,post, i as String))
            }
        }
        return stack.pop()
    }


}