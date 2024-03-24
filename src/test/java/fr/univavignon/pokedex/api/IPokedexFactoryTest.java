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
        // Criar uma instância de IPokedexFactoryImpl
        pokedexFactory = new IPokedexFactoryImpl();
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    void testCreatePokedex() {
        IPokedex expectedPokedex = mock(IPokedex.class);

        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(createdPokedex, "La factory devrait créer une instance de IPokedex non nulle.");
        assertEquals(expectedPokedex, createdPokedex, "L'instance de IPokedex créée devrait être celle attendue.");


    }

}