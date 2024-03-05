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
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);
    }

    @Test
    void testCreateTrainer() {
        String trainerName = "Ash";
        Team team = Team.MYSTIC;

        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);

        PokemonTrainer expectedTrainer = new PokemonTrainer(trainerName, team, pokedex);
        when(trainerFactory.createTrainer(trainerName, team, pokedexFactory)).thenReturn(expectedTrainer);

        PokemonTrainer createdTrainer = trainerFactory.createTrainer(trainerName, team, pokedexFactory);

        assertNotNull(createdTrainer, "La factory devrait créer une instance de PokemonTrainer non nulle.");
        assertEquals(trainerName, createdTrainer.getName(), "Le nom du trainer créé devrait correspondre à l'entrée.");
        assertEquals(team, createdTrainer.getTeam(), "L'équipe du trainer créé devrait correspondre à l'entrée.");
        assertNotNull(createdTrainer.getPokedex(), "Le trainer créé devrait avoir un IPokedex non nul.");

        verify(trainerFactory).createTrainer(trainerName, team, pokedexFactory);
    }
}
