package br.com.unifor.personview.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unifor.personview.R
import br.com.unifor.personview.adapter.PeopleAdapter
import br.com.unifor.personview.listener.PersonItemListener
import br.com.unifor.personview.repository.UserRepository

class MainActivity : AppCompatActivity(), PersonItemListener {

    private lateinit var mPeopleList:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val llm = LinearLayoutManager(this)
        val peopleAdapter = PeopleAdapter(UserRepository.findAll())
        peopleAdapter.setOnPersonItemListener(this)
        mPeopleList = findViewById(R.id.main_recycleview_peoplelist)



        mPeopleList.apply {
            hasFixedSize()
            adapter = peopleAdapter
            layoutManager = llm
        }

//        mPeopleList.hasFixedSize()
//        mPeopleList.layoutManager = llm
//        mPeopleList.adapter = peopleAdapter

    }

    override fun onItemClick(view: View, position: Int) {
        val it = Intent(this,ViewUserActivity::class.java)
        it.putExtra("user_id",position)
        startActivity(it)

    }
}