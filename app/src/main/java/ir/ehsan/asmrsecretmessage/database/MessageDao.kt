package ir.ehsan.asmrsecretmessage.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {
    @Insert
    fun createMessage(message:MessageEntity)

    @Query("SELECT * FROM messages")
    fun getMessages():Flow<List<MessageEntity>>

    @Delete
    fun deleteMessage(message:MessageEntity)
}