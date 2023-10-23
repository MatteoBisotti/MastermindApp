import java.util.*;

public class Gioco {

    final private List<String> colori = new ArrayList<>();

    /**
     * Costruisce un oggetto di tipo Gioco
     */
    public Gioco() {
        this.colori.add("rosso");
        this.colori.add("blu");
        this.colori.add("verde"); 
        this.colori.add("bianco");
        this.colori.add("nero");
        this.colori.add("giallo");
        this.colori.add("viola");
        this.colori.add("arancione");
    }

    /**
     * Il gioco sceglie randomicamente 4 colori che l'utente dovrà indovinare e restituisce la sequenza scelta
     * @return una lista di stringhe che rappresenta la sequenza di colori scelta casualmente da this
     */
    public List<String> estrazione_4() {
        Random rand = new Random();
        // Array che conterrà la sequenza di 4 colori scelta dal gioco all'inizio della partita
        List<String> scelta = new ArrayList<>();
        // Primo colore scelto randomicamente
        int colore = rand.nextInt(this.colori.size());
        // Set che contiene i colori scelti man mano dal gioco, serve per non avere ripetizioni
        Set<Integer> validate = new HashSet<>();
        // Aggiungiamo il primo colore scelto al set
        validate.add(colore);
        for (int i=0; i<4; i++) {
            // Continuo ad estrarre casualmente un colore fino a quando non ne trovo uno che non è presente nel set, in modo da non avere ripetizioni
            while (validate.contains(colore)) {
                colore = rand.nextInt(this.colori.size());
            }
            validate.add(colore);
            scelta.add(this.colori.get(colore));
        }
        return scelta;
    }

    /**
     * Il gioco sceglie randomicamente 5 colori che l'utente dovrà indovinare e restituisce la sequenza scelta
     * @return una lista di stringhe che rappresenta la sequenza di colori scelta casualmente da this
     */
    public List<String> estrazione_5() {
        Random rand = new Random();
        // Array che conterrà la sequenza di 4 colori scelta dal gioco all'inizio della partita
        List<String> scelta = new ArrayList<>();
        // Primo colore scelto randomicamente
        int colore = rand.nextInt(this.colori.size());
        // Set che contiene i colori scelti man mano dal gioco, serve per non avere ripetizioni
        Set<Integer> validate = new HashSet<>();
        // Aggiungiamo il primo colore scelto al set
        validate.add(colore);
        for (int i=0; i<5; i++) {
            // Continuo ad estrarre casualmente un colore fino a quando non ne trovo uno che non è presente nel set, in modo da non avere ripetizioni
            while (validate.contains(colore)) {
                colore = rand.nextInt(this.colori.size());
            }
            validate.add(colore);
            scelta.add(this.colori.get(colore));
        }
        return scelta;
    }

    public List<String> estrazione_6() {
        Random rand = new Random();
        // Array che conterrà la sequenza di 4 colori scelta dal gioco all'inizio della partita
        List<String> scelta = new ArrayList<>();
        // Primo colore scelto randomicamente
        int colore = rand.nextInt(this.colori.size());
        // Set che contiene i colori scelti man mano dal gioco, serve per non avere ripetizioni
        Set<Integer> validate = new HashSet<>();
        // Aggiungiamo il primo colore scelto al set
        validate.add(colore);
        for (int i=0; i<6; i++) {
            // Continuo ad estrarre casualmente un colore fino a quando non ne trovo uno che non è presente nel set, in modo da non avere ripetizioni
            while (validate.contains(colore)) {
                colore = rand.nextInt(this.colori.size());
            }
            validate.add(colore);
            scelta.add(this.colori.get(colore));
        }
        return scelta;
    }

    /**
     * Restituisca una rappresentazione testuale di this
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i=0; i<this.colori.size(); i++) {
            s.append(this.colori.get(i));
            s.append("\n");
        }
        return s.toString();
    }

}