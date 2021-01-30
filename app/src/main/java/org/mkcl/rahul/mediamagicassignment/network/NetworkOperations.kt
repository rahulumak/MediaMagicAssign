package org.mkcl.rahul.mediamagicassignment.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.net.URL

class NetworkOperations {

    val TAG: String = NetworkOperations::class.java.simpleName

    sealed class Result<out R> {
        data class Success<out T>(val data: T) : Result<T>()
        data class Error(val exception: Exception) : Result<Nothing>()
    }
     suspend fun makeGETRequest(url: String):String {
         var text=""
         try {
             text = URL(url).readText()

         } catch (e: Exception) {
             Log.d(TAG,"Exception:${e.message}")
         }
         return text
     }

//    sealed class Result {
//        object Loading:Result()
//        data class Success(val data: String) : Result()
//        data class Error(val exception: Exception) : Result()
//    }
//    suspend fun makeGETRequest(url: String):Result {
//        var text=""
//        try {
//            text = URL(url).readText()
//            return Result.Success(text)
//        } catch (e: Exception) {
//            Log.d(TAG,"Exception:${e.message}")
//            return Result.Error(e)
//        }
//    }
}