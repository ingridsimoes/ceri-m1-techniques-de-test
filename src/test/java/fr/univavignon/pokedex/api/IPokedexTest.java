package fr.univavignon.pokedex.api;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class IPokedexTest {

    private IPokedex pokedex;

    @BeforeEach
    void setUp() {
        pokedex = new IPokedexImpl(mock(IPokemonMetadataProvider.class), mock(IPokemonFactory.class));
    }

    @Test
    void testAddPokemon() {
        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);



        int index = pokedex.addPokemon(bulbasaur);

        assertEquals(0, index);

    }

    @Test
    void testGetPokemon() throws PokedexException {
        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);

        Pokemon result = pokedex.getPokemon(0);

        assertEquals(bulbasaur, result);

    }

    @Test
    void testGetSize() {


        int size = pokedex.size();

        assertEquals(0, size);

    }

    @Test
    void testGetPokemons() {
        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon ivysaur = new Pokemon(1, "Ivysaur", 186, 168, 260, 2729, 202, 5000, 4, 100);


        List<Pokemon> pokemons = pokedex.getPokemons();

        assertEquals(0, pokemons.size());

    }
}
