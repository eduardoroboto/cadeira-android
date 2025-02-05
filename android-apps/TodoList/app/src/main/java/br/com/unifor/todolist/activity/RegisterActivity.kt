package br.com.unifor.todolist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.unifor.todolist.R
import br.com.unifor.todolist.model.User
import br.com.unifor.todolist.util.Database
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mRegisterName: EditText
    private lateinit var mRegisterEmail: EditText
    private lateinit var mRegisterPassword: EditText
    private lateinit var mRegisterPasswordConfirmation: EditText
    private lateinit var mRegisterSignUp: Button

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mRegisterName = findViewById(R.id.register_edittext_name)
        mRegisterEmail = findViewById(R.id.register_edittext_email)
        mRegisterPassword = findViewById(R.id.register_edittext_password_one)
        mRegisterPasswordConfirmation = findViewById(R.id.register_edittext_password_two)
        mRegisterSignUp = findViewById(R.id.register_button_signup)
        mRegisterSignUp.setOnClickListener(this)

    }


    fun FormIsEmptyTest(formItemList: List<EditText>): Boolean {
        var isFormFilled = true
        formItemList.forEach {
            if (it.text.isEmpty()) {
                it.error = resources.getString(R.string.register_empty_error)
                isFormFilled = false
            }
        }
        return isFormFilled
    }

    fun passwordIsEqualTest(): Boolean {
        if (mRegisterPassword.text.toString() != mRegisterPasswordConfirmation.text.toString()) {
            mRegisterPasswordConfirmation.error =
                resources.getString(R.string.register_mismatch_password_error)
            return false
        }
        return true
    }

    override fun onClick(v: View?) {
        var isFormFilled = FormIsEmptyTest(
            listOf(
                mRegisterName,
                mRegisterEmail,
                mRegisterPassword,
                mRegisterPasswordConfirmation
            )
        )
        var samePassword = passwordIsEqualTest()

        if (isFormFilled && samePassword) {
            val name = mRegisterName.text.toString()
            val email = mRegisterEmail.text.toString()
            val password = mRegisterPassword.text.toString()
            val passwordConfirmation = mRegisterPasswordConfirmation.text.toString()


            val newUser = User(
                name = name,
                email = email,
                password = password
            )

            GlobalScope.launch {

                val userSearch = Database
                    .getInstance(applicationContext)
                    .getUserDao()
                    .findByEmail(email)

                if (userSearch == null) {
                    Database
                        .getInstance(applicationContext)
                        .getUserDao()
                        .insert(newUser)

                    handler.post {
                        Toast.makeText(
                            applicationContext,
                            "Usuário inserido com sucesso!",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    }

                } else {

                    handler.post {
                        Toast.makeText(
                            applicationContext,
                            "Uma conta com esse email já existe",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

        }

    }
}