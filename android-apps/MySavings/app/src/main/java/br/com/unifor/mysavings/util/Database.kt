package br.com.unifor.mysavings.util

import android.content.Context
import androidx.room.Room
import br.com.unifor.mysavings.repository.MySavingsDatabase

object Database {

    private var instance: MySavingsDatabase? = null

    fun getInstance(context: Context): MySavingsDatabase{

        if(instance == null){
            instance = Room.databaseBuilder(
                context,
                MySavingsDatabase::class.java,
                "savings.db"
            )
                // .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }

        return instance!!

    }

}