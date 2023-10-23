/**
 * Main
 */

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n\n--------------------------- MASTERMIND ---------------------------\n\n");

        System.out.println("All'inizio il gioco sceglie randomicamente una sequenza di colori,\nusando una qualsiasi combinazione di 4/5 colori. L'utente, di volta\nin volta, compone una combinazione, che sarà lasciata sulla tabella,\nscegliendo i suoi colori. Il gioco da le informazioni in questo modo:\n");
        char c;
        c = '\u2705';
        System.out.println(c + " -> indica che un colore è esatto e nella posizione corretta");
        c = '\u2713';
        System.out.println(c + " -> indica che un colore è esatto ma nella posizione sbagliata\n");

        System.out.println("Questi indicatori vengono collocati in un qualsiasi ordine.\nIl gioco termina quando sono finiti tutti e 10 i tentativi o se \nla combinazione viene indovinata.\n");

        System.out.println("Lo scopo, da parte del gioco, è di creare una combinazione di colori\nche non consenta all'utente di risolverla prima di aver finito il\nproprio numero di tentativi. Di contro, lo scopo dell'utente è\nquello di indovinare la combinazione entro il numero di tentativi\ncha ha a disposizione.\n");

        System.out.print("Inserire il nome del giocatore -> ");
        Scanner s = new Scanner(System.in);
        String nome = s.next();
        Giocatore giocatore = new Giocatore(nome);
        
        Gioco g = new Gioco();
        System.out.print("Vuoi giocare con una sequenza di 4 colori, di 5 colori o di 6 colori? ");
        int numero = s.nextInt();
        List<String> sequenza_gioco = new ArrayList<>();
        if (numero == 4) {
            sequenza_gioco = g.estrazione_4();
        } else if (numero == 5) {
            sequenza_gioco = g.estrazione_5();
        } else if (numero == 6) {
            sequenza_gioco = g.estrazione_6();
        } else {
            System.out.println("Numero non valido");
            System.exit(0);
        }

        Tabella tabella = new Tabella(10, numero);

        tabella.stampaPaletteColori();

        System.out.println("\n...");

        // Aspetta 4 secondi
        /** 
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex){
        }
        */

        System.out.println("\nIl gioco ha scelto la sua sequenza di " + numero + " colori, ora tocca a te " + giocatore.toString() + "...fai la tua prima scelta\n");
        
        // Inizio del gioco
        for (int i=0; i<10; i++) {
            Tentativo tentativo = new Tentativo(numero, sequenza_gioco);
            tentativo.inserisci(numero);
            int[] risultato = tentativo.confronta(numero);
            tabella.stampaTabella(tentativo.sequenzaScelta(), risultato);
            if (tentativo.vittoria(risultato)) {
                System.out.println("\n                    VITTORIA!!!\n");
                System.out.print("La sequenza scelta era: ");
                for (int j=0; j<sequenza_gioco.size(); j++) {
                    System.out.print(tabella.parolaColorata(sequenza_gioco.get(j)) + " ");
                }
                System.out.println("\n");
                System.exit(0);
            }
            System.out.println();
        }
        System.out.println("Purtroppo hai esaurito i tentativi...ho vinto io!!!");
        System.out.print("La sequenza scelta era: ");
        for (int i=0; i<sequenza_gioco.size(); i++) {
            System.out.print(tabella.parolaColorata(sequenza_gioco.get(i)) + " ");
        }
        System.out.println("\n");

    }
    
}