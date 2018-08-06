package Logica;

import Utils.Archivo;
import Utils.ManejoDeArchivos;
import Utils.TipoDeArchivo;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class AnhoEnPixeles {

    private final int CANTIDAD_DE_RESPALDOS = 3;
    private final int MESES_DEL_ANHO = 12;
    private final int DIAS_DEL_MES = 31;
    private final int CANTIDAD_DE_ESTADOS = 5;

    private EstadoDeAnimo[] opcionesDeEstados;
    private EstadoDeAnimo[][] calendarioDeEstados;

    private ArrayList<EstadoDeAnimo> calendarioEstados;
    private ArrayList<EstadoDeAnimo> calendarioPrueba;

    private ControladorDeFecha controlador;

    private ManejoDeArchivos manejoArchivos;
    private Archivo[] listaDeArchivos;

    public AnhoEnPixeles() {
        this.opcionesDeEstados = new EstadoDeAnimo[this.CANTIDAD_DE_ESTADOS + 1]; //se considera el estado que no esta especificado
        this.controlador = new ControladorDeFecha();
        this.listaDeArchivos = new Archivo[this.CANTIDAD_DE_RESPALDOS];
        this.manejoArchivos = new ManejoDeArchivos();

        this.calendarioDeEstados = new EstadoDeAnimo[this.DIAS_DEL_MES][this.MESES_DEL_ANHO];
        this.calendarioEstados = new ArrayList<>();

        this.calendarioPrueba = new ArrayList<>();
        inicializarOpciones();
        inicializarArchivos();

        inicializarFinal();

    }

    private void inicializarOpciones() {
        this.opcionesDeEstados[0] = new EstadoDeAnimo(TipoDeEstado.ESTADO_1, Color.yellow);
        this.opcionesDeEstados[1] = new EstadoDeAnimo(TipoDeEstado.ESTADO_2, Color.green);
        this.opcionesDeEstados[2] = new EstadoDeAnimo(TipoDeEstado.ESTADO_3, Color.blue);
        this.opcionesDeEstados[3] = new EstadoDeAnimo(TipoDeEstado.ESTADO_4, Color.orange);
        this.opcionesDeEstados[4] = new EstadoDeAnimo(TipoDeEstado.ESTADO_5, Color.red);
        this.opcionesDeEstados[5] = new EstadoDeAnimo(TipoDeEstado.SIN_ESPECIFICAR, Color.white);
    }

    /*
    private void inicializarCalendario() {

        for (int dia = 0; dia < this.DIAS_DEL_MES; dia++) {
            for (int mes = 0; mes < this.MESES_DEL_ANHO; mes++) {
                //si son fechas futuras
                if (this.controlador.validarFechaPasada(dia + 1, mes + 1)) {
                    ingresarEstado(dia, mes, 5); //el cinco correspone al estado sin especificar dentro del arreglo de opciones

                } //si son fechas que ya pasaron, pero se sale del rango de cambios
                else if (this.controlador.validarFechaFutura(dia + 6, mes + 1)) {
                    ingresarEstado(dia, mes, 5);

                } //si en los dias es posible hacer cambios
                else {
                    ingresarEstado(dia, mes, 0);

                }
            }
        }
    }

    public void ingresarEstado(int dia, int mes, int indice) {
        this.calendarioDeEstados[dia][mes] = this.opcionesDeEstados[indice];
    }
     */
    private void establecerParametrosIniciales() {
        int posicion = 0;
        for (int dia = 0; dia < this.DIAS_DEL_MES; dia++) {
            for (int mes = 0; mes < this.MESES_DEL_ANHO; mes++) {
                if (this.controlador.validarFechaPasada(dia + 1, mes + 1)) {
                    this.calendarioEstados.add(posicion, this.opcionesDeEstados[2]);
                } else if (this.controlador.validarFechaFutura(dia + 1, mes + 1)) {
                    this.calendarioEstados.add(posicion, this.opcionesDeEstados[1]);
                } else {
                    this.calendarioEstados.add(posicion, this.opcionesDeEstados[5]);
                }
                posicion++;
            }
        }
    }

    private void inicializarArchivos() {
        this.listaDeArchivos[0] = new Archivo("usuarios", "jaime", TipoDeArchivo.CALENDARIO);
        this.listaDeArchivos[1] = new Archivo("usuarios", "user", TipoDeArchivo.COLORES_DE_OPCIONES);
        this.listaDeArchivos[2] = new Archivo("usuarios", "user_prueba", TipoDeArchivo.CALENDARIO);
    }

    public Archivo obtenerArchivo(int indicador) {
        return this.listaDeArchivos[indicador];
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

    public EstadoDeAnimo getEstado(int indice) {
        return this.opcionesDeEstados[indice];
    }

    public ControladorDeFecha getControlador() {
        return this.controlador;
    }

    public EstadoDeAnimo getEstadoEnLaFecha(int dia, int mes) {
        int diasTranscurridos = calcularDiferencia(dia, mes);
        return this.calendarioEstados.get(diasTranscurridos);
    }

    private void inicializarFinal() {
        if (!carpetaExiste(this.listaDeArchivos[2])) {
            establecerParametrosIniciales();
            //establecerParametrosRandom();
            this.manejoArchivos.cargarCalendario(this.calendarioEstados, obtenerArchivo(2));
            //this.calendarioEstados.forEach(n -> System.out.println(n.toString()));
        } else {
            this.calendarioEstados = this.manejoArchivos.recuperarCalendario(obtenerArchivo(2));
            //this.calendarioEstados.forEach(n -> System.out.println(n.toString()));
        }
    }

    private boolean carpetaExiste(Archivo archivo) {
        File file = archivo.getFile();
        return file.exists();
    }

    private int calcularDiferencia(int dia, int mes) {
        return this.controlador.diasTranscurridos(dia, mes);
    }

    public int cantidadDeElementos() {
        return this.calendarioEstados.size();
    }

    private void establecerParametrosRandom() {
        Random random = new Random();
        int posicion = 0, opcion;
        for (int dia = 0; dia < this.DIAS_DEL_MES; dia++) {
            for (int mes = 0; mes < this.MESES_DEL_ANHO; mes++) {
                opcion = random.nextInt(6);
                    this.calendarioEstados.add(posicion, opcionesDeEstados[opcion]);
                posicion++;
            }
        }
    }

}
