package br.com.unifor.mysavings.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class DialogQuestion(Positive:()-> Unit, Neutral: ()-> Unit,
                     val msg_question: String, val start_msg: String, val neutral_msg:String, val cancel_msg: String
): DialogFragment() {
    val start = Positive
    val end = Neutral
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage(msg_question)
                .setPositiveButton(start_msg,
                    DialogInterface.OnClickListener { dialog, id ->
                        // FIRE ZE MISSILES!
                        start()
                    })
                .setNeutralButton(neutral_msg,
                    DialogInterface.OnClickListener { dialog, id ->
                        // FIRE ZE MISSILES!
                        end()
                    })
                .setNegativeButton(cancel_msg,
                    DialogInterface.OnClickListener { dialog, id ->
                        //do nothing
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}
