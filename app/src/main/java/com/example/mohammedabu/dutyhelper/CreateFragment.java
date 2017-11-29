package com.example.mohammedabu.dutyhelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohammedabu.dutyhelper.dbHelpers.UserHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Mohammed on 25/09/2017.
 */

public class CreateFragment extends Fragment {
    ImageButton datePicker;
    Button cancel;
    Button create;
    ImageButton timePicker;
    TextView taskDate;
    TextView taskTime;
    EditText task;
    EditText taskDescription;
    DatabaseReference db;
    String userID;
    FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        userID= new UserHelper(firebaseAuth.getInstance()).getUID();

        View view = inflater.inflate(R.layout.activity_create, container, false);
        //Creating the Spinner with the user's name into the application.
        Spinner mySpinner = (Spinner)view.findViewById(R.id.create_UserSelection);
        //The Strings that will use the users names from the array string in the strings.xml file in resources.
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        db=FirebaseDatabase.getInstance().getReference("events");

        taskDate = (TextView)view.findViewById(R.id.taskDate) ;
        taskTime = (TextView) view.findViewById(R.id.taskTime);

        task= (EditText) view.findViewById(R.id.task);

        taskDescription = (EditText) view.findViewById(R.id.taskDescription);

        cancel = (Button)view.findViewById(R.id.buttonCancel);
        //navigating from this fragment page to the calendar page once the cancel button is clicked
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new CalenderFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().replace(getId(), fragment);
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        create= (Button)view.findViewById(R.id.buttonCreate);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });

       timePicker = (ImageButton)view.findViewById(R.id.imageButtonTimePicker);
       timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timeDialog = new TimeFragment();
                timeDialog.show(getFragmentManager(), "TimePicker");
            }
        });


        datePicker = (ImageButton)view.findViewById(R.id.imageButtonDatePicker);
        //popping the datePicker dialogue when select date is pressed.
        datePicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DialogFragment dateDialog = new DateFragment();
                dateDialog.show(getFragmentManager(), "DatePicker");

            }
        });

        return view;
    }

    private void addProduct(){
        String date=taskDate.getText().toString().trim();
        String name=task.getText().toString().trim();
        String description=taskDescription.getText().toString().trim();
        String time= taskTime.getText().toString().trim();

        if (!(TextUtils.isEmpty(name)&&TextUtils.isEmpty(date))){
            String id=db.push().getKey();
            CalendarTask event=new CalendarTask(name, date, time, description, 0, "user");// edit to add points and assignee
            db.child(userID+id).setValue(event);
            task.setText("");
            taskTime.setText("");
            taskDescription.setText("");
            taskDescription.setText("");
            Toast.makeText(getActivity(), "Event added", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getActivity(), "Please enter event details", Toast.LENGTH_LONG).show();
        }



    }

}
