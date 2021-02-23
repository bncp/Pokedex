package edu.uca.pokedex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import edu.uca.pokedex.data.UserConfig;
import edu.uca.pokedex.models.TrainerModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokemonAdapter adapterPokemon;
    public static final String FULLNAME_KEY = "FULLNAME";
    public String trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerPokemon);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapterPokemon = new PokemonAdapter(getPokemon());
        recyclerView.setAdapter(adapterPokemon);

        Intent startIntent = getIntent();
        TrainerModel userModel = getUserModelFromSources(startIntent.getExtras());
        trainer = userModel.getTrainer();

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(trainer + "'s Pokedex ");

    }
    @NonNull
    private TrainerModel getUserModelFromSources(Bundle extras) {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        final TrainerModel user = userConfig.getTrainer();
        if(user != null) {
            return user;
        }
        if(extras == null) {
            throw new InvalidParameterException("Extras");
        }
        return new TrainerModel(extras.getString(FULLNAME_KEY));
    }

    public List<PokemonModel> getPokemon(){
        List<PokemonModel> poke = new ArrayList<>();
        poke.add(new PokemonModel(
                "Charmander",
                "Los Charmander son de tipo fuego y de color naranja. La llama que tiene en la punta de la cola arde según sus sentimientos. Llamea levemente cuando está alegre y arde vigorosamente cuando está enfadado.",
                R.drawable.charmanderc));
        poke.add(new PokemonModel(
                "Oddish",
                "Los Oddish son de tipos planta veneno y de color azul. Durante el día, Oddish se entierra en el suelo para absorber nutrientes valiéndose de todo el cuerpo. Cuanto más fértil sea el suelo, mayor brillo tendrá en las hojas.",
                R.drawable.oddishc));
        poke.add(new PokemonModel(
                "Gastly",
                "Los Gastly son de tipos fantasma veneno y de color morado. Gastly está compuesto en gran medida de materia gaseosa. Suelen agruparse bajo los aleros de las casas para resguardarse del viento.",
                R.drawable.gastlyc));
        poke.add(new PokemonModel(
                "Rhydon",
                "Los Rhydon son de tipos tierra roca y de color gris.Rhydon tiene un cuerno capaz de horadar hasta un diamante en bruto. Y con una sacudida de la cola puede derribar un edificio. La piel de este Pokémon es muy fuerte; ni los disparos de un cañón le arañarían.",
                R.drawable.rhydonc));
        poke.add(new PokemonModel(
                "Lapras",
                "Los Lapras son de tipos agua hielo y de color azul. Dicen que, al anochecer, se pone a cantar quejicoso mientras busca a los miembros de su especie que puedan quedar.",
                R.drawable.laprasc));
        poke.add(new PokemonModel(
                "Snorlax",
                "Los Snorlax son de tipo normal y de color negro. Un día cualquiera en la vida de Snorlax consiste nada más y nada menos que en comer y dormir. Es un Pokémon tan dócil que es fácil ver niños usando la gran panza que tiene como lugar de juegos.",
                R.drawable.snorlaxc));
        poke.add(new PokemonModel(
                "Dragonite",
                "Los Dragonite son de tipos dragon volador y de color marrón. Dragonite es capaz de dar la vuelta al mundo en sólo 16 horas. Es un Pokémon de buen corazón que guía hasta tierra a los barcos que se encuentran perdidos en plena tormenta y a punto de zozobrar.",
                R.drawable.dragonitec));
        poke.add(new PokemonModel(
                "Ampharos",
                "Los Ampharos son de tipo electrico y de color amarillo. Ampharos desprende tanta luz que es posible verle hasta desde el espacio. Antes, la gente usaba su luz como sistema de comunicación para enviarse señales.",
                R.drawable.ampharosc));
        poke.add(new PokemonModel(
                "Houndoom",
                "Los Houndoom son de tipos siniestro fuego y de color negro. En la manada de Houndoom, el que tiene los cuernos bastante orientados hacia atrás tiene un papel de liderazgo. Estos Pokémon suelen elegir al jefe batiéndose entre ellos.",
                R.drawable.houndoomc));

        return poke;
    }
}