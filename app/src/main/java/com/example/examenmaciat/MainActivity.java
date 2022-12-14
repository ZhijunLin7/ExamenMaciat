package com.example.examenmaciat;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;


public class MainActivity extends AppCompatActivity {
    private TextInputLayout t1;
    private TextInputEditText e1;
    private TextInputLayout t2;
    private TextInputEditText e2;
    private Button b1;
    private Button b2;
    private ImageView imageView;
    private int screen=1;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findview();

        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (validateEmail()) {
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (screen == 1) {
                   toScreen2();
                }else if (screen == 2){
                    if (encontrarEmail()) {
                        toScreen3();
                    }else{
                        e1.setText("");
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                    }
                }else if (screen==3){
                    if (encontrarcontra()&&encontrarEmail()) {
                        startPregunta();
                    }else{
                        toScreen2();
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (screen == 1) {
                    toScreen2();
                }else if (screen == 2){
                    save(e1.getText().toString(),false);
                    toScreen3();
                }else if (screen==3){
                    save(e2.getText().toString(),false);
                    startPregunta();
                }
            }
        });
    }

    public void findview(){
        t1=(TextInputLayout) findViewById(R.id.t1);
        e1=(TextInputEditText) findViewById(R.id.e1);
        t2=(TextInputLayout) findViewById(R.id.t2);
        e2=(TextInputEditText) findViewById(R.id.e2);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        imageView=(ImageView)findViewById(R.id.imageView);

    }
    public void toScreen2(){
        screen=2;
        imageView.setVisibility(View.GONE);
        b1.setEnabled(false);
        b2.setEnabled(false);
        t1.requestFocus();
        t2.setVisibility(View.GONE);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }
    public void toScreen3(){
        t2.setVisibility(View.VISIBLE);
        screen=3;
    }
    public boolean validateEmail(){
        boolean email= android.util.Patterns.EMAIL_ADDRESS.matcher(e1.getText().toString()).matches();
        return email;
    }

    public boolean encontrarEmail(){
        boolean encontrado=false;
        sharedPreferences=getSharedPreferences("info",Context.MODE_PRIVATE);
        String email=sharedPreferences.getString("Email",null);
        Toast.makeText(this, "email"+email, Toast.LENGTH_SHORT).show();
        if (e1.getText().toString().equals(email)) {
            encontrado=true;
        }

        return encontrado;
    }
    public boolean encontrarcontra(){
        boolean encontrado=false;
        sharedPreferences=getSharedPreferences("info",Context.MODE_PRIVATE);
        String contra=sharedPreferences.getString("Contra",null);
        Toast.makeText(this, "contra"+contra, Toast.LENGTH_SHORT).show();
        if (e2.getText().toString().equals(contra)) {
            encontrado=true;
        }

        return encontrado;
    }
    public void save(String contraOemail,boolean contra){
        if (contra) {
            sharedPreferences=getSharedPreferences("info",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor =sharedPreferences.edit();
            editor.putString("Contra",contraOemail);
            editor.commit();
        }else {
            sharedPreferences=getSharedPreferences("info",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor =sharedPreferences.edit();
            editor.putString("Email",contraOemail);
            editor.commit();
        }


    }
    public void  startPregunta(){
        Intent intent=new Intent(this,Question.class);
        startActivity(intent );
    }
}

