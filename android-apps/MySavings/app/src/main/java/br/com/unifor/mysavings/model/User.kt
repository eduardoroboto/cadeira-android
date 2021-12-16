package br.com.unifor.mysavings.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
    indices = [
        Index("email", unique = true)]
)
data class User(
    @PrimaryKey
    val id:Int? = null,
    val name:String,
    val email:String,
    val password:String,
    val telephone:String,

)
