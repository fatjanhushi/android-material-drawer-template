package com.fatjoni.droid.t25guide;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by user on 5/5/2015.
 */
public class CardViewDataAdapter extends RecyclerView.Adapter<CardViewDataAdapter.ViewHolder> {

    private List<Workout> workoutList;

    public CardViewDataAdapter(List<Workout> workoutList) {
        this.workoutList = workoutList;
    }


    @Override
    public CardViewDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_row, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final int pos = i;
        viewHolder.tvName.setText(workoutList.get(i).getName());
        viewHolder.chkSelected.setChecked(workoutList.get(i).isChecked());
        viewHolder.chkSelected.setTag(workoutList.get(i));

        viewHolder.chkSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                Workout workout = (Workout) cb.getTag();

                workout.setIsChecked(cb.isChecked());
                workoutList.get(pos).setIsChecked(cb.isChecked());

                Toast.makeText(v.getContext(),"Clicked on Checkbox: " + cb.getText() + " is "+ cb.isChecked(), Toast.LENGTH_LONG).show();
            }
        });


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public CheckBox chkSelected;

        public Workout singleWorkout;

        public ViewHolder(View v) {
            super(v);

            tvName = (TextView) v.findViewById(R.id.tvName);
            chkSelected = (CheckBox) v.findViewById(R.id.chkSelected);

        }

    }

}

