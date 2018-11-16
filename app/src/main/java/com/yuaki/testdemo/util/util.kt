package com.yuaki.testdemo.util

import java.lang.NumberFormatException
import java.math.BigInteger


fun isNumber(str:String):Boolean{


    try {
        val a = str.toBigInteger() //Integer.parseInt(str)
        return true
    }catch (ex : NumberFormatException) {
        return false
    }

}

