package Visual;

import Logica.EstadoDeAnimo;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelActualizarEstado extends JPanel {

    private final int TAMANHO_BOTON = 50;
    private JButton[] botonesDeColor;
    private JButton btnOpcionAunNo;
    private JButton btnOpcionGuardar;
    private JLabel labelTitulo;

    public PanelActualizarEstado(Ventana ventana) {
        this.botonesDeColor = new JButton[ventana.getAnhoEnPixeles().getCANTIDAD_DE_ESTADOS()];
        initComponents(ventana);
    }

    private void initComponents(Ventana ventana) {

        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        this.labelTitulo = initTitulo();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 100;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 0;
        this.add(this.labelTitulo, c);

        JLabel label = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 100;
        c.ipady = 50;
        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 1;
        this.add(label, c);

        JButton boton = new JButton("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 100;
        c.ipady = 50;
        c.weightx = 1.0;
        c.gridx = 1;
        c.gridy = 1;
        this.add(boton, c);

        boton = new JButton("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 100;
        c.ipady = 50;
        c.weightx = 1.0;
        c.gridx = 2;
        c.gridy = 1;
        this.add(boton, c);

        label = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 100;
        c.ipady = 50;
        c.weightx = 1.0;
        c.gridx = 3;
        c.gridy = 1;
        this.add(label, c);

        initBottonsInferiores();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 1;   //2 columns wide
        c.gridy = 2;       //third row
        this.add(this.btnOpcionAunNo, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 3.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 2;       //aligned with button 2
        c.gridwidth = 1;   //2 columns wide
        c.gridy = 2;       //third row
        this.add(this.btnOpcionGuardar, c);
        /*        
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
        this.add(boton);*/
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

    private JLabel initTitulo() {
        String titulo = "¿Cómo estuviste hoy?";
        JLabel label = new JLabel(titulo);
        return label;
    }

    private JButton crearBoton(EstadoDeAnimo[] estados, int indice) {
        JButton boton = new JButton();
        boton.setBackground(estados[indice].getColorRepresentacion());
        boton.setPreferredSize(new Dimension(this.TAMANHO_BOTON, this.TAMANHO_BOTON));
        return boton;

    }

    private void initBottonsInferiores() {
        String texto1 = "Aún no";
        String texto2 = "Guardar mi día";
        this.btnOpcionAunNo = new JButton(texto1);
        this.btnOpcionGuardar = new JButton(texto2);

    }

    private void setListener(JButton boton, int i) {
        boton.addActionListener(
                (ActionEvent e) -> {
                    System.out.println("Presionaste el boton " + (i + 1));
                }
        );
    }

    private JLabel crearLabel(int opcion) {
        JLabel label = new JLabel();
        String texto = "";
        switch (opcion) {
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
