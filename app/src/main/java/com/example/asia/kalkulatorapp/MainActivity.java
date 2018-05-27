package com.example.asia.kalkulatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        switch(view.getId())
        {
            case R.id.simpleButton:
                Intent intent =new Intent(MainActivity.this, Simple.class);
                startActivity(intent);
                break;
            case R.id.advancedButton:
                intent =new Intent(MainActivity.this, Advanced.class);
                startActivity(intent);
                break;
            case R.id.aboutButton:
                intent =new Intent(MainActivity.this, About.class);
                startActivity(intent);
                break;
            case R.id.exitButton:
            {
                finish();
                System.exit(0);
                break;
            }
        }
    }
}
