package com.example.quote_app.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.quote_app.databinding.FragmentDailyQuoteBinding;
import com.example.quote_app.retrofit.ApiServer;





public class DailyQuoteFragment extends Fragment {

    private FragmentDailyQuoteBinding binding;

    public DailyQuoteFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onGetQuoteClicked();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDailyQuoteBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;

        // return inflater.inflate(R.layout.fragment_daily_quote, container, false);
    }

    private void onGetQuoteClicked() {

        ApiServer.getInstance().getRandomQuote(new ApiServer.ApiListener() {
            @Override
            public void onQuoteReceived(String quote, String author) {
                binding.quoteTxtView.setText(quote);
                binding.authorTxtView.setText(author);
            }

            @Override
            public void onFailure() {
                //Toast.makeText(DailyQuoteFragment.this, "Something happened", Toast.LENGTH_LONG).show();
            }
        });


    }
}