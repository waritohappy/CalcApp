package jp.techacademy.yutaro.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus_button.setOnClickListener(this)
        minus_button.setOnClickListener(this)
        times_button.setOnClickListener(this)
        div_button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var fvalue:Double=0.0
        var svalue:Double=0.0
        var avail_cal:Boolean=false
        try{
            fvalue=editText1.text.toString().toDouble()
            svalue=editText2.text.toString().toDouble()
            avail_cal=true
        }catch(e:NumberFormatException){
            Snackbar.make(v, "数字を入力してください", Snackbar.LENGTH_LONG).show()
        }

        if (avail_cal){
            if(v.id == R.id.div_button && editText2.text.toString()=="0") {
                Snackbar.make(v, "割り算では割る値に0を入力しないでください", Snackbar.LENGTH_LONG).show()
            }else{
                var result: Double = 0.0
                val intent = Intent(this, SecondActivity::class.java)
                if (v.id == R.id.plus_button) {
                    result = fvalue + svalue
                } else if (v.id == R.id.minus_button) {
                    result = fvalue - svalue
                } else if (v.id == R.id.times_button) {
                    result = fvalue * svalue
                } else if (v.id == R.id.div_button) {
                    result = fvalue / svalue
                }
                Log.d("oztest","fvalue=${fvalue},svalue=${svalue},result=${result}")
                intent.putExtra("RESULT", result)
                startActivity(intent)
            }
        }
    }
}