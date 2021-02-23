package edu.uca.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import edu.uca.pokedex.data.UserConfig;
import edu.uca.pokedex.models.TrainerModel;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class StartPage extends AppCompatActivity {

    EditText tvNameW;
    TextInputLayout editText;

    TrainerModel trainerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        setUp();
    }

    private void setUp(){

        editText = findViewById(R.id.tvNameW);
        tvNameW= editText.getEditText();

        Button LogIn;
        LogIn = findViewById(R.id.Button1);

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        loadDefaultDataIfDebug();
    }

    @SuppressLint("SetTextI18n")
    private void loadDefaultDataIfDebug() {tvNameW.setText("");
    }

    private void saveUser(TrainerModel user) {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        userConfig.setTrainer(user);
    }

    private void navigateToMain(TrainerModel user) {
        Intent intent = new Intent(this, MainActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(MainActivity.FULLNAME_KEY, user.getTrainer());
        startActivity(intent);
    }

    private void signUp() {
        trainerModel = new TrainerModel(tvNameW.getText().toString());
        saveUser(trainerModel);
        navigateToMain(trainerModel);
    }


}