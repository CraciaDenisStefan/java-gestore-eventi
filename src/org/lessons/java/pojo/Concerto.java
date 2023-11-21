package org.lessons.java.pojo;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.lessons.java.pojo.abs.Evento;

public class Concerto extends Evento {
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) throws Exception {
        super(titolo, data, postiTotali);
        setOra(ora);
        setPrezzo(prezzo);
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) throws Exception {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) throws Exception {
    	 if (prezzo == null || prezzo.compareTo(BigDecimal.ZERO) < 0) {
             throw new Exception("Il prezzo deve essere un valore positivo.");
         }
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s - %.2f€", super.toString(), getOra() , getTitolo(), getPrezzo());
    }

}
