package com.example.tasky.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tasky.model.Task
import com.example.tasky.databinding.ListItemBinding

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TodoViewHolder>() {
    private val taskList = ArrayList<Task>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return TodoViewHolder(binding)
    }
    override fun getItemCount(): Int = taskList.size
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val task = taskList[position]
        holder.run{
            textTask.text = task.title
            check.isChecked = task.completed
        }
    }
    inner class TodoViewHolder(binding: ListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
            val textTask: TextView = binding.tvTitle
            val check: CheckBox = binding.checkDone
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setTaskList(taskList:List<Task>)  {
        this.taskList.addAll(taskList)
        notifyDataSetChanged()
    }
}