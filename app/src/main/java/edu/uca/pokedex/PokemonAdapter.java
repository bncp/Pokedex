package edu.uca.pokedex;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.uca.pokedex.Detail;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.uca.pokedex.Detail;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> implements View.OnClickListener{

    private final List<PokemonModel> pokeList;

    @Override
    public void onClick(View v) {

    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, description;
        ImageView imgPokemon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.tvName);
            description=(TextView)itemView.findViewById(R.id.tv_desc);
            imgPokemon = (ImageView)itemView.findViewById(R.id.imgPokemon);
        }
    }

    public PokemonAdapter(List<PokemonModel> pokeList) {
        this.pokeList = pokeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viu = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);
        ViewHolder viuHolder = new ViewHolder(viu);
        return viuHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(pokeList.get(position).getName());
        holder.description.setText(pokeList.get(position).getDescription());
        holder.imgPokemon.setImageResource(pokeList.get(position).getImg());
/*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(Detail.this, Detail.EXTRA_POKEMON, pokeList);

            }
        });*/

    }


    @Override
    public int getItemCount() {
        return pokeList.size();
    }



}
