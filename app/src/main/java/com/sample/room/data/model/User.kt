package com.sample.room.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_table")//ORM架構
data class User (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    val id: Int,
    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    val name: String,
    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.INTEGER)
    val age: Int
): Parcelable