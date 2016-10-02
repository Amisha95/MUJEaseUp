package com.amisha.mujeaseup;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StudentDialog extends DialogFragment implements View.OnClickListener {

    Button ams,feedback,outpass;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.studentdialog,null);
        ams = (Button) view.findViewById(R.id.button6);
        ams.setOnClickListener(this);
        feedback = (Button) view.findViewById(R.id.button7);
        feedback.setOnClickListener(this);
        outpass = (Button) view.findViewById(R.id.button8);
        outpass.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button6) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http:ams.muj.edu.in/sis"));
            startActivity(browserIntent);
        }
        else if(v.getId()==R.id.button7) {

        }
        else {
            Intent intent = new Intent(getActivity(),OutpassActivity.class);
            startActivity(intent);
        }
    }
}
