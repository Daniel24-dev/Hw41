package com.example.hw41;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private EditText editTextLogin, editTextPassword;
    private Button buttonLogin;
    private TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextLogin = findViewById(R.id.email_input);
        editTextPassword = findViewById(R.id.password_input);
        buttonLogin = findViewById(R.id.login_button);
        textViewWelcome = findViewById(R.id.welcome_text);




        editTextLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                buttonLogin.setBackgroundColor(Color.parseColor("#FFA500"));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        buttonLogin.setOnClickListener(v -> {
            String login = editTextLogin.getText().toString();
            String password = editTextPassword.getText().toString();
            if (login.equals("admin")&& password.equals("admin")){
                Snackbar.make(v,"Вы успешно зарегистрировались "+login,Snackbar.LENGTH_LONG).show();
                textViewWelcome.setText("Добро пожаловать");

                hideLoginFields();

            }else {
                Snackbar.make(v, "Неправильный логин и пароль", Snackbar.LENGTH_LONG).show();
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }



    private void buttonColorChange(){
        if (!editTextLogin.getText().toString().isEmpty() && !editTextPassword.getText().toString().isEmpty()){
            buttonLogin.setBackgroundColor(Color.parseColor("#FFA500"));

        }else {
            buttonLogin.setBackgroundColor(Color.parseColor("#A9A9A9"));
        }
    }

    private void hideLoginFields() {
        editTextLogin.setVisibility(View.GONE);
        editTextPassword.setVisibility(View.GONE);
        buttonLogin.setVisibility(View.GONE);
    }
}