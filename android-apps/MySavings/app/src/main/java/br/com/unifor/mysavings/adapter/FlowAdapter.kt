package br.com.unifor.mysavings.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.unifor.mysavings.R
import br.com.unifor.mysavings.model.Flow
import br.com.unifor.mysavings.listener.FlowItemListener

class FlowAdapter(private val flows: List<Flow>)
    :RecyclerView.Adapter<FlowAdapter.FlowViewHolder>(){

    class FlowViewHolder(item: View, listener: FlowItemListener?):RecyclerView.ViewHolder(item) {

        val nName:TextView = item.findViewById(R.id.itemflow_textview_name)
        val nValue:TextView = item.findViewById(R.id.itemflow_textview_value)
        val nDate: TextView = item.findViewById(R.id.itemflow_textview_date)
        val nFlowId:TextView = item.findViewById(R.id.moneyflow_textview_flowid)

        init {
            item.setOnClickListener {
                listener?.onItemClick(it,nFlowId)
            }
        }
    }

    private var listener:FlowItemListener? = null

    fun setOnFlowItemListener(listener: FlowItemListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowViewHolder {
        val item = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_flow_list,parent,false)
        return FlowViewHolder(item,listener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FlowViewHolder, position: Int) {
        holder.nName.text = flows[position].name
        val value_text = flows[position].value.toString()
        val country_currency = "R\$"
        var type=""
        if(flows[position].type.toString() == "receita") type="+"
        if(flows[position].type.toString() == "recibo") type="+"
        if(flows[position].type.toString() == "debito") type="-"
        if(flows[position].type.toString() == "despesa") type="-"
        holder.nValue.text = "$type $country_currency $value_text"
        holder.nDate.text = flows[position].date
        holder.nFlowId.text = flows[position].id.toString()
    }

    override fun getItemCount(): Int {
        return flows.size
    }


}