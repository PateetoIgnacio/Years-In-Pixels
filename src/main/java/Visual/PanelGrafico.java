package Visual;

import java.util.Random;
import javax.swing.JPanel;

public class PanelGrafico extends JPanel{
    
    private int registro [][] = new int [12][31];
    private int datosMensuales [][] = new int [12][5];
    
    public PanelGrafico(){
        crearMatriz();
        mostrarMatriz(this.registro, 12, 31);
        
        crearMatrizMensual();
        mostrarMatriz(this.datosMensuales, 12, 5);
 
    }

    private void crearMatriz() {
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 31; j++) {
                this.registro[i][j] = random.nextInt(6 - 1)+1;
            }
        }
    }

    private void crearMatrizMensual() {
        int suma1, suma2, suma3, suma4, suma5;
        for (int i = 0; i < 12; i++) {
            suma1 = 0; suma2 = 0; suma3 = 0; suma4 = 0; suma5 = 0;
            for (int j = 0; j < 31; j++) {
                switch(this.registro[i][j]){
                    case 1:
                        suma1++; break;
                    case 2:
                        suma2++; break;
                    case 3:
                        suma3++; break;
                    case 4:
                        suma4++; break;
                    default:
                        suma5++; break;
                            
                }
            }
            this.datosMensuales[i][0] = suma1;
            this.datosMensuales[i][1] = suma2;
            this.datosMensuales[i][2] = suma3;
            this.datosMensuales[i][3] = suma4;
            this.datosMensuales[i][4] = suma5;
        }
    }

    private void mostrarMatriz(int[][] registro, int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("\t" + registro[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("\n\n\n");
    }

}