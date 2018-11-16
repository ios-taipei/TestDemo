package com.yuaki.testdemo.test

import com.yuaki.testdemo.util.isNumber
import junit.framework.TestCase.*
import org.junit.Test

class UnitTest {

    @Test
    @Throws(Exception::class)
    fun isNumber_isCorrect() {
        assertTrue(isNumber("123"))
    }

    @Test
    @Throws(Exception::class)
    fun isNumber_isWrong() {
        assertFalse(isNumber("ABC"))
    }

    @Test
    @Throws(Exception::class)
    fun isNumber_Boundry() {
        assertTrue(isNumber("1234567890123456789012345678901234567890"))
    }

    @Test
    @Throws(Exception::class)
    fun isNumber_Decimal() {
        assertTrue(isNumber("1234567890123456789012345678901234567890.01"))
    }


}