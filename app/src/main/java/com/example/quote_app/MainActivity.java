package com.example.quote_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolBar();
        setViewPager2();

    }


    private void setToolBar(){
        toolBar = findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
    }

    private void setViewPager2(){
        viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new QuotePagerAdapter(this));
    }
}