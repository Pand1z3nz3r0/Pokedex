package mdp2026.pokedex.utility;

import java.util.Scanner;

/**
 * Implementazione basata sull'uso dello Scanner della+
 * libreria standard util
 */
public class ScannerTextInput implements TextInput {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String readInput() {
        return scanner.nextLine();
    }

}
