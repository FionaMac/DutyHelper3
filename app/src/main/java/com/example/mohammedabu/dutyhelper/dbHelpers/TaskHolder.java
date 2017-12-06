package com.example.mohammedabu.dutyhelper.dbHelpers;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.mohammedabu.dutyhelper.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TaskHolder extends RecyclerView.ViewHolder {

    private final TextView title;
    private final TextView description;
    private final TextView assignee;
    private final TextView dateTime;
    private final ImageView hamburgerMenuButton;

    private final ToggleButton completedToggle;
    private final TextView points;

    private PopupMenu popUp;


    public TaskHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.Task_Title);
        description = (TextView) itemView.findViewById(R.id.Single_TaskDescription);
        assignee = (TextView) itemView.findViewById(R.id.Single_Task_Assignee);
        dateTime = (TextView) itemView.findViewById(R.id.Due_Date_Time);
        completedToggle = (ToggleButton)itemView.findViewById(R.id.chkState);

        hamburgerMenuButton = (ImageButton) itemView.findViewById(R.id.hamburger_card);

        points = (TextView) itemView.findViewById(R.id.Task_Points);

//        radioButton = (ImageView) itemView.findViewById(R.id.iv_image);

    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setStatus(boolean completed) {
        int resID;
        if (completed) {
            resID = R.drawable.abc_btn_radio_to_on_mtrl_015;
        } else {
            resID = R.drawable.abc_btn_radio_to_on_mtrl_000;
        }
//        radioButton.setImageResource(resID);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setAssignee(String assignee) {
        this.assignee.setText(assignee);
    }

    public void setDateTime(String dateTime) {
        this.dateTime.setText(dateTime);
    }

    public void setPoints(int points) {
        String text = String.valueOf(points) + " Points";
        this.points.setText(text);
    }

    @Deprecated
    public ImageView getRadioButton() {
//        return radioButton;
        return null;
    }

    public ImageView getHamburgerButton() {
        return hamburgerMenuButton;
    }

    public ToggleButton getCompletedToggle() {
        return completedToggle;
    }
}
