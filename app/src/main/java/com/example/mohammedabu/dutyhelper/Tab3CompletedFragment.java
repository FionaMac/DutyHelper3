package com.example.mohammedabu.dutyhelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mohammedabu.dutyhelper.R;

/**
 * Created by User on 2/28/2017.
 */

public class Tab3CompletedFragment extends Fragment {
    private static final String TAG = "Tab3CompletedFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_completed,container,false);
        return view;
    }
}