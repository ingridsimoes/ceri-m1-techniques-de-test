package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class IPokemonMetadataProviderImpl implements IPokemonMetadataProvider {

    // Map pour stocker les métadonnées des Pokémon en fonction de leur index
    private final Map<Integer, PokemonMetadata> metadataMap;

    public IPokemonMetadataProviderImpl() {
        metadataMap = new HashMap<>();

        metadataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 49, 49)); // Pour l'index 0 (Bulbizarre)
        metadataMap.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260)); // Pour l'index 133 (Aquali)

    }

    /*
     * Retourne les métadonnées du Pokémon pour l'index fourni.
     *
     * @param index Index du Pokémon.
     * @return Métadonnées du Pokémon.
     * @throws PokedexException Si les métadonnées ne sont pas disponibles pour l'index fourni.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Métadonnées non trouvées pour l'index du Pokémon : " + index);
        }

        return metadataMap.get(index);
    }
}
