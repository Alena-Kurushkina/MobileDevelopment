package com.example.lab3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> names = new ArrayList<>();
    public ArrayList<String> urls = new ArrayList<>();
    public String url = "https://www.theplace.ru/photos/";
    private int imageNumber = 0;
    private String nameCelebrity = "";
    private ImageView picture;
    private TextView result;
    public int kol = 1;
    public int right = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picture = findViewById(R.id.image);

        Parser.getContent(names,urls,url);

        showPicture();
    }

    public void Answer(View view){
        EditText answer = findViewById(R.id.editTextTextPersonName);
        TextView help = findViewById(R.id.textView2);
        kol+=1;

        String answerStr=answer.getText().toString();

        if (answerStr.toLowerCase().compareTo(nameCelebrity.toLowerCase())==0) {
            right+=1;
            help.setText("Правильно");
        }else {
            help.setText("Неправильно");
        }
        answer.setText("");
        showPicture();
    }

    public void Help(View view){
        TextView help = findViewById(R.id.textView2);
        help.setText(nameCelebrity);
    }

    public void End(View view){
        TextView help = findViewById(R.id.textView2);
        help.setText("Игра окончена: "+ Integer.toString(right)+"/"+Integer.toString(kol)+" правильных ответов!");
    }
    private void showPicture()
    {
        imageNumber = (int) (Math.random()*urls.size());
        nameCelebrity = names.get(imageNumber);
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        ImageRequest imageRequest = new ImageRequest(
                "https://www.theplace.ru"+urls.get(imageNumber), // Image URL
                response -> {
                    picture.setImageBitmap(response);
                },
                0,
                0,
                ImageView.ScaleType.CENTER_CROP, // Image scale type
                Bitmap.Config.RGB_565, //Image decode configuration
                error -> {
                    // Do something with error response
                    System.out.println("JSON error:" + error.getMessage());
                    error.printStackTrace();

                }
        );
        // Add ImageRequest to the RequestQueue
        requestQueue.add(imageRequest);

    }

}


