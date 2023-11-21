package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.lessons.java.pojo.Concerto;
import org.lessons.java.pojo.abs.Evento;
import org.lessons.java.pojo.ProgrammEventi;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		 Scanner in = new Scanner(System.in);
		 ProgrammEventi program = new ProgrammEventi("Programma Eventi");
	     
		 boolean datiValidi = true;
		 Evento evento = null;

		 while (datiValidi) {
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
		         program.aggiungiEvento(evento);
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
			        in.nextLine();
			        for (int i = 0; i < numDisdette; i++) {
			            try {
			                evento.disdici();
			                System.out.println("Disdetta effettuata.");
			            } catch (Exception e) {
			                System.out.println("Errore: " + e.getMessage());
			            }
			        }
		     
			        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
			        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));	         
		        
		         System.out.println("Vuoi aggiungere un altro evento? (si/no): ");
	                String risposta = in.nextLine().toLowerCase();

	                if (risposta.equals("no")) {
	                    datiValidi = false;
	                }
	              
		     } catch (Exception e) {
		         System.out.println("Errore nei dati inseriti: " + e.getMessage());
		         System.out.println("Riprova.");
		     }
		 }
		 
		 
		 boolean menuAttivo = true;

	        while (menuAttivo) {
	            System.out.println("\n Menu:");
	            System.out.println("1. Visualizza numero eventi nella lista");
	            System.out.println("2. Svuota la lista degli eventi");
	            System.out.println("3. Esci e visualizza la lista dei tuoi eventi");

	            int sceltaMenu = in.nextInt();
	            in.nextLine(); // 

	            switch (sceltaMenu) {
	                case 1:
	                    System.out.println("Numero di eventi nella lista: " + program.quantitaEventi());
	                    break;
	                case 2:
	                    program.svuotaEventi();
	                    System.out.println("La lista degli eventi è stata svuotata.");
	                    break;
	                case 3:
	                    menuAttivo = false;
	                    break;
	                default:
	                    System.out.println("Scelta non valida. Riprova.");
	            }
	        }

	        in.close();
	        System.out.println(program.toString());
	}
}
