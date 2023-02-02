package com.example.app_cda_b2

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log


class ConfirmDeleteDialogFragment: DialogFragment() {
    val TAG = ConfirmDeleteDialogFragment::class.java.simpleName
    //Interface de recup des clicks
    interface ConfirmDeleteListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }
    var listener: ConfirmDeleteListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Design pattern builder
        val builder = AlertDialog.Builder(activity)

        // Config builder
        builder.setMessage("Supprimer tout le contenu")
        // Logic for positive response
            .setPositiveButton("Oui", object: DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, id: Int) {
                    Log.i(TAG, "Tu va etre cassé")
                    // Get var
                    listener?.onDialogPositiveClick()
                }
            })
            .setNegativeButton("Non", DialogInterface.OnClickListener {
                dialog, id ->
                Log.i(TAG, "Ok bien compris")
                dialog.dismiss()
               listener?.onDialogNegativeClick()
            })
        return builder.create()
    }
}