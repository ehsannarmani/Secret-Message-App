package ir.ehsan.asmrsecretmessage.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MessageEntity::class], version = 1)
abstract class SecretDatabase:RoomDatabase() {
    abstract fun messageDao():MessageDao
}