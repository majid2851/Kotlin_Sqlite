package com.example.kotlinsqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.reflect.Array.get

class DatabaseHelper(context:Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION)
{
    companion object{
        private val DATABASE_VERSION=1
        private val DATABASE_NAME="mag.db"

        private val TABLE_NAME="tableName"
        private val COL_ID="tableName"
        private val COL_NAME="tableName"
        private val COL_EMAIL="tableName"

    }



    override fun onCreate(db: SQLiteDatabase?) {
        val createTable=("create table "+ TABLE_NAME+"( " + COL_ID+" INTEGER PRIMARY KEY ,"+
                COL_NAME+" TEXT,"+ COL_EMAIL+" TEXT)")
        db!!.execSQL(createTable)


    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        //db!!.execSQL("Drop Table if exists "+ TABLE_NAME)
        db!!.execSQL("Drop table if exists $TABLE_NAME")
        onCreate(db)
    }

    val allData:List<MyModel>
    get(){
        val lstPersons=ArrayList<MyModel>()
        val selectQuery="SELECT * FROM $TABLE_NAME"
        val db=this.writableDatabase
        val cursor=db.rawQuery(selectQuery,null)
        if (cursor.moveToFirst()){
            do {
                val model=MyModel()
                model.id=cursor.getInt(cursor.getColumnIndex(COL_ID))
                model.name=cursor.getString(cursor.getColumnIndex(COL_NAME))
                model.email=cursor.getString(cursor.getColumnIndex(COL_EMAIL))
            }while ()


        }


    }






}


