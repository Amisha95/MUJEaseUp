package com.amisha.mujeaseup;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class GuestDialog extends DialogFragment implements View.OnClickListener {

    Button about,query;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guest_dialog,null);
        about = (Button) view.findViewById(R.id.button9);
        about.setOnClickListener(this);
        query = (Button) view.findViewById(R.id.button10);
        query.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button9) {
            Intent intent = new Intent(getActivity(),AboutActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(getActivity(),QueryActivity.class);
            startActivity(intent);
        }
    }
}
