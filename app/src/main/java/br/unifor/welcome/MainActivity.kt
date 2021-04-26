package br.unifor.welcome

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var mColorView: View;
    private lateinit var mColorPickerR: SeekBar;
    private lateinit var mColorPickerG: SeekBar;
    private lateinit var mColorPickerB: SeekBar;
    private lateinit var mColorValue: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mColorView = findViewById(R.id.main_view_colorview);
        mColorPickerR = findViewById(R.id.main_seekbar_colorpicker);
        mColorPickerG = findViewById(R.id.main_seekbar_colorpicker2);
        mColorPickerB = findViewById(R.id.main_seekbar_colorpicker3);
        mColorValue = findViewById(R.id.main_textview_colorvalue);

        mColorPickerR.setOnSeekBarChangeListener(this);
        mColorPickerG.setOnSeekBarChangeListener(this);
        mColorPickerB.setOnSeekBarChangeListener(this);

        mColorPickerR.progress = 0;
        mColorPickerG.progress = 0;
        mColorPickerB.progress = 0;

    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        if(fromUser){
            Log.i("App", "Value: $progress");

            var Rvalue = mColorPickerR.progress;
            var Gvalue = mColorPickerG.progress;
            var Bvalue = mColorPickerB.progress;

            var hexValueR = Rvalue.toString(radix = 16);
            var hexValueG = Gvalue.toString(radix = 16);
            var hexValueB = Bvalue.toString(radix = 16);

            if(hexValueR.length == 1){
                hexValueR = "0$hexValueR"
            }
            if(hexValueG.length == 1){
                hexValueG = "0$hexValueG"
            }
            if(hexValueB.length == 1){
                hexValueB = "0$hexValueB"
            }

            mColorView.setBackgroundColor(Color.rgb(Rvalue, Gvalue, Bvalue));
            mColorValue.text = "#$hexValueR$hexValueG$hexValueB".toUpperCase();
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        when(seekBar?.id) {
            R.id.main_seekbar_colorpicker -> {
                Log.i("App", "Start touch1!")
            }
        }
        when(seekBar?.id) {
            R.id.main_seekbar_colorpicker2 -> {
                Log.i("App", "Start touch2!")
            }
        }
        when(seekBar?.id) {
            R.id.main_seekbar_colorpicker3 -> {
                Log.i("App", "Start touch3!")
            }
        }

    }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
        when(seekBar?.id) {
            R.id.main_seekbar_colorpicker -> {
                Log.i("App", "Stop touch1!")
            }
        }
        when(seekBar?.id) {
            R.id.main_seekbar_colorpicker2 -> {
                Log.i("App", "Stop touch2!")
            }
        }
        when(seekBar?.id) {
            R.id.main_seekbar_colorpicker3 -> {
                Log.i("App", "Stop touch3!")
            }
        }

    }


}