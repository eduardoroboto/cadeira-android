package br.com.unifor.activitynavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private const val MESSAGE_ACTIVITY_ID = 0
private const val REQUEST_IMAGE_CAPTURE = 1


class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var mButtonFirstActivity: Button
    private lateinit var mButtonSecondActivity: Button
    private lateinit var mButtonMessageActivity: Button

    private lateinit var mTextViewMessage:TextView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mButtonFirstActivity = findViewById(R.id.main_button_firstactivity)
        mButtonFirstActivity.setOnClickListener(this)

        mButtonSecondActivity = findViewById(R.id.main_button_secondactivity)
        mButtonSecondActivity.setOnClickListener(this)

        mButtonMessageActivity = findViewById(R.id.main_button_getmessage)
        mButtonMessageActivity.setOnClickListener(this)

        mTextViewMessage = findViewById(R.id.main_textview_message)

        Log.i("App","[MainActivity] - onCreat")
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.main_button_firstactivity ->{
                val it = Intent(this, FirstActivity::class.java)
                startActivity(it)
            }
            R.id.main_button_secondactivity ->{
                val it = Intent(this, SecondActivity::class.java)
                startActivity(it)
            }

            R.id.main_button_getmessage ->{
                val it = Intent(this, MessageActivity::class.java)
                //startActivity(it)
                startActivityForResult(it, MESSAGE_ACTIVITY_ID)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            MESSAGE_ACTIVITY_ID -> {
                 if(resultCode == RESULT_OK){
                      val message = data?.getStringExtra("message")
                     mTextViewMessage.text = message
                 }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.i("App","[MainActivity] - onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("App","[MainActivity] - onRestart")
        Toast.makeText(
            this,
            "Main Activity está visível",
            Toast.LENGTH_LONG).show()
    }
    override fun onResume() {
        super.onResume()
        Log.i("App","[MainActivity] - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("App","[MainActivity] - onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i("App","[MainActivity] - onStop")
        Toast.makeText(
            this,
            "Main Activity não está mais visível",
            Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("App","[MainActivity] - onDestroy")
    }
}