package br.com.unifor.todolist.activity

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
import br.com.unifor.todolist.model.Category
import br.com.unifor.todolist.util.Database
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CategoryFormActivity : AppCompatActivity(), View.OnClickListener {

    private var userId = -1
    private var userEmail = ""

    private lateinit var mCategoryFormTitle: TextView
    private lateinit var mCategoryFormName:EditText
    private lateinit var mCategoryFormDescription:EditText
    private lateinit var mCategoryFormButton: Button

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_form)

        userId = intent.getIntExtra("user_id",-1)
        userEmail = intent.getStringExtra("user_email").toString()

        mCategoryFormTitle = findViewById(R.id.categoryform_edittext_title)
        mCategoryFormName = findViewById(R.id.categoryform_edittext_name)
        mCategoryFormDescription =findViewById(R.id.categoryform_edittext_description)
        mCategoryFormButton= findViewById(R.id.categoryform_button_action)


        mCategoryFormButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v?.id){
           R.id.categoryform_button_action ->{
               val formIsFilled = FormIsEmptyTest(listOf(mCategoryFormName,mCategoryFormDescription))
               if (formIsFilled){
                   val name = mCategoryFormName.text.toString()
                   val description = mCategoryFormDescription.text.toString()

                   val newCategory = Category(
                       name=name,
                       description=description,
                       userId=userId
                   )

                   GlobalScope.launch {
                       Database.getInstance(applicationContext)
                           .getCategoryDao()
                           .insert(newCategory)
                       handler.post {
                           Toast
                               .makeText(
                                   applicationContext,
                                   "Categoria $name cadastrada com sucesso",
                               Toast.LENGTH_SHORT
                                   ).show()
                           finish()
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
                it.error = resources.getString(R.string.register_empty_error)
                isFormFilled = false
            }
        }
        return isFormFilled
    }
}