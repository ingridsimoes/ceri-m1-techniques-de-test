package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @BeforeEach
    void setUp() {
        metadataProvider = new IPokemonMetadataProviderImpl();
    }

    @Test
    void testGetPokemonMetadata_ValidIndexBulbasaur() throws PokedexException {
        int indexBulbasaur = 0;
        String nameBulbasaur = "Bulbizarre";
        int attackBulbasaur = 126;
        int defenseBulbasaur = 126;
        int staminaBulbasaur = 90;

        PokemonMetadata metadataBulbasaur = metadataProvider.getPokemonMetadata(indexBulbasaur);

        assertNotNull(metadataBulbasaur, "Les métadonnées ne devraient pas être null");
        assertEquals(nameBulbasaur, metadataBulbasaur.getName(), "Le nom du Pokémon devrait être Bulbizarre");
        assertEquals(attackBulbasaur, metadataBulbasaur.getAttack(), "L'attaque de Bulbizarre devrait être 126");
        assertEquals(defenseBulbasaur, metadataBulbasaur.getDefense(), "La défense de Bulbizarre devrait être 126");
        assertEquals(staminaBulbasaur, metadataBulbasaur.getStamina(), "L'endurance de Bulbizarre devrait être 90");
    }

    @Test
    void testGetPokemonMetadata_ValidIndexAquali() throws PokedexException {
        int indexAquali = 133;
        String nameAquali = "Aquali";
        int attackAquali = 186;
        int defenseAquali = 168;
        int staminaAquali = 260;

        PokemonMetadata metadataAquali = metadataProvider.getPokemonMetadata(indexAquali);

        assertNotNull(metadataAquali, "Les métadonnées ne devraient pas être null");
        assertEquals(nameAquali, metadataAquali.getName(), "Le nom du Pokémon devrait être Aquali");
        assertEquals(attackAquali, metadataAquali.getAttack(), "L'attaque d'Aquali devrait être 186");
        assertEquals(defenseAquali, metadataAquali.getDefense(), "La défense d'Aquali devrait être 168");
        assertEquals(staminaAquali, metadataAquali.getStamina(), "L'endurance d'Aquali devrait être 260");
    }
}
