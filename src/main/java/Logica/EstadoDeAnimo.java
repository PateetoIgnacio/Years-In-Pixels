
package Logica;

import java.awt.Color;
import java.io.Serializable;

public class EstadoDeAnimo implements Serializable{
    private TipoDeEstado tipo;
    private Color color;

    public EstadoDeAnimo(){
        this.tipo = TipoDeEstado.SIN_ESPECIFICAR;
        this.color = Color.white;
    }
    
    public EstadoDeAnimo(TipoDeEstado tipo, Color color){
        this.tipo = tipo;
        this.color = color;
    }
    public TipoDeEstado getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoDeEstado estado) {
        this.tipo = estado;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color colorRepresentacion) {
        this.color = colorRepresentacion;
    }
    
    public void setCambio(EstadoDeAnimo estado){
        this.tipo = estado.getTipo();
        this.color = estado.getColor();
    }

    @Override
    public String toString() {
        return "EstadoDeAnimo{" + "tipo=" + tipo + ", color=" + color + '}';
    }
    

}