package ru.zakir.android.e_commerce.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.zakir.android.e_commerce.MainActivity
import ru.zakir.android.e_commerce.R
import ru.zakir.android.e_commerce.model.Category

class CategoryAdapter(var context: Context, var categories: MutableList<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val categoryItems: View = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(categoryItems)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.categoryTitle.text = categories[position].title

        holder.itemView.setOnClickListener {
            MainActivity.showCoursesByCategory(categories[position].id)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var categoryTitle: TextView = itemView.findViewById(R.id.categoryTitle)

    }
}