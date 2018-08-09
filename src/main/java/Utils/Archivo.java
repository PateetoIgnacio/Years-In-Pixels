package Utils;

import java.io.File;

public class Archivo implements java.io.Serializable{

    private String RUTA;
    private String IDENTIFICADOR;
    private String USUARIO;
    private String N0MBRE;
    private File file;

    public Archivo(String identificador, String usuario, TipoDeArchivo tipo) {
        switch (tipo) {
            case CALENDARIO:
                this.N0MBRE = "calendario";
                break;
            case COLORES_DE_OPCIONES:
                this.N0MBRE = "colores";
                break;
            case CONTRASENHA:
                this.N0MBRE = "contraseña";
                break;
        }
        this.IDENTIFICADOR = identificador;
        this.USUARIO = usuario;
        this.RUTA = "data" + "/" + this.IDENTIFICADOR + "/" + this.USUARIO + "/" + this.N0MBRE + ".bin";
        this.file = new File(this.RUTA);
    }

    public Archivo(String identificador, String nombre){
        this.USUARIO = "";
        this.IDENTIFICADOR = identificador;
        this.N0MBRE = nombre;
        this.RUTA = "data/" + this.IDENTIFICADOR + "/" + this.N0MBRE + ".bin";
        this.file = new File(this.RUTA);
    }

    public File getFile() {
        return file;
    }

}
