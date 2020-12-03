package com.example.quote_app.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.quote_app.ui.adapters.QuotePagerAdapter;
import com.example.quote_app.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private OnRefreshClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
        setRefreshButton();
        setToolBar();
        setViewPager2();
        setTabLayout();

    }

    private void setToolBar() {
        setSupportActionBar(binding.toolBar);
    }

    private void setViewPager2() {
        binding.viewPager.setAdapter(new QuotePagerAdapter(this));
    }

    private void setTabLayout() {
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: {
                        tab.setText("DAILY QUOTE");
                        break;
                    }
                    case 1: {
                        tab.setText("MY QUOTES");
                        break;
                    }

                }
            }
        });
        tabLayoutMediator.attach();
    }

    private void setRefreshButton() {
        binding.refreshImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getListener() != null) {
                    getListener().onRefreshClick();
                }
            }
        });
    }

    public OnRefreshClickListener getListener() {
        return listener;
    }

    public void setListener(OnRefreshClickListener listener) {
        this.listener = listener;
    }

    public interface OnRefreshClickListener {
        void onRefreshClick();

    }


}