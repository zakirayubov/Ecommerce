package ru.zakir.android.e_commerce

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.zakir.android.e_commerce.MainActivity.Companion.courseList
import ru.zakir.android.e_commerce.adapter.CategoryAdapter
import ru.zakir.android.e_commerce.adapter.CourseAdapter
import ru.zakir.android.e_commerce.model.Category
import ru.zakir.android.e_commerce.model.Course
import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream

class MainActivity : AppCompatActivity() {
    private lateinit var categoryRecycler: RecyclerView
    private lateinit var courseRecycler: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categoryList: MutableList<Category> = mutableListOf()
        categoryList.add(Category(1, "Игры"))
        categoryList.add(Category(2, "Сайты"))
        categoryList.add(Category(3, "Языки"))
        categoryList.add(Category(4, "Прочие"))

        courseList.add(
            Course(
                1,
                "java",
                "Профессия Java \n разработчик",
                "1 апреля",
                "начальный",
                "#424345",
                "TEST",
                3
            )
        )
        courseList.add(
            Course(
                2,
                "python",
                "Профессия Python \n разработчик",
                "10 апреля",
                "начальный",
                "#9FA52D",
                "TEST",
                1
            )
        )

        fullCourseList.addAll(courseList)
        setCategoryRecycler(categoryList)
        setCourseRecycler(courseList)
    }

    private fun setCategoryRecycler(categoryList: MutableList<Category>) {
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        categoryRecycler = findViewById(R.id.categoryRecycler)
        categoryRecycler.layoutManager = layoutManager

        categoryAdapter = CategoryAdapter(this, categoryList)
        categoryRecycler.adapter = categoryAdapter
    }

    private fun setCourseRecycler(courseList: MutableList<Course>) {
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        courseRecycler = findViewById(R.id.courseRecycler)
        courseRecycler.layoutManager = layoutManager

        courseAdapter = CourseAdapter(this, courseList)
        courseRecycler.adapter = courseAdapter
    }

    fun openShoppingCart(view: View) {
        val intent = Intent(this, OrderPage::class.java)
        startActivity(intent)
    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        private lateinit var courseAdapter: CourseAdapter
        private val courseList: MutableList<Course> = mutableListOf()
        val fullCourseList: MutableList<Course> = mutableListOf()


        fun showCoursesByCategory(category: Int) {

            val filterCourses: MutableList<Course> = mutableListOf()

            for (course: Course in fullCourseList) {
                if (course.category == category) {
                    filterCourses.add(course)
                }
            }

            courseList.clear()
            courseList.addAll(filterCourses)
            courseAdapter.notifyDataSetChanged()
        }
    }

    fun showAll(view: View) {
        courseList.clear()
        courseList.addAll(fullCourseList)
        courseAdapter.notifyDataSetChanged()
    }
}
