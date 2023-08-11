package clases;

import javax.swing.JLabel;

public class Conejo {
    
    public JLabel conejo;
    private String ubicacion;
    
    public Conejo(JLabel conejo) {
        ubicacion = "JUGAR";
        this.conejo = conejo;
        System.out.println(ubicacion);
    }
    
    public Conejo() {
    }
    
    public void accion() {
        switch (ubicacion) {
            case "JUGAR":
                new MenuInicio().setVisible(false);
                 new Juego().setVisible(true);
                break;
            case "PUNTAJES":
                
                break;
            case "SONIDO":
                
                break;
            case "CREDITOS":
                
                break;
            case "SALIR":
                System.exit(0);
                break;
        }
    }
    
    public void moverArriba() {
        switch (ubicacion) {
            case "JUGAR":
                conejo.setLocation(110, 480);
                ubicacion = "SALIR";
                System.out.println(ubicacion);
                break;
            case "PUNTAJES":
                conejo.setLocation(110, 80);
                ubicacion = "JUGAR";
                System.out.println(ubicacion);
                break;
            case "SONIDO":
                conejo.setLocation(110, 180);
                ubicacion = "PUNTAJES";
                System.out.println(ubicacion);
                break;
            case "CREDITOS":
                conejo.setLocation(110, 280);
                ubicacion = "SONIDO";
                System.out.println(ubicacion);
                break;
            case "SALIR":
                conejo.setLocation(110, 380);
                ubicacion = "CREDITOS";
                System.out.println(ubicacion);
                break;
        }
        conejo.repaint();
        System.out.println("mover arriba");
    }
    
    public void moverAbajo() {
        switch (ubicacion) {
            case "JUGAR":
                conejo.setLocation(110, 180);
                ubicacion = "PUNTAJES";
                System.out.println(ubicacion);
                break;
            case "PUNTAJES":
                conejo.setLocation(110, 280);
                ubicacion = "SONIDO";
                System.out.println(ubicacion);
                break;
            case "SONIDO":
                conejo.setLocation(110, 380);
                ubicacion = "CREDITOS";
                System.out.println(ubicacion);
                break;
            case "CREDITOS":
                ubicacion = "SALIR";
                System.out.println(ubicacion);
                conejo.setLocation(110, 480);
                break;
            case "SALIR":
                conejo.setLocation(110, 80);
                ubicacion = "JUGAR";
                System.out.println(ubicacion);
                break;
        }
        conejo.repaint();
        System.out.println("mover abajo");
    }
    
}
