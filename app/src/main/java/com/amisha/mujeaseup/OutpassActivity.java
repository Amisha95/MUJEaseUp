package com.amisha.mujeaseup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class OutpassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outpass);
    }

    protected void sendInfo(View view) {
       try {
           EditText editText1 = (EditText) findViewById(R.id.editText);
           EditText editText2 = (EditText) findViewById(R.id.editText2);
           EditText editText3 = (EditText) findViewById(R.id.editText3);
           EditText editText4 = (EditText) findViewById(R.id.editText4);
           EditText editText5 = (EditText) findViewById(R.id.editText5);
           EditText editText6 = (EditText) findViewById(R.id.editText6);
           EditText editText7 = (EditText) findViewById(R.id.editText7);
           EditText editText8 = (EditText) findViewById(R.id.editText8);
           EditText editText9 = (EditText) findViewById(R.id.editText9);
           EditText editText10 = (EditText) findViewById(R.id.editText10);
           EditText editText11 = (EditText) findViewById(R.id.editText11);
           EditText editText12 = (EditText) findViewById(R.id.editText12);

           String name = editText1.getText().toString();
           String regno = editText2.getText().toString();
           String year = editText3.getText().toString();
           String branch = editText4.getText().toString();
           String room = editText5.getText().toString();
           String days = editText6.getText().toString();
           String from = editText7.getText().toString();
           String to = editText8.getText().toString();
           String address = editText9.getText().toString();
           String reason = editText10.getText().toString();
           String transport = editText11.getText().toString();
           String phone = editText12.getText().toString();


                Log.i("Send email", "");
                String[] TO = {"amisha.saya@gmail.com"};
                String[] CC = {"ankita1honey@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");

           emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
           emailIntent.putExtra(Intent.EXTRA_CC, CC);
           emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Outpass Request!");
           emailIntent.putExtra(Intent.EXTRA_TEXT, "Name:" + name + "\n" + "Registration Number:" + regno + "\n" + "Year:" +year +
           "\n" + "Branch/Course:" +branch+ "\n" + "Block/Room:" +room+ "\n" + "Days of Leave:" +days+ "\n" + "From:" +from+ "\n" +
                   "To:" +to+ "\n" + "Address:" +address+ "\n" + "Reason of Leave:" +reason+ "\n" + "Transport:" +transport+ "\n"
           + "Phone Number:" +phone );

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    Log.i("Sent!", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(OutpassActivity.this,
                            "There is no Email App Installed!", Toast.LENGTH_SHORT).show();
                }
            } catch (NullPointerException ne) {
                System.out.print(ne);
            }
     }
}
