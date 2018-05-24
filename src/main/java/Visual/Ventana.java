package Visual;

import Logica.AnhoEnPixeles;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private final int MEDIDA_EN_X = 600; //Width
    private final int MEDIDA_EN_Y = 700; //Height

    private AnhoEnPixeles anhoEnPixeles = new AnhoEnPixeles();
    private PanelActualizarEstado panelActualizarEstado;
    private PanelPixeles panelPixeles;
    private PanelGrafico panelGrafico;
    private PanelConfiguracion panelConfiguracion;

    public Ventana() {
        initComponents();
    }

    private void initComponents() {

        //Creamos el conjunto de pestañas
        JTabbedPane pestañas = new JTabbedPane();

        //Creamos el panel ActualizarEstado y se adiciona al conjunto
        this.panelActualizarEstado = new PanelActualizarEstado(this);
        this.panelActualizarEstado.setBackground(Color.WHITE);
        pestañas.addTab("Día", this.panelActualizarEstado);
        
        //Creamos el panel que representa el Calendario y se adiona al conjunto
        this.panelPixeles = new PanelPixeles(this);
        this.panelPixeles.setBackground(Color.WHITE);
        pestañas.addTab("Calendario", this.panelPixeles);
        
        //Creamos el panel de Grafico y se adiciona al conjunto
        this.panelGrafico = new PanelGrafico();
        this.panelGrafico.setBackground(Color.WHITE);
        pestañas.addTab("Gráfico", this.panelGrafico);
        
        //Creamos el panel de Configuraciones y se adiciona al conjunto
        this.panelConfiguracion = new PanelConfiguracion(this);
        this.panelConfiguracion.setBackground(Color.WHITE);
        pestañas.addTab("Configuración", this.panelConfiguracion);
        
        //Se agrega el conjunto de pestañas al frame
        getContentPane().add(pestañas);

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
