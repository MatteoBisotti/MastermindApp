/**
 * Tentativo
 */

import java.util.*;

 public class Tentativo {

    final private List<String> soluzione;
    final private List<String> sequenza;

    /**
     * Costruisce un oggetto di tipo Tentativo
     * @param numero intero
     * @param soluzione lista di stringhe
     */
    public Tentativo(final int numero, final List<String> soluzione) {
        if (numero != 4 && numero != 5 && numero != 6) throw new IllegalArgumentException("Il numero non è valido");
        Objects.requireNonNull(soluzione);
        if (soluzione.size()==0) throw new IllegalArgumentException("La soluzione è vuota");

       this.sequenza = new ArrayList<>();
       this.soluzione = soluzione;
    }

    /**
     * L'utente inserisce la sequenza di colori per il tentativo corrente
     * @param numero intero
     * @throws IllegalArgumentException nel caso in cui numero non sia o 4 o 5
     */
    public void inserisci(final int numero) {
        if (numero != 4 && numero != 5 && numero != 6) throw new IllegalArgumentException("Il numero non è valido");
        Scanner s = new Scanner(System.in);
        for (int i=0; i<numero; i++) {
            String colore = s.next();
            this.sequenza.add(colore);
        }
    }

    /**
     * Restituisce la sequenza di colori scelta dall'utente
     * @return una lista di stringhe che corrisponde alla sequenza di colori scelta 
     */
    public List<String> sequenzaScelta() {
        return this.sequenza;
    }

    /**
     * Confronta la sequenza scelta dall'utente con la soluzione e restituisce un risultato
     * @param numero intero
     * @return un array di interi che corrisponde al risulato
     */
    public int[] confronta(final int numero) {
        if (numero != 4 && numero != 5 && numero != 6) throw new IllegalArgumentException("Il numero non è valido");
        int[] risultato = new int[numero];
        for (int i=0; i<numero; i++) {
            String corrente = this.sequenza.get(i);
            if (corrente.equals(this.soluzione.get(i))) {
                risultato[i] = -1;
            } else if (this.soluzione.contains(corrente)) {
                risultato[i] = 0;
            } else {
                risultato[i] = 1;
            }
        }
        return risultato;
    }

    /**
     * Restituisce un booleano per verificare che l'utente abbia inserito la sequenza corretta
     * @param risultato array di interi
     * @return un booleano per controllare se l'utente ha ottenuto la vittoria
     */
    public boolean vittoria(final int[] risultato) {
        if (risultato.length==0) throw new NoSuchElementException("L'array è vuoto.");
        for (int i=0; i<risultato.length; i++) {
            if (risultato[i]!=-1) return false;
        }
        return true;
    }

    /**
     * Verifica l'invariante di rappresentazione 
     */
    public boolean repOk() {
        if (this.sequenza == null) return false;
        if (this.soluzione == null) return false;
        return true;
    }

    /**
     * Restituisce una rappresentazione testuale di this
     */
    public String toString() {
        String s = "";
        for (int i=0; i<this.soluzione.size(); i++) {
            s += this.soluzione.get(i); 
        }
        s += "\n";
        for (int i=0; i<this.sequenza.size(); i++) {
            s += this.sequenza.get(i);
        }
        return s;
    }

}