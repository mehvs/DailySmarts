package com.example.quote_app.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.quote_app.R;
import com.example.quote_app.database.model.Quote;
import com.example.quote_app.databinding.FragmentDailyQuoteBinding;
import com.example.quote_app.retrofit.ApiServer;
import com.example.quote_app.ui.viewmodels.QuoteViewModel;


public class DailyQuoteFragment extends Fragment {

    private FragmentDailyQuoteBinding binding;
    private QuoteViewModel quoteViewModel;
    private Boolean isClicked = false;

    public DailyQuoteFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onGetQuoteClicked();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        binding = FragmentDailyQuoteBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        quoteViewModel = ViewModelProviders.of(getActivity()).get(QuoteViewModel.class);

        setupHeartButton();

        return view;
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

    private void setupHeartButton() {
        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isClicked) {
                    Quote quote = new Quote(binding.quoteTxtView.getText().toString(), binding.authorTxtView.getText().toString());
                    quoteViewModel.insert(quote);
                    binding.imageView.setBackgroundResource(R.drawable.ic_favorite_black_24px);
                    isClicked = true;
                } else {
                    quoteViewModel.deleteByQuoteText(binding.quoteTxtView.getText().toString());
                    binding.imageView.setBackgroundResource(R.drawable.ic_favorite_border_black_24px);
                    isClicked = false;
                }
            }
        });
    }
}