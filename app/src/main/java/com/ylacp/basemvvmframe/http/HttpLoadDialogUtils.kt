package com.dfzw.dfzwmanageproject.http

import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.dfzw.dfzwmanageproject.R

/**
 * @description 显示加载等待时的dialog
 */
class HttpLoadDialogUtils {
    var TAG = javaClass.simpleName

    companion object {
        private val isShow = true
        private var builder: AlertDialog.Builder? = null
        private var dialog: AlertDialog? = null

        fun showDialog(context: Context) {
            if (dialog != null && dialog!!.isShowing) {
                return
            }
            if (dialog == null) {
                builder = AlertDialog.Builder(context)
                val view = View.inflate(context, R.layout.dialog_show_loading, null)
                builder!!.setView(view)
                dialog = builder!!.create()
            }
            dialog!!.setCanceledOnTouchOutside(false)
            dialog!!.setOnCancelListener { dialog1: DialogInterface? ->
                dialog!!.dismiss()
                dialog = null
            }
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(context.resources.getColor(R.color.transparent)))
            dialog!!.show()
        }

        fun hidDialog() {
            if (dialog != null && dialog!!.isShowing) {
                dialog!!.dismiss()
                dialog = null
            }
        }
    }

}