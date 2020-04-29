package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultDisplay extends AppCompatActivity {
        TextView txt4,txt5,txt6;
        Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_display);
        txt4=findViewById(R.id.textView4);
        txt5=findViewById(R.id.textView5);
        txt6=findViewById(R.id.textView6);
        start=findViewById(R.id.start);
        Intent i=getIntent();
        String total=i.getStringExtra("total");
        String correct=i.getStringExtra("correct");
        String wrong=i.getStringExtra("wrong");

        txt4.setText(": "+total);
        txt5.setText(": "+correct);
        txt6.setText(": "+wrong);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResultDisplay.this,MainActivity.class);
               // intent.putExtra("total",ameharic);
                startActivity(intent);
            }
        });
    }
  }


