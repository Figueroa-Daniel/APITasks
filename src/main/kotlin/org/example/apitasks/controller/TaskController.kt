package org.example.apitasks.controller

import org.example.apitasks.dto.TaskRequest
import org.example.apitasks.model.State
import org.example.apitasks.model.Task
import org.example.apitasks.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/tasks")
class TaskController(
    private val taskService: TaskService
) {
    @GetMapping("/getTasksByTitle")
    fun findTasksByTitle(@RequestParam title: String): ResponseEntity<List<Task>> =
        ResponseEntity.ok(taskService.findByTitle(title))

    @GetMapping("/getTasksByState")
    fun findTasksByState(@RequestParam state: State): ResponseEntity<List<Task>> =
        ResponseEntity.ok(taskService.findByStatus(state))

    @PostMapping("/createTask")
    fun creteTask(@RequestBody taskRequest: TaskRequest): ResponseEntity<Boolean> =
        ResponseEntity.ok(taskService.createTask(taskRequest.title, taskRequest.description,taskRequest.state))

    @PutMapping("/updateTask")
    fun updateTask(@RequestBody task: Task): ResponseEntity<Boolean> =
        ResponseEntity.ok(taskService.updateTask(task))

    @DeleteMapping("/removeTaskById")
    fun deleteTask(@RequestParam id:Long): ResponseEntity<Boolean> =
        ResponseEntity.ok(taskService.deleteTaskById(id))

}