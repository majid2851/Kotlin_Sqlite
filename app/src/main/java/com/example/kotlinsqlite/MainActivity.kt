package com.example.kotlinsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity()
{
    lateinit var databaseHelper:DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseHelper= DatabaseHelper(this)

        databaseHelper.addPerson(MyModel(1,"majid","majidbagheri2851@gmail.com"))
        databaseHelper.addPerson(MyModel(2,"majid2851","majidbagheri28512@gmail.com"))


        Log.i("mag2851",databaseHelper.allData.toString())

    }
}