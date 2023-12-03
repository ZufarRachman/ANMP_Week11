package com.example.anmpstudent.model

import com.google.gson.annotations.SerializedName

data class Student(
    val id:String?,
    @SerializedName("student_name")
    val name:String?,
    @SerializedName("birth_of_date")
    val bod:String?,
    val phone:String?,
    @SerializedName("photo_url")
    val photoUrl:String
)

data class Car(
    val model:String?,
    val year:String?,
    val features:List<String>?,
    val specs:CarSpecifications?
)

data class CarSpecifications(
    val engine: String?,
    val transmission: String?,
    val fuelType: String?,
    val motor: String?,
    val battery: String?
)