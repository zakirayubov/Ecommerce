package ru.zakir.android.e_commerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import ru.zakir.android.e_commerce.model.Course
import ru.zakir.android.e_commerce.model.Order

class OrderPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_page)

        val ordersList: ListView = findViewById(R.id.order_list)

        val coursesTitle: MutableList<String> = mutableListOf()

        for (course: Course in MainActivity.fullCourseList) {
           if(Order.itemsId.contains(course.id)) {
               coursesTitle.add(course.title)
           }
        }

        ordersList.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, coursesTitle)
    }

}
