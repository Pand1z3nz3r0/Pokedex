package mdp2026.pokedex;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import mdp2026.pokedex.utility.ResourceReader;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pokedex extends ResourceReader {
    private List<Pokemon> pokedex;

    public Pokedex(){
        // lettura file json in una stringa
        String jsonDati = leggiFile("data.json");
        // gestisco la creazione dell'oggeto Gson
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Pokemon>>(){}.getType();
        this.pokedex = gson.fromJson(jsonDati, listType);

    }

    public List<Pokemon> getPokedex() {
        return pokedex;
    }

    public Pokemon getPokemon(int id){
        for(Pokemon p : pokedex){
            if(p.getNumero() == id){
                p.setFound(true);
                return p;
            }
        }
        return null;
    }

    public Pokemon naviga(Pokemon attuale, int direzione) {
        // creo un pokedex parallelo ma solo con i pokemon scoperti
        List<Pokemon> scoperti = this.pokedex.stream().filter(p -> p.isFound()).collect(Collectors.toList());
        //prendo l'indice dal mio pokémon
        int indiceAttuale = scoperti.indexOf(attuale);
        //calcolo l'indice in base alla direzione +1 e -1, la formula serve per evitare che si rompa la lista agli estremi
        int nuovoIndice = (indiceAttuale + direzione + scoperti.size()) % scoperti.size();
        //ritorno l'indice del pokemon
        return scoperti.get(nuovoIndice);
    }
}
