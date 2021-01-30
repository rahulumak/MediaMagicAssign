package org.mkcl.rahul.mediamagicassignment.ui.imageGrid

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.mkcl.rahul.mediamagicassignment.config.ProjectConfig
import org.mkcl.rahul.mediamagicassignment.network.NetworkOperations

class ImageRepository {
    suspend fun fetchImageList():List<ImageModel>{
        val jsonString: String = NetworkOperations().makeGETRequest(ProjectConfig.BASE_URL)
        return Gson().fromJson(jsonString, object : TypeToken<List<ImageModel?>?>() {}.type)

//        return NetworkOperations().makeGETRequest(ProjectConfig.BASE_URL)
    }
}

