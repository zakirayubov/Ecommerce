package ru.zakir.android.e_commerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import ru.zakir.android.e_commerce.model.Order

class CoursePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_page)

        val courseBg: ConstraintLayout = findViewById(R.id.coursePageBg)
        val courseImage: ImageView = findViewById(R.id.coursePageImage)
        val courseTitle: TextView = findViewById(R.id.coursePageTitle)
        val courseDate: TextView = findViewById(R.id.coursePageDate)
        val courseLevel: TextView = findViewById(R.id.coursePageLevel)
        val courseText: TextView = findViewById(R.id.coursePageText)

        courseBg.setBackgroundColor(intent.getIntExtra("courseBg", 0))
        courseImage.setImageResource(intent.getIntExtra("courseImage", 0))
        courseTitle.text = intent.getStringExtra("courseTitle")
        courseDate.text = intent.getStringExtra("courseDate")
        courseLevel.text = intent.getStringExtra("courseLevel")
        courseText.text = intent.getStringExtra("courseText")

    }

    fun addToCart(view: View) {
        val itemId: Int = intent.getIntExtra("courseId", 0)
        Order.itemsId.add(itemId)
        Toast.makeText(this, "Добавлено!", Toast.LENGTH_LONG).show()
    }
}