package Utils;

import Logica.EstadoDeAnimo;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ManejoDeArchivos {

    public void almacenarObjetos(ArrayList<Object> objetos, Archivo archivo) {

        try {
            File f = archivo.getFile();
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);

            for (Object objeto : objetos) {
                oo.writeObject(objeto);
            }

        } catch (IOException e) {
            e.getMessage();
        }

    }

    public void cargarEstados(ArrayList<EstadoDeAnimo> estados, Archivo archivo) {

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

    public ArrayList<Object> recuperarObjetos(Archivo archivo) {

        ArrayList<Object> objetos = new ArrayList<>();

        try {
            File f1 = archivo.getFile();
            FileInputStream fo1 = new FileInputStream(f1);
            ObjectInputStream oo1 = new ObjectInputStream(fo1);

            // Se lee el primer objeto
            Object aux = oo1.readObject();

            // Mientras haya objetos
            while (aux != null) {
                aux = oo1.readObject();

            }
            // ois.close();
        } catch (EOFException e1) {
            System.out.println("Fin de fichero");
        } catch (IOException | ClassNotFoundException e2) {
            e2.getMessage();
        }

        return objetos;
    }

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
}
