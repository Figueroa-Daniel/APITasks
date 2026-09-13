package org.example.apitasks.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "task")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    var id: Long? = null,
    @Column("title")
    var title: String,
    @Column("description")
    var description: String,
    @Column("status")
    var state:State
)

