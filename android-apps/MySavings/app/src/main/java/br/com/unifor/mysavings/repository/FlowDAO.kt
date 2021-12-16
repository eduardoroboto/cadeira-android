package br.com.unifor.mysavings.repository

import androidx.room.*
import br.com.unifor.mysavings.model.Flow


@Dao
interface FlowDAO {

    @Insert
    fun insert(flow: Flow)

    @Update
    fun update(flow: Flow)

    @Delete
    fun delete(flow: Flow)

    @Query("SELECT * FROM flows WHERE id = :id")
    fun find(id: Int): Flow

    @Query("SELECT * FROM flows WHERE user_id = :userId")
    fun findAllByUserId(userId:Int): List<Flow>

    @Query("DELETE FROM flows WHERE id = :id")
    fun deleteById(id: Int)

    @Query("SELECT * FROM flows")
    fun findAll():List<Flow>

}