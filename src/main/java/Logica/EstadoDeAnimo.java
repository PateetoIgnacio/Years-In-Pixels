
package Logica;

import java.awt.Color;

public class EstadoDeAnimo {
    private TipoDeEstado estado;
    private Color colorRepresentacion;

    public EstadoDeAnimo(){
        this.estado = TipoDeEstado.SIN_ESPECIFICAR;
        this.colorRepresentacion = Color.white;
    }

    public TipoDeEstado getEstado() {
        return this.estado;
    }

    public void setEstado(TipoDeEstado estado) {
        this.estado = estado;
    }

    public Color getColorRepresentacion() {
        return this.colorRepresentacion;
    }

    public void setColorRepresentacion(Color colorRepresentacion) {
        this.colorRepresentacion = colorRepresentacion;
    }

}