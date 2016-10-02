package com.amisha.mujeaseup;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class LoginActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button studentb = (Button) findViewById(R.id.button4);
        if(studentb!=null) studentb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                StudentDialog myDialog=new StudentDialog();
                myDialog.show(fragmentManager,"StudentDialog");
            }
        });

        Button guestb = (Button) findViewById(R.id.button3);
        if(guestb!=null) guestb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                GuestDialog myDialog=new GuestDialog();
                myDialog.show(fragmentManager,"GuestDialog");
            }
        });

        Button facultyb = (Button) findViewById(R.id.button5);
        if(facultyb!=null) facultyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FacultyDialog myDialog=new FacultyDialog();
                myDialog.show(fragmentManager,"FacultyDialog");
            }
        });
    }
}
