package com.example.quote_app.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProviders;

import com.example.quote_app.R;
import com.example.quote_app.database.model.Quote;
import com.example.quote_app.ui.adapters.RecyclerAdapter;
import com.example.quote_app.ui.viewmodels.QuoteViewModel;

import java.util.ArrayList;
import java.util.List;


public class FavoriteQuotesFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<String> quoteList;
    private QuoteViewModel quoteViewModel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorite_quotes, container, false);



        quoteList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(getActivity(), quoteList);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(recyclerAdapter);

        quoteList.add("Test");
        quoteList.add("Test 2");

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quoteViewModel = new ViewModelProvider(this).get(QuoteViewModel.class);
        quoteViewModel.getAllQuotes().observe(getViewLifecycleOwner(), new Observer<List<Quote>>() {
            @Override
            public void onChanged(List<Quote> quotes) {
                Toast.makeText(getActivity(),"On changed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}