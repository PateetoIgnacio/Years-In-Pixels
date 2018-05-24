
package Logica;

import java.awt.Color;

public class AnhoEnPixeles {
    private final int MESES_DEL_ANHO = 12;
    private final int DIAS_DEL_MES = 31;
    private final int CANTIDAD_DE_ESTADOS = 5;
    private EstadoDeAnimo [] opcionesDeEstados;
    private ControladorDeFecha controlador;

    public AnhoEnPixeles(){
        this.opcionesDeEstados = new EstadoDeAnimo[this.CANTIDAD_DE_ESTADOS];
        this.controlador = new ControladorDeFecha();
        inicializarArreglo();
    }

    private void inicializarArreglo(){
        EstadoDeAnimo estado = new EstadoDeAnimo();
        for (int indicador = 0; indicador < opcionesDeEstados.length; indicador++){
            switch (indicador){
                case 0:
                    estado.setTipo(TipoDeEstado.ESTADO_1); 
                    estado.setColor(Color.yellow);
                    break;
                case 1:
                    estado.setTipo(TipoDeEstado.ESTADO_2); 
                    estado.setColor(Color.green);
                    break;
                case 2:
                    estado.setTipo(TipoDeEstado.ESTADO_3); 
                    estado.setColor(Color.blue);
                    break;
                case 3:
                    estado.setTipo(TipoDeEstado.ESTADO_4); 
                    estado.setColor(Color.orange);
                    break;
                case 4:
                    estado.setTipo(TipoDeEstado.ESTADO_5);
                    estado.setColor(Color.red);
                    break;
                default:
                    estado.setTipo(TipoDeEstado.SIN_ESPECIFICAR);
                    estado.setColor(Color.white);
                    break;
            }
            this.opcionesDeEstados[indicador] = estado;
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

    public EstadoDeAnimo[] getOpcionesDeEstados() { 
        return this.opcionesDeEstados; 
    }
    
    public EstadoDeAnimo getEstado(int indice){
        return this.opcionesDeEstados[indice];
    }

    public ControladorDeFecha getControlador() { 
        return this.controlador; 
    }
}