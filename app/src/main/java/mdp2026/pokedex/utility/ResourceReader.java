package mdp2026.pokedex.utility;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Classe astratta di supporto utile ad implementazioni
 * volte alla lettura diretta di file di risorse
 */
public abstract class ResourceReader {

    protected String leggiFile(String nomeFile) {
        try (InputStream is = ResourceReader.class
                .getClassLoader()
                .getResourceAsStream(nomeFile)) {

            if (is == null) {
                throw new RuntimeException("File non trovato: " + nomeFile);
            }

            return new String(is.readAllBytes(), StandardCharsets.UTF_8);

        } catch (Exception e) {
            throw new RuntimeException("Errore lettura file: " + nomeFile, e);
        }
    }
}
