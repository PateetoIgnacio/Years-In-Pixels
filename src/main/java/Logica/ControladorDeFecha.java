package Logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ControladorDeFecha {

    private Date fechaActual;

    public ControladorDeFecha() {
        Calendar dia = Calendar.getInstance(TimeZone.getTimeZone("America/Chile"));
        this.fechaActual = dia.getTime();
    }

    public Date getFechaActual() {
        return this.fechaActual;
    }
    
    public boolean validarFechaPasada(int dia, int mes) {
        return (getFechaActual().after(crearFechaDia(dia, mes)));
    }

    public boolean validarFechaFutura(int dia, int mes) {
        return (getFechaActual().before(crearFechaDia(dia, mes)));
    }

    public boolean validarFechaActual(int dia, int mes) {
        return (getFechaActual().equals(crearFechaDia(dia, mes)));
    }

    public int diasTranscurridos(int dia, int mes) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaInicial = crearFechaDia(01, 01);
        Date fechaFinal = crearFechaDia(dia, mes);

        return (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
    }
    public int diasTranscurridos(Date fecha){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaInicial = crearFechaDia(01, 01);
        Date fechaFinal = fecha;

        return (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
    }

    private Date crearFechaDia(int dia, int mes) {
        Calendar auxiliar = Calendar.getInstance();
        auxiliar.set(Calendar.YEAR, 2018);
        auxiliar.set(Calendar.MONTH, mes - 1);
        auxiliar.set(Calendar.DAY_OF_MONTH, dia);
        return auxiliar.getTime();
    }

}