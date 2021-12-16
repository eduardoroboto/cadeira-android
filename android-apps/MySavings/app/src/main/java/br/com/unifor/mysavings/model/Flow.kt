package br.com.unifor.mysavings.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flows")
data class Flow(
    @PrimaryKey
    val id:Int? = null,
    val name:String,
    val value:Float,
    val type:String,
    val date:String,
    @ColumnInfo(name = "user_id")
    val userId:Int
)
