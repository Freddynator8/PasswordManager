package com.example.passwordmanager.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PasswordDBDefinition::class], version = 1, exportSchema = false)
abstract class PasswordDBDatabase: RoomDatabase()  {

    abstract fun passwordDBDao(): PasswordDBDao

    companion object{
        @Volatile
        private var INSTANCE: PasswordDBDatabase? = null

        fun getPasswordDB(context: Context): PasswordDBDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null)
            {
                return tempInstance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PasswordDBDatabase::class.java,
                    "password_default_table_v1"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}