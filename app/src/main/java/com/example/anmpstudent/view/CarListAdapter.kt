package com.example.anmpstudent.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anmpstudent.R
import com.example.anmpstudent.model.Car
import com.example.anmpstudent.model.Student

class CarListAdapter(val carList:ArrayList<Car>): RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {
    class CarViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val txtInfo: TextView
        init {
            txtInfo = view.findViewById(R.id.txtInfo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.car_list_item, parent,false)
        return CarListAdapter.CarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.txtInfo.text = "${carList[position].model} \n ${carList[position].year} \n ${carList[position].features.toString()} \n ${carList[position].specs?.engine}"
    }

    fun updateCarList(newCarList:ArrayList<Car>) {
        carList.clear()
        carList.addAll(newCarList)
        notifyDataSetChanged()
    }

}