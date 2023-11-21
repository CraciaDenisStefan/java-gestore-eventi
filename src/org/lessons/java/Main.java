package org.lessons.java;

import java.time.LocalDate;
import org.lessons.java.pojo.abs.Evento;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws Exception {
		 Scanner in = new Scanner(System.in);

	     
	        System.out.println("Inserisci i dettagli dell'evento:");
	        System.out.print("Titolo: ");
	        String titolo = in.nextLine();
	        System.out.print("Data (YYYY-MM-DD): ");
	        String dataString = in.nextLine();
	        System.out.print("Numero di posti totali: ");
	        int postiTotali = in.nextInt();

	 
	        LocalDate data = LocalDate.parse(dataString);

	        Evento evento = new Evento(titolo, data, postiTotali);

	        System.out.println("Posti disponibili: "+ postiTotali);
	        System.out.println("Quante prenotazioni vuoi fare?");
	        int numPrenotazioni = in.nextInt();

	        for (int i = 0; i < numPrenotazioni; i++) {
	            try {
	                evento.prenota();
	                System.out.println("Prenotazione effettuata.");
	            } catch (Exception e) {
	                System.out.println("Impossibile effettuare la prenotazione: " + e.getMessage());
	            }
	        }

	        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
	        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

	
	        System.out.println("Quanti posti vuoi disdire?");
	        int numDisdette = in.nextInt();

	        for (int i = 0; i < numDisdette; i++) {
	            try {
	                evento.disdici();
	                System.out.println("Disdetta effettuata.");
	            } catch (Exception e) {
	                System.out.println("Impossibile effettuare la disdetta: " + e.getMessage());
	            }
	        }

	        in.close();
	        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
	        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
    }
}
