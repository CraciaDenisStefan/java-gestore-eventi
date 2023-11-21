package org.lessons.java;

import java.time.LocalDate;
import org.lessons.java.pojo.abs.Evento;
public class Main {
	public static void main(String[] args) {
        try {
          
            Evento evento1 = new Evento("Evento 1", LocalDate.now().plusDays(10), 50);
            Evento evento2 = new Evento("Evento 2", LocalDate.now().plusDays(20), 100);

       
            Evento[] eventi = {evento1, evento2};

            
            for (Evento evento : eventi) {
                System.out.println(evento);
            }

   
            evento1.prenota();
            evento2.prenota();
            evento1.disdici();
            evento2.prenota();
            evento2.prenota();
            evento2.disdici();

   
            for (Evento evento : eventi) {
                System.out.println(evento);
                System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
                System.out.println();
            }

        } catch (Exception e) {
       
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
