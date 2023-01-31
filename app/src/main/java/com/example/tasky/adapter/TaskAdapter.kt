package com.example.tasky.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasky.model.Task
import com.example.tasky.databinding.ListItemBinding

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TodoViewHolder>() {
    private val taskList = ArrayList<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return TodoViewHolder(binding)
    }
    override fun getItemCount(): Int { return taskList.size }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = taskList[position]
        holder.binding.run{
            tvTitle.text = todo.title
            checkDone.isChecked = todo.completed
        }
    }

    inner class TodoViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
}