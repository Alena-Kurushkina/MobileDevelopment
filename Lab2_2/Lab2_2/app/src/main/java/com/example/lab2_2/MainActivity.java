package com.example.lab2_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button allNumbers = findViewById(R.id.button);
    }
    public void allNumbersTest(View view) {
        Intent intent = new Intent(this, activity_test.class);
        intent.putExtra("flag",false);
        startActivity(intent);
    }
    public void oneNumberTest(View view) {
        EditText editNumber = findViewById(R.id.editTextNumberDecimal);
        if (editNumber.getText().length()!=0) {
            Intent intent = new Intent(this, activity_test.class);
            intent.putExtra("flag", true);

            intent.putExtra("arg", editNumber.getText().toString());
            startActivity(intent);
        }
    }
}