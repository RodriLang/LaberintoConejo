package clases;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclas extends KeyAdapter {

    static String direccion = "arriba";
    Conejo conejo = new Conejo();

//    @Override
//    public void keyPressed(KeyEvent ke) {
//        if (ke.getKeyCode() == KeyEvent.VK_UP) {
//            conejo.moverArriba();
//        } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
//            conejo.moverAbajo();
//        }
//    }

}
