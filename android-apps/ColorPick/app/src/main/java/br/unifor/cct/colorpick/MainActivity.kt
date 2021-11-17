package br.unifor.cct.colorpick

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var mViewColor:View
    private lateinit var mSeekBarValueRed:SeekBar
    private lateinit var mSeekBarValueGreen:SeekBar
    private lateinit var mSeekBarValueBlue:SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewColor = findViewById(R.id.main_view_color)

        mSeekBarValueRed = findViewById(R.id.main_seekbar_value_red)
        mSeekBarValueRed.setOnSeekBarChangeListener(this)

        mSeekBarValueGreen = findViewById(R.id.main_seekbar_value_green)
        mSeekBarValueGreen.setOnSeekBarChangeListener(this)

        mSeekBarValueBlue = findViewById(R.id.main_seekbar_value_blue)
        mSeekBarValueBlue.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUse: Boolean) {
      //mViewColor.setBackgroundColor(Color.rgb(progress,progress,progress))
        if(seekBar == mSeekBarValueRed){
            var green = mSeekBarValueGreen.progress
            var blue = mSeekBarValueBlue.progress
            mViewColor.setBackgroundColor(Color.rgb(progress,green,blue))
            Log.i("App","Red chamado")
        }

        if(seekBar == mSeekBarValueGreen){
            var red = mSeekBarValueRed.progress
            var blue = mSeekBarValueBlue.progress
            mViewColor.setBackgroundColor(Color.rgb(red,progress,blue))
            Log.i("App","Green chamado")
        }

        if(seekBar == mSeekBarValueBlue){
            var red = mSeekBarValueRed.progress
            var green = mSeekBarValueGreen.progress
            mViewColor.setBackgroundColor(Color.rgb(red,green,progress))
            Log.i("App","Blue chamado")
        }

        Log.i("App","Valor $progress")
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        Log.i("App","O usuário tocou o componente")
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        Log.i("App","O usuário não esta tocando mais o componente")
    }


}