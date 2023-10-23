import java.util.*;

public class Giocatore {

    final private String nome;

    /**
     * Costruisce un oggetto di tipo Giocatore
     * @param nome Stringa
     */
    public Giocatore(final String nome) {
        Objects.requireNonNull(nome);
        if (nome.isEmpty()) throw new IllegalArgumentException("Il nome del giocatore non può essere una parola vuota.");
        this.nome = nome;
    }

    /**
     * Verifica l'invariante di rappresentazione
     */
    public boolean repok() {
        if (this.nome == null) return false;
        if (this.nome.isEmpty()) return false;
        return true;
    }

    /**
     * Restituisce il nome del giocatore 
     * @return il nome di this
     */
    public String nome() {
        assert repok();
        return this.nome;
    }

    /**
     * Restituisce una rappresentazione testuale di this
     */
    @Override 
    public String toString() {
        assert repok();
        return this.nome;
    }

}