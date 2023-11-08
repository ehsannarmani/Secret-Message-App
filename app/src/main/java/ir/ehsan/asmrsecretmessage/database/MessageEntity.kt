package ir.ehsan.asmrsecretmessage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("messages")
data class MessageEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    @ColumnInfo("message")
    val message:String
)
