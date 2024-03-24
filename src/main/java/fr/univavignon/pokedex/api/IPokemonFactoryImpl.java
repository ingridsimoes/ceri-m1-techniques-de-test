package fr.univavignon.pokedex.api;

public class IPokemonFactoryImpl implements IPokemonFactory {

    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Aqui você pode calcular os IVs com base nos parâmetros fornecidos
        // Por simplicidade, vamos criar uma instância de Pokemon com os parâmetros fornecidos
        return new Pokemon(index, "Pokemon", cp, hp, dust, candy, 0, 0, 0, 0.0);
    }
}
