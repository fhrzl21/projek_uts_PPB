package com.example.go_ruqyah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText etUser,etPass,etNama;
    Button submitBtn;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Username = "usernameKey";
    public static final String Password = "passwordKey";

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        etUser =(EditText) findViewById(R.id.etUser);
        etNama =(EditText) findViewById(R.id.etNama);
        etPass =(EditText) findViewById(R.id.etPass);
        submitBtn =(Button) findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Username, user);
                editor.putString(Password, pass);
                editor.commit();
                Toast.makeText(SignUp.this, "Welcome Back ^_^",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}