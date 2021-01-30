package org.mkcl.rahul.mediamagicassignment.ui.imageGrid

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageGridViewModel(private val imageRepository: ImageRepository) : ViewModel() {
    var imageList: MutableLiveData<List<ImageModel>> = MutableLiveData()

    init {
        viewModelScope.launch(Dispatchers.IO) {
             imageList.postValue( imageRepository.fetchImageList())
        }
    }

}