package mdp2026.pokedex;

import mdp2026.pokedex.utility.ScannerTextInput;
import mdp2026.pokedex.utility.StandardTextOutput;
import mdp2026.pokedex.utility.TextInput;
import mdp2026.pokedex.utility.TextOutput;

public class App {
    public static void main(String[] args) {
        // Inizializziamo gli strumenti della repo e il nostro Pokedex
        TextInput input = new ScannerTextInput();
        TextOutput output = new StandardTextOutput();
        Pokedex pokedex = new Pokedex();

        boolean running = true;

        while (running) {
            output.println("\n=== POKEDEX PRINCIPALE ===");
            // Filtriamo la lista per mostrare solo i pokemon già scoperti
            // Se la lista è vuota (all'inizio), non stamperà nulla
            pokedex.getPokedex().stream()
                    .filter(Pokemon::isFound)
                    .forEach(p -> output.println(p.toString()));

            // Opzionale: un messaggio se non hai ancora scoperto nulla
            long scopertiCount = pokedex.getPokedex().stream().filter(Pokemon::isFound).count();
            if (scopertiCount == 0) {
                output.println("[ Nessun Pokémon ancora scoperto ]");
            }

            output.println("\nScegli un'opzione:");
            output.println("0. Esci");
            output.println("1. Cerca Pokemon");
            output.println("Scelta: ");

            String scelta = input.readInput();

            if (scelta.equals("0")) {
                running = false;
                output.println("Spegnimento Pokédex... Addio!");
            } else if (scelta.equals("1")) {
                output.println("Inserisci il numero del Pokemon (1-151):");
                String numInput = input.readInput();
                // Controlliamo se l'input è composto solo da cifre
                if (isNumeric(numInput)) {
                    int numero = Integer.parseInt(numInput);

                    if (numero >= 1 && numero <= 151) {
                        Pokemon p = pokedex.getPokemon(numero);
                        gestisciDettaglio(p, pokedex, input, output);
                    } else {
                        output.println("Errore: il numero deve essere tra 1 e 151. Riprova.");
                    }
                } else {
                    // Se l'utente ha inserito lettere o è vuoto
                    output.println("Errore: '" + numInput + "' non è un numero valido. Usa solo cifre.");
                }
            }
        }
    }


    private static void gestisciDettaglio(Pokemon p, Pokedex pokedex, TextInput input, TextOutput output) {
        boolean inDettaglio = true;
        while (inDettaglio) {
            output.println("\n--- DETTAGLIO POKEMON ---");
            output.println("Stai visualizzando: " + p.toString());
            output.println("-------------------------");
            output.println("Comandi: [-1] Precedente, [1] Successivo, [0] Torna al Menu");

            String cmd = input.readInput();

            switch (cmd) {
                case "0" -> inDettaglio = false;
                case "1" -> p = pokedex.naviga(p, 1);
                case "-1" -> p = pokedex.naviga(p, -1);
                default -> output.println("Comando non valido.");
            }
        }
    }

    private static boolean isNumeric(String str) {
        // Verifica se la stringa non è vuota e contiene solo cifre da 0 a 9
        return str != null && str.matches("\\d+");
    }


}