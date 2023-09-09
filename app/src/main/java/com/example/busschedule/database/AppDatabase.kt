package com.example.busschedule.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDao

/*
 * Now that you've defined the models, DAO, and a view model for fragments to access the DAO,
 * you still need to tell Room what to do with all of these classes.
 * That's where the AppDatabase class comes in. An Android app using Room,
 * such as yours, subclasses the RoomDatabase class and has a few key responsibilities.
 * In your app, the AppDatabase needs to :
 * 1. Specify which entities are defined in the database.
 * 2. Provide access to a single instance of each DAO class.
 * 3. Perform any additional setup, such as pre-populating the database.
 */

@Database(entities = arrayOf(Schedule::class), version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao

    // When using an AppDatabase class, ensure that only one instance of the database exists
    // to prevent race conditions or other potential issues.
    // The instance is stored in the companion object,
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Use the Elvis operator to either return the existing instance
        // of the database (if it already exists) or
        // create the database for the first time if needed.
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }

}