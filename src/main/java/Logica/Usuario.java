
package Logica;

import Utils.Archivo;
import Utils.TipoDeArchivo;
import java.util.Objects;

public class Usuario {
    
    private String nombreUsuario;
    private String contrasenha;
    private int numIdentificador;
    private Archivo archivos [];

    public Usuario(String nombreUsuario, String contrasenha) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenha;
        this.numIdentificador = 0;
        this.archivos = new Archivo[3];
        
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
    
    
    public Archivo getArchivo(TipoDeArchivo tipo){
        Archivo archivo = null;
        switch(tipo){
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

    public boolean compararUsuarios(Object obj){
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

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", contrasenha=" + contrasenha + ", numIdentificador=" + numIdentificador + '}';
    }
    
}