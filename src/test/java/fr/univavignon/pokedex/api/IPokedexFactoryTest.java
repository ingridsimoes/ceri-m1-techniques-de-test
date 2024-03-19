package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    void testCreatePokedex() {
        IPokedex expectedPokedex = mock(IPokedex.class);

        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(expectedPokedex);

        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(createdPokedex, "La factory devrait créer une instance de IPokedex non nulle.");
        assertEquals(expectedPokedex, createdPokedex, "L'instance de IPokedex créée devrait être celle attendue.");

        verify(pokedexFactory).createPokedex(metadataProvider, pokemonFactory);
    }
    @Test
    void testCreatePokedexWithNullParameters() {
        assertThrows(IllegalArgumentException.class, () -> {
            pokedexFactory.createPokedex(null, pokemonFactory);
        }, "Should throw IllegalArgumentException for null metadataProvider.");

        assertThrows(IllegalArgumentException.class, () -> {
            pokedexFactory.createPokedex(metadataProvider, null);
        }, "Should throw IllegalArgumentException for null pokemonFactory.");
    }

    @Test
    void testCreatePokedexWithNullMetadataProvider() {
        assertThrows(IllegalArgumentException.class, () -> {
            pokedexFactory.createPokedex(null, pokemonFactory);
        }, "Création de IPokedex avec un IPokemonMetadataProvider null devrait lancer une exception.");
    }

    @Test
    void testCreatePokedexWithNullPokemonFactory() {
        assertThrows(IllegalArgumentException.class, () -> {
            pokedexFactory.createPokedex(metadataProvider, null);
        }, "Création de IPokedex avec un IPokemonFactory null devrait lancer une exception.");
    }

    @Test
    void testInitialStateOfCreatedPokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex, "La factory devrait créer une instance non nulle de IPokedex.");
        assertEquals(0, pokedex.size(), "Un nouveau IPokedex devrait être vide.");
    }

    @Test
    void testPokedexFactoryUnderLoad() {
        for (int i = 0; i < 1000; i++) {
            IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
            assertNotNull(pokedex, "La factory devrait toujours créer une instance non nulle de IPokedex.");
        }
        // Considérez d'ajouter des vérifications spécifiques liées à la performance ou à l'utilisation des ressources ici.
    }
}
