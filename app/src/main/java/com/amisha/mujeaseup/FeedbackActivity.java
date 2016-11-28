package com.amisha.mujeaseup;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class FeedbackActivity extends AppCompatActivity {
    RatingBar ratingBar1;
    RatingBar ratingBar2;
    RatingBar ratingBar3;
    RatingBar ratingBar4;
    RatingBar ratingBar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        onStarClick();
    }

    public void onStarClick() {
        ratingBar1=(RatingBar)findViewById(R.id.ratingBar);
        ratingBar2=(RatingBar)findViewById(R.id.ratingBar2);
        ratingBar3=(RatingBar)findViewById(R.id.ratingBar3);
        ratingBar4=(RatingBar)findViewById(R.id.ratingBar4);
        ratingBar5=(RatingBar)findViewById(R.id.ratingBar5);
        Button button=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating1=String.valueOf(ratingBar1.getRating());
                String rating2=String.valueOf(ratingBar2.getRating());
                String rating3=String.valueOf(ratingBar3.getRating());
                String rating4=String.valueOf(ratingBar4.getRating());
                String rating5=String.valueOf(ratingBar5.getRating());

                Intent intent = new Intent(getApplicationContext(),PerformanceActivityFragment.class);
                intent.putExtra("rating1",rating1).putExtra("rating2",rating2).putExtra("rating3",rating3)
                        .putExtra("rating4",rating4).putExtra("rating5",rating5);
                startActivity(intent);
            }
        });
    }
}
