package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class IPokedexTest {

    private IPokedex pokedex;
    private IPokemonMetadataProvider fournisseurMetadonnees;
    private IPokemonFactory fabriquePokemon;

    @BeforeEach
    void setUp() {
        fournisseurMetadonnees = mock(IPokemonMetadataProvider.class);
        fabriquePokemon = mock(IPokemonFactory.class);

        pokedex = new IPokedexImpl(fournisseurMetadonnees, fabriquePokemon);
    }

    @Test
    void testAjouterPokemon_Bulbizarre() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        int indice = pokedex.addPokemon(bulbizarre);
        assertEquals(0, indice, "Bulbizarre doit être le premier Pokémon dans le Pokedex.");
    }

    @Test
    void testObtenirPokemon_Aquali() throws PokedexException {
        // Création d'Aquali
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        int indiceAquali = pokedex.addPokemon(aquali);

        Pokemon resultat = pokedex.getPokemon(indiceAquali);
        assertEquals(aquali, resultat, "Le Pokémon récupéré doit être Aquali.");
    }
}
