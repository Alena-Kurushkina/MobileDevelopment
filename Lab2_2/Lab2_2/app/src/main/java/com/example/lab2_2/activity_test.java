package com.example.lab2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_test extends AppCompatActivity {
    int right;
    int kol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TextView a = findViewById(R.id.textView3);
        TextView b = findViewById(R.id.textView5);
        TextView result = findViewById(R.id.textView7);
        TextView info_kol = findViewById(R.id.textView8);
        TextView right_or_not = findViewById(R.id.textView9);
        EditText number = findViewById(R.id.editTextNumberDecimal2);
        Button answer = findViewById(R.id.button3);

        right = 0;
        kol = 3;
        int all_kol = kol;
        //int arg_number;

        Bundle arg=getIntent().getExtras();
        boolean flag=arg.getBoolean("flag");
        if (flag) {
            a.setText(arg.getString("arg"));
        }

        info_kol.setText("1 / " + all_kol);

        set_params(a, b,flag);
        answer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (number.getText().length() == 0) {
                    number.setText("0");
                }
                kol -= 1;
                if ((Integer.parseInt(a.getText().toString()) * Integer.parseInt(b.getText().toString())) == Integer.parseInt(number.getText().toString())) {
                    right += 1;
                    right_or_not.setText("Правильно!");
                    right_or_not.setTextColor(Color.GREEN);
                } else {
                    right_or_not.setText("Неправильно!");
                    right_or_not.setTextColor(Color.RED);
                }
                if (kol == 0) {
                    result.setText("Тест окончен, резултаты:\nВерно: " + right + "/" + all_kol);
                    answer.setEnabled(false);
                } else {
                    set_params(a, b,flag);
                    number.setText("");
                    info_kol.setText(all_kol - kol + 1 + " / " + all_kol);
                }
            }

        });

    }


    public void set_params(TextView a, TextView b, Boolean flag) {
        int int_b = (int) (Math.random() * 10 + 1);
        b.setText(String.valueOf(int_b));
        if (!flag){
            int int_a = (int) (Math.random() * 10 + 1);
            a.setText(String.valueOf(int_a));
        }
    }
}

