package com.example.tasky

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.strikeThrough
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasky.adapter.TaskAdapter
import com.example.tasky.databinding.ActivityMainBinding
import com.example.tasky.databinding.ListItemBinding
import com.example.tasky.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskAdapter: TaskAdapter
    private val viewModel by viewModel<TaskViewModel>()
    private lateinit var _binding: ListItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
//        getFormattedText(_binding)
        setupObservers()
    }


    private fun setupObservers() {
        viewModel.taskList.observe(this@MainActivity) { taskList ->
            taskAdapter.setTaskList(taskList)
        }
    }

    private fun setRecyclerView() = binding.run {
        taskAdapter = TaskAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = taskAdapter
    }

    private fun getFormattedText(binding: ListItemBinding) {
        val textTask: TextView = binding.tvTitle
        val check: CheckBox = binding.checkDone

        if (check.isChecked) {
            striket
        }
    }

}