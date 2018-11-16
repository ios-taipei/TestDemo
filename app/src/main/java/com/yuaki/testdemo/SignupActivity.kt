package com.yuaki.testdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import java.lang.Integer.parseInt
import java.lang.NumberFormatException


class SignupActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.signup)

        findViewById<View>(R.id.login).setOnClickListener {
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }



}
