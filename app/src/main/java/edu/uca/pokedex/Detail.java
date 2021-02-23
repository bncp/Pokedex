package edu.uca.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    public static final String EXTRA_POKEMON = "extra_pokemon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.iv_logo);
        TextView name = findViewById(R.id.tv_title);
        TextView desc = findViewById(R.id.tv_desc);

        PokemonModel pk = getIntent().getParcelableExtra(EXTRA_POKEMON);



    }
}