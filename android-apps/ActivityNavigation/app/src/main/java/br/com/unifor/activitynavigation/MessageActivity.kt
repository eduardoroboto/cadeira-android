package br.com.unifor.activitynavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MessageActivity : AppCompatActivity() {

    private lateinit var mMessage: EditText
    private lateinit var mButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        mMessage = findViewById(R.id.message_edittext_text)
        mButton = findViewById(R.id.message_button_sendmessage)

        mButton.setOnClickListener {
/*
           Toast.makeText(
               this,
               mMessage.text,
               Toast.LENGTH_SHORT).show()
*/
            if(mMessage.text.isNotEmpty()){

                var it = Intent()
                it.putExtra("message",mMessage.text.toString())
                setResult(RESULT_OK,it)
                finish()
            }else{
                mMessage.error = "Este campo não poder estar em branco"
            }
        }

    }
}