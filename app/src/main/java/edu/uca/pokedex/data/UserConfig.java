package edu.uca.pokedex.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import edu.uca.pokedex.models.TrainerModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import edu.uca.pokedex.BuildConfig;

import java.util.Locale;

public class UserConfig {
    private static final String USER_PREF_NAME = "user_prefs";
    private static final String PREF_FIRST_TIME = "is_first_time";
    private static final String PREF_USER_NAME = "trainer_name";


    private final SharedPreferences nPrefs;

    public UserConfig(@NonNull Context context) {

        nPrefs = context.getSharedPreferences(getPrefsName(), Context.MODE_PRIVATE);

    }

    public boolean isFirstTime() {
        return nPrefs.getBoolean(PREF_FIRST_TIME, true);
    }


    public boolean setIsFirstTime(boolean value) {
        SharedPreferences.Editor editor = nPrefs.edit();
        editor.putBoolean(PREF_FIRST_TIME, value);
        editor.apply();

        return true;

    }


    public boolean trainerExists() {
        return nPrefs.contains(PREF_USER_NAME);
    }

    @Nullable
    public TrainerModel getTrainer() {
        final String name = nPrefs.getString(PREF_USER_NAME, null);

        if (TextUtils.isEmpty(name)) {
            return null;
        }

        return new TrainerModel(name);
    }


    public boolean setTrainer(@Nullable TrainerModel trainer) {
        if (trainer == null) return false;
        if (TextUtils.isEmpty(trainer.getTrainer()))
            return false;

        SharedPreferences.Editor prefsEditor = nPrefs.edit();
        prefsEditor.putString(PREF_USER_NAME, trainer.getTrainer());
        prefsEditor.apply();
        return true;
    }



    private String getPrefsName(){

        return String.format(
                Locale.getDefault(),
                "%s_%s" ,
                BuildConfig.APPLICATION_ID, USER_PREF_NAME

        );

    }


}

