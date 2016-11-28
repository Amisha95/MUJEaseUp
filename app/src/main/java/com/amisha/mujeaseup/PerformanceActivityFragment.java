package com.amisha.mujeaseup;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PerformanceActivityFragment extends Fragment {
    String ratings1;
    public PerformanceActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_performance,container,false);
        Intent intent = getActivity().getIntent();
        getActivity().setTitle("Ratings");
        if(intent!=null && intent.hasExtra("rating1")) {
            ratings1=intent.getStringExtra("rating1");
            TextView textView=(TextView)rootView.findViewById(R.id.rating1);
            textView.setText(ratings1);
        }
        return rootView;
    }
}
