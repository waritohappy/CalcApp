package jp.techacademy.yutaro.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val value1 = intent.getDoubleExtra("RESULT", 0.0)

        if (value1 ==Math.floor(value1)){   //もし答えが整数なら
                val value2= value1.toInt()
                textView_second.text = "答え=${value2}"   //整数で表示する
        }else{                              //小数第1位以下に値を有するなら
            textView_second.text = "答え=${value1}"   //小数で表示する
        }
    }
}