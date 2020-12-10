package com.unicorndk.chatty;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.view.View;

import android.widget.EditText;

import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static int MAX_MESSAGE_LENGTH = 150;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("messages");

    FloatingActionButton button;
    EditText editTextMessage;
    RecyclerView messageRecycler;

    ArrayList<String> messages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.send_button);
        editTextMessage = findViewById(R.id.text_area);
        messageRecycler = findViewById(R.id.messages_recycler);

        messageRecycler.setLayoutManager(new LinearLayoutManager(this));

        final DataAdapter dataAdapter = new DataAdapter(this, messages);
        messageRecycler.setAdapter(dataAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editTextMessage.getText().toString();

                if (msg.equals("")) {
                    Toast.makeText(getApplicationContext(), "Вы не ввели сообщение!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (msg.length() > MAX_MESSAGE_LENGTH) {
                    Toast.makeText(getApplicationContext(), "Вы превысили лимит символов!", Toast.LENGTH_LONG).show();
                    return;
                }

                myRef.push().setValue(msg);
                editTextMessage.setText("");
            }
        });

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String msg = dataSnapshot.getValue(String.class);
                messages.add(msg);
                dataAdapter.notifyDataSetChanged();
                messageRecycler.smoothScrollToPosition(messages.size());

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}















