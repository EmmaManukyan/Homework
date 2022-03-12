package com.example.homework

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var btnAdd:TextView
    lateinit var btnGo:TextView
    lateinit var text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd = findViewById(R.id.btn_add)
        text= findViewById(R.id.tv_number)
        btnGo = findViewById(R.id.tv_activity2)
        btnAdd.setOnClickListener(this)
        btnGo.setOnClickListener(this)
        var isTrue = intent.getBooleanExtra("is",false)
        Toast.makeText(this, "$isTrue", Toast.LENGTH_SHORT).show()
        if (isTrue){
            text.setText(intent.getStringExtra("number"))
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_add->{
                var num = text.text.toString().toInt()
                if (num<999){
                    text.setText((num+1).toString())
                }else{
                    Toast.makeText(this, "You can't add a number", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.tv_activity2->{
                val intent = Intent(this, Activity2::class.java)
                intent.putExtra("result", text.text.toString())
                startActivity(intent)
            }
        }
    }
}