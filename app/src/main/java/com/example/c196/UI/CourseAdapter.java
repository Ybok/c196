package com.example.c196.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196.R;
import com.example.c196.entities.Course;
import com.example.c196.entities.Term;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    class CourseViewHolder extends RecyclerView.ViewHolder {

        private final TextView courseItemView;
        private final TextView courseItemView2;
        private final TextView courseItemView3;
        private final TextView courseItemView4;
        private final TextView courseItemView5;

        private CourseViewHolder(View itemView) {
            super(itemView);
//            find applicable text view
            courseItemView = itemView.findViewById(R.id.textViewCourseTitle);
            courseItemView2 = itemView.findViewById(R.id.textViewCourseStart);
            courseItemView3 = itemView.findViewById(R.id.textViewCourseEnd);
            courseItemView4 = itemView.findViewById(R.id.textViewCourseStatus);
            courseItemView5 = itemView.findViewById(R.id.textViewCourseInstructor);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                final Course curCourse = mCourses.get(position);
                Intent intent = new Intent(context, CourseDetails.class);
                intent.putExtra("title", curCourse.getCourseTitle());
                intent.putExtra("startDate", curCourse.getCourseStartDate());
                intent.putExtra("endDate" , curCourse.getCourseEndDate());
                intent.putExtra("status" , curCourse.getCourseStatus());
                context.startActivity(intent);
            });
        }
    }
    private List<Course> mCourses;
    private final Context context;
    private final LayoutInflater mInflater;

    public CourseAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        if(mCourses != null) {
            Course current = mCourses.get(position);
            String title = current.getCourseTitle();
            holder.courseItemView.setText(title);
        } else {
            holder.courseItemView.setText("No Course Title");
        }
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    public void setCourses(List<Course> courses) {
        mCourses = courses;
        notifyDataSetChanged();
    }
}