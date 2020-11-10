package com.example.go_ruqyah;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.go_ruqyah.SignUp.Password;
import static com.example.go_ruqyah.SignUp.Username;

public class Login extends AppCompatActivity {

    EditText etUser,etPass;
    Button submitBtn, callSignUp;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Username = "usernameKey";
    public static final String Password = "passwordKey";

    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        callSignUp = findViewById(R.id.signup_Screen);
        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        submitBtn = findViewById(R.id.submitBtn);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Username, user);
                editor.putString(Password, pass);
                editor.commit();
                Toast.makeText(Login.this, "Welcome To Dashboard",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}