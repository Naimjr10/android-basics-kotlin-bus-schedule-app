package com.example.busschedule.database.schedule

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
 * When working with Room, each table in database is represented by a class.
 * In an ORM (Object Relational Mapping) library, such as Room,
 * these are often called model classes, or entities.
 */

/*
 * This Kotlin class below can be used to represent a table in the database.
 */

@Entity(tableName="schedule")
data class Schedule(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "stop_name") val stopName: String,
    @NonNull @ColumnInfo(name = "arrival_time") val arrivalTime: Int
)
