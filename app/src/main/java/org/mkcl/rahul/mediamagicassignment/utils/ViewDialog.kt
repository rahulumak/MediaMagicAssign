package org.mkcl.rahul.mediamagicassignment.utils

import android.app.Activity
import android.app.Dialog
import android.view.Window
import android.widget.TextView
import org.mkcl.rahul.mediamagicassignment.R

class ViewDialog(var activity: Activity) {
    var dialog: Dialog? = null
    var txtMessage: TextView? = null
    fun showDialog() {
        dialog = Dialog(activity)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setCancelable(false)
        dialog!!.setContentView(R.layout.custom_loading_layout)
        txtMessage = dialog!!.findViewById(R.id.txtMessage)
        dialog!!.show()
    }

    fun setMessage(message: String?) {
        txtMessage!!.text = message
    }

    fun hideDialog() {
        dialog!!.dismiss()
    }
}