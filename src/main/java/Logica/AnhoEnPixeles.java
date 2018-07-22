
package Logica;

import java.awt.Color;

public class AnhoEnPixeles {
    private final int MESES_DEL_ANHO = 12;
    private final int DIAS_DEL_MES = 31;
    private final int CANTIDAD_DE_ESTADOS = 5;

    private EstadoDeAnimo [] opcionesDeEstados;
    private EstadoDeAnimo [][] calendarioDeEstados;
    private ControladorDeFecha controlador;

    public AnhoEnPixeles(){
        this.opcionesDeEstados = new EstadoDeAnimo[this.CANTIDAD_DE_ESTADOS + 1]; //se considera el estado que no esta especificado
        this.calendarioDeEstados = new EstadoDeAnimo[this.DIAS_DEL_MES][this.MESES_DEL_ANHO];
        this.controlador = new ControladorDeFecha();
        inicializarOpciones();
        inicializarCalendario();
        mostrarMatriz();
        
    }

    private void inicializarOpciones(){
        this.opcionesDeEstados[0] = new EstadoDeAnimo(TipoDeEstado.ESTADO_1, Color.yellow);
        this.opcionesDeEstados[1] = new EstadoDeAnimo(TipoDeEstado.ESTADO_2, Color.green);
        this.opcionesDeEstados[2] = new EstadoDeAnimo(TipoDeEstado.ESTADO_3, Color.blue);
        this.opcionesDeEstados[3] = new EstadoDeAnimo(TipoDeEstado.ESTADO_4, Color.orange);
        this.opcionesDeEstados[4] = new EstadoDeAnimo(TipoDeEstado.ESTADO_5, Color.red);
        this.opcionesDeEstados[5] = new EstadoDeAnimo(TipoDeEstado.SIN_ESPECIFICAR, Color.white);

    }
    
    private void inicializarCalendario() {
        for (int dia = 0; dia < this.DIAS_DEL_MES; dia++) {
            for (int mes = 0; mes < this.MESES_DEL_ANHO; mes++) {
                //si son fechas futuras
                if(this.controlador.validarFechaPasada(dia+1, mes+1)){
                    ingresarEstado(dia, mes, 5); //el cinco correspone al estado sin especificar dentro del arreglo de opciones
                }
                //si son fechas que ya pasaron, pero se sale del rango de cambios
                else if (this.controlador.validarFechaFutura(dia+6, mes+1)){
                    ingresarEstado(dia, mes, 1);
                }
                //si en los dias es posible hacer cambios
                else{
                    ingresarEstado(dia, mes, 0);
                }
            }
        }
    }
    
    private void mostrarMatriz(){
        String msj;
        for (int i = 0; i < this.DIAS_DEL_MES; i++) {
            for (int j = 0; j < this.MESES_DEL_ANHO; j++) {
                switch(this.calendarioDeEstados[i][j].getTipo()){
                    case ESTADO_1: msj = "1  ";
                        break;
                    case ESTADO_2: msj = "2  ";
                        break;
                    case ESTADO_3: msj = "3  ";
                        break;
                    case ESTADO_4: msj = "4  ";
                        break;
                    case ESTADO_5: msj = "5  ";
                        break;
                    default: msj = "-  ";
                        break;
                }
                System.out.print(msj);
            }
            System.out.println("");
        }
    }
    
    public void ingresarEstado(int dia, int mes, int indice){
        this.calendarioDeEstados[dia][mes] = this.opcionesDeEstados[indice];
    }

    public int getMESES_DEL_ANHO() {
        return this.MESES_DEL_ANHO;
    }

    public int getDIAS_DEL_MES() {
        return this.DIAS_DEL_MES;
    }

    public int getCANTIDAD_DE_ESTADOS() { 
        return this.CANTIDAD_DE_ESTADOS; 
    }

    public EstadoDeAnimo[] getOpcionesDeEstados() { 
        return this.opcionesDeEstados; 
    }
    
    public EstadoDeAnimo getEstado(int indice){
        return this.opcionesDeEstados[indice];
    }

    public ControladorDeFecha getControlador() { 
        return this.controlador; 
    }

    public EstadoDeAnimo getEstadoEnLaFecha(int dia, int mes) {
        return this.calendarioDeEstados[dia][mes];
    }

}