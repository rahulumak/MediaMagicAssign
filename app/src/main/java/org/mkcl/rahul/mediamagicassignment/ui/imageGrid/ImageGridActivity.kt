package org.mkcl.rahul.mediamagicassignment.ui.imageGrid

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.mkcl.rahul.mediamagicassignment.R
import org.mkcl.rahul.mediamagicassignment.utils.ViewDialog


class ImageGridActivity : AppCompatActivity() {
    private val TAG = ImageGridActivity::class.java.simpleName
    private lateinit var imageGridViewModel: ImageGridViewModel
    private lateinit var imageGridAdapter: ImageGridAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var imageList: ArrayList<ImageModel>
    var viewDialog: ViewDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageGridViewModel = ViewModelProvider(
            this,
            ImageViewModelFactory(ImageRepository())
        ).get(ImageGridViewModel::class.java)
        title = "Image List"
        initData()
        bindUI()

    }

    private fun initData() {
        viewDialog = ViewDialog(this)
        imageList=ArrayList()
        imageGridAdapter = ImageGridAdapter(imageList)
        gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        recycler_view.layoutManager = gridLayoutManager
        recycler_view.adapter = imageGridAdapter
    }

    private fun bindUI() {
        viewDialog!!.showDialog()
        viewDialog!!.setMessage("Fetching Images...")
        val imageObserver = Observer<List<ImageModel>>() { list ->
            if (imageList.size>0){
                imageList.clear()
            }
            imageList.addAll(list)
            imageGridAdapter.notifyDataSetChanged()
            viewDialog!!.hideDialog()

        }
        imageGridViewModel.imageList.observe(this, imageObserver)
    }
}