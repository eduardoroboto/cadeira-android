package br.com.unifor.mysavings.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.unifor.mysavings.model.Flow
import br.com.unifor.mysavings.model.User

@Database(entities = [User::class, Flow::class], version = 2)
abstract class MySavingsDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDAO

    abstract fun getFlowDao(): FlowDAO

}