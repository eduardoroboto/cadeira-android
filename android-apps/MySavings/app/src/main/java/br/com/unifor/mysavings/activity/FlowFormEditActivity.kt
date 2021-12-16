package br.com.unifor.mysavings.activity

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.unifor.mysavings.R
import br.com.unifor.mysavings.model.Flow
import br.com.unifor.mysavings.util.Database
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class FlowFormEditActivity: AppCompatActivity(), View.OnClickListener {

    private var flowId =-1
    private var userId =-1
    private var oldDate:String = ""

    private lateinit var mFlowMoneyFormName: EditText
    private lateinit var mFlowMoneyFormValue: EditText
    private lateinit var mFlowMoneyFormDatePickerDialog: DatePickerDialog
    private lateinit var mFlowMoneyFormDatePickerButton: Button
    private lateinit var mFlowMoneyFormButton: Button
    private lateinit var mFlowMoneyRadioGroup: RadioGroup
    private lateinit var mFlowMoneyRadioButtonRecibo: RadioButton
    private lateinit var mFlowMoneyRadioButtonDebito: RadioButton

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow_form)

        flowId = intent.getIntExtra("flow_id",-1)
        userId = intent.getIntExtra("user_id",-1)

        mFlowMoneyFormName = findViewById(R.id.moneyflowform_edittext_name)
        mFlowMoneyFormValue = findViewById(R.id.moneyflowform_edittext_value)
        mFlowMoneyFormDatePickerButton = findViewById(R.id.flowmoneyform_datepickerbutton)
        mFlowMoneyFormDatePickerButton.text = oldDate
        mFlowMoneyRadioGroup = findViewById(R.id.moneyflow_radiogroup_type)
        mFlowMoneyRadioButtonRecibo = findViewById(R.id.moneyflow_radiobutton_receita)
        mFlowMoneyRadioButtonDebito = findViewById(R.id.moneyflow_radiobutton_debito)
        mFlowMoneyFormButton = findViewById(R.id.moneyflowform_button_action)

        mFlowMoneyFormButton.setOnClickListener(this)
        mFlowMoneyRadioButtonRecibo.setOnClickListener(this)
        mFlowMoneyRadioButtonDebito.setOnClickListener(this)
        initDatePicker()

    }

    override fun onStart() {
        super.onStart()

        flowId = intent.getIntExtra("flow_id",-1)

        GlobalScope.launch {
            val oldFlow = Database
                .getInstance(applicationContext)
                .getFlowDao()
                .find(flowId)

            mFlowMoneyFormName.setText(oldFlow.name)
            mFlowMoneyFormValue.setText(oldFlow.value.toString())
            mFlowMoneyFormDatePickerButton.text = oldFlow.date
            if(oldFlow.type == "receita"){
                mFlowMoneyRadioGroup.check(R.id.moneyflow_radiobutton_receita)
            }
            if(oldFlow.type == "despesa"){
                mFlowMoneyRadioGroup.check(R.id.moneyflow_radiobutton_debito)
            }
            oldDate = oldFlow.date
        }
    }

    private fun initDatePicker() {
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, day ->
            val correctMonth = month+1
            val date = makeDateString(day,correctMonth,year)
            mFlowMoneyFormDatePickerButton.text = date

        }
        val cal  = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val style = AlertDialog.THEME_HOLO_LIGHT

        mFlowMoneyFormDatePickerDialog = DatePickerDialog(this,style,dateSetListener,year,month,day)

    }

    private fun makeDateString(day: Int, correctMonth: Int, year: Int): String {
        val month = getMonthFormat(correctMonth)
        return "$month $day $year"
    }

    private fun getMonthFormat(correctMonth: Int): String {
        return when (correctMonth) {
            1 -> "JAN"
            2 -> "FEB"
            3 -> "MAR"
            4 -> "APR"
            5 -> "MAY"
            6 -> "JUN"
            7 -> "JUL"
            8 -> "AUG"
            9 -> "SEP"
            10 -> "OCT"
            11 -> "NOV"
            12 -> "DEC"
            else -> {
                "JAN"
            }
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.moneyflowform_button_action -> {
                val isFormFilled = formIsEmptyTest(
                    listOf(
                        mFlowMoneyFormName,
                        mFlowMoneyFormValue,
                    )
                )
                if(mFlowMoneyRadioGroup.checkedRadioButtonId<=0){
                    mFlowMoneyRadioButtonRecibo.error = "Select one"
                    mFlowMoneyRadioButtonDebito.error = "Select one"
                }
                if(isFormFilled && mFlowMoneyRadioGroup.checkedRadioButtonId>0){
                    val name = mFlowMoneyFormName.text.toString()
                    val value = mFlowMoneyFormValue.text.toString().toFloat()
                    val date = mFlowMoneyFormDatePickerButton.text.toString()


                    if(mFlowMoneyRadioButtonRecibo.isChecked){
                        val newMoneyFlow = Flow(
                            id = flowId,
                            name = name,
                            value = value,
                            date = date,
                            type = "receita",
                            userId = userId
                        )
                        GlobalScope.launch {
                            Database.getInstance(applicationContext)
                                .getFlowDao()
                                .update(newMoneyFlow)

                            handler.post { send_msg("Flow Updated") }
                            finish()
                        }
                    }
                    if(mFlowMoneyRadioButtonDebito.isChecked){
                        val newMoneyFlow = Flow(
                            id = flowId,
                            name = name,
                            value = value,
                            date = date,
                            type = "despesa",
                            userId = userId
                        )
                        GlobalScope.launch {
                            Database.getInstance(applicationContext)
                                .getFlowDao()
                                .update(newMoneyFlow)

                            handler.post { send_msg("Flow updated") }
                            finish()
                        }
                    }

                }
            }
            R.id.moneyflow_radiobutton_debito ->{
                mFlowMoneyRadioButtonDebito.error = null
                mFlowMoneyRadioButtonRecibo.error = null
            }
            R.id.moneyflow_radiobutton_receita ->{
                mFlowMoneyRadioButtonRecibo.error = null
                mFlowMoneyRadioButtonDebito.error = null
            }
        }
    }


    fun formIsEmptyTest(formItemList: List<EditText>): Boolean {
        var isFormFilled = true
        formItemList.forEach {
            if (it.text.isEmpty()) {
                it.error = resources.getString(R.string.register_empty_error)
                isFormFilled = false
            }
        }
        return isFormFilled
    }

    fun send_msg(msg:String){
        Toast.makeText(
            applicationContext,
            msg,
            Toast.LENGTH_SHORT
        )
            .show()

    }

    fun openDatePicker(view: android.view.View) {
        mFlowMoneyFormDatePickerDialog.show()
    }


}