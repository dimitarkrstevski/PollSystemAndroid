package com.example.proektandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> {
    private Context context3;
    private ArrayList  question_id3, answer1_id3, answer2_id3, answer3_id3, answer4_id3;

    public MyAdapter3(Context context3, ArrayList question_id3, ArrayList answer1_id3, ArrayList answer2_id3, ArrayList answer3_id3, ArrayList answer4_id3) {
        this.context3 = context3;
        this.question_id3 = question_id3;
        this.answer1_id3 = answer1_id3;
        this.answer2_id3 = answer2_id3;
        this.answer3_id3 = answer3_id3;
        this.answer4_id3 = answer4_id3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context3).inflate(R.layout.userentry3, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.question_id3.setText(String.valueOf(question_id3.get(position)));
        holder.answer1_id3.setText(String.valueOf(answer1_id3.get(position)));
        holder.answer2_id3.setText(String.valueOf(answer2_id3.get(position)));
        holder.answer3_id3.setText(String.valueOf(answer3_id3.get(position)));
        holder.answer4_id3.setText(String.valueOf(answer4_id3.get(position)));

    }

    @Override
    public int getItemCount() {
        return question_id3.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView question_id3, answer1_id3, answer2_id3, answer3_id3, answer4_id3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            question_id3 = itemView.findViewById(R.id.textViewPrasanje3);
            answer1_id3 = itemView.findViewById(R.id.TretcheckBoxOdgovor1);
            answer2_id3 = itemView.findViewById(R.id.TretcheckBox2Odgovor2);
            answer3_id3 = itemView.findViewById(R.id.TretcheckBox3Odgovor3);
            answer4_id3 = itemView.findViewById(R.id.TretcheckBox4Odgovor4);
        }
    }
}
