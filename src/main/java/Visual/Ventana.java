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

    private Probando probando = new Probando(this);

    public Ventana() {
        initComponents();
    }

    private void initComponents() {

        //Creamos el conjunto de pestañas
        JTabbedPane pestañas = new JTabbedPane();

        //Creamos el panel ActualizarEstado
        this.panelActualizarEstado = new PanelActualizarEstado(this);
        pestañas.addTab("Día", this.panelActualizarEstado);

        this.panelPixeles = new PanelPixeles();
        this.panelPixeles.setBackground(Color.BLACK);
        pestañas.addTab("Calendario", this.panelPixeles);
        
        this.panelGrafico = new PanelGrafico();
        this.panelGrafico.setBackground(Color.red);
        pestañas.addTab("Gráfico", this.panelGrafico);

        this.panelConfiguracion = new PanelConfiguracion(this);
        this.panelConfiguracion.setBackground(Color.LIGHT_GRAY);
        pestañas.addTab("Configuracion", this.panelConfiguracion);
        
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
