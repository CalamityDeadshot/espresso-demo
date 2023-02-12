package ru.myitacademy.espressodemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ru.myitacademy.espressodemo.adapter.UsersAdapter
import ru.myitacademy.espressodemo.model.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.users_rv)
        val usersAdapter = UsersAdapter(
            dataSet = listOf(
                User(
                    name = "Пьянков Семён Александрович",
                    teaches = listOf("Kotlin")
                ),
                User(
                    name = "Запорожских Александр Игоревич",
                    teaches = listOf("Java")
                ),
                User(
                    name = "Степанов Павел Валериевич",
                    teaches = listOf("Kotlin, Java")
                )
            ),
            onPhoneActionClick = {
                Snackbar.make(recyclerView, "Сalling ${it.name}", Snackbar.LENGTH_LONG).show()
            }
        )
        recyclerView.apply {
            adapter = usersAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}