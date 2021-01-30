package org.mkcl.rahul.mediamagicassignment.ui.imageGrid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ImageViewModelFactory(private val imageRepository: ImageRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageGridViewModel(imageRepository) as T
    }
}