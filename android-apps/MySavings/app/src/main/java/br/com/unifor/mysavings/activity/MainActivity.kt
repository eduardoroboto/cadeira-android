package br.com.unifor.mysavings.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unifor.mysavings.R
import br.com.unifor.mysavings.adapter.FlowAdapter
import br.com.unifor.mysavings.fragments.DialogQuestion
import br.com.unifor.mysavings.listener.FlowItemListener
import br.com.unifor.mysavings.model.Flow
import br.com.unifor.mysavings.util.Database
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener,FlowItemListener {

    private var userId =-1

    private lateinit var mFlowListAdd: FloatingActionButton
    //private lateinit var mFlowListRm:FloatingActionButton
    private lateinit var dialogQuest: DialogQuestion
    private lateinit var mFlowMoneyList: RecyclerView
    private lateinit var mFlowMoneySaldo: TextView

    private var test = this
    private var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userId = intent.getIntExtra("user_id",-1)

        mFlowMoneyList = findViewById(R.id.moneyflow_recyclerview_flow)
        mFlowMoneyList.layoutManager = LinearLayoutManager(applicationContext)

        mFlowMoneySaldo = findViewById(R.id.flowmoney_textview_saldo)
        mFlowListAdd = findViewById(R.id.moneyflow_floatingactionbutton_add)
        //mFlowListRm = findViewById(R.id.moneyflow_floatingactionbutton_remove)
        mFlowListAdd.setOnClickListener(this)
        //mFlowListRm.setOnClickListener(this)
       mFlowMoneySaldo.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            val flows = Database
                .getInstance(applicationContext)
                .getFlowDao()
                .findAllByUserId(userId)

            val saldo = calculateSaldo(flows)
            mFlowMoneySaldo.text = "R$ $saldo"

            handler.post{
                val finalFlows = lastFiveOfEachType(flows)
                Log.i("Flow List","$finalFlows")
                val flowAdapter = FlowAdapter(finalFlows)
                flowAdapter.setOnFlowItemListener(test)
                mFlowMoneyList.adapter = flowAdapter
            }
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.moneyflow_floatingactionbutton_add ->{
                val it = Intent(applicationContext,FlowFormActivity::class.java)
                it.putExtra("user_id",userId)
                startActivity(it)
            }
            R.id.flowmoney_textview_saldo ->{
                val it = Intent(applicationContext,FlowGraphActivity ::class.java)
                it.putExtra("user_id",userId)
                startActivity(it)
            }
//            R.id.moneyflow_floatingactionbutton_remove ->{
//                val it = Intent(applicationContext,FlowActivity::class.java)
//                it.putExtra("user_id",userId)
//                startActivity(it)
//            }
        }
    }

    override fun onItemClick(view: View,flowId:TextView) {
        val fm: FragmentManager = supportFragmentManager
        dialogQuest = DialogQuestion(
            {editFlow(flowId)},
            {removeFlow(flowId)},
            "What do you want to do?",
            "Edit",
            "Delete",
            "Cancel")
        dialogQuest.show(fm, "Remove Flow Fragment")
    }


    fun removeFlow(flowId: TextView){
        val thisFlowId = flowId.text.toString().toInt()
        GlobalScope.launch {
            val flows = Database
                .getInstance(applicationContext)
                .getFlowDao()
                .deleteById(thisFlowId)
        }
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    fun editFlow(flowId: TextView) {
        val thisFlowId = flowId.text.toString().toInt()
        val it = Intent(applicationContext,FlowFormEditActivity::class.java)
        it.putExtra("user_id",userId)
        it.putExtra("flow_id",thisFlowId)
        startActivity(it)
    }


    fun calculateSaldo(flows: List<Flow>):Float {
        var saldo:Float = 0F
        flows.forEach {
           if (it.type == "receita") {
               saldo += it.value
           }
            if (it.type == "despesa") {
                saldo -= it.value
            }
        }
        return saldo
    }

    fun lastFiveOfEachType(flows: List<Flow>): List<Flow> {
        val flowReceitas = mutableListOf<Flow>()
        val flowDespesas = mutableListOf<Flow>()
        flows.reversed().forEach {
            if (flowReceitas.size <= 4 && it.type == "receita") {
                flowReceitas.add(it)
                Log.i("Flow","Receita Adicionado")
            }
            if (flowDespesas.size <= 4 && it.type == "despesa") {
                flowDespesas.add(it)
                Log.i("Flow","Despesa Adicionado")
            }
            if (flowDespesas.size == 5 && flowReceitas.size == 5) {
                flowReceitas.addAll(flowDespesas)
                return flowReceitas.toList()
            }

        }
        flowReceitas.addAll(flowDespesas)
        Log.i("Flow Lits","$flowReceitas")
        return flowReceitas.toList()

    }

}