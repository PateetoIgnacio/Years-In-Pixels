package Logica;

import Utils.Archivo;
import Utils.ManejoDeArchivos;
import Utils.TipoDeArchivo;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnhoEnPixeles {

    private final int MESES_DEL_ANHO = 12;
    private final int DIAS_DEL_MES = 31;
    private final int CANTIDAD_DE_ESTADOS = 5;

    private EstadoDeAnimo[] detallesDeLosEstados;
    private ControladorDeFecha controlador;
    private ArrayList<EstadoDeAnimo> registroEstados;
    private ArrayList<EstadoDeAnimo> detalles;
    private ManejoDeArchivos manejoArchivos;
    private List<Usuario> usuarios;
    private int idUsuario;

    public AnhoEnPixeles(Usuario usuario) {
        this.detallesDeLosEstados = new EstadoDeAnimo[this.CANTIDAD_DE_ESTADOS + 1]; //se considera el estado que no esta especificado
        this.controlador = new ControladorDeFecha();
        this.manejoArchivos = new ManejoDeArchivos();
        this.registroEstados = new ArrayList<>();
        this.detalles = new ArrayList<>();
        this.usuarios = new ArrayList<>();

        inicializarArrayUsuario(usuario);
        inicializarOpciones();
        inicializarArrayCalendario();

    }

    private void inicializarOpciones() {
        Archivo archivoAux = this.usuarios.get(this.idUsuario).getArchivo(TipoDeArchivo.COLORES_DE_OPCIONES);
        if (!archivoExiste(archivoAux)) {
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_1, Color.yellow));
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_2, Color.green));
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_3, Color.blue));
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_4, Color.orange));
            this.detalles.add(new EstadoDeAnimo(TipoDeEstado.ESTADO_5, Color.red));
            this.detalles.add(new EstadoDeAnimo());
            this.manejoArchivos.cargarEstados(this.detalles, archivoAux);
        } else {
            this.detalles = this.manejoArchivos.recuperarEstados(archivoAux);
        }
        this.registroEstados.forEach(n -> System.out.println(n.toString()));

    }

    
    private void establecerParametrosIniciales() {
        int posicion = 0;
        for (int dia = 0; dia < this.DIAS_DEL_MES; dia++) {
            for (int mes = 0; mes < this.MESES_DEL_ANHO; mes++) {
                if (this.controlador.validarFechaPasada(dia + 1, mes + 1)) {
                    this.registroEstados.add(posicion, this.detallesDeLosEstados[5]);
                } else if (this.controlador.validarFechaFutura(dia + 1, mes + 1)) {
                    this.registroEstados.add(posicion, this.detallesDeLosEstados[5]);
                } else {
                    this.registroEstados.add(posicion, this.detallesDeLosEstados[5]);
                }
                posicion++;
            }
        }
    }
     
    private void inicializarArrayCalendario() {
        Archivo archivoAux = this.usuarios.get(this.idUsuario).getArchivo(TipoDeArchivo.CALENDARIO);
        if (!archivoExiste(archivoAux)) {
            //establecerParametrosIniciales();
            establecerParametrosRandom();
            this.manejoArchivos.cargarEstados(this.registroEstados, archivoAux);
            //this.registroEstados.forEach(n -> System.out.println(n.toString()));

        } else {
            this.registroEstados = this.manejoArchivos.recuperarEstados(archivoAux);
            //this.registroEstados.forEach(n -> System.out.println(n.toString()));
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
        return this.detallesDeLosEstados;
    }

    public EstadoDeAnimo getEstado(int indice) {
        return this.detalles.get(this.idUsuario);
    }

    public ControladorDeFecha getControlador() {
        return this.controlador;
    }

    public EstadoDeAnimo getEstadoEnLaFecha(int dia, int mes) {
        int diasTranscurridos = calcularDiferencia(dia, mes);
        return this.registroEstados.get(diasTranscurridos);
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

    private void inicializarArrayUsuario(Usuario usuario) {
        //Usuario prueba = new Usuario("usuario", "contraseña");
        //this.usuarios.add(prueba);

        //si el usuario no estaba registrado, lo ingreso al array
        if (!usuarioSeEncuentra(usuario)) {
            //le asigno un identificador el cual usamos para hacerle referencia
            usuario.setNumIdentificador(this.usuarios.size());
            //se agrega en el array
            this.usuarios.add(usuario);
            //asignamos la identificacion del usuario con el cual se trabajara
            this.idUsuario = usuario.getNumIdentificador();
        } else {

            //falta programar!!!
            System.out.println("el usuario se encontraba!");
        }

        this.usuarios.forEach(x -> System.out.println(x.toString()));

    }

}
