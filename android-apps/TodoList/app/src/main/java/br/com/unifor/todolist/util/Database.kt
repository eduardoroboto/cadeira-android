package br.com.unifor.todolist.util

import android.content.Context
import androidx.room.Room
import br.com.unifor.todolist.repository.TodoDatabase

object Database {

    private var instance: TodoDatabase? = null

    fun getInstance(context: Context): TodoDatabase{

        if(instance == null){
            instance = Room.databaseBuilder(
                context,
                TodoDatabase::class.java,
                "todo.db"
            )
               // .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }

        return instance!!

    }

}