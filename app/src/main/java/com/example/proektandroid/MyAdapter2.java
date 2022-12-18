package com.example.proektandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    private Context context2;
    private ArrayList  question_id2, answer1_id2, answer2_id2, answer3_id2, answer4_id2;

    public MyAdapter2(Context context2, ArrayList question_id2, ArrayList answer1_id2, ArrayList answer2_id2, ArrayList answer3_id2, ArrayList answer4_id2) {
        this.context2 = context2;
        this.question_id2 = question_id2;
        this.answer1_id2 = answer1_id2;
        this.answer2_id2 = answer2_id2;
        this.answer3_id2 = answer3_id2;
        this.answer4_id2 = answer4_id2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context2).inflate(R.layout.userentry2, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.question_id2.setText(String.valueOf(question_id2.get(position)));
        holder.answer1_id2.setText(String.valueOf(answer1_id2.get(position)));
        holder.answer2_id2.setText(String.valueOf(answer2_id2.get(position)));
        holder.answer3_id2.setText(String.valueOf(answer3_id2.get(position)));
        holder.answer4_id2.setText(String.valueOf(answer4_id2.get(position)));

    }

    @Override
    public int getItemCount() {
        return question_id2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView question_id2, answer1_id2, answer2_id2, answer3_id2, answer4_id2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            question_id2 = itemView.findViewById(R.id.textViewPrasanje2);
            answer1_id2 = itemView.findViewById(R.id.VtorcheckBoxOdgovor1);
            answer2_id2 = itemView.findViewById(R.id.VtorcheckBox2Odgovor2);
            answer3_id2 = itemView.findViewById(R.id.VtorcheckBox3Odgovor3);
            answer4_id2 = itemView.findViewById(R.id.VtorcheckBox4Odgovor4);
        }
    }
}
