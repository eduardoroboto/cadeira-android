package br.com.unifor.threeintents

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView

private const val REQUEST_IMAGE_CAPTURE = 1

class CameraActivity : AppCompatActivity() {

    private lateinit var buttonCameraTakeIt: Button
    private lateinit var imageViewCamera: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        Log.i("App", "[CameraActivity] - onCreat")

        imageViewCamera = findViewById(R.id.image_viewcamera)

        buttonCameraTakeIt = findViewById(R.id.button_cameratakeit)
        buttonCameraTakeIt.setOnClickListener {

            val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(it, REQUEST_IMAGE_CAPTURE)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQUEST_IMAGE_CAPTURE ->{
                if(resultCode == RESULT_OK){
                    val thumbnail: Bitmap = data?.extras?.get("data") as Bitmap
                    imageViewCamera.setImageBitmap(thumbnail)
                }
            }
        }
    }

}

