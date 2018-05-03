package Visual;

import Logica.EstadoDeAnimo;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelActualizarEstado extends JPanel{
    private final int TAMANHO_BOTON = 50;
    private final int filas = 5;
    private final int columnas = 2;
    private JButton [] botonesDeColor;
    private JButton btnOpcionAunNo;
    private JButton btnOpcionGuardar;
    private JLabel labelTitulo;

    public PanelActualizarEstado(Ventana ventana){
        this.botonesDeColor = new JButton[ventana.getAnhoEnPixeles().getCANTIDAD_DE_ESTADOS()];
        initComponents(ventana);
    }
    private void initComponents(Ventana ventana){

        JPanel panelGeneral = new JPanel();
        panelGeneral.setOpaque(true);
        Dimension dimGeneral = new Dimension(700, 700);
        panelGeneral.setPreferredSize(dimGeneral);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setPreferredSize(new Dimension((int) dimGeneral.getWidth(), (int) dimGeneral.getHeight()/10));
        panelSuperior.setBackground(Color.CYAN);
        initTitulo();
        panelSuperior.add(this.labelTitulo, BorderLayout.CENTER);
        panelGeneral.add(panelSuperior);

        JPanel panelLateralIzquierdo = new JPanel();
        panelLateralIzquierdo.setPreferredSize(new Dimension(50, 400));
        panelLateralIzquierdo.setBackground(Color.CYAN);
        panelGeneral.add(panelLateralIzquierdo, BorderLayout.EAST);

        JPanel panelCentral = new JPanel();
        Dimension dimCentro = new Dimension(500, 400);
        panelCentral.setPreferredSize(dimCentro);
        panelCentral.setBackground(Color.CYAN);

        /*
        for (int opcion = 0; opcion < this.filas; opcion++){
            for (int elemento = 0; elemento < this.columnas; elemento++){
                if(elemento == 0){
                    this.botonesDeColor[opcion] = crearBoton(ventana.getAnhoEnPixeles().getEstados(), opcion);
                    setListener(botonesDeColor[opcion], opcion);
                    this.botonesDeColor[opcion].setLocation((int) dimCentro.getWidth(), (int) dimCentro.getHeight()*(opcion + 1));
                    panelCentral.add(this.botonesDeColor[opcion]);
                }
                else{
                    JLabel label = crearLabel(opcion);
                    panelCentral.add(label);
                }
            }
        }
        */
        panelGeneral.add(panelCentral, BorderLayout.CENTER);

        JPanel panelLateralDerecho = new JPanel();
        panelLateralDerecho.setPreferredSize(new Dimension(50, 400));
        panelLateralDerecho.setBackground(Color.CYAN);
        panelGeneral.add(panelLateralDerecho, BorderLayout.WEST);

        JPanel panelInferior = new JPanel();
        panelInferior.setPreferredSize(new Dimension(700, 100));
        panelInferior.setBackground(Color.CYAN);
        initBottonsInferiores();
        panelInferior.setLayout(new FlowLayout());
        panelInferior.add(this.btnOpcionAunNo);
        panelInferior.add(this.btnOpcionGuardar);
        panelSuperior.add(this.labelTitulo, BorderLayout.SOUTH);
        panelGeneral.add(panelInferior);

        this.add(panelGeneral);
    }

    private void initTitulo() {
        String titulo = "¿Cómo estuviste hoy?";
        this.labelTitulo = new JLabel(titulo);
    }

    private JButton crearBoton(EstadoDeAnimo [] estados, int indice){
        JButton boton = new JButton();
        boton.setBackground(estados[indice].getColorRepresentacion());
        boton.setPreferredSize(new Dimension(this.TAMANHO_BOTON, this.TAMANHO_BOTON));
        return boton;

    }
    private void initBottonsInferiores(){
        String opcion1 = "Aún no";
        String opcion2 = "Guardar mi día";
        this.btnOpcionAunNo = new JButton(opcion1);
        this.btnOpcionGuardar = new JButton(opcion2);

    }


    private void setListener(JButton boton, int i){
        boton.addActionListener(
                (ActionEvent e) -> {
                    System.out.println("Presionaste el boton " + (i+1));
                }
        );
    }

    private JLabel crearLabel(int opcion){
        JLabel label = new JLabel();
        String texto = "";
        switch (opcion){
            case 0:
                texto = "Vivo. activo. feliz. energético.\nmotivado. productivo";
                break;
            case 1:
                texto = "Sin eventos. promedio. normal";
                break;
            case 2:
                texto = "Enfermo. cansando. desmotivado.\naburrido. perezoso";
                break;
            case 3:
                texto = "Triste. solitario. deprimido.\ninseguro. deprimido";
                break;
            default:
                texto = "Enojado. frustrado. irritable.\nmolesto. gruñón";
                break;
        }
        label.setText(texto);
        return label;
    }
}
