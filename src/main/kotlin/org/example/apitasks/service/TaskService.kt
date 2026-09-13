package org.example.apitasks.service

import org.example.apitasks.model.State
import org.example.apitasks.model.Task
import org.example.apitasks.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService(
    private val taskRepository: TaskRepository
) {

    fun findAllTasks(): List<Task> = taskRepository.findAll()

    fun findByTitle(title:String):List<Task> {
        val taskList = taskRepository.findAll()
        val listTaskByTitle:MutableList<Task> = mutableListOf()
        for (task in taskList) {
            if (task.title == title) {
                listTaskByTitle.add(task)
            }
        }
        return listTaskByTitle
    }

    fun findByStatus(state: State): List<Task> {
        val taskList = taskRepository.findAll()
        val listTaskByTitle:MutableList<Task> = mutableListOf()
        for (task in taskList) {
            if (task.state == state) {
                listTaskByTitle.add(task)
            }
        }
        return listTaskByTitle

    }

    fun createTask(title:String, description:String, state: State): Boolean {
        try {
            val task = Task(title = title, description = description, state = state)
            taskRepository.save(task)
        } catch (ex: Exception) {
            return false
        }
        return true
    }

    fun updateTask(task:Task): Boolean {
        try {
            taskRepository.save(task)
        } catch (ex: Exception) {
            return false
        }
        return true
    }

    fun deleteTaskById(id: Long): Boolean {
        try{
            taskRepository.deleteById(id)
        }catch (ex:Exception){
            return false
        }
        return true
    }

}