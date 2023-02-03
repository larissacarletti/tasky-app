package com.example.tasky

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasky.adapter.TaskAdapter
import com.example.tasky.databinding.ActivityMainBinding
import com.example.tasky.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskAdapter: TaskAdapter
    private val viewModel by viewModel<TaskViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
        setupObservers()

        binding.sent.setOnClickListener{

        }


    }


    private fun setupObservers() {
        viewModel.taskList.observe(this@MainActivity) { taskList ->
            taskAdapter.setTaskList(taskList.sortedBy { it.completed })
        }
    }

    private fun setRecyclerView() = binding.run {
        val newTask: EditText = binding.newtask!!
        taskAdapter = TaskAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = taskAdapter
    }

}