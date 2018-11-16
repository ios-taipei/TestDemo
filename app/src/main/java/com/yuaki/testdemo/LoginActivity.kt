package com.yuaki.testdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.yuaki.testdemo.util.isNumber


class LoginActivity : Activity() {

    private var emailEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var errorView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login)

        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)

        val submitButton = findViewById<View>(R.id.submit)
        submitButton.setOnClickListener {
            validateFields()

            if (emailEditText!!.error == null && passwordEditText!!.error == null) {
                validateAccount()
            }
        }

        findViewById<View>(R.id.signup).setOnClickListener {
            val intent = Intent(this@LoginActivity, SignupActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }


    }

    private fun validateFields() {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailEditText!!.text.toString()).matches()) {
            emailEditText!!.error = getString(R.string.msg_email_error)
        } else {
            emailEditText!!.error = null
        }

        if (passwordEditText!!.text.toString().isEmpty()) {
            passwordEditText!!.error = getString(R.string.msg_password_error)
        } else {
            passwordEditText!!.error = null
        }
    }

    private fun validateAccount() {
        if (errorView == null) {
            errorView = findViewById(R.id.error)
        }

        if (emailEditText!!.text.toString() != Test_EMAIL || passwordEditText!!.text.toString() != Test_PASSWORD) {
            errorView!!.visibility = View.VISIBLE
        } else {
            errorView!!.visibility = View.GONE
        }

    }

    companion object {
        private val Test_EMAIL = "yuaki@yuaki.com"
        private val Test_PASSWORD = "thisisreallypassword"
    }
}