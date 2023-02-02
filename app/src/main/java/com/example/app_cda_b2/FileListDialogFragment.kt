package com.example.app_cda_b2

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log

class FileListDialogFragment: DialogFragment() {
    val TAG = FileListDialogFragment::class.java.simpleName
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use design pattern builder
        val builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater

        // The builder go find into dialog_file_list
        builder.setView(inflater?.inflate(R.layout.dialog_file_list, null))
        // Create response positive or negative
            .setPositiveButton("Supprimer", DialogInterface.OnClickListener{
                dialog, id ->
                Log.i(TAG, "Suppression en cours")
            })
            .setNegativeButton("Annuler", DialogInterface.OnClickListener{
                dialog, id ->
                dialog.dismiss()
                Log.i(TAG, "")
            })
            .setTitle("Contenue supprimé")
        return builder.create()
    }
}