package com.example.c196.UI;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196.R;
import com.example.c196.entities.Term;

import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {

    class TermViewHolder extends RecyclerView.ViewHolder {

        private final TextView termItemView;

        private TermViewHolder(View itemView) {
            super(itemView);

            termItemView = itemView.findViewById(R.id.textView6);
            termItemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                final Term curTerm = mTerms.get(position);
                Intent intent = new Intent(context, TermDetails.class);
                intent.putExtra("id", curTerm.getTermID());
                intent.putExtra("name", curTerm.getTermTitle());
                intent.putExtra("startDate", curTerm.getTermStartDate());
                intent.putExtra("endDate" , curTerm.getTermEndDate());
                context.startActivity(intent);
            });
        }
    }
    private List<Term> mTerms;
    private final Context context;
    private final LayoutInflater mInflater;

    public TermAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.term_item, parent, false);
        return new TermAdapter.TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {
        if(mTerms != null) {
            Term current = mTerms.get(position);
            String title = current.getTermTitle();
            holder.termItemView.setText(title);
        } else {
            holder.termItemView.setText("No Term Title");
        }
    }

    @Override
    public int getItemCount() {
        return mTerms.size();
    }

    public void setTerms(List<Term> terms) {
        mTerms = terms;
        notifyDataSetChanged();
    }
}