package com.example.user.thirdtask.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.thirdtask.R;
import com.example.user.thirdtask.model.Student;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    List<Student> students;

    public RecyclerViewAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item_student, viewGroup, false);
        return new RecyclerViewAdapter.RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.name.setText(students.get(i).fio);
        recyclerViewHolder.date.setText(students.get(i).date);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView date;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_fio);
            date = itemView.findViewById(R.id.item_date);
        }
    }
}
