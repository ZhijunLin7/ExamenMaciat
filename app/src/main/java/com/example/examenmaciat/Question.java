package com.example.examenmaciat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Question extends AppCompatActivity {
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox check4;
    private Button button1;
    private Button button2;
    private RadioGroup radioGroup;
    private LinearLayout checkbox;
    private LinearLayout radio;
    private int numpregunta= 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        findeview();

    }

    public void findeview(){
        checkbox=(LinearLayout)findViewById(R.id.checkbox);
        radio=(LinearLayout)findViewById(R.id.radio);
        button1=(Button)findViewById(R.id.boton1) ;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numpregunta == 2) {
                    topre1();
                }
                if (numpregunta == 3) {
                    topre2();
                }
            }
        });
        button2=(Button)findViewById(R.id.boton2) ;
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numpregunta == 1) {
                    topre2();
                }
                if (numpregunta == 2) {

                }
            }
        });

        check1=(CheckBox) findViewById(R.id.check1);
        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                button2.setEnabled(true);
            }
        });
        check2=(CheckBox) findViewById(R.id.check2);
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                button2.setEnabled(true);
            }
        });
        check3=(CheckBox) findViewById(R.id.check3);
        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                button2.setEnabled(true);
            }
        });
        check4=(CheckBox) findViewById(R.id.check4);
        check4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                button2.setEnabled(true);
            }
        });

        radioGroup=(RadioGroup)findViewById(R.id.radio1) ;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                button2.setEnabled(true);
            }
        });

    }
    public void topre2(){
        checkbox.setVisibility(View.GONE);
        radio.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setEnabled(false);
        numpregunta=2;
    }
    public void topre1(){
        checkbox.setVisibility(View.VISIBLE);
        radio.setVisibility(View.GONE);
        button1.setVisibility(View.GONE);
        button2.setEnabled(true);
        numpregunta=2;
    }



}