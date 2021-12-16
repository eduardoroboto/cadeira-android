package br.com.unifor.todolist.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.unifor.todolist.model.Category
import br.com.unifor.todolist.model.Task
import br.com.unifor.todolist.model.User

@Database(entities = [User::class, Task::class,Category::class], version = 1)
abstract class TodoDatabase: RoomDatabase(){

    abstract fun getUserDao(): UserDAO

    abstract fun getTaskDao(): TaskDAO

    abstract fun getCategoryDao(): CategoryDAO

}