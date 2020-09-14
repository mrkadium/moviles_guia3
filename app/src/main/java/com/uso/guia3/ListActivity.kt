package com.uso.guia3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListActivity : AppCompatActivity() {
    lateinit var listviewNombres: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listviewNombres = findViewById(R.id.listviewNombres)
        var adapter:ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        adapter.addAll(MainActivity.list)
        listviewNombres.adapter = adapter
    }
}