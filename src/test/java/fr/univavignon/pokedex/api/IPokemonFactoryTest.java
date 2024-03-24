package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    void testCreatePokemon_Bulbasaur() {
        int index = 0;
        String nom = "Bulbizarre";
        int attaque = 126;
        int defense = 126;
        int endurance = 90;
        int cp = 613;
        int hp = 64;
        int poussiere = 4000;
        int bonbon = 4;
        int iv = 56;

        Pokemon BulbasaurAttendu = new Pokemon(index, nom, attaque, defense, endurance, cp, hp, poussiere, bonbon, iv);

        when(pokemonFactory.createPokemon(index, cp, hp, poussiere, bonbon)).thenReturn(BulbasaurAttendu);

        Pokemon BulbasaurCree = pokemonFactory.createPokemon(index, cp, hp, poussiere, bonbon);

        assertNotNull(BulbasaurCree, "Le Pokémon créé ne doit pas être nul.");
        assertEquals(BulbasaurAttendu, BulbasaurCree, "Le Pokémon créé doit correspondre à l'instance attendue.");
    }

    @Test
    void testCreatePokemon_Aquali() {
        int index = 133;
        String nom = "Aquali";
        int attaque = 186;
        int defense = 168;
        int endurance = 260;
        int cp = 2729;
        int hp = 202;
        int poussiere = 5000;
        int bonbon = 4;
        int iv = 100;

        Pokemon aqualiAttendu = new Pokemon(index, nom, attaque, defense, endurance, cp, hp, poussiere, bonbon, iv);

        when(pokemonFactory.createPokemon(index, cp, hp, poussiere, bonbon)).thenReturn(aqualiAttendu);

        Pokemon aqualiCree = pokemonFactory.createPokemon(index, cp, hp, poussiere, bonbon);

        assertNotNull(aqualiCree, "Le Pokémon créé ne doit pas être nul.");
        assertEquals(aqualiAttendu, aqualiCree, "Le Pokémon créé doit correspondre à l'instance attendue.");
    }
}
