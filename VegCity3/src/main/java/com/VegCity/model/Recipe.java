package com.VegCity.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Recipe {

    public Recipe(String id, String titolo, String ingredienti, String preparazione, String cottura, Object img) {
        this.id = id;
        this.titolo = titolo;
        this.ingredienti = ingredienti;
        this.preparazione = preparazione;
        this.cottura = cottura;
        this.img = img;
    }

    private String id;
    private String titolo;
    private String ingredienti;
    private String preparazione;
    private String cottura;
    private Object img;

    private User user;

}
