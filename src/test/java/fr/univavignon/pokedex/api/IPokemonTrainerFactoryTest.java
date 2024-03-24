package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @BeforeEach
    void setUp() {
        trainerFactory = new IPokemonTrainerFactoryImpl();
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);
    }

    @Test
    void testCreateTrainer() {
        String trainerName = "train";
        Team team = Team.MYSTIC;

        PokemonTrainer pokemonTrainerMock = mock(PokemonTrainer.class);

        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);

        when(trainerFactory.createTrainer(trainerName, team, pokedexFactory)).thenReturn(pokemonTrainerMock);

        PokemonTrainer createdTrainer = trainerFactory.createTrainer(trainerName, team, pokedexFactory);

        assertNotNull(createdTrainer, "La factory devrait créer une instance de PokemonTrainer non nulle.");
        assertEquals(pokemonTrainerMock, createdTrainer, "L'instance de PokemonTrainer créée devrait être celle attendue.");

        verify(trainerFactory).createTrainer(trainerName, team, pokedexFactory);
    }
}
