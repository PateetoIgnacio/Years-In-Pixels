package Utils;

import Logica.EstadoDeAnimo;
import Logica.Usuario;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ManejoDeArchivos {

    /**
     * Guarda el ArrayList de estados de animo en el archivo que recibe.
     *
     * @param estados
     * @param archivo
     */
    public void guardarEstados(ArrayList<EstadoDeAnimo> estados, Archivo archivo) {

        try {
            File f = archivo.getFile();
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);

            for (EstadoDeAnimo estado : estados) {
                oo.writeObject(estado);
            }
          

        } catch (IOException e) {
            e.getMessage();
        }

    }

    /**
     * A partir de una archivo .bin el cual se recibe se cargan los datos al
     * ArrayList.
     *
     * @param archivo
     * @return
     */
    public ArrayList<EstadoDeAnimo> recuperarEstados(Archivo archivo) {

        ArrayList<EstadoDeAnimo> estados = new ArrayList<>();

        try {
            File f1 = archivo.getFile();
            FileInputStream fo1 = new FileInputStream(f1);
            ObjectInputStream oo1 = new ObjectInputStream(fo1);

            // Se lee el primer objeto
            Object aux = oo1.readObject();

            // Mientras haya objetos
            while (aux != null) {
                if (aux instanceof EstadoDeAnimo) {
                    EstadoDeAnimo estado = (EstadoDeAnimo) aux;
                    estados.add(estado);
                }
                aux = oo1.readObject();
            }

            // ois.close();
        } catch (EOFException e1) {
            System.out.println("Fin de fichero");
        } catch (IOException | ClassNotFoundException e2) {
            e2.getMessage();
        }

        return estados;
    }

    /**
     * Guarda el ArrayList de usuario que recibe en el archivo que recibe.
     *
     * @param usuarios
     * @param archivo
     */
    public void almacenarUsuarios(ArrayList<Usuario> usuarios, Archivo archivo) {

        try {
            File f = archivo.getFile();
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);

            for (Usuario usuario : usuarios) {
                oo.writeObject((Object)usuario);
            }
            fo.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
      
    public ArrayList<Usuario> recuperarInfoUsuarios(Archivo archivo) {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            File f1 = archivo.getFile();
            FileInputStream fo1 = new FileInputStream(f1);
            ObjectInputStream oo1 = new ObjectInputStream(fo1);

            // Se lee el primer objeto
            Object aux = oo1.readObject();

            // Mientras haya objetos
            while (aux != null) {
                if (aux instanceof Usuario) {
                    Usuario usuario = (Usuario) aux;
                    usuarios.add(usuario);
                }
                aux = oo1.readObject();
            }
            // ois.close();
        } catch (EOFException e1) {
            System.out.println("Fin de fichero");
        } catch (IOException | ClassNotFoundException e2) {
            e2.getMessage();
        }

        return usuarios;
    }

}
