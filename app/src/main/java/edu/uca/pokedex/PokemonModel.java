package edu.uca.pokedex;

public class PokemonModel {

    private String name;
    private String description;
    private int img;

    public PokemonModel() {
    }

    public PokemonModel(String name, String description, int img) {
        this.name = name;
        this.description = description;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
