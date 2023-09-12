package com.tanify.library.localdb.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tanify.library.localdb.data.entity.WhiteListAppDbModel

@Database(entities = [WhiteListAppDbModel::class], version = 1)
abstract class WhiteListAppDatabase: RoomDatabase() {
    abstract fun whiteListAppDao(): WhiteListAppDao

    companion object {
        const val DATABASE_NAME = "white_list_app_db"
    }
}