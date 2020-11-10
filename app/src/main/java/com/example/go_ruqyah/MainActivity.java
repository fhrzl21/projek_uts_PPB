package com.example.go_ruqyah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode){
        switch (selectedMode){
            case R.id.call_center :
                String noHp = "085259004702";
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("Tel :", noHp, null));
                startActivity(intent);
                break;
            case R.id.sms_center :
                Uri uri = Uri.parse("SMS to : 085259004702");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                it.putExtra("sms_body", "You Send Your Message");
                startActivity(it);
                break;
            case R.id.lokasi :
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/brdbPVhxTd68pzr9A"));
                startActivity(intent1);
                break;
            /*case R.id.update_pass :
                Preferences.clearALL(getBaseContext());
                Intent intent2 = new (MainActivity.this,SignUp.class);
                startActivity(intent2);
                break;

             */
        }
    }

/*
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String noHp = "085259004702";
        switch (item.getItemId()){
            case R.id.call_center:
                String uriTel = "Tel :"+noHp;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uriTel));
                startActivity(intent);
                break;
        }
        if (item.getItemId() == R.id.call_center){
            startActivity(new Intent(MainActivity.this,call_center.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private class call_center {
    }

 */
}