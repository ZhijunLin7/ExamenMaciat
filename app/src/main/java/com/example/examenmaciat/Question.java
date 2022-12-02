package com.example.examenmaciat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Question extends AppCompatActivity {
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private ProgressBar progressBar;
    private LinearLayout linearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        findeview();


    }


    public void findeview(){
         TextView t1=(TextView)findViewById(R.id.q1);
         TextView t2=(TextView)findViewById(R.id.q2);
         TextView t3=(TextView)findViewById(R.id.q3);
         ProgressBar progressBar=(ProgressBar)findViewById(R.id.progressBar);
         LinearLayout linearLayout=(LinearLayout)findViewById(R.id.linearLayout1);
    }

    public void  actualizarP(){

    }
}