package br.com.unifor.mysavings.activity

import android.graphics.Color
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.unifor.mysavings.util.Database
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import br.com.unifor.mysavings.R
import br.com.unifor.mysavings.model.Flow
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class FlowGraphActivity : AppCompatActivity() {
    private var userId =-1
    private lateinit var mFlowGraph:GraphView
    private lateinit var series:LineGraphSeries<DataPoint>
    private lateinit var series2:LineGraphSeries<DataPoint>

    private lateinit var despesas:List<Flow>
    private lateinit var receitas:List<Flow>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow_graph)
        userId = intent.getIntExtra("user_id",-1)

        mFlowGraph = findViewById(R.id.flowGraph)


//        var y:Double
//        var x:Double = -5.0
//
//        series = LineGraphSeries<DataPoint>()
//        series.appendData(DataPoint(x,y),true,500)
//        mFlowGraph.addSeries(series)

    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            val flows = Database
                .getInstance(applicationContext)
                .getFlowDao()
                .findAllByUserId(userId)

            receitas = returnListOfOneType(flows,"receitas")
            despesas = returnListOfOneType(flows,"despesas")


            var saldo = LineGraphSeries<DataPoint>()
            saldo.color = Color.GREEN
            saldo.title = "Saldos"

            var receita = LineGraphSeries<DataPoint>()
            receita.color = Color.BLUE
            receita.title = "Receitas"
            receita.isDrawBackground = true

            var despesa = LineGraphSeries<DataPoint>()
            despesa.color = Color.RED
            despesa.title = "Despesas"
            despesa.isDrawBackground = true

            val receitasPoints:List<DataPoint> = flowListToEntryPointList(receitas)
            val despesasPoints:List<DataPoint> = flowListToEntryPointList(despesas)

            val saldoPoints:List<DataPoint> = flowListToEntryPointListForSaldo(flows)

            if(receitasPoints.isNotEmpty()) receitasPoints.forEach { receita.appendData(it,true,receitasPoints.size) }
           if(despesasPoints.isNotEmpty()) {despesasPoints.forEach { despesa.appendData(it,true,despesasPoints.size) }}
           if(saldoPoints.isNotEmpty()) {saldoPoints.forEach { saldo.appendData(it,true,saldoPoints.size) }}


            mFlowGraph.addSeries(receita)
            mFlowGraph.addSeries(despesa)
            mFlowGraph.addSeries(saldo)


        }
    }


    fun returnListOfOneType(flows: List<Flow>,type:String): List<Flow> {
        val flowReceitas = mutableListOf<Flow>()
        val flowDespesas = mutableListOf<Flow>()
        flows.forEach {
            if (it.type == "receita") {
                flowReceitas.add(it)
            }
            if (it.type == "despesa") {
                flowDespesas.add(it)
            }

        }
        if(type == "receitas") return flowReceitas.toList()
        if(type == "despesas") return flowDespesas.toList()

        return flowReceitas.toList()

    }

    fun flowListToEntryPointList(flows:List<Flow>):List<DataPoint>{
        val moneyFlow = mutableListOf<DataPoint>()
        for (i in 0..flows.size-1){
            moneyFlow.add(DataPoint(i.toDouble(),flows[i].value.toDouble()))
        }

        return moneyFlow.toList()
    }

    fun flowListToEntryPointListForSaldo(flows:List<Flow>):List<DataPoint>{
        val moneyFlow = mutableListOf<DataPoint>()
        var value:Double = 0.0
        moneyFlow.add(DataPoint(0.0,value))
        for (i in 0..flows.size-1){
            if (flows[i].type == "receita") {
                value+=flows[i].value.toDouble()
            }
            if (flows[i].type == "despesa") {
                value-=flows[i].value.toDouble()
            }
            moneyFlow.add(DataPoint(i+1.toDouble(),value))
        }

        return moneyFlow.toList()
    }
}