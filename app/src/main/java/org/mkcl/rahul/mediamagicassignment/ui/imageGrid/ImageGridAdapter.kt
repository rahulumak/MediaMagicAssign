package org.mkcl.rahul.mediamagicassignment.ui.imageGrid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_image_grid.view.*
import org.mkcl.rahul.mediamagicassignment.R
import org.mkcl.rahul.mediamagicassignment.config.ProjectConfig
import org.mkcl.rahul.mediamagicassignment.utils.DownloadImageTask

class ImageGridAdapter(private val imageList: ArrayList<ImageModel>) :
    RecyclerView.Adapter<ImageGridAdapter.ImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_image_grid, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.itemView.txtAuthor.text = imageList[position].author
        DownloadImageTask(holder.itemView.image).execute(ProjectConfig.IMAGE_URL + imageList[position].id)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}