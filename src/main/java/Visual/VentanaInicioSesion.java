package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.jdesktop.swingx.prompt.PromptSupport;

public class VentanaInicioSesion extends JFrame implements ActionListener{
    
    JLabel fondoLbl;
    JLabel usuarioLbl;
    JButton btnSalir;
    private JPasswordField contrasenia;
    private JTextField usuario;
    JButton btnAgregarUsuario;
    JButton btnIngresar;
    
    
    public VentanaInicioSesion(){
        initComponents();
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        
        this.btnSalir = new JButton();
        this.usuarioLbl = new JLabel();
        this.usuario = new JTextField();
        this.contrasenia = new JPasswordField();
        this.btnAgregarUsuario = new JButton();
        this.btnIngresar = new JButton();
        this.fondoLbl = new JLabel();
        
        
        //Configuraciones del frame
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        getContentPane().setLayout(null);
        
        //Configuracion de la imagen usuario
        this.usuarioLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario.png")));
        this.usuarioLbl.setBounds(225, 150, 260, 270);
        getContentPane().add(this.usuarioLbl);
        
        //Configuracion campo de texto usuario
        PromptSupport.setPrompt("Usuario", this.usuario);
        this.usuario.setFont(new Font("Courier New", 0, 16));
        this.usuario.setBounds(195, 470, 320, 40);
        getContentPane().add(this.usuario);
        
        //Configuracion campo de contraseña
        PromptSupport.setPrompt("Contraseña", this.contrasenia);
        this.contrasenia.setFont(new Font("Courier New", 0, 16));
        this.contrasenia.setBounds(195, 540, 320, 40);
        getContentPane().add(this.contrasenia);
        
        //Configuración botón agregar usuario
        this.btnAgregarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mas.png"))); // NOI18N
        this.btnAgregarUsuario.setBorder(null);
        this.btnAgregarUsuario.setContentAreaFilled(false);
        this.btnAgregarUsuario.addActionListener(this);
        this.btnAgregarUsuario.setBounds(300, 590, 50, 40);
        getContentPane().add(btnAgregarUsuario);
        
        //Configuración ingresar con usuario especificado
        this.btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login.png"))); // NOI18N
        this.btnIngresar.setBorder(null);
        this.btnIngresar.setContentAreaFilled(false);
        this.btnIngresar.addActionListener(this);
        getContentPane().add(this.btnIngresar);
        this.btnIngresar.setBounds(390, 590, 50, 40);
        
        //Configuraciones del boton salir
        this.btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png")));
        this.btnSalir.setBorder(null);
        this.btnSalir.setBorderPainted(false);
        this.btnSalir.setContentAreaFilled(false);
        this.btnSalir.addActionListener(this);
        this.btnSalir.setBounds(610, 10, 90, 70);
        getContentPane().add(this.btnSalir);
        
        
        //Configuraciones del label fondo
        this.fondoLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mt-rainier-with-powerlines-prints-678.jpg")));
        this.fondoLbl.setBounds(0, 0, 700, 700);
        getContentPane().add(this.fondoLbl);
        
        this.setVisible(true);
        
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.btnSalir == e.getSource()){
            System.exit(0);
        }
        
    }
    
}
