package com.example.quote_app.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quote_app.R;
import com.example.quote_app.database.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Quote> quotes = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
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

    public Quote getQuoteAt(int position) {
        return quotes.get(position);
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        TextView quoteTextView, authorTextView;
        ImageView heartImageView, shareImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            quoteTextView = itemView.findViewById(R.id.quote_txt_view);
            authorTextView = itemView.findViewById(R.id.author_txt_view);
            heartImageView = itemView.findViewById(R.id.imageView);
            shareImageView = itemView.findViewById(R.id.share_image_view);

            heartImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onHeartClick(position);
                        }
                    }
                }
            });

            shareImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onShareClick(position);
                        }
                    }
                }
            });

        }
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
    
    public interface OnItemClickListener{
        void onHeartClick(int position);
        void onShareClick(int position);
    }
}


