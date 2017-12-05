package com.example.mohammedabu.dutyhelper.dbHelpers;

/**
 * Created by XavOli-Idea on 12/5/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import com.example.mohammedabu.dutyhelper.R;

public class CalendarTaskHolder extends RecyclerView.ViewHolder {

    private final TextView title;
    private final TextView description;
    private final TextView dateTime;


    public CalendarTaskHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.Task_Title);
        description = (TextView) itemView.findViewById(R.id.Single_TaskDescription);
        dateTime = (TextView) itemView.findViewById(R.id.Due_Date_Time);

    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setDateTime(String dateTime) {
        this.dateTime.setText(dateTime);
    }

}
