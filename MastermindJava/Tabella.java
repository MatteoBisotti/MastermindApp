import java.rmi.server.ServerNotActiveException;
import java.util.*;
import java.io.*;

/**
 * Tabella
 */
public class Tabella {

    final private int rows;
    final private int columns;
    final private List<List<String>> sequenze = new ArrayList<>();
    final private List<int[]> risultati = new ArrayList<>();

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[43m" + "\u001B[30m" + "Giallo" + reset;
    public static final String red = "\u001B[41m" + "\u001B[30m" + "Rosso" + reset;
    public static final String green = "\u001B[42m" + "\u001B[30m" + "Verde" + reset;
    public static final String purple = "\u001B[45m" + "\u001B[30m" + "Viola" + reset;
    public static final String black = "\u001B[40m" + "Nero" + reset;
    public static final String blue = "\u001B[44m" + "\u001B[30m" + "Blu" + reset;
    public static final String orange = "\033[48:5:166m" + "\u001B[30m" + "Arancione" + "\033[m";
    public static final String white = "\u001B[47m" + "\u001B[30m" + "Bianco" + reset;

    /**
     * Costruisce un oggetto di tipo Tabella
     * @param rows intero
     * @param columns intero
     */
    public Tabella(final int rows, final int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    /**
     * Stampa la sequenza di colori scelta ad ogni turno dall'utente
     * @param sequenza lista di stringhe  
     * @throws NullPointerException nel caso in cui sequenza sia null  
     */
    public void stampaRiga(final List<String> sequenza) {
        Objects.requireNonNull(sequenza);
        for (int i=0; i<sequenza.size(); i++) {
            String stringaColorata = parolaColorata(sequenza.get(i));
            if ((stringaColorata.length()-14)==5) {
                System.out.print("|   " + stringaColorata + "   ");
            } else if ((stringaColorata.length()-14)==3) {
                System.out.print("|    " + stringaColorata + "    ");
            } else if ((stringaColorata.length())==28) {
                System.out.print("| " + stringaColorata + " ");
            } else if ((stringaColorata.length())==13) {
                System.out.print("|    " + stringaColorata + "   ");
            } else {
                System.out.print("|   " + stringaColorata + "  ");
            }
        }
        System.out.print("|   ");
    }

    /**
     * Stampa una riga vuota della tabella
     */
    public void stampaRigaVuota() {
        System.out.print("|");
        for (int i=0; i<this.columns; i++) {
            System.out.print("           |");
        }
        System.out.println();
    }

    /**
     * Stampa il risultato che fornisce ad ogni turno dato dal confronto tra la sequenza scelta e la sequenza soluzione
     * @param risultato array di interi
     * @throws NoSuchElementException nel caso in cui risultato sia vuoto
     */
    public void stampaRisultato(int[] risultato) {
        if (risultato.length == 0) throw new NoSuchElementException();
        Arrays.sort(risultato);
        for (int i=0; i<risultato.length; i++) {
            char c;
            if (risultato[i]==-1) {
                c = '\u2705';
                System.out.print(c + " ");
            } else if (risultato[i]==0) {
                c = '\u2713';
                System.out.print(c + " ");
            }
        }
        System.out.println();
    }

    /**
     * Stampa bordo superiore e inferiore della tabella
     */
    public void stampaBordo() {
        System.out.print("+");
        for (int i=0; i<this.columns; i++) {
            System.out.print("-----------+");
        }
        System.out.println();
    }

    /**
     * Stampa la palette di colori disponibili
     */
    public void stampaPaletteColori() {
        System.out.print("\n" + yellow + " ");
        System.out.print(red + " ");
        System.out.print(green + " ");
        System.out.print(purple + " ");
        System.out.print(black + " ");
        System.out.print(blue + " ");
        System.out.print(orange + " ");
        System.out.print(white + " \n");
    }

    /**
     * Aggiunge la sequenza corrente alla lista delle sequenze scelte dall'utente, per tenere traccia dell'evoluzione del gioco
     * @param sequenza lista di stringhe
     * @throws NullPointerException nel caso in cui sequenza sia null
     */
    public void aggiungiSequenza(final List<String> sequenza) {
        Objects.requireNonNull(sequenza);
        this.sequenze.add(sequenza);
    }

    /**
     * Aggiunge il risultato corrente alla lista dei risultati, per tenere traccia dell'evoluzoine del gioco
     * @param risultato array di interi
     * @throws NoSuchElementException nel caso in cui risultato sia vuoto
     */
    public void aggiungiRisultato(int[] risultato) {
        if (risultato.length == 0) throw new NoSuchElementException();
        this.risultati.add(risultato);
    }

    /**
     * Restituisce ogni stringa nel colore che rappresenta
     * @param s stringa
     * @throws NullPointerException nel caso in cui s sia null
    */
    public String parolaColorata(final String s) {
        Objects.requireNonNull(s);
        if (s.equals("arancione")) {
            return orange;
        } else if (s.equals("rosso")) {
            return red;
        } else if (s.equals("blu")) {
            return blue;
        } else if (s.equals("verde")) {
            return green;
        } else if (s.equals("bianco")) {
            return white;
        } else if (s.equals("viola")) {
            return purple;
        } else if (s.equals("giallo")) {
            return yellow;
        } else {
            return black;
        }   
    }
    

    /**
     * Stampa la tabella completa, che tiene conto dell'evoluzione del gioco
     * @param sequenza lista di stringhe 
     * @param risultato array di interi
     * @throws IllegalArgumentException nel caso in cui sequenza sia null
     * @throws NoSuchElementException nel caso in cui risultato sia vuoto
     */
    public void stampaTabella(final List<String> sequenza, int[] risultato) {
        Objects.requireNonNull(sequenza);
        if (risultato.length == 0) throw new NoSuchElementException();
        stampaPaletteColori();
        stampaBordo();
        this.sequenze.add(sequenza);
        this.risultati.add(risultato);
        for (int i=0; i<this.rows; i++) {
            if (i<sequenze.size()) {
                stampaRiga(sequenze.get(i));
                stampaRisultato(risultati.get(i));
            } else {
                stampaRigaVuota();
            }
            stampaBordo();
        }
    }

}