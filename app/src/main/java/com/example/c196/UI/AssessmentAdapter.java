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
import com.example.c196.entities.Assessment;

import java.util.List;

public class AssessmentAdapter extends RecyclerView.Adapter<AssessmentAdapter.AssessmentViewHolder> {

    class AssessmentViewHolder extends RecyclerView.ViewHolder {

        private final TextView assessmentItemView;

        private AssessmentViewHolder(View itemView) {
            super(itemView);

            assessmentItemView = itemView.findViewById(R.id.textViewAssessmentTitle);
            assessmentItemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                final Assessment curAssessment = mAssessments.get(position);
                Intent intent = new Intent(context, AssessmentDetails.class);
                intent.putExtra("id" , curAssessment.getAssessmentID());
                intent.putExtra("title" , curAssessment.getAssessmentTitle());
                intent.putExtra("type" , curAssessment.getAssessmentType());
                intent.putExtra("startDate" , curAssessment.getAssessmentStartDate());
                intent.putExtra("endDate" , curAssessment.getAssessmentEndDate());
                intent.putExtra("courseID" , curAssessment.getCourseID());
                context.startActivity(intent);
            });
        }
    }

    private List<Assessment> mAssessments;
    private final Context context;
    private final LayoutInflater mInflater;

    public AssessmentAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public AssessmentAdapter.AssessmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.assessment_item, parent, false);
        return new AssessmentAdapter.AssessmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AssessmentAdapter.AssessmentViewHolder holder, int position) {
        if(mAssessments != null) {
            Assessment current = mAssessments.get(position);
            String title = current.getAssessmentTitle();
            holder.assessmentItemView.setText(title);
        } else {
            holder.assessmentItemView.setText("No Assessment Title");
        }
    }

    @Override
    public int getItemCount() {
        return mAssessments.size();
    }

    public void setAssessments(List<Assessment> assessments) {
        mAssessments = assessments;
        notifyDataSetChanged();
    }

}
