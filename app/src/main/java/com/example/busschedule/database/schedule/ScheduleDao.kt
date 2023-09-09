package com.example.busschedule.database.schedule

import androidx.room.Dao
import androidx.room.Query

/*
 * DAO stands for Data Access Object and is a Kotlin class that provides access to the data.
 * Specifically, the DAO is where you would include functions for reading and manipulating data.
 * Calling a function on the DAO is the equivalent of performing a SQL command on the database.
 */

@Dao
interface ScheduleDao {

    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAll(): List<Schedule>

    // You can reference Kotlin values from the query by preceding it with a colon (:)
    // (e.g. :stopName from the function parameter).
    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getByStopName(stopName: String): List<Schedule>
}