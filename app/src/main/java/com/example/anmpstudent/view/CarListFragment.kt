package com.example.anmpstudent.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anmpstudent.R
import com.example.anmpstudent.viewmodel.CarViewModel
import com.example.anmpstudent.viewmodel.ListViewModel

class CarListFragment : Fragment() {
    private lateinit var viewModel: CarViewModel
    private val carListAdapter  = CarListAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CarViewModel::class.java)
        viewModel.refresh()

        Log.d("CEKMASUK", "tes")

        val recView = view.findViewById<RecyclerView>(R.id.recCarView)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = carListAdapter

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.carsLD.observe(viewLifecycleOwner, Observer {
            carListAdapter.updateCarList(it)
        })
    }
}