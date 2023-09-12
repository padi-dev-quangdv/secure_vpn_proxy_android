package com.tanify.library.localdb.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tanify.library.localdb.data.entity.WhiteListAppDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface WhiteListAppDao {

    @Query("SELECT * FROM white_list_app")
    fun getWhiteListAppsFromDb(): Flow<List<WhiteListAppDbModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAppToDb(vararg whiteListAppDbModel: WhiteListAppDbModel)

    @Delete
    fun deleteAppFromDb(whiteListAppDbModel: WhiteListAppDbModel)
}