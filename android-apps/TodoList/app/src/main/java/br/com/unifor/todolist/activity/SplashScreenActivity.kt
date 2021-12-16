package br.com.unifor.todolist.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import br.com.unifor.todolist.R
import br.com.unifor.todolist.util.Database

class SplashScreenActivity : AppCompatActivity() {

    private val DELAY_TIME = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Database.getInstance(this)

        var handler = Handler(Looper.getMainLooper())
        handler.postDelayed(
            {
            val it = Intent(SplashScreenActivity@this, LoginActivity::class.java)
            startActivity(it)
            finish()
            },
            DELAY_TIME
        )


    }
}