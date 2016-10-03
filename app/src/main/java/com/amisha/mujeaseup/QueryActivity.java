package com.amisha.mujeaseup;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class QueryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
    }


    protected void sendEmail(View view) {

        try {
            EditText editText = (EditText) findViewById(R.id.editText13);
            String query = editText.getText().toString();

            Log.i("Send email", "");
            String[] TO = {"amisha.saya@gmail.com"};
            String[] CC = {"xyz@gmail.com"};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");

            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_CC, CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Query!");
            emailIntent.putExtra(Intent.EXTRA_TEXT, query);

            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                finish();
                Log.i("Finished sending email!", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(QueryActivity.this,
                        "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
        } catch (NullPointerException ne) {
            System.out.print(ne);
        }
    }
}
