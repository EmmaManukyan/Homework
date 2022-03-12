package com.example.homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class Activity2 : AppCompatActivity(),View.OnClickListener {
    lateinit var btnSubtract: TextView
    lateinit var btnGo: TextView
    lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        btnSubtract = findViewById(R.id.btn_subtract)
        btnGo = findViewById(R.id.tv_activity1)
        text = findViewById(R.id.tv_number_ac2)
        btnSubtract.setOnClickListener(this)
        btnGo.setOnClickListener(this)
        if (intent!=null){
            text.setText(intent.getStringExtra("result"))
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_subtract->{
                var num = text.text.toString().toInt()
                if (num>0){
                    text.setText((num-1).toString())
                }else{
                    Toast.makeText(this, "You can't subtract a number", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.tv_activity1->{
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("number", text.text.toString())
                intent.putExtra("is", true)
                startActivity(intent)
            }
        }
    }
}