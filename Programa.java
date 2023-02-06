import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public class Programa implements Runnable{ 

        JFrame f;
        Thread t = null;
        int horas = 0, minutos = 0, segundos = 0;
        String horaString = "";
        JLabel b;

        Programa(){
                f = new JFrame();
                
                t = new Thread(this);
                t.start();
                
                b = new JLabel();
                b.setBounds(160,85,200,150);                
                
                f.add(b);
                f.setSize(500,400);
                b.setFont(new Font("Arial", Font.PLAIN, 30)); 
                f.setLayout(null);
                f.setVisible(true);

                // Icono del programa 
                Image icono = Toolkit.getDefaultToolkit().getImage("D:/xampp/htdocs/xampp/nc/tutoriales/blog/primer-programa-java/logo.png");
                f.setIconImage(icono);
        }

        public void run() {
                try {
                        while (true) {

                                Calendar calendario = Calendar.getInstance();
                                horas = calendario.get( Calendar.HOUR_OF_DAY );

                                if ( horas > 12 ) horas -= 12;

                                minutos = calendario.get( Calendar.MINUTE );
                                segundos = calendario.get( Calendar.SECOND );

                                SimpleDateFormat formatear = new SimpleDateFormat("hh:mm:ss aa");
                                Date fecha = calendario.getTime();
                                horaString = formatear.format( fecha );

                                imprimirHora();

                                t.sleep( 1000 );  // intervalo en milimetros 

                        }
                }
                catch (Exception e) { }
        }

        public void imprimirHora(){
                b.setText(horaString);
        }

        public static void main(String[] args) {
                new Programa(); 
        }

}