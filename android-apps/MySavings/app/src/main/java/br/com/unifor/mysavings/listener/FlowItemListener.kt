package br.com.unifor.mysavings.listener

import android.view.View
import android.widget.TextView

interface FlowItemListener {

    fun onItemClick(view: View, flowId: TextView)

}