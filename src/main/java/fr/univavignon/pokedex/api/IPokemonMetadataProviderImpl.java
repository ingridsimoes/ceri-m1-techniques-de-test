package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class IPokemonMetadataProviderImpl implements IPokemonMetadataProvider {

    // Mapa para armazenar metadados de Pokémon com base no índice
    private final Map<Integer, PokemonMetadata> metadataMap;

    public IPokemonMetadataProviderImpl() {
        // Inicialize o mapa de metadados
        metadataMap = new HashMap<>();

        // Adicione metadados de exemplo para alguns Pokémon
        metadataMap.put(1, new PokemonMetadata(1, "Bulbasaur", 45, 49, 49));
        metadataMap.put(2, new PokemonMetadata(2, "Ivysaur", 60, 62, 63));
        metadataMap.put(3, new PokemonMetadata(3, "Venusaur", 80, 82, 83));
        // Adicione mais metadados conforme necessário
    }

    /**
     * Retorna os metadados do Pokémon para o índice fornecido.
     *
     * @param index Índice do Pokémon.
     * @return Metadados do Pokémon.
     * @throws PokedexException Se os metadados não estiverem disponíveis para o índice fornecido.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Verifica se os metadados estão disponíveis para o índice fornecido
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Metadados não encontrados para o índice do Pokémon: " + index);
        }

        // Retorna os metadados do Pokémon para o índice fornecido
        return metadataMap.get(index);
    }
}
