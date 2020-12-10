package com.unicorndk.chatty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataAdapter extends RecyclerView.Adapter<ViewHolder> {

    ArrayList<String> messages;
    LayoutInflater inflater;

    public DataAdapter(Context context, ArrayList messages) {
        this.messages = messages;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String msg = messages.get(position);
        holder.messageText.setText(msg);
        holder.messageDate.setText(DateFormat.format("HH:mm", new Date().getTime()));
        holder.messageUserName.setText("Guest");
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
















