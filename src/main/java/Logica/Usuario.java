package Logica;

import Utils.Archivo;
import Utils.TipoDeArchivo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Usuario implements java.io.Serializable {

    private String nombreUsuario;
    private String contrasenha;
    private Date fechaDeInicio;
    private int numIdentificador;
    private Archivo archivos[];
    private int estadisticasMensuales[][];

    public Usuario(String nombreUsuario, String contrasenha) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenha;
        this.numIdentificador = 0;
        this.archivos = new Archivo[3];
        this.estadisticasMensuales = new int[12][5];
        this.archivos[0] = new Archivo("usuarios", this.nombreUsuario, TipoDeArchivo.CALENDARIO);
        this.archivos[1] = new Archivo("usuarios", this.nombreUsuario, TipoDeArchivo.COLORES_DE_OPCIONES);
        this.archivos[2] = new Archivo("usuarios", this.nombreUsuario, TipoDeArchivo.CONTRASENHA);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public int getNumIdentificador() {
        return numIdentificador;
    }

    public void setNumIdentificador(int numIdentificador) {
        this.numIdentificador = numIdentificador;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public Archivo getArchivo(TipoDeArchivo tipo) {
        Archivo archivo = null;
        switch (tipo) {
            case CALENDARIO:
                archivo = this.archivos[0];
                break;
            case COLORES_DE_OPCIONES:
                archivo = this.archivos[1];
                break;
            case CONTRASENHA:
                archivo = this.archivos[2];
                break;
        }
        return archivo;
    }

    public boolean compararUsuarios(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.numIdentificador != other.numIdentificador) {
            return false;
        }
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasenha, other.contrasenha)) {
            return false;
        }
        return true;
    }

    public int[][] inicializarEstadisticasHastaElMes(int cantidadDeMeses, int cantidadDeEstados) {
        for (int mes = 0; mes < cantidadDeMeses; mes++) {
            for (int estado = 0; estado < cantidadDeEstados; estado++) {
                this.estadisticasMensuales[mes][estado] = 0;
            }
        }
        return this.estadisticasMensuales;
    }

    public int[][] actualizarEstadisticas(ArrayList<EstadoDeAnimo> estados, int dias, int meses) {
        ControladorDeFecha control = new ControladorDeFecha();
        int cantidades[] = new int[5];
        for (int i = 0; i < cantidades.length; i++) {
            cantidades[i] = 0;
        }

        for (int mes = 0; mes < meses; mes++) {
            for (int dia = 0; dia < dias; dia++) {
                switch (estados.get(control.diasTranscurridos(dia+1, mes+1)).getTipo()) {
                    case ESTADO_1:
                        cantidades[0]++;
                        break;
                    case ESTADO_2:
                        cantidades[1]++;
                        break;
                    case ESTADO_3:
                        cantidades[2]++;
                        break;
                    case ESTADO_4:
                        cantidades[3]++;
                        break;
                    case ESTADO_5:
                        cantidades[4]++;
                        break;
                }
            }
            this.estadisticasMensuales[mes][0] = cantidades[0];
            this.estadisticasMensuales[mes][1] = cantidades[1];
            this.estadisticasMensuales[mes][2] = cantidades[2];
            this.estadisticasMensuales[mes][3] = cantidades[3];
            this.estadisticasMensuales[mes][4] = cantidades[4];
            
            cantidades[0] = 0;
            cantidades[1] = 0;
            cantidades[2] = 0;
            cantidades[3] = 0;
            cantidades[4] = 0;
        }
        return this.estadisticasMensuales;
    }

    public int[][] getEstadisticasMensuales() {
        return estadisticasMensuales;
    }

    public void setEstadisticasMensuales(int[][] estadisticasMensuales) {
        this.estadisticasMensuales = estadisticasMensuales;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", contrasenha=" + contrasenha + ", numIdentificador=" + numIdentificador + ", fechaDeInicio=" + fechaDeInicio + '}';
    }

}
