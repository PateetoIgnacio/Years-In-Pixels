package Logica;

import Utils.Archivo;
import Utils.ManejoDeArchivos;
import Utils.TipoDeArchivo;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class AnhoEnPixeles {

    private final int MESES_DEL_ANHO = 12;
    private final int DIAS_DEL_MES = 31;
    private final int CANTIDAD_DE_ESTADOS = 5;

    private ControladorDeFecha controlador;
    private ArrayList<EstadoDeAnimo> registroEstados;
    private ArrayList<EstadoDeAnimo> detalles;
    private ManejoDeArchivos manejoArchivos;
    private ArrayList<Usuario> usuarios;
    private int idUsuario;
    private int diasTranscurridos;
    private int mesesTranscurridos;


    public AnhoEnPixeles(Usuario usuario) {
        this.controlador = new ControladorDeFecha();
        this.registroEstados = new ArrayList<>();
        this.detalles = new ArrayList<>();
        this.manejoArchivos = new ManejoDeArchivos();
        this.usuarios = new ArrayList<>();
        this.diasTranscurridos = controlador.diasTranscurridos(controlador.getFechaActual());
        inicializarArrayUsuario(usuario);
        inicializarOpciones();
        inicializarArrayCalendario();


    }

    /**
     * Inicializa el ArrayList que contiene los datos de los usuarios, evalua si
     * el usuario esta o no registrado para ejecutar una u otra cosa.
     *
     * @param usuario
     */
    private void inicializarArrayUsuario(Usuario usuario) {
        //si el usuario no estaba registrado, lo ingreso al array
        if (!usuarioSeEncuentra(usuario)) {
            //le asigno un identificador el cual usamos para hacerle referencia
            usuario.setNumIdentificador(this.usuarios.size());
            //se agrega en el array
            this.usuarios.add(usuario);
            //asignamos la identificacion del usuario con el cual se trabajara
            this.idUsuario = usuario.getNumIdentificador();
            this.manejoArchivos.almacenarUsuarios(this.usuarios, new Archivo("respaldos", "info"));
        } else {
            this.usuarios = this.manejoArchivos.recuperarInfoUsuarios(new Archivo("respaldos", "info"));
        }
    }

    private boolean usuarioSeEncuentra(Usuario usuario) {
        boolean usuarioSeEncuentra = false;
        for (Usuario usuarioAux : this.usuarios) {
            //evaluamos si el usuario recibido pertenece al array
            if (usuarioAux.compararUsuarios(usuario)) {
                usuarioSeEncuentra = true;
                //se guarda la posicion en la que se encontraba el usuario
                this.idUsuario = this.usuarios.indexOf(usuarioAux);
            }
        }
        return usuarioSeEncuentra;
    }

    /**
     * Crea el Array con los colores por defecto y de existir uno asigna desde
     * el archivo.
     */
    private void inicializarOpciones() {
        Archivo archivo = this.usuarios.get(this.idUsuario).getArchivo(TipoDeArchivo.COLORES_DE_OPCIONES);
        if (!archivoExiste(archivo)) {
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_1, Color.yellow));
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_2, Color.green));
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_3, Color.blue));
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_4, Color.orange));
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_5, Color.red));
            this.detalles.add(new EstadoDeAnimo());
            this.manejoArchivos.guardarEstados(this.detalles, archivo);
        } else {
            this.detalles = this.manejoArchivos.recuperarEstados(archivo);
        }

    }

    private void inicializarArrayCalendario() {
        Archivo archivoAux = this.usuarios.get(this.idUsuario).getArchivo(TipoDeArchivo.CALENDARIO);
        if (!archivoExiste(archivoAux)) {
            //establecerParametrosDeCalendario(); this.mesesTranscurridos = 0;
            //establecerParametrosRandom(); this.mesesTranscurridos = 12;
            establecerParametrosRandomALaFecha(); this.mesesTranscurridos = (int) this.diasTranscurridos / this.DIAS_DEL_MES;
            this.manejoArchivos.guardarEstados(this.registroEstados, archivoAux);
        } else {
            this.registroEstados = this.manejoArchivos.recuperarEstados(archivoAux);
        }

    }

    /**
     * establece los parametros de animos en el calendario para aquel usuario
     * que ingresa por primera vez.
     */
    private void establecerParametrosDeCalendario() {
        EstadoDeAnimo estadoInderminado = new EstadoDeAnimo();
        int posicion = 0;
        for (int dia = 0; dia < this.DIAS_DEL_MES; dia++) {
            for (int mes = 0; mes < this.MESES_DEL_ANHO; mes++) {
                this.registroEstados.add(estadoInderminado);
                posicion++;
            }
        }
    }

    private void establecerParametrosRandom() {
        Random random = new Random();
        int posicion = 0, opcion;
        for (int dia = 0; dia < this.DIAS_DEL_MES; dia++) {
            for (int mes = 0; mes < this.MESES_DEL_ANHO; mes++) {
                opcion = random.nextInt(6);
                this.registroEstados.add(posicion, detalles.get(opcion));
                posicion++;
            }
        }
    }

    private void establecerParametrosRandomALaFecha() {
        Random random = new Random();
        int posicion = 0, opcion;
        for (int mes = 0; mes < this.MESES_DEL_ANHO; mes++) {
            for (int dia = 0; dia < this.DIAS_DEL_MES; dia++) {
                if (this.controlador.validarFechaPasada(dia + 1, mes + 1)) {
                    opcion = random.nextInt(6);
                    this.registroEstados.add(posicion, detalles.get(opcion));
                } else {
                    this.registroEstados.add(posicion, detalles.get(5));
                }

                posicion++;
            }
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

    public ArrayList<EstadoDeAnimo> getOpcionesDeEstados() {
        return this.detalles;
    }

    public EstadoDeAnimo getEstado(int indice) {
        return this.detalles.get(indice);
    }

    public ControladorDeFecha getControlador() {
        return this.controlador;
    }

    public EstadoDeAnimo getEstadoEnLaFecha(int dia, int mes) {
        int transcurrido = calcularDiferencia(dia, mes);
        return this.registroEstados.get(transcurrido);
    }

    private boolean archivoExiste(Archivo archivo) {
        File file = archivo.getFile();
        return file.exists();
    }

    private int calcularDiferencia(int dia, int mes) {
        return this.controlador.diasTranscurridos(dia, mes);
    }

    public int cantidadDeElementos() {
        return this.registroEstados.size();
    }
    
    public int getMesesTranscurridos(){
        return this.mesesTranscurridos;
    }

}