package com.example.quote_app.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quote_app.R;
import com.example.quote_app.database.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<Quote> quotes = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Quote currentQuote = quotes.get(position);
        holder.quoteTextView.setText(currentQuote.getQuoteText());
        holder.authorTextView.setText(currentQuote.getAuthor());
    }


    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public void setQuotes(List<Quote> quoteList) {
        this.quotes = quoteList;
        notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private TextView quoteTextView, authorTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            quoteTextView = itemView.findViewById(R.id.quote_txt_view);
            authorTextView = itemView.findViewById(R.id.author_txt_view);

        }
    }
}


