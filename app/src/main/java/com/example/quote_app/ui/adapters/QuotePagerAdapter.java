package com.example.quote_app.ui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quote_app.ui.fragments.DailyQuoteFragment;
import com.example.quote_app.ui.fragments.FavoriteQuotesFragment;

public class QuotePagerAdapter extends FragmentStateAdapter {

    public QuotePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new DailyQuoteFragment();
                break;
            case 1:
                fragment = new FavoriteQuotesFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
