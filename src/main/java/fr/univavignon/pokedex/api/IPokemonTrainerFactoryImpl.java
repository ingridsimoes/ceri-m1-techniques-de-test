package fr.univavignon.pokedex.api;

public class IPokemonTrainerFactoryImpl implements IPokemonTrainerFactory {

    /**
     * Creates and returns a PokemonTrainer instance.
     *
     * @param name            Name of the created trainer.
     * @param team            Team of the created trainer.
     * @param pokedexFactory  Factory to use for creating associated pokedex instance.
     * @return Created trainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Aqui você pode criar uma instância de PokemonTrainer com os parâmetros fornecidos
        // Vamos criar uma instância de exemplo para demonstração
        IPokemonMetadataProvider metadataProvider = new IPokemonMetadataProviderImpl();
        IPokemonFactory pokemonFactory = new IPokemonFactoryImpl();
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        return new PokemonTrainer(name, team, pokedex);
    }
}
