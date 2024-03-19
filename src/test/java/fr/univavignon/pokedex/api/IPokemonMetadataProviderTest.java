package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @BeforeEach
    void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    void testGetPokemonMetadata_ValidIndexBulbasaur() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));

        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);

        assertNotNull(metadata, "Les métadonnées ne devraient pas être null");
        assertEquals("Bulbizarre", metadata.getName(), "Le nom du Pokémon devrait être Bulbizarre");
        assertEquals(126, metadata.getAttack(), "L'attaque de Bulbizarre devrait être 126");
        assertEquals(126, metadata.getDefense(), "La défense de Bulbizarre devrait être 126");
        assertEquals(90, metadata.getStamina(), "L'endurance de Bulbizarre devrait être 90");
    }

    @Test
    void testGetPokemonMetadata_ValidIndexAquali() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));

        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(133);

        assertNotNull(metadata, "Les métadonnées ne devraient pas être null");
        assertEquals("Aquali", metadata.getName(), "Le nom du Pokémon devrait être Aquali");
        assertEquals(186, metadata.getAttack(), "L'attaque d'Aquali devrait être 186");
        assertEquals(168, metadata.getDefense(), "La défense d'Aquali devrait être 168");
        assertEquals(260, metadata.getStamina(), "L'endurance d'Aquali devrait être 260");
    }

    @Test
    void testGetPokemonMetadata_InvalidIndex_ThrowsException() {
        int invalidIndex = -1; // or any invalid index that should trigger the exception
        try {
            when(metadataProvider.getPokemonMetadata(invalidIndex)).thenThrow(PokedexException.class);
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }

        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(invalidIndex));
    }

    @Test
    void testGetPokemonMetadata_ValidIndexMew() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(151)).thenReturn(new PokemonMetadata(151, "Mew", 100, 100, 100));

        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(151);

        assertNotNull(metadata);
        assertEquals("Mew", metadata.getName());
    }

    @Test
    void testGetPokemonMetadata_OutOfRangeHighIndex_ThrowsException() {
        int outOfRangeIndex = 152; // Supposant que 151 est le max

        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(outOfRangeIndex));
    }

    @Test
    void testGetPokemonMetadata_OutOfRangeNegativeIndex_ThrowsException() {
        int negativeIndex = -2; // Tout index négatif est invalide

        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(negativeIndex));
    }

    @Test
    void testGetPokemonMetadata_ConsistencyOverMultipleCalls() throws PokedexException {
        PokemonMetadata expectedMetadata = new PokemonMetadata(25, "Pikachu", 112, 96, 111);
        when(metadataProvider.getPokemonMetadata(25)).thenReturn(expectedMetadata);

        PokemonMetadata firstCall = metadataProvider.getPokemonMetadata(25);
        PokemonMetadata secondCall = metadataProvider.getPokemonMetadata(25);

        assertEquals(firstCall, secondCall);
    }

}
