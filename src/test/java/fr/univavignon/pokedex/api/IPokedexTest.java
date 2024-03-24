package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class IPokedexTest {

    private IPokedex pokedex;

    @BeforeEach
    void setUp() {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        pokedex = new IPokedexImpl(metadataProvider, pokemonFactory);
    }

    @Test
    void testAddPokemon_Bulbizarre() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        int index = pokedex.addPokemon(bulbizarre);

        assertEquals(0, index);
    }

    @Test
    void testGetPokemon_Aquali() throws PokedexException {
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        pokedex.addPokemon(aquali);

        Pokemon result = pokedex.getPokemon(133);

        assertEquals(aquali, result);
    }
}
