package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class menuActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView question,timer;
    DatabaseReference databaseReference;
    int total=0;
    int correct=0;
    int wrong=0;
    String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        question=findViewById(R.id.questionTxt);
        timer=findViewById(R.id.timerTxt);
        Intent i=getIntent();
        category=i.getStringExtra("total");
        updateQuestion();

    }
    public void updateQuestion(){
        total++;
        if (total >5){
            Intent intent=new Intent(menuActivity.this,ResultDisplay.class);
            intent.putExtra("total",String.valueOf(total -1));
            intent.putExtra("correct",String.valueOf(correct));
            intent.putExtra("wrong",String.valueOf(wrong));
            startActivity(intent);
        }
        else {
            databaseReference= FirebaseDatabase.getInstance().getReference().child(category).child(String.valueOf(total));
            if (databaseReference != null){

            }
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Questions questions =dataSnapshot.getValue(Questions.class);
                    reversTimer(30,timer);
                    question.setText(questions.getQuestion());
                    b1.setText(questions.getOption1());
                    b2.setText(questions.getOption2());
                    b3.setText(questions.getOption3());
                    b4.setText(questions.getOption4());


                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (b1.getText().toString().equals(questions.getAnswer())){
                                b1.setBackground(getResources().getDrawable(R.drawable.green));
                             //   b1.setBackgroundColor(R.drawable.green);
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackground(getResources().getDrawable(R.drawable.round_button));
                                      //  b1.setBackgroundColor(R.drawable.round_button);
                                        updateQuestion();
                                    }
                                },1500);
                            }else {
                                wrong++;
                                b1.setBackground(getResources().getDrawable(R.drawable.red));
                             //   b1.setBackgroundColor(R.drawable.red);
                                if (b2.getText().toString().equals(questions.getAnswer())){
                                    b2.setBackground(getResources().getDrawable(R.drawable.green));
                                   // b2.setBackgroundColor(R.drawable.green);
                                }
                                else if (b3.getText().toString().equals(questions.getAnswer())){
                                    b3.setBackground(getResources().getDrawable(R.drawable.green));
                                  //  b3.setBackgroundColor(R.drawable.green);
                                }
                                else if (b4.getText().toString().equals(questions.getAnswer())){
                                    b4.setBackground(getResources().getDrawable(R.drawable.green));
                                    //b4.setBackgroundColor(R.drawable.green);
                                }
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackground(getResources().getDrawable(R.drawable.round_button));
                                        b2.setBackground(getResources().getDrawable(R.drawable.round_button));
                                        b3.setBackground(getResources().getDrawable(R.drawable.round_button));
                                        b4.setBackground(getResources().getDrawable(R.drawable.round_button));
//                                        b1.setBackgroundColor(R.drawable.round_button);
//                                        b2.setBackgroundColor(R.drawable.round_button);
//                                        b3.setBackgroundColor(R.drawable.round_button);
//                                        b4.setBackgroundColor(R.drawable.round_button);
                                        updateQuestion();
                                    }
                                },1500);
                            }

                        }
                    });

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (b2.getText().toString().equals(questions.getAnswer())){
                                b2.setBackground(getResources().getDrawable(R.drawable.green));
                               // b2.setBackgroundColor(R.drawable.green);
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackground(getResources().getDrawable(R.drawable.round_button));
                                      //  b2.setBackgroundColor(R.drawable.round_button);
                                        updateQuestion();
                                    }
                                },1500);
                            }else {
                                wrong++;
                                b2.setBackground(getResources().getDrawable(R.drawable.red));
                              //  b2.setBackgroundColor(R.drawable.red);
                                if (b1.getText().toString().equals(questions.getAnswer())){
                                    b1.setBackground(getResources().getDrawable(R.drawable.green));
                                   // b1.setBackgroundColor(R.drawable.green);
                                }
                                else if (b3.getText().toString().equals(questions.getAnswer())){
                                    b3.setBackground(getResources().getDrawable(R.drawable.green));
                                   // b3.setBackgroundColor(R.drawable.green);
                                }
                                else if (b4.getText().toString().equals(questions.getAnswer())){
                                    b4.setBackground(getResources().getDrawable(R.drawable.green));
                                    //b4.setBackgroundColor(R.drawable.green);
                                }
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackground(getResources().getDrawable(R.drawable.round_button));
                                        b2.setBackground(getResources().getDrawable(R.drawable.round_button));
                                        b3.setBackground(getResources().getDrawable(R.drawable.round_button));
                                        b4.setBackground(getResources().getDrawable(R.drawable.round_button));
//                                        b1.setBackgroundColor(R.drawable.round_button);
//                                        b2.setBackgroundColor(R.drawable.round_button);
//                                        b3.setBackgroundColor(R.drawable.round_button);
//                                        b4.setBackgroundColor(R.drawable.round_button);
                                        updateQuestion();
                                    }
                                },1500);
                            }
                        }
                    });
                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (b3.getText().toString().equals(questions.getAnswer())){
                                b3.setBackground(getResources().getDrawable(R.drawable.green));
                              //  b3.setBackgroundColor(R.drawable.green);
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackground(getResources().getDrawable(R.drawable.round_button));
                                      //  b3.setBackgroundColor(R.drawable.round_button);
                                        updateQuestion();
                                    }
                                },1500);
                            }else {
                                wrong++;
                                b3.setBackground(getResources().getDrawable(R.drawable.red));
                             //   b3.setBackgroundColor(R.drawable.red);
                                if (b2.getText().toString().equals(questions.getAnswer())){
                                    b2.setBackground(getResources().getDrawable(R.drawable.green));
                                   // b2.setBackgroundColor(R.drawable.green);
                                }
                                else if (b1.getText().toString().equals(questions.getAnswer())){
                                    b1.setBackground(getResources().getDrawable(R.drawable.green));
                                    //b1.setBackgroundColor(R.drawable.green);
                                }
                                else if (b4.getText().toString().equals(questions.getAnswer())){
                                    b4.setBackground(getResources().getDrawable(R.drawable.green));
                                   // b4.setBackgroundColor(R.drawable.green);
                                }
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackground(getResources().getDrawable(R.drawable.round_button));
                                        b2.setBackground(getResources().getDrawable(R.drawable.round_button));
                                        b3.setBackground(getResources().getDrawable(R.drawable.round_button));
                                        b4.setBackground(getResources().getDrawable(R.drawable.round_button));
//                                        b1.setBackgroundColor(R.drawable.round_button);
//                                        b2.setBackgroundColor(R.drawable.round_button);
//                                        b3.setBackgroundColor(R.drawable.round_button);
//                                        b4.setBackgroundColor(R.drawable.round_button);
                                        updateQuestion();
                                    }
                                },1500);
                            }
                        }
                    });
                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (b4.getText().toString().equals(questions.getAnswer())){
                                b4.setBackground(getResources().getDrawable(R.drawable.green));
                               // b4.setBackgroundColor(R.drawable.green);
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackground(getResources().getDrawable(R.drawable.round_button));
                                       // b4.setBackgroundColor(R.drawable.round_button);
                                        updateQuestion();
                                    }
                                },1500);
                            }else {
                                wrong++;
                                b4.setBackground(getResources().getDrawable(R.drawable.red));
                               // b4.setBackgroundColor(R.drawable.red);
                                if (b2.getText().toString().equals(questions.getAnswer())){
                                    b2.setBackground(getResources().getDrawable(R.drawable.green));
                                  //  b2.setBackgroundColor(R.drawable.green);
                                }
                                else if (b3.getText().toString().equals(questions.getAnswer())){
                                    b3.setBackground(getResources().getDrawable(R.drawable.green));
                                    //b3.setBackgroundColor(R.drawable.green);
                                }
                                else if (b1.getText().toString().equals(questions.getAnswer())){
                                    b1.setBackground(getResources().getDrawable(R.drawable.green));
                                   // b1.setBackgroundColor(R.drawable.green);
                                }
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackground(getResources().getDrawable(R.drawable.round_button));
                                        b2.setBackground(getResources().getDrawable(R.drawable.round_button));
                                        b3.setBackground(getResources().getDrawable(R.drawable.round_button));
                                        b4.setBackground(getResources().getDrawable(R.drawable.round_button));
//                                        b1.setBackgroundColor(R.drawable.round_button);
//                                        b2.setBackgroundColor(R.drawable.round_button);
//                                        b3.setBackgroundColor(R.drawable.round_button);
//                                        b4.setBackgroundColor(R.drawable.round_button);
                                        updateQuestion();
                                    }
                                },1500);
                            }
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
    public void reversTimer( int timer,final TextView txt){
        new CountDownTimer(timer*1000+1000 ,1000){
            @Override
            public void onTick(long lo) {
                int seconds= (int) lo / 1000;
                int minutes=seconds /60;
                seconds= seconds % 60;
                txt.setText(String.format("%02d",minutes)+":"+String.format("%02d",seconds));

            }

            @Override
            public void onFinish() {
                txt.setText("Completed");
//                Intent intent=new Intent(menuActivity.this,ResultDisplay.class);
//                intent.putExtra("total",String.valueOf(total));
//                intent.putExtra("correct",String.valueOf(correct));
//                intent.putExtra("wrong",String.valueOf(wrong));
//                startActivity(intent);
            }
        }.start();
    }
}
