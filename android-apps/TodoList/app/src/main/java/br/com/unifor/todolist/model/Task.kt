package br.com.unifor.todolist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "tasks",
    indices = [
        Index("name", unique = true)]
)
data class Task(
    @PrimaryKey
    val id:Int? = null,
    val name:String,
    val description:String,
   @ColumnInfo(name = "user_id")
    val userId:Int,
    @ColumnInfo(name = "category_id")
    val categoryId:Int,
)
