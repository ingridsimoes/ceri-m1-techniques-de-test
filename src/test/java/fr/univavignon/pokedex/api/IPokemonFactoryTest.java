package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        pokemonFactory = new IPokemonFactoryImpl();
    }

    @Test
    void testCreatePokemon_Bulbasaur() {
        int index = 0;
        String name = "Bulbizarre";
        int attack = 126;
        int defense = 126;
        int stamina = 90;
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;
        int iv = 56;

        Pokemon expectedBulbasaur = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);

        Pokemon createdBulbasaur = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(createdBulbasaur, "The created Pokemon should not be null.");
        assertEquals(expectedBulbasaur, createdBulbasaur, "The created Pokemon should match the expected instance.");
    }

    @Test
    void testCreatePokemon_Aquali() {
        int index = 133;
        String name = "Aquali";
        int attack = 186;
        int defense = 168;
        int stamina = 260;
        int cp = 2729;
        int hp = 202;
        int dust = 5000;
        int candy = 4;
        int iv = 100;

        Pokemon expectedAquali = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);

        Pokemon createdAquali = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(createdAquali, "The created Pokemon should not be null.");
        assertEquals(expectedAquali, createdAquali, "The created Pokemon should match the expected instance.");
    }
}
