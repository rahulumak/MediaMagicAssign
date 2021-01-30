package org.mkcl.rahul.mediamagicassignment.ui.imageGrid


import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("author")
    val author: String,
    @SerializedName("id")
    val id: Int
)