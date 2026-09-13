package org.example.apitasks.dto

import org.example.apitasks.model.State

data class TaskRequest(
    val title: String,
    val description: String,
    val state: State
)