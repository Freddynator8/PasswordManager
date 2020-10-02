package com.example.passwordmanager.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "password_table_v1")
data class PasswordDBDefinition(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val username: String,
    val email: String,
    val password: String,
    val website: String): Parcelable