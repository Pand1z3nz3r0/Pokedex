package mdp2026.pokedex.utility;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Implementazione basata sulle classiche classi
 * di output, con una standardizzazione a UTF8
 */
public class StandardTextOutput implements TextOutput {

    @Override
    public void println(String text) {
        new PrintStream(System.out, true, StandardCharsets.UTF_8).println(text);
    }

}
