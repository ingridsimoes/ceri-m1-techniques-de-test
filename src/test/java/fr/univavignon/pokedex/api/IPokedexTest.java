package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class IPokedexTest {

    private IPokedex pokedex;

    @BeforeEach
    void setUp() {
        pokedex = mock(IPokedex.class);
    }

    @Test
    void testAddPokemon() {
        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        when(pokedex.addPokemon(bulbasaur)).thenReturn(0);

        int index = pokedex.addPokemon(bulbasaur);

        assertEquals(0, index);
        verify(pokedex).addPokemon(bulbasaur);
    }

    @Test
    void testGetPokemon() throws PokedexException {
        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        when(pokedex.getPokemon(0)).thenReturn(bulbasaur);

        Pokemon result = pokedex.getPokemon(0);

        assertEquals(bulbasaur, result);
        verify(pokedex).getPokemon(0);
    }

    @Test
    void testGetSize() {
        when(pokedex.size()).thenReturn(1);

        int size = pokedex.size();

        assertEquals(1, size);
        verify(pokedex).size();
    }

    @Test
    void testGetPokemons() {
        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon ivysaur = new Pokemon(1, "Ivysaur", 186, 168, 260, 2729, 202, 5000, 4, 100);
        when(pokedex.getPokemons()).thenReturn(Arrays.asList(bulbasaur, ivysaur));

        List<Pokemon> pokemons = pokedex.getPokemons();

        assertEquals(Arrays.asList(bulbasaur, ivysaur), pokemons);
        verify(pokedex).getPokemons();
    }


}
