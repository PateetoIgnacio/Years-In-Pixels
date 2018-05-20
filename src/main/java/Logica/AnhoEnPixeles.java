
package Logica;

import java.awt.*;

public class AnhoEnPixeles {
    private final int MESES_DEL_ANHO = 12;
    private final int DIAS_DEL_MES = 31;
    private final int CANTIDAD_DE_ESTADOS = 5;
    private EstadoDeAnimo [] estados;
    private Controlador controlador;

    public AnhoEnPixeles(){
        this.estados = new EstadoDeAnimo[this.CANTIDAD_DE_ESTADOS];
        this.controlador = new Controlador();
        inicializarArreglo(this.estados);
    }

    private void inicializarArreglo(EstadoDeAnimo[] estados){
        EstadoDeAnimo estado = new EstadoDeAnimo();
        for (int indicador = 0; indicador < estados.length; indicador++){
            switch (indicador){
                case 0:
                    estado.setEstado(TipoDeEstado.ESTADO_1); 
                    estado.setColorRepresentacion(Color.yellow);
                    break;
                case 1:
                    estado.setEstado(TipoDeEstado.ESTADO_2); 
                    estado.setColorRepresentacion(Color.green);
                    break;
                case 2:
                    estado.setEstado(TipoDeEstado.ESTADO_3); 
                    estado.setColorRepresentacion(Color.blue);
                    break;
                case 3:
                    estado.setEstado(TipoDeEstado.ESTADO_4); 
                    estado.setColorRepresentacion(Color.orange);
                    break;
                case 4:
                    estado.setEstado(TipoDeEstado.ESTADO_5);
                    estado.setColorRepresentacion(Color.red);
                    break;
                default:
                    estado.setEstado(TipoDeEstado.SIN_ESPECIFICAR);
                    estado.setColorRepresentacion(Color.white);
                    break;
            }
            this.estados[indicador] = estado;
        }
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

    public EstadoDeAnimo[] getEstados() { 
        return this.estados; 
    }
    
    public EstadoDeAnimo getEstado(int indice){
        return this.estados[indice];
    }

    public Controlador getControlador() { 
        return this.controlador; 
    }


}