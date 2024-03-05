package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    void testCreatePokemon_Bulbasaur() {
        // Provided metadata for Bulbizarre
        int index = 0;
        String name = "Bulbizarre";
        int attack = 126; // Attaque
        int defense = 126; // Défense
        int stamina = 90; // Endurance
        int cp = 613; // CP
        int hp = 64; // HP
        int dust = 4000; // Dust
        int candy = 4; // Candy
        int iv = 56; // IV

        Pokemon expectedBulbasaur = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);

        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(expectedBulbasaur);

        Pokemon createdBulbasaur = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(createdBulbasaur, "The created Pokemon should not be null.");
        assertEquals(expectedBulbasaur, createdBulbasaur, "The created Pokemon should match the expected instance.");
    }

    @Test
    void testCreatePokemon_Aquali() {
        int index = 133;
        String name = "Aquali";
        int attack = 186; // Attaque
        int defense = 168; // Défense
        int stamina = 260; // Endurance
        int cp = 2729; // CP
        int hp = 202; // HP
        int dust = 5000; // Dust
        int candy = 4; // Candy
        int iv = 100; // IV

        Pokemon expectedAquali = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);

        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(expectedAquali);

        Pokemon createdAquali = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(createdAquali, "The created Pokemon should not be null.");
        assertEquals(expectedAquali, createdAquali, "The created Pokemon should match the expected instance.");
    }
}
