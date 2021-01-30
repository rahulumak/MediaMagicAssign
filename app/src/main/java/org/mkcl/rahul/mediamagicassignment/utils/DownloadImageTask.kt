package org.mkcl.rahul.mediamagicassignment.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import java.io.InputStream
import java.net.URL

//Instead Of Using AsyncTask, We can use Glide or Picaso Library
 class DownloadImageTask(bmImage: ImageView) : AsyncTask<String?, Void?, Bitmap?>() {
    var bmImage: ImageView = bmImage
     override fun doInBackground(vararg p0: String?): Bitmap? {
        val urldisplay = p0[0]
        var bmp: Bitmap? = null
        try {
            val inputStream: InputStream = URL(urldisplay).openStream()
            bmp = BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            e.message?.let { Log.e("Error", it) }
            e.printStackTrace()
        }
        return bmp
    }
     override fun onPostExecute(result: Bitmap?) {
         bmImage.setImageBitmap(result)
     }
}
