package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.lessons.java.pojo.Concerto;
import org.lessons.java.pojo.abs.Evento;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		 Scanner in = new Scanner(System.in);

	     
		 boolean datiValidi = false;
		 Evento evento = null;

		 while (!datiValidi) {
		     try {
		         System.out.println("Inserisci i dettagli dell'evento:");
		         System.out.print("Titolo: ");
		         String titolo = in.nextLine();

		         System.out.print("Data (YYYY-MM-DD): ");
		         String dataString = in.nextLine();
		         LocalDate data = LocalDate.parse(dataString);

		         System.out.print("Numero di posti totali: ");
		         int postiTotali = in.nextInt();
		         in.nextLine();


		         System.out.print("Ora (HH:mm): ");
		         String oraString = in.nextLine();
		         LocalTime ora = LocalTime.parse(oraString);
		          

		         System.out.print("Prezzo: ");
		         BigDecimal prezzo = in.nextBigDecimal();
		         in.nextLine();

		      
		         evento = new Concerto(titolo, data, postiTotali, ora, prezzo);
		         datiValidi = true;
		     } catch (Exception e) {
		         System.out.println("Errore nei dati inseriti: " + e.getMessage());
		         System.out.println("Riprova.");
		     }
		 }
		 
		 
	        System.out.println("Posti disponibili: "+ evento.getPostiTotali() );
	        System.out.println("Quante prenotazioni vuoi fare?");
	        int numPrenotazioni = in.nextInt();

	        for (int i = 0; i < numPrenotazioni; i++) {
	            try {
	                evento.prenota();
	                System.out.println("Prenotazione effettuata.");
	            } catch (Exception e) {
	                System.out.println("Errore: " + e.getMessage());
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
	                System.out.println("Errore: " + e.getMessage());
	            }
	        }

	        in.close();
	        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
	        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
	 
	        System.out.println(evento.toString());
    }
}
