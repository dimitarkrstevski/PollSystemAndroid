package com.example.proektandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList  question_id, answer1_id, answer2_id, answer3_id, answer4_id;

    public MyAdapter(Context context, ArrayList question_id, ArrayList answer1_id, ArrayList answer2_id, ArrayList answer3_id, ArrayList answer4_id) {
        this.context = context;
        this.question_id = question_id;
        this.answer1_id = answer1_id;
        this.answer2_id = answer2_id;
        this.answer3_id = answer3_id;
        this.answer4_id = answer4_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.question_id.setText(String.valueOf(question_id.get(position)));
        holder.answer1_id.setText(String.valueOf(answer1_id.get(position)));
        holder.answer2_id.setText(String.valueOf(answer2_id.get(position)));
        holder.answer3_id.setText(String.valueOf(answer3_id.get(position)));
        holder.answer4_id.setText(String.valueOf(answer4_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return question_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView question_id, answer1_id, answer2_id, answer3_id, answer4_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            question_id = itemView.findViewById(R.id.questionname);
            answer1_id = itemView.findViewById(R.id.checkBoxOdgovor1);
            answer2_id = itemView.findViewById(R.id.checkBox2Odgovor2);
            answer3_id = itemView.findViewById(R.id.checkBox3Odgovor3);
            answer4_id = itemView.findViewById(R.id.checkBox4Odgovor4);
        }
    }
}
