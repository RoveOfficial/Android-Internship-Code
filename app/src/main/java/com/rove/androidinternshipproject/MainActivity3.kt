package com.rove.androidinternshipproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val myShapes:List<Shape> = arrayListOf(Shape("sqaure","blue"),Shape("rectangle","yellow"),Shape("sqaure","red"))
        val persons:List<Person> = arrayListOf(Person("sqaure",15),Person("rectangle",20),Person("sqaure",30))
        //myShapes.myShapeFilter { it.name == "square" }
       myShapes.myShapeFilter(::myShapeFilterFunction)
        persons.myShapeFilter { it.age > 10 }
        val myLiveData= MutableLiveData<Person>()
    }

private fun myShapeFilterFunction(shape:Shape):Boolean{
        return shape.name == "square"
    }

    class Shape(val name:String, val color:String){

    }

    class Person(val name:String, val age:Int){

    }


    fun <MyType> List<MyType>.myShapeFilter(filterFunction: (myType:MyType) -> Boolean) : List<MyType>{
        val resultList = ArrayList<MyType>()
        for(item in this){
            if(filterFunction.invoke(item)){
                resultList.add(item)
            }
        }
        return resultList
    }



}