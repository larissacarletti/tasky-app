package com.example.tasky

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasky.adapter.TaskAdapter
import com.example.tasky.databinding.ActivityMainBinding
import com.example.tasky.model.Task
import com.example.tasky.util.Resource
import com.example.tasky.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
class MainActivity : AppCompatActivity(), TaskAdapter.TasksClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskAdapter: TaskAdapter
    private val viewModel by viewModel<TaskViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
        setupObservers()
        setupView()
    }
    private fun setupObservers() {
        viewModel.taskList.observe(this@MainActivity) { result ->
            when (result) {
                is Resource.Success -> result.data?.let { taskList ->
                    taskAdapter.setTaskList(
                        taskList.sortedBy { it.completed }
                    )
                }
                else -> Unit
            }
        }
    }

    private fun setRecyclerView() = binding.run {
        taskAdapter = TaskAdapter(this@MainActivity)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = taskAdapter
    }

    private fun setupView() = binding.run {
        imgSent.setOnClickListener {
            viewModel.insertTask(
                Task(
                    title = newtask.text.toString(),
                    completed = false
                )
            )
            newtask.text.clear()
        }
    }

    override fun onItemClicked(task: Task) {
        viewModel.updateTask(
            Task(
                id = task.id,
                title = task.title,
                completed = !task.completed
            )
        )
    }
}
