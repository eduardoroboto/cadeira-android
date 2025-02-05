package br.com.unifor.todolist.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.com.unifor.todolist.R
import br.com.unifor.todolist.util.Database
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.Normalizer

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mEmailLogin: EditText
    private lateinit var mPasswordLogin: EditText
    private lateinit var mRegisterLogin: TextView
    private lateinit var mSignInLogin: Button
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mEmailLogin = findViewById(R.id.login_edittext_email)
        mPasswordLogin = findViewById(R.id.login_edittext_password)

        mRegisterLogin = findViewById(R.id.login_textview_register)
        mRegisterLogin.setOnClickListener(this)

        mSignInLogin = findViewById(R.id.login_button_enter)
        mSignInLogin.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.login_textview_register -> {

                val it = Intent(this, RegisterActivity::class.java)
                startActivity(it)
            }
            R.id.login_button_enter -> {

                val formIsFilled = FormIsEmptyTest(listOf(mEmailLogin, mPasswordLogin))
                if (formIsFilled) {
                    val email = mEmailLogin.text.toString()
                    val password = mPasswordLogin.text.toString()

                    GlobalScope.launch {
                        val user = Database
                            .getInstance(applicationContext)
                            .getUserDao()
                            .findByEmail(email)

                        if (user != null && user.password == password) {
                            handler.post {
                                val it = Intent(applicationContext, MainActivity::class.java)
                                startActivity(it)
                                it.putExtra("user_id",user.id)
                                it.putExtra("user_email",user.email)
                                finish()
                            }
                        } else {
                            handler.post {
                                Toast.makeText(
                                    applicationContext,
                                    "Usuário ou senha inválidos",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }


            }
        }
    }

    fun FormIsEmptyTest(formItemList: List<EditText>): Boolean {
        var isFormFilled = true
        formItemList.forEach {
            if (it.text.isEmpty()) {
                it.error = resources.getString(R.string.login_empty_error)
                isFormFilled = false
            }
        }
        return isFormFilled
    }
}