package br.com.unifor.mysavings.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unifor.mysavings.R
import br.com.unifor.mysavings.adapter.FlowAdapter
import br.com.unifor.mysavings.fragments.DialogQuestion
import br.com.unifor.mysavings.listener.FlowItemListener
import br.com.unifor.mysavings.util.Database
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FlowActivity : AppCompatActivity(),FlowItemListener {

    private var userId =-1
    private lateinit var mFlowMoneyList: RecyclerView
    private lateinit var dialogQuest: DialogQuestion
    private var test = this
    private var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)

        userId = intent.getIntExtra("user_id",-1)
        mFlowMoneyList = findViewById(R.id.moneyflow_recycleview_deleteflows)
        mFlowMoneyList.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun onStart() {
        super.onStart()

        GlobalScope.launch {
            val flows = Database
                .getInstance(applicationContext)
                .getFlowDao()
                .findAllByUserId(userId)
            handler.post{
                val flowAdapter = FlowAdapter(flows)
                flowAdapter.setOnFlowItemListener(test)
                mFlowMoneyList.adapter = flowAdapter
            }
        }

    }

    override fun onItemClick(view: View,flowId:TextView) {
        val fm:FragmentManager = supportFragmentManager
        dialogQuest = DialogQuestion({ removeFlow(flowId) }, { removeFlow(flowId) },
            "Do you really want to delete this?","Edit","Delete","Cancel")
        dialogQuest.show(fm, "Remove Flow Fragment")
    }

    fun send_msg(msg:String){
        Toast.makeText(
            applicationContext,
            msg,
            Toast.LENGTH_SHORT
        )
            .show()

    }

    fun removeFlow(flowId: TextView):Boolean{
        val flowId = flowId.text.toString().toInt()
       GlobalScope.launch {
           val flows = Database
               .getInstance(applicationContext)
               .getFlowDao()
               .deleteById(flowId)
       }
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
        return true
    }



}