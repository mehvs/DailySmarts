package com.example.quote_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<String> quoteList;
    Context context;

    public RecyclerAdapter(Context context, List<String> quoteList) {
        this.context = context;
        this.quoteList = quoteList;
    }


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
        holder.quoteTextView.setText(quoteList.get(position));
        holder.authorTextView.setText(quoteList.get(position));
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
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


