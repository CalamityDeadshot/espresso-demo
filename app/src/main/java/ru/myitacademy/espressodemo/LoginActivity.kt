package ru.myitacademy.espressodemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginEditText = findViewById<EditText>(R.id.login_edit_text)
        val passwordEditText = findViewById<EditText>(R.id.password_edit_text)
        val repeatPasswordEditText = findViewById<EditText>(R.id.repeat_password_edit_text)

        findViewById<Button>(R.id.button_register).apply {
            setOnClickListener {
                val login = loginEditText.text.toString()
                val password = passwordEditText.text.toString()
                val repeatedPassword = repeatPasswordEditText.text.toString()

                val loginIsEmpty = login.isNotEmpty()
                val passwordIsTooShort = password.length < 8
                val passwordsMatch = repeatedPassword != password

                if (loginIsEmpty) {
                    loginEditText.error = "Login must not be empty"
                }

                if (passwordIsTooShort) {
                    passwordEditText.error = "Password must be at least 8 characters long"
                }

                if (!passwordsMatch) {
                    repeatPasswordEditText.error = "Passwords do not match"
                }

                if (!loginIsEmpty && !passwordIsTooShort && passwordsMatch) {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}