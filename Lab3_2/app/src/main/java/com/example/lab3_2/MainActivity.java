package com.example.lab3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result = findViewById(R.id.textView3);
        result.setMovementMethod(new ScrollingMovementMethod());

    }

    ArrayList<FuelOrder> fuelOrders = new ArrayList<FuelOrder>();

    public void Sale(View view){
        Spinner fuelType = findViewById(R.id.spinner2);
        EditText value = findViewById(R.id.editTextNumberDecimal2);
        TextView result = findViewById(R.id.textView3);
        if (value.getText().length() == 0) {
            value.setText("0");
        }
        FuelOrder fuelOrder = new FuelOrder(fuelType.getSelectedItem().toString(), Double.parseDouble(value.getText().toString()));
        value.setText("");
        fuelOrders.add(fuelOrder);
        Toast toast = Toast.makeText(getApplicationContext(), "Заказ добавлен", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,0,0);
        toast.show();
        //result.setText("Заказ добавлен\n");
    }

    public void Complete(View view){
        TextView result = findViewById(R.id.textView3);
        String res = "";
        for(FuelOrder fuelOrder : fuelOrders){
            res = res + fuelOrder.returnSumOrder();
        }
        result.setText(res);
    }
}