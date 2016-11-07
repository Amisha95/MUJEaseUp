package com.amisha.mujeaseup;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FacultyDialog extends DialogFragment implements View.OnClickListener {

    Button performance;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faculty_dialog,null);
        performance = (Button) view.findViewById(R.id.button11);
        performance.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button11) {

        }
        else {

        }
    }
}
