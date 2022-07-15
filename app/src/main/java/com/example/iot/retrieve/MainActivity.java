package com.example.iot.retrieve;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {



    TextView a,b;
    Button btn;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a=(TextView)findViewById(R.id.parking);
        b=(TextView)findViewById(R.id.parking2);



                reff = FirebaseDatabase.getInstance().getReference().child("available");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        String status = dataSnapshot.child("available").getValue().toString();
                        String status2 = dataSnapshot.child("available2").getValue().toString();
                        a.setText(status);
                        b.setText(status2);
                        if(status.equals("true"))
                        {
                            a.setText("Available");
                            a.setBackgroundColor(Color.GREEN);
                        }
                        else {
                            a.setText("Occupied");
                            a.setBackgroundColor(Color.RED);
                        }
                        if(status2.equals("true"))
                        {
                            b.setText("Available");
                            b.setBackgroundColor(Color.GREEN);
                        }
                        else {
                            b.setText("Occupied");
                            b.setBackgroundColor(Color.RED);

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        };
