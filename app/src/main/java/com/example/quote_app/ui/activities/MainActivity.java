package com.example.quote_app.ui.activities;

import android.app.ActivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quote_app.ui.adapters.QuotePagerAdapter;
import com.example.quote_app.databinding.ActivityMainBinding;
import com.example.quote_app.util.InternetAvailabilityProvider;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private OnRefreshClickListener refreshListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        getAvailability();
        setContentView(view);
        setRefreshButton();
        setToolBar();
        setViewPager2();
        setTabLayout();

    }

    public OnRefreshClickListener getRefreshListener() {
        return refreshListener;
    }

    public void setRefreshListener(OnRefreshClickListener refreshListener) {
        this.refreshListener = refreshListener;
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
                if (getRefreshListener() != null) {
                    getRefreshListener().onRefreshClick();
                }
            }
        });
    }

    private void getAvailability() {
        InternetAvailabilityProvider internetAvailabilityProvider = new InternetAvailabilityProvider();
        Toast toast = Toast.makeText(getApplication(), "No internet access", Toast.LENGTH_LONG);
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {

                    try {
                        Thread.sleep(1000);  //1000ms = 1 sec

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                if (!internetAvailabilityProvider.isOnline(getApplication())) {
                                    if (!isInBackground()) {
                                        toast.show();
                                    } else {
                                        toast.cancel();
                                    }
                                }
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        };
        thread.start();


    }

    private boolean isInBackground() {
        ActivityManager.RunningAppProcessInfo myProcess = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(myProcess);
        return myProcess.importance != ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND;
    }


    public interface OnRefreshClickListener {
        void onRefreshClick();
    }

}