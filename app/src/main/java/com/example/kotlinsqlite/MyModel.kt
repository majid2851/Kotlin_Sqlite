package com.example.kotlinsqlite

import android.provider.ContactsContract

class MyModel
{
    var id:Int=0
    var name:String?=null
    var email:String?=null

    constructor(){}

    constructor(id:Int,name:String,email:String){
        this.id=id
        this.name=name
        this.email=email
    }

    override fun toString(): String {
        return "id:"+id+"\t"+"name:"+name+"\t"+"email:"+email
    }



}