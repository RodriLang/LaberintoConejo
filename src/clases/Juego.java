package clases;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
/**
 *
 * @author Rodri
 */
public class Juego extends JFrame implements ActionListener {

    //Declaracíon de los atributos
    //Laberinto
    private JLabel laberinto = new JLabel();//Se usará para contener una imagen del laberinto
    private JLabel conejo = new JLabel();//Será nuestro personaje
    private JLabel zanahoria = new JLabel();//Será un objeto a recolectar y se locarizará aleatoriamente
    private JLabel palanca = new JLabel();//Servirá para mostrar la imagen de la palanca encendida o apagada que activa el puente
    private JLabel puente = new JLabel();//Se colocará sobre el lago para poder cruzar
    private JLabel puerta = new JLabel();//Mostrará la imagen de la puerta abierta o cerrada al final del laberinto
    private JLabel llave = new JLabel();//Al conseguir la última zanahoria, se generará una llave que abrirá la puerta
    //
    //Datos y Controles
    private JLabel labelControles = new JLabel();//Servirá de alojamiento para los botones
    private JButton botonAbajo = new JButton();//Moverá al conejo hacia abajo
    private JButton botonArriba = new JButton();//Moverá al conejo hacia arriba
    private JButton botonDerecha = new JButton();//Moverá al conejo a la derecha
    private JButton botonIzquierda = new JButton();//Moverá al conejo a la izquierda
    private JButton botonReset = new JButton();//Reubicará al conejo al comienzo del laberinto y reiniciará el contador de zanahorias
    private JLabel labelObjetos = new JLabel();//Contendrá el puente y la llave cuando no estén en uso
    private JLabel labelZanahorias = new JLabel();//Contendrá los 5 label para mostrar las zanahorias encontradas
    private JLabel puntaje1 = new JLabel();//
    private JLabel puntaje2 = new JLabel();//
    private JLabel puntaje3 = new JLabel();//Mostrarán una imagen de zanahoria o su silueta dependiendo el estado
    private JLabel puntaje4 = new JLabel();//
    private JLabel puntaje5 = new JLabel();//
    private JLabel labelLlegadas = new JLabel();//Mostrará las veces que el conejo haya atravezado la puerta al final del laberinto
    //Imagenes
    private ImageIcon imgConejoIzq = new ImageIcon("src/imagenes/conejoIzq.png");
    private ImageIcon imgLaberintoLago = new ImageIcon("src/imagenes/laberintoLago.png");
    private ImageIcon imgConejoDer = new ImageIcon("src/imagenes/conejoDer.png");
    private ImageIcon imgPalancaApagada = new ImageIcon("src/imagenes/palancaApagada.png");
    private ImageIcon imgPalancaEncendida = new ImageIcon("src/imagenes/palancaEncendida.png");
    private ImageIcon imgPuente = new ImageIcon("src/imagenes/puente.png");
    private ImageIcon imgZanahoriaEncendida = new ImageIcon("src/imagenes/zanahoriaEncendida.png");
    private ImageIcon imgZanahoriaApagada = new ImageIcon("src/imagenes/zanahoriaApagada.png");
    private ImageIcon imgPuertaAbierta = new ImageIcon("src/imagenes/puertaAbierta.png");
    private ImageIcon imgPuertaCerrada = new ImageIcon("src/imagenes/puertaCerrada.png");
    private ImageIcon imgLlave = new ImageIcon("src/imagenes/llave.png");
    private ImageIcon imgZanahoria = new ImageIcon("src/imagenes/zanahoria.png");
    private static int posicionX = 5;
    private static int posicionY = 5;
    private static int xConejo = 5;
    private static int yConejo = 5;
    private static int xZanahoria = 5;
    private static int yZanahoria = 5;
    private static int xLlave;
    private static int yLlave;
    private int llegadas = 0;

    public Juego() {
        System.out.println("" + posicionOcupada(5, 5));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(545, 404);
        setResizable(false);
        setTitle("Laberinto");
        setLocationRelativeTo(null);

        conejo.setIcon(imgConejoDer);
        conejo.setBounds(xConejo, yConejo, 20, 20);
        laberinto.add(conejo);

        zanahoria.setIcon(imgZanahoria);
        posicionAleatoria();
        xZanahoria = posicionX;
        yZanahoria = posicionY;
        zanahoria.setBounds(xZanahoria, yZanahoria, 20, 20);
        laberinto.add(zanahoria);

        llave.setIcon(imgLlave);
        llave.setBounds(410, 60, 20, 20);
        add(llave);

        puerta.setIcon(imgPuertaCerrada);
        puerta.setBounds(325, 345, 20, 20);
        laberinto.add(puerta);

        palanca.setIcon(imgPalancaApagada);
        palanca.setBounds(265, 105, 20, 20);
        laberinto.add(palanca);

        puente.setIcon(imgPuente);
        puente.setBounds(385, 60, 20, 20);
        add(puente);

        laberinto.setIcon(imgLaberintoLago);
        laberinto.setBounds(5, 0, 350, 370);
        laberinto.setBorder(BorderFactory.createLineBorder(Color.darkGray, 5));
        add(laberinto);

        puntaje5.setIcon(imgZanahoriaApagada);
        puntaje5.setBounds(481, 15, 20, 20);
        add(puntaje5);

        puntaje4.setIcon(imgZanahoriaApagada);
        puntaje4.setBounds(457, 15, 20, 20);
        add(puntaje4);

        puntaje3.setIcon(imgZanahoriaApagada);
        puntaje3.setBounds(433, 15, 20, 20);
        add(puntaje3);

        puntaje2.setIcon(imgZanahoriaApagada);
        puntaje2.setBounds(409, 15, 20, 20);
        add(puntaje2);

        puntaje1.setIcon(imgZanahoriaApagada);
        puntaje1.setBounds(385, 15, 20, 20);
        add(puntaje1);

        labelObjetos.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        labelObjetos.setBounds(380, 55, 125, 30);
        add(labelObjetos);

        labelLlegadas.setText("Llegadas al final: " + llegadas);
        labelLlegadas.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        labelLlegadas.setBounds(380, 145, 125, 30);
        add(labelLlegadas);

        labelZanahorias.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        labelZanahorias.setBounds(380, 10, 125, 30);
        add(labelZanahorias);

        botonIzquierda.setText("←");
        botonIzquierda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonIzquierdaActionPerformed(evt);
            }
        });
        botonIzquierda.setBounds(10, 70, 50, 20);
        labelControles.add(botonIzquierda);

        botonAbajo.setText("↓");
        botonAbajo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonAbajoActionPerformed(evt);
            }
        });
        botonAbajo.setBounds(55, 100, 50, 20);
        labelControles.add(botonAbajo);

        botonDerecha.setText("→");
        botonDerecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonDerechaActionPerformed(evt);
            }
        });
        botonDerecha.setBounds(100, 70, 50, 20);
        labelControles.add(botonDerecha);

        botonArriba.setText("↑");
        botonArriba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonArribaActionPerformed(evt);
            }
        });
        botonArriba.setBounds(55, 40, 50, 20);
        labelControles.add(botonArriba);

        botonReset.setText("Reset");
        botonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonResetActionPerformed(evt);
            }
        });
        botonReset.setBounds(380, 100, 125, 29);
        add(botonReset);

        labelControles.setHorizontalAlignment(SwingConstants.CENTER);
        labelControles.setText("controles");
        labelControles.setVerticalAlignment(SwingConstants.TOP);
        labelControles.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        labelControles.setBounds(365, 200, 160, 150);
        add(labelControles);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                teclaPresionada(ke);
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
        setFocusable(true);
    }

    private void posicionAleatoria() {
        do {
            posicionX = (((int) (Math.random() * 16) + 1) * 20)+5;
            posicionY = (((int) (Math.random() * 16) + 1) * 20)+5;
        } while (posicionOcupada(posicionY, posicionX) || (posicionX == 40 && posicionY == 80));

        System.out.println("posicion x " + (posicionX));
        System.out.println("posicion y " + (posicionY));
    }

    private void teclaPresionada(KeyEvent evento) {
        if (evento.getKeyCode() == 38) {
            if (!posicionOcupada(yConejo - 20, xConejo)) {
                yConejo = yConejo - 20;
                conejo.setLocation(xConejo, yConejo);
                encontrarZanahoria(xConejo, yConejo);
                encontrarLlave(xConejo, yConejo);
            }
        }
        if (evento.getKeyCode() == 40) {
            String mensajeLago = "No puedes cruzar el agua...\n Intenta activar el puente.";
            String mensajePuerta = "La puerta está cerrada.";
            if (yConejo == 60 && xConejo == 40 && palanca.getIcon() != imgPalancaEncendida) {
                JOptionPane.showMessageDialog(null, mensajeLago);
            }
            if (yConejo == 360 && xConejo == 320 && puerta.getIcon() != imgPuertaAbierta) {
                JOptionPane.showMessageDialog(null, mensajePuerta);
            }
            if (!posicionOcupada(yConejo + 20, xConejo)) {
                yConejo = yConejo + 20;
                conejo.setLocation(xConejo, yConejo);
                encontrarZanahoria(xConejo, yConejo);
                encontrarLlave(xConejo, yConejo);
            }
            if (xConejo == 320 && yConejo == 380 && puerta.getIcon() == imgPuertaAbierta) {
                // resetConejo();
                llegadas++;
                labelLlegadas.setText("Llegadas al final: " + llegadas);
                String mensajeGanador = "¡Felicitaciones\n llegaste a la final!";
                JOptionPane.showMessageDialog(null, mensajeGanador);

            }
        }
        if (evento.getKeyCode() == 37) {
            conejo.setIcon(imgConejoIzq);
            if (!posicionOcupada(yConejo, xConejo - 20)) {
                xConejo = xConejo - 20;
                conejo.setLocation(xConejo, yConejo);
                encontrarZanahoria(xConejo, yConejo);
                encontrarLlave(xConejo, yConejo);
            }
            if (xConejo == 260 && yConejo == 100) {
                palanca.setIcon(imgPalancaEncendida);
                puente.setLocation(45, 85);
                laberinto.add(puente);
            }

        }
        if (evento.getKeyCode() == 39) {
            conejo.setIcon(imgConejoDer);
            if (!posicionOcupada(yConejo, xConejo + 20)) {
                xConejo = xConejo + 20;
                conejo.setLocation(xConejo, yConejo);
                encontrarZanahoria(xConejo, yConejo);
                encontrarLlave(xConejo, yConejo);
            }

        }
    }

    private void encontrarLlave(int x, int y) {
        if (y == yLlave && x == xLlave) {
            puerta.setIcon(imgPuertaAbierta);
            llave.setLocation(600, 0);
        }
    }

    public void generarZanahoria() {
        posicionAleatoria();
        yZanahoria = posicionY;
        xZanahoria = posicionX;
        System.out.println("xZanahoria " + xZanahoria);
        System.out.println("yZanahoria " + yZanahoria);
        //zanahoria.setLocation(xZanahoria, yZanahoria);
        zanahoria.setBounds(xZanahoria, yZanahoria, 20, 20);
    }

    private void encontrarZanahoria(int x, int y) {
        if (y == yZanahoria && x == xZanahoria) {
            //posicionAleatoria();

            if (puntaje1.getIcon() != imgZanahoriaEncendida) {
                generarZanahoria();
                //zanahoria.setLocation(xZanahoria, yZanahoria);
                puntaje1.setIcon(imgZanahoriaEncendida);
            } else if (puntaje2.getIcon() != imgZanahoriaEncendida) {
                generarZanahoria();
                //zanahoria.setLocation(xZanahoria, yZanahoria);
                puntaje2.setIcon(imgZanahoriaEncendida);
            } else if (puntaje3.getIcon() != imgZanahoriaEncendida) {
                generarZanahoria();
                //zanahoria.setLocation(xZanahoria, yZanahoria);
                puntaje3.setIcon(imgZanahoriaEncendida);
            } else if (puntaje4.getIcon() != imgZanahoriaEncendida) {
                generarZanahoria();
                //zanahoria.setLocation(xZanahoria, yZanahoria);
                puntaje4.setIcon(imgZanahoriaEncendida);
            } else if (puntaje5.getIcon() != imgZanahoriaEncendida) {
                puntaje5.setIcon(imgZanahoriaEncendida);
                activarLlave();
            }
        }
    }

    private void resetConejo() {
        // posicionAleatoria();
        zanahoria.setLocation(xZanahoria, yZanahoria);
        yConejo = 0;
        xConejo = 0;
        conejo.setLocation(xConejo, yConejo);
        puntaje1.setIcon(imgZanahoriaApagada);
        puntaje2.setIcon(imgZanahoriaApagada);
        puntaje3.setIcon(imgZanahoriaApagada);
        puntaje4.setIcon(imgZanahoriaApagada);
        puntaje5.setIcon(imgZanahoriaApagada);
        puerta.setIcon(imgPuertaCerrada);
        palanca.setIcon(imgPalancaApagada);

    }

    private void activarLlave() {
        xZanahoria = 600;
        yZanahoria = 0;
        zanahoria.setLocation(xZanahoria, yZanahoria);
        posicionAleatoria();
        xLlave = posicionX;
        yLlave = posicionY;
        System.out.println("xLlave " + xLlave);
        System.out.println("yLlave " + yLlave);
        llave.setLocation(xLlave, yLlave);

    }

    private boolean posicionOcupada(int posicionY, int posicionX) {
        //posicionY += 5;
        //posicionX += 5;
        System.out.println("posicionOcupada():");
        System.out.println("posicionY "+(posicionY));
        System.out.println("posicionX "+(posicionX));

             return posicionY == 5 &&  (posicionX == 25 || posicionX == 65 || posicionX == 325 || (posicionX >= 105 && posicionX <= 145) || (posicionX >= 185 && posicionX <= 225))
                || (posicionY == 25 &&((posicionX >= 265 && posicionX <= 285)))
                || (posicionY == 45 && (posicionX == 5 || posicionX == 25 || posicionX == 65 || posicionX == 105 || posicionX == 125 || posicionX == 165 || posicionX == 205 
                                     || posicionX == 245 || posicionX == 285 || posicionX == 305 || posicionX == 325))
                || (posicionY == 65 && (posicionX == 25 || posicionX == 65 || posicionX == 165 || posicionX == 205 || posicionX == 285))
                || (posicionY == 85 && (posicionX == 25 || (posicionX == 45 && palanca.getIcon() != imgPalancaEncendida) || posicionX == 65 || (posicionX >= 105 && posicionX <= 165)
                                     || posicionX == 205 || posicionX == 245 || posicionX == 265 || posicionX == 305))
                || (posicionY == 105 &&(posicionX == 25 || posicionX == 65 || posicionX == 165 || posicionX == 245 || posicionX == 305))
                || (posicionY == 125 &&(posicionX == 65 || (posicionX >= 105 && posicionX <= 205) || posicionX == 245 || posicionX == 265 || posicionX == 305))
                || (posicionY == 145 &&(posicionX == 5 || posicionX == 45 || posicionX == 85 || posicionX == 265 || posicionX == 305))
                || (posicionY == 165 &&(posicionX == 5 || posicionX == 45 || posicionX == 105 || posicionX == 125 || (posicionX >= 165 && posicionX <= 205) || posicionX == 245 
                                     || posicionX == 265 || posicionX == 305))
                || (posicionY == 185 &&(posicionX == 5 || posicionX == 45 || posicionX == 65 || posicionX == 105 || posicionX == 125 || posicionX == 225 || posicionX == 265 || posicionX == 305))
                || (posicionY == 205 &&(posicionX == 65 || posicionX == 165 || posicionX == 205))
                || (posicionY == 225 &&(posicionX == 25 || posicionX == 45 || posicionX == 105 || posicionX == 125 || posicionX == 205 || (posicionX >= 245 && posicionX <= 305)))
                || (posicionY == 245 &&(posicionX == 65 || (posicionX >= 105 && posicionX <= 205) || posicionX == 245 || posicionX == 305))
                || (posicionY == 265 &&(posicionX == 25 || posicionX == 65 || posicionX == 265))
                || (posicionY == 285 &&(posicionX == 25 || (posicionX >= 65 && posicionX <= 245) || posicionX == 285 || posicionX == 305))
                || (posicionY == 305 &&(posicionX == 25 || posicionX == 245 || posicionX == 305))
                || (posicionY == 325 &&(posicionX == 25 || posicionX == 65 || (posicionX >= 105 && posicionX <= 225) || posicionX == 265 || posicionX == 305))
                || (posicionY == 345 &&(posicionX == 45 || posicionX == 305 || (posicionX == 325 && puerta.getIcon() == imgPuertaCerrada)))
                                     //|| posicionX < 5 || posicionX > laberinto.getWidth() - 25
               // ||  posicionY < 5 || posicionY > laberinto.getHeight() - 25
                     ;
    }

    private void botonArribaActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == botonArriba) {
            if (!posicionOcupada(yConejo - 20, xConejo)) {
                yConejo = yConejo - 20;
                conejo.setLocation(xConejo, yConejo);
                encontrarZanahoria(xConejo, yConejo);
                encontrarLlave(xConejo, yConejo);
            }
        }
    }

    private void botonAbajoActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == botonAbajo) {
            String mensajeLago = "No puedes cruzar el agua...\n Intenta activar el puente.";
            String mensajePuerta = "La puerta está cerrada.";
            if (!posicionOcupada(yConejo + 20, xConejo)) {
                yConejo = yConejo + 20;
                conejo.setLocation(xConejo, yConejo);
                encontrarZanahoria(xConejo, yConejo);
                encontrarLlave(xConejo, yConejo);
            }
            if (yConejo == 101 && xConejo == 53 && palanca.getIcon() != imgPalancaEncendida) {
                JOptionPane.showMessageDialog(null, mensajeLago);
            }
            if (yConejo == 367 && xConejo == 319 && puerta.getIcon() != imgPuertaAbierta) {
                JOptionPane.showMessageDialog(null, mensajePuerta);
            }

            if (xConejo == 319 && yConejo == 367 && puerta.getIcon() == imgPuertaAbierta) {
                // resetConejo();
                llegadas++;
                labelLlegadas.setText("Llegadas al final: " + llegadas);
                String mensajeGanador = "¡Felicitaciones\n llegaste a la final!";
                JOptionPane.showMessageDialog(null, mensajeGanador);

            }

        }
    }

    private void botonIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {
        if ((evt.getSource() == botonIzquierda)) {
            conejo.setIcon(imgConejoIzq);
            if (!posicionOcupada(yConejo, xConejo - 20)) {
                xConejo = xConejo - 20;
                conejo.setLocation(xConejo, yConejo);
                encontrarZanahoria(xConejo, yConejo);
                encontrarLlave(xConejo, yConejo);
            }
            if (xConejo == 260 && yConejo == 100) {
                palanca.setIcon(imgPalancaEncendida);
                puente.setLocation(53, 120);
            }
        }
    }

    private void botonDerechaActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == botonDerecha) {
            conejo.setIcon(imgConejoDer);
            if (!posicionOcupada(yConejo, xConejo + 20)) {
                xConejo = xConejo + 20;
                conejo.setLocation(xConejo, yConejo);
                encontrarZanahoria(xConejo, yConejo);
                encontrarLlave(xConejo, yConejo);
            }
        }
    }

    private void botonResetActionPerformed(java.awt.event.ActionEvent evt) {
        //  resetConejo();
// TODO add your handling code here:
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments //
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Ventana().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify                     
}
