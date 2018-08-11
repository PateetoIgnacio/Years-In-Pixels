package Visual;

import Logica.AnhoEnPixeles;
import Logica.Usuario;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private final int MEDIDA_EN_X = 500; //Width
    private final int MEDIDA_EN_Y = 700; //Height

    private AnhoEnPixeles anhoEnPixeles;
    private PanelActualizarEstado panelActualizarEstado;
    private PanelPixeles panelPixeles;
    private PanelOpcionesDeGrafico panelOpcionesDeGrafico;
    private PanelConfiguracion panelConfiguracion;

    public Ventana(Usuario usuario, VentanaInicioSesion inicio){
        initComponents(usuario);
    }

    private void initComponents(Usuario usuario) {
        
        this.anhoEnPixeles = new AnhoEnPixeles(usuario);
        
        //Creamos el conjunto de pestanhas
        JTabbedPane pestanhas = new JTabbedPane();
        
        //Creamos el panel ActualizarEstado y se adiciona al conjunto
        this.panelActualizarEstado = new PanelActualizarEstado(this);
        this.panelActualizarEstado.setBackground(Color.WHITE);
        pestanhas.addTab("Día", this.panelActualizarEstado);
        
        //Creamos el panel que representa el Calendario y se adiona al conjunto
        this.panelPixeles = new PanelPixeles(this);
        this.panelPixeles.setBackground(Color.WHITE);
        pestanhas.addTab("Calendario", this.panelPixeles);
        
        //Creamos el panel de Grafico y se adiciona al conjunto
        this.panelOpcionesDeGrafico = new PanelOpcionesDeGrafico(this);
        this.panelOpcionesDeGrafico.setBackground(Color.WHITE);
        pestanhas.addTab("Gráfico", this.panelOpcionesDeGrafico);
        
        //Creamos el panel de Configuraciones y se adiciona al conjunto
        this.panelConfiguracion = new PanelConfiguracion(this);
        this.panelConfiguracion.setBackground(Color.WHITE);
        pestanhas.addTab("Configuración", this.panelConfiguracion);
        
        //Se agrega el conjunto de pestanhas al frame
        getContentPane().add(pestanhas);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setTitle("Año en Pixeles");
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(this.MEDIDA_EN_X, this.MEDIDA_EN_Y));
        this.setResizable(false);
        this.setVisible(true);

    }

    public AnhoEnPixeles getAnhoEnPixeles() {
        return this.anhoEnPixeles;
    }
}
