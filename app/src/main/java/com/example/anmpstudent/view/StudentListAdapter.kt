package com.example.anmpstudent.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.anmpstudent.databinding.StudentListItemBinding
import com.example.anmpstudent.model.Student

class StudentListAdapter(val studentList:ArrayList<Student>):RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonClickListener{
    class StudentViewHolder(val binding:StudentListItemBinding):RecyclerView.ViewHolder(binding.root) {
//        val txtID:TextView
//        val txtName:TextView
//        val btnDetail:Button
//        val imgPhoto:ImageView
//
//        init {
//            txtID = view.findViewById(R.id.txtID)
//            txtName = view.findViewById(R.id.txtName)
//            btnDetail = view.findViewById(R.id.btnDetail)
//            imgPhoto = view.findViewById(R.id.imgPhoto)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//
        val binding = StudentListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.student = studentList[position]
        holder.binding.listener = this
//        holder.txtID.text = studentList[position].id
//        holder.txtName.text = studentList[position].name
//        holder.btnDetail.setOnClickListener {
//            val action = StudentListFragmentDirections.actionStudentDetail()
//            Navigation.findNavController(it).navigate(action)
        }

//        val picasso = Picasso.Builder(holder.itemView.context)
//        picasso.listener { picasso, uri, exception ->
//            exception.printStackTrace()
//        }
//        picasso.build().load(studentList[position].photoUrl).into(holder.imgPhoto)
//    }

    fun updateStudentList(newStudentList:ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonClick(v: View) {
        val id = v.tag.toString()
        val action = StudentListFragmentDirections.actionStudentDetail(id)
        Navigation.findNavController(v).navigate(action)
    }
}


