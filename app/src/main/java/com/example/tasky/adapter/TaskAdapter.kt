package com.example.tasky.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tasky.MainActivity
import com.example.tasky.R
import com.example.tasky.model.Task
import com.example.tasky.databinding.ListItemBinding

class TaskAdapter (private val listener: MainActivity):
    RecyclerView.Adapter<TaskAdapter.TodoViewHolder>() {
    private val taskList = ArrayList<Task>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return TodoViewHolder(binding)
    }
    override fun getItemCount(): Int = taskList.size
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val task = taskList[position]
        val previousTask = if(position == 0) null else taskList[position - 1]
        holder.run{
            textTask.text = task.title
            check.isChecked = task.completed
            if(task.completed) textTask.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            if(previousTask != null && !previousTask.completed && task.completed){
                finishedLabel.visibility = View.VISIBLE
                finishedLabel.text = listener.getString(
                    R.string.finished,
                    taskList.filter {it.completed}.size
                )
                divider.visibility = View.VISIBLE
            } else { finishedLabel.visibility = View.GONE}
        }
        holder.check.setOnClickListener {
            listener.onItemClicked(taskList[holder.adapterPosition])
        }

    }
    inner class TodoViewHolder(binding: ListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
            val textTask: TextView = binding.tvTitle
            val check: CheckBox = binding.checkDone
            val finishedLabel: TextView = binding.finishLabel
            val divider: View = binding.dividerFinish

    }
    interface TasksClickListener {
        fun onItemClicked(task:Task)
    }

    fun setTaskList(taskList:List<Task>)  {
        this.taskList.clear()
        this.taskList.addAll(taskList)
        notifyDataSetChanged()
    }

}