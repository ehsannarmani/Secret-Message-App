package ir.ehsan.asmrsecretmessage

import android.app.Application
import androidx.room.Room
import ir.ehsan.asmrsecretmessage.database.SecretDatabase
import org.koin.core.context.startKoin
import org.koin.dsl.module

class KoinApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(module {
                single {
                    Room.databaseBuilder(this@KoinApp,SecretDatabase::class.java,"secret").build()
                }
            })
        }
    }
}