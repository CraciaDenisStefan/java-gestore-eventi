package org.lessons.java.pojo.abs;

import java.time.LocalDate;

public  class Evento {
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    public Evento(String titolo, LocalDate data, int postiTotali) throws Exception{
        setTitolo(titolo);
        setData(data);
        setPostiTotali(postiTotali);
        setPostiPrenotati(0);
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws Exception {
        if (data.isBefore(LocalDate.now())) {
            throw new Exception("La data è già passata.");
        }
        this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    private void setPostiTotali(int postiTotali) throws Exception {
        if (postiTotali <= 0) {
            throw new Exception("Il numero di posti totali deve essere positivo.");
        }
        this.postiTotali = postiTotali;
    }
    
    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    private void setPostiPrenotati(int postiPrenotati) {
        this.postiPrenotati = postiPrenotati;
    }

    public void prenota() throws Exception {
        if (data.isBefore(LocalDate.now()) || postiPrenotati >= postiTotali) {
            throw new Exception("Impossibile effettuare la prenotazione.");
        }
        setPostiPrenotati(getPostiPrenotati() + 1);
    }

    public void disdici() throws Exception {
        if (data.isBefore(LocalDate.now()) || postiPrenotati == 0) {
            throw new Exception("Impossibile effettuare la disdetta.");
        }
        setPostiPrenotati(getPostiPrenotati() - 1);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", getData(), getTitolo());
    }
}
