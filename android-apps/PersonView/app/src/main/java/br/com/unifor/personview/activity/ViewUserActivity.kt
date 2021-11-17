package br.com.unifor.personview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.com.unifor.personview.R
import br.com.unifor.personview.repository.UserRepository

class ViewUserActivity : AppCompatActivity() {

    private lateinit var mUserPhoto:ImageView
    private lateinit var mUserName: TextView
    private lateinit var mUserEmail:TextView
    private lateinit var mUserBirthday:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_user)

        mUserPhoto = findViewById(R.id.viewuser_imageview_photo)
        mUserName = findViewById(R.id.viewuser_textview_name)
        mUserEmail = findViewById(R.id.viewuser_textview_email)
        mUserBirthday = findViewById(R.id.viewuser_textview_birthday)

       val position = intent.getIntExtra("user_id",-1)
       if(position >= 0){

           UserRepository.findAll().forEach {
               if (it.id == position+1){
                   mUserPhoto.setImageResource(it.photo)
                   mUserName.text = it.name
                   mUserEmail.text = it.email
                   mUserBirthday.text = it.birthday
               }
           }
       }

    }
}