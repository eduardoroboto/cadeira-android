package br.com.unifor.todolist.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unifor.todolist.R
import br.com.unifor.todolist.adapter.CategoryAdapter
import br.com.unifor.todolist.util.Database
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CategoryActivity : AppCompatActivity(), View.OnClickListener {

    private var userId =-1
    private var userEmail = ""

    private lateinit var mCategoryList: RecyclerView
    private lateinit var mCategoryAdd: FloatingActionButton

    private var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        userId = intent.getIntExtra("user_id",-1)
        userEmail = intent.getStringExtra("user_email").toString()

        mCategoryList = findViewById(R.id.category_recyclerview_category)
        mCategoryList.layoutManager = LinearLayoutManager(applicationContext)
        mCategoryAdd = findViewById(R.id.category_floatingbutton_add)
        mCategoryAdd.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        GlobalScope.launch {
            val categories = Database
                .getInstance(applicationContext)
                .getCategoryDao()
                .findAll()

            handler.post {
                mCategoryList.adapter = CategoryAdapter(categories)
            }
        }

    }
    override fun onClick(v: View?) {
       when(v?.id){
           R.id.category_floatingbutton_add ->{
               val it = Intent(applicationContext, CategoryFormActivity::class.java)
               it.putExtra("user_id",userId)
               it.putExtra("user_email",userEmail)
               startActivity(it)
           }
       }
    }


}