package Visual;

import Logica.EstadoDeAnimo;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelActualizarEstado extends JPanel{
    private final int TAMANHO_BOTON = 50;
    private JButton [] botonesDeColor;
    private JButton btnOpcionAunNo;
    private JButton btnOpcionGuardar;
    private JLabel labelTitulo;

    public PanelActualizarEstado(Ventana ventana){
        this.botonesDeColor = new JButton[ventana.getAnhoEnPixeles().getCANTIDAD_DE_ESTADOS()];
        initComponents(ventana);
    }
    private void initComponents(Ventana ventana){
        
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        
        JButton boton = new JButton("1");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(boton, c);

        boton = new JButton("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        this.add(boton, c);
        
        boton = new JButton("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        this.add(boton, c);
        
        boton = new JButton("botoncito 4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;
        c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;
        this.add(boton, c);
        
        boton = new JButton("este es el de la esquina");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 3;
        this.add(boton);
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