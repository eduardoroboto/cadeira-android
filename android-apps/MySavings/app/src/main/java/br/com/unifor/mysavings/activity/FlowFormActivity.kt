package br.com.unifor.mysavings.activity

import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.view.View
import android.widget.*
import br.com.unifor.mysavings.R
import br.com.unifor.mysavings.model.Flow
import br.com.unifor.mysavings.util.Database
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class FlowFormActivity : AppCompatActivity(), View.OnClickListener {

    private var userId =-1

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

        userId = intent.getIntExtra("user_id",-1)

        mFlowMoneyFormName = findViewById(R.id.moneyflowform_edittext_name)
        mFlowMoneyFormValue = findViewById(R.id.moneyflowform_edittext_value)
        mFlowMoneyFormDatePickerButton = findViewById(R.id.flowmoneyform_datepickerbutton)
        mFlowMoneyFormDatePickerButton.text = getTodayDate()
        mFlowMoneyRadioGroup = findViewById(R.id.moneyflow_radiogroup_type)
        mFlowMoneyRadioButtonRecibo = findViewById(R.id.moneyflow_radiobutton_receita)
        mFlowMoneyRadioButtonDebito = findViewById(R.id.moneyflow_radiobutton_debito)
        mFlowMoneyFormButton = findViewById(R.id.moneyflowform_button_action)

        initDatePicker()
        mFlowMoneyFormButton.setOnClickListener(this)
        mFlowMoneyRadioButtonRecibo.setOnClickListener(this)
        mFlowMoneyRadioButtonDebito.setOnClickListener(this)

    }

    private fun getTodayDate(): String {

        val cal  = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        var month = cal.get(Calendar.MONTH)
        month = month+1
        val day = cal.get(Calendar.DAY_OF_MONTH)
        return makeDateString(day,month,year)
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
                            name = name,
                            value = value,
                            date = date,
                            type = "receita",
                            userId = userId
                        )
                            GlobalScope.launch {
                                Database.getInstance(applicationContext)
                                    .getFlowDao()
                                    .insert(newMoneyFlow)

                                handler.post { send_msg("Flow added") }
                                finish()
                            }
                    }
                    if(mFlowMoneyRadioButtonDebito.isChecked){
                       val newMoneyFlow = Flow(
                            name = name,
                            value = value,
                            date = date,
                            type = "despesa",
                            userId = userId
                        )
                        GlobalScope.launch {
                            Database.getInstance(applicationContext)
                                .getFlowDao()
                                .insert(newMoneyFlow)

                            handler.post { send_msg("Flow added") }
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