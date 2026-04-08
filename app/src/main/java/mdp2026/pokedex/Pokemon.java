package mdp2026.pokedex;

public class Pokemon {
    private int numero;
    private String nome;
    private String tipo1;
    private String tipo2;
    private double altezza;
    private double peso;
    private boolean found;

    public Pokemon(){}

    public void setFound(boolean found){
        this.found = found;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo1() {
        return tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public double getAltezza() {
        return altezza;
    }

    public double getPeso() {
        return peso;
    }

    public boolean isFound() {
        return found;
    }

    public String toString(){
        return "nome: " + getNome() + "\n" +
                "tipo1: " + getTipo1() + "\n" +
                "tipo2: " + getTipo2() + "\n" +
                "altezza: " + getAltezza()  + "\n" +
                "peso:" + getPeso() + "\n";
    }
}
