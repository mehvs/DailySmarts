package com.example.quote_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolBar();
        setViewPager2();
        setTabLayout();

    }


    private void setToolBar() {
        toolBar = findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
    }

    private void setViewPager2() {
        viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new QuotePagerAdapter(this));
    }

    private void setTabLayout() {
        tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: {
                        tab.setText("DAILY QUOTE");
                    }
                    case 1: {
                        tab.setText("MY QUOTES");
                    }

                }
            }
        });
        tabLayoutMediator.attach();
    }
}