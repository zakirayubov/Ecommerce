package ru.zakir.android.e_commerce.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ru.zakir.android.e_commerce.CoursePage
import ru.zakir.android.e_commerce.R
import ru.zakir.android.e_commerce.model.Course

class CourseAdapter(var context: Context, var courses: MutableList<Course>) :
    RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val courseItems: View =
            LayoutInflater.from(context).inflate(R.layout.course_item, parent, false)
        return CourseViewHolder(courseItems)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.courseBg.setCardBackgroundColor(Color.parseColor(courses[position].color))

        val imageId: Int = context.resources.getIdentifier(
            "ic_" + courses[position].img,
            "drawable",
            context.packageName
        )
        holder.courseImage.setImageResource(imageId)

        holder.courseTitle.text = courses[position].title
        holder.courseDate.text = courses[position].date
        holder.courseLevel.text = courses[position].level

        holder.itemView.setOnClickListener {
            val intent = Intent(context, CoursePage::class.java)

             val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                 context as Activity,
                 Pair(holder.courseImage, "courseImage")
             )

            intent.putExtra("courseBg", Color.parseColor(courses[position].color))
            intent.putExtra("courseImage", imageId)
            intent.putExtra("courseTitle", courses[position].title)
            intent.putExtra("courseDate", courses[position].date)
            intent.putExtra("courseLevel", courses[position].level)
            intent.putExtra("courseText", courses[position].text)
            intent.putExtra("courseId", courses[position].id)

            context.startActivity(intent, options.toBundle())
        }

    }

    override fun getItemCount(): Int {
        return courses.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var courseBg: CardView = itemView.findViewById(R.id.courseBg)
        var courseImage: ImageView = itemView.findViewById(R.id.courseImage)
        var courseTitle: TextView = itemView.findViewById(R.id.courseTitle)
        var courseDate: TextView = itemView.findViewById(R.id.courseDate)
        var courseLevel: TextView = itemView.findViewById(R.id.courseLevel)

    }
}