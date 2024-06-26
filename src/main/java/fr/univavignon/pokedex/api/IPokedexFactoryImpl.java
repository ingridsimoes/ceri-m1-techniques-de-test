package fr.univavignon.pokedex.api;

public class IPokedexFactoryImpl implements IPokedexFactory {

    /**
     * Creates a new IPokedex instance using the provided metadataProvider and pokemonFactory.
     *
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokemon factory the created pokedex will use.
     * @return A new instance of IPokedexImpl.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        if (metadataProvider == null || pokemonFactory == null) {
            throw new IllegalArgumentException("Les paramètres ne peuvent pas être nuls.");
        }
        return new IPokedexImpl(metadataProvider, pokemonFactory);
    }
}
