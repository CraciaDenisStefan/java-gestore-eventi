package org.lessons.java.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.lessons.java.pojo.abs.Evento;

public class ProgrammEventi {
    private String titolo;
    private List<Evento> eventi;

    public ProgrammEventi(String titolo) {
    	setTitolo(titolo);
		setEventi(new ArrayList<>());
    }

    public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}

	public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    public List<Evento> eventiInData(LocalDate data) {
        List<Evento> eventiInData = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getData().equals(data)) {
                eventiInData.add(evento);
            }
        }
        return eventiInData;
    }

    public int quantitaEventi() {
        return eventi.size();
    }

    public void svuotaEventi() {
        eventi.clear();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(titolo).append("\n");

        Collections.sort(eventi, Comparator.comparing(Evento::getData));

        for (Evento evento : eventi) {
            result.append(evento.getData()).append(" - ").append(evento.getTitolo()).append("\n");
        }

        return result.toString();
    }
}
