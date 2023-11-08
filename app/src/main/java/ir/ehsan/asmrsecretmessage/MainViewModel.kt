package ir.ehsan.asmrsecretmessage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.ehsan.asmrsecretmessage.database.MessageEntity
import ir.ehsan.asmrsecretmessage.database.SecretDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel:ViewModel(),KoinComponent {
    val db:SecretDatabase by inject()
    val dao = db.messageDao()

    private val _messages = MutableStateFlow<List<MessageEntity>>(emptyList())
    val messages = _messages.asStateFlow()


    init {
        getAll()
    }

    fun createOne(message:String){
        viewModelScope.launch(Dispatchers.IO){
            dao.createMessage(MessageEntity(message = message))
        }
    }
    fun getAll(){
        viewModelScope.launch(Dispatchers.IO){
            dao.getMessages().collect{result->
                _messages.update { result }
            }
        }
    }
    fun deleteOne(message:MessageEntity){
        viewModelScope.launch(Dispatchers.IO){
            dao.deleteMessage(message)
        }
    }
}