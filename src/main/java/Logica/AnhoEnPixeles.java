package Logica;

import Utils.Archivo;
import Utils.ManejoDeArchivos;
import Utils.TipoDeArchivo;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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

    private Boolean usuarioEsNuevo;

    public AnhoEnPixeles(Usuario usuario) {
        this.controlador = new ControladorDeFecha();
        this.registroEstados = new ArrayList<>();
        this.detalles = new ArrayList<>();
        this.manejoArchivos = new ManejoDeArchivos();
        this.usuarios = new ArrayList<>();
        this.diasTranscurridos = controlador.diasTranscurridos(controlador.getFechaActual());

        inicializarArrayUsuario(usuario);
        inicializarOpciones();
        inicializarArrayCalendario(usuario);
        this.usuarios.get(this.idUsuario).setEstadisticasMensuales(usuario.actualizarEstadisticas(this.registroEstados, this.DIAS_DEL_MES, this.MESES_DEL_ANHO));
        this.manejoArchivos.almacenarUsuarios(this.usuarios, new Archivo("respaldos", "info"));

    }

    /**
     * Inicializa el ArrayList que contiene los datos de los usuarios, evalua si
     * el usuario esta o no registrado para ejecutar una u otra cosa.
     *
     * @param usuario
     */
    private void inicializarArrayUsuario(Usuario usuario) {

        Usuario random1 = new Usuario("random1", "random1");
        Usuario random2 = new Usuario("random2", "random2");

        //cargamos los datos de los usuarios
        this.usuarios = this.manejoArchivos.recuperarInfoUsuarios(new Archivo("respaldos", "info"));

        //si el usuario no estaba registrado, lo ingreso al array
        if (!usuarioSeEncuentra(usuario)) {
            //le asigno un identificador el cual usamos para hacerle referencia
            usuario.setNumIdentificador(this.usuarios.size());
            //guardamos la fecha de comienzo
            usuario.setFechaDeInicio(this.controlador.getFechaActual());

            if (!usuario.compararUsuarios(random1) && !usuario.compararUsuarios(random2)) {
                //inicializamos las estadisticas con datos cero.
                usuario.inicializarEstadisticasHastaElMes(this.MESES_DEL_ANHO, this.CANTIDAD_DE_ESTADOS);
                System.out.println("se crearon puros datos ceros!!");
            }

            //asignamos la identificacion del usuario con el cual se trabajara
            this.idUsuario = usuario.getNumIdentificador();
            //se agrega en el array los datos del nuevo usuario
            this.usuarios.add(usuario);
            this.manejoArchivos.almacenarUsuarios(this.usuarios, new Archivo("respaldos", "info"));
            this.usuarioEsNuevo = true;
        } else {
            this.usuarioEsNuevo = false;
            this.usuarios = this.manejoArchivos.recuperarInfoUsuarios(new Archivo("respaldos", "info"));
        }
        this.usuarios.forEach(x -> System.out.println(x.toString()));
        System.out.println("numero de meses transcurridos: " + this);
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
        this.detalles = this.manejoArchivos.recuperarEstados(archivo);
        if (!archivoExiste(archivo)) {
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_1, Color.yellow));
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_2, Color.green));
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_3, Color.orange));
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_4, Color.red));
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_5, Color.blue));
            this.detalles.add(new EstadoDeAnimo());
            this.manejoArchivos.guardarEstados(this.detalles, archivo);
        } else {
            this.detalles = this.manejoArchivos.recuperarEstados(archivo);
        }

    }

    private void inicializarArrayCalendario(Usuario usuario) {
        Archivo archivoAux = this.usuarios.get(this.idUsuario).getArchivo(TipoDeArchivo.CALENDARIO);
        if (!archivoExiste(archivoAux)) {
            if (usuario.getNombreUsuario().equalsIgnoreCase("random1")) {
                establecerParametrosRandom();
                this.mesesTranscurridos = this.MESES_DEL_ANHO;
            } else if (usuario.getNombreUsuario().equalsIgnoreCase("random2")) {
                establecerParametrosRandomALaFecha();
                this.mesesTranscurridos = (int) this.diasTranscurridos / this.DIAS_DEL_MES;
            } else {
                establecerParametrosDeCalendario();
                this.mesesTranscurridos = (int) this.diasTranscurridos / this.DIAS_DEL_MES;
            }
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
        Date aux = this.controlador.getFechaActual();
        
        int posicion = 0, opcion;
        for (int dia = 0; dia < this.DIAS_DEL_MES; dia++) {
            for (int mes = 0; mes < this.MESES_DEL_ANHO; mes++) {
                if (posicion <= this.controlador.diasTranscurridos(aux)) {
                    opcion = random.nextInt(6);
                    this.registroEstados.add(posicion, this.detalles.get(opcion));
                } else {
                    this.registroEstados.add(posicion, this.detalles.get(5));
                }
                posicion++;
            }
        }
    }

    public void reasigarColoresDeEstados(Color colores[]) {
        for (int indice = 0; indice < colores.length; indice++) {
            this.detalles.get(indice).setColor(colores[indice]);
        }
    }

    public void actualizarCambioEnEstado(EstadoDeAnimo estado, int posicion) {
        this.registroEstados.get(posicion).setCambio(estado);
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

    public EstadoDeAnimo getDetalleEstado(int indice) {
        return this.detalles.get(indice);
    }

    public ControladorDeFecha getControlador() {
        return this.controlador;
    }

    public ArrayList<EstadoDeAnimo> getDetalles() {
        return detalles;
    }

    public EstadoDeAnimo getEstadoEnLaFecha(int dia, int mes) {
        int transcurrido = calcularDiferencia(dia, mes);
        return this.registroEstados.get(transcurrido);
    }

    public int getMesesTranscurridos() {
        return this.mesesTranscurridos;
    }

    public boolean getUsuarioEsNuevo() {
        return this.usuarioEsNuevo;
    }

    public Usuario getUsuarioDeLaLista(int posicion) {
        return this.usuarios.get(posicion);
    }

    public int getIndiceUsuarioRepresentado() {
        return this.idUsuario;
    }    

}
