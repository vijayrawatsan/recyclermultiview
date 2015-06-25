package com.vijayrawatsan.recyclermultiview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.koushikdutta.ion.Ion;


public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Ion.getDefault(this.getApplicationContext()).configure().setLogging("ION_LOGS", Log.DEBUG);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.tb_top);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new HomeFragment()).commit();
        }
    }
}
