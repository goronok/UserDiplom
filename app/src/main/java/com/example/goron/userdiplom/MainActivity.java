package com.example.goron.userdiplom;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextInputEditText textInputPassword, textInputName;

    Button goToStartActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализируем элементы:
        textInputPassword = findViewById(R.id.textInputPassword);
        textInputName = findViewById(R.id.textInputName);

        goToStartActivity = findViewById(R.id.goToStartActivity);


        // Обработчик нажатия на кнопку вход
        clickButtonGoToStartActivity();

    }


    // Обработчик нажатия на кнопку вход
    private void clickButtonGoToStartActivity() {
        goToStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), StartActivity.class);
                startActivity(intent);
            }
        });

    }//clickButtonGoToStartActivity





}
