package edu.uca.pokedex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import edu.uca.pokedex.data.UserConfig;

public class StartActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        launchFirstActivity();
    }

    private void launchFirstActivity(){

        UserConfig userConfig = new UserConfig(getApplicationContext());
        Intent intent;

        if (userConfig.trainerExists()) {
            intent = new Intent(getBaseContext(),  MainActivity.class);
        }else{
            intent = new Intent(getBaseContext(), StartPage.class);

        }

        startActivity(intent);
        finish();
    }

}
