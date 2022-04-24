package com.example.kotlinsqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.reflect.Array.get

class DatabaseHelper(context:Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION)
{
    companion object{
        private val DATABASE_VERSION=2
        private val DATABASE_NAME="mag.db"

        private val TABLE_NAME="tableName"
        private val COL_ID="id"
        private val COL_NAME="name"
        private val COL_EMAIL="email"

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

    val allData:List<MyModel>  get()
    {
        val listPersons=ArrayList<MyModel>()
        val selectQuery="SELECT * FROM $TABLE_NAME"
        val db=this.writableDatabase
        val cursor=db.rawQuery(selectQuery,null)
        if (cursor.moveToFirst()){
            do {
                val model=MyModel()
                model.id=cursor.getInt(0)
                model.name=cursor.getString(1)
                model.email=cursor.getString(2)
                listPersons.add(model)
            }while (cursor.moveToNext())
        }
        db.close()
        return listPersons

    }

    fun addPerson(model:MyModel){
        val db=this.writableDatabase
        val values=ContentValues()
        values.put(COL_ID,model.id)
        values.put(COL_NAME,model.name)
        values.put(COL_EMAIL,model.email)

        db.insert(TABLE_NAME, null,values)
        db.close()
    }


    fun updatePerson(model:MyModel){
        val db=this.writableDatabase
        val values=ContentValues()
        values.put(COL_ID,model.id)
        values.put(COL_NAME,model.name)
        values.put(COL_EMAIL,model.email)

        db.update(TABLE_NAME, values,"$COL_ID=?", arrayOf(model.id.toString()))
        db.close()
    }

    fun deletePerson(model:MyModel){
        val db=this.writableDatabase
        val values=ContentValues()
        values.put(COL_ID,model.id)
        values.put(COL_NAME,model.name)
        values.put(COL_EMAIL,model.email)

        db.delete(TABLE_NAME,"$COL_ID=?", arrayOf(model.id.toString()))
        db.close()
    }



//    fun getListPersons():List<MyModel>{
//        val listPersons=ArrayList<MyModel>()
//        val selectQuery="SELECT * FROM $TABLE_NAME"
//        val db=this.writableDatabase
//        val cursor=db.rawQuery(selectQuery,null)
//        if (cursor.moveToFirst()){
//            do {
//                val model=MyModel()
//                model.id=cursor.getInt(0)
//                model.name=cursor.getString(1)
//                model.email=cursor.getString(2)
//                listPersons.add(model)
//            }while (cursor.moveToNext())
//        }
//        return listPersons
//    }





}


