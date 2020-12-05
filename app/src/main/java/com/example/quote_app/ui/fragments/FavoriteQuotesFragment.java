package com.example.quote_app.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quote_app.R;
import com.example.quote_app.ui.adapters.RecyclerAdapter;
import com.example.quote_app.ui.viewmodels.QuoteViewModel;

public class FavoriteQuotesFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private QuoteViewModel quoteViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_quotes, container, false);

        buildRecyclerView(view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quoteViewModel = new ViewModelProvider(this).get(QuoteViewModel.class);
        quoteViewModel.getAllQuotes().observe(getViewLifecycleOwner(), quotes -> recyclerAdapter.setQuotes(quotes));
    }

    public void buildRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {

            @Override
            public void onHeartClick(int position) {
                quoteViewModel.delete(recyclerAdapter.getQuoteAt(position));
            }

            @Override
            public void onShareClick(int position) {
                recyclerAdapter.getQuoteAt(position).getQuoteText().toString();
                recyclerAdapter.getQuoteAt(position).getAuthor().toString();

                String shareText = "\"" + recyclerAdapter.getQuoteAt(position).getQuoteText().toString() + "\"" + "-" + recyclerAdapter.getQuoteAt(position).getAuthor().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                sendIntent.setType("text/*");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

    }


}