package com.uso.guia3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    companion object{
        var list:MutableList<String> = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openForm(view: View){
        var intent: Intent = Intent(this, FormActivity::class.java)
        startActivity(intent)
    }

    fun openList(view: View){
        if(list.isNotEmpty()) {
            var intent: Intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }else
            Toast.makeText(this, R.string.no_data, Toast.LENGTH_SHORT).show()
    }

    fun openData(view: View){
        var intent: Intent = Intent(this, DataActivity::class.java)
        startActivity(intent)
    }
}