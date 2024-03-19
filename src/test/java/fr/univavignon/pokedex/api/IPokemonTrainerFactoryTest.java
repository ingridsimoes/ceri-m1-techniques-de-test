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
        String trainerName = "train";
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

    @Test
    void testCreateTrainerDifferentTeams() {
        Team[] teams = Team.values();
        for (Team team : teams) {
            PokemonTrainer createdTrainer = trainerFactory.createTrainer("Ash", team, pokedexFactory);
            assertEquals(team, createdTrainer.getTeam(), "L'équipe du trainer créé devrait correspondre à l'entrée.");
        }
    }
    @Test
    void testCreateTrainerWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> trainerFactory.createTrainer(null, Team.MYSTIC, pokedexFactory));
    }

    @Test
    void testCreateTrainerWithNullPokedexFactory() {
        assertThrows(IllegalArgumentException.class, () -> trainerFactory.createTrainer("Ash", Team.MYSTIC, null));
    }
    @Test
    void testCreateMultipleTrainers() {
        PokemonTrainer trainer1 = trainerFactory.createTrainer("Trainer1", Team.VALOR, pokedexFactory);
        PokemonTrainer trainer2 = trainerFactory.createTrainer("Trainer2", Team.INSTINCT, pokedexFactory);

        assertNotEquals(trainer1, trainer2, "Chaque appel à createTrainer devrait créer une nouvelle instance de PokemonTrainer.");
    }
    @Test
    void testPokedexCreationForTrainer() {
        trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);
        verify(pokedexFactory).createPokedex(any(), any());
    }
    @Test
    void testPokedexFactoryExceptionHandling() {
        when(pokedexFactory.createPokedex(any(), any())).thenThrow(new RuntimeException("Erreur de création de Pokedex"));

        assertThrows(RuntimeException.class, () -> trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory), "La factory devrait propager l'exception de création de Pokedex.");
    }

}
