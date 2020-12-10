package com.unicorndk.chatty;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.daasuu.bl.BubbleLayout;

public class ViewHolder extends RecyclerView.ViewHolder {
    BubbleLayout message;
    TextView messageText;
    TextView messageDate;
    TextView messageUserName;

    public ViewHolder(View itemView) {
        super(itemView);
        message = itemView.findViewById(R.id.message_item);
        messageText = message.findViewById(R.id.message_text);
        messageDate = message.findViewById(R.id.message_date);
        messageUserName = message.findViewById(R.id.message_user_name);
    }
}
