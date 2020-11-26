package com.example.quote_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class QuotePagerAdapter extends FragmentStateAdapter {

    public QuotePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DailyQuoteFragment();
            case 1:
                return new FavoriteQuotesFragment();
            default:
                throw new IllegalArgumentException("There are not that much fragments");
        }


    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
