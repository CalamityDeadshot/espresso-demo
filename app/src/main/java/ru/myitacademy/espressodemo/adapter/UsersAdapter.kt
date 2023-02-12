package ru.myitacademy.espressodemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import ru.myitacademy.espressodemo.R
import ru.myitacademy.espressodemo.model.User

class UsersAdapter(
    val dataSet: List<User>,
    val onPhoneActionClick: (User) -> Unit
): RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val teaches: TextView
        val callButton: AppCompatImageButton

        init {
            name = itemView.findViewById(R.id.name)
            teaches = itemView.findViewById(R.id.teaches)
            callButton = itemView.findViewById(R.id.button_call)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.user_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = dataSet[position].name
        holder.teaches.text = dataSet[position].teaches.joinToString(
            prefix = "Преподаватель "
        )
        holder.callButton.apply {
            setOnClickListener {
                onPhoneActionClick(dataSet[position])
            }
            contentDescription = "Call ${dataSet[position].name}"
        }
    }

    override fun getItemCount(): Int = dataSet.size
}