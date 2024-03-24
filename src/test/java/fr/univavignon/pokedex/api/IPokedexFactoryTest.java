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
        pokedexFactory = new IPokedexFactoryImpl();
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    void testCreatePokedex() {
        IPokedex expectedPokedex = mock(IPokedex.class);

        IPokedexFactory pokedexFactoryMock = mock(IPokedexFactory.class);

        when(pokedexFactoryMock.createPokedex(metadataProvider, pokemonFactory)).thenReturn(expectedPokedex);

        IPokedex createdPokedex = pokedexFactoryMock.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(createdPokedex, "La factory devrait créer une instance de IPokedex non nulle.");

        assertEquals(expectedPokedex, createdPokedex, "L'instance de IPokedex créée devrait être celle attendue.");

        verify(pokedexFactoryMock).createPokedex(metadataProvider, pokemonFactory);
    }
    @Test
    void testCreatePokedexWithNullProviderShouldThrowException() {
        IPokedexFactory factory = new IPokedexFactoryImpl();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.createPokedex(null, pokemonFactory);
        });

        String expectedMessage = "Le fournisseur de métadonnées ne peut pas être nul";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
