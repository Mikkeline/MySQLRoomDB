package com.michellewsp.mysqlroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.room.Insert
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var dao : ProductDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.btnInsert)
        dao = ProductDB.getInstance(application).productDao

        btn.setOnClickListener {
            val p = Product(0,"Apple", 1.50)

           CoroutineScope(IO).launch {
               dao.insertProduct(p)
           }


        }
    }
}