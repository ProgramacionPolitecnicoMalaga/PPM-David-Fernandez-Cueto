import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Tirada {
    private JPanel panelMain;
    private JPanel panelImagen;
    private JButton butTirar;
    private JTextField txtRealizarTiradas;
    private JButton realizarTiradasButton;
    private JTextField txtTiradas;
    private JTextField txtCara;
    private JTextField txtCruz;
    private JLabel lblMoneda;

    private int contadorCara = 0;
    private int contadorCruz = 0;
    private int contadorTiradas = contadorCara + contadorCruz;
    ImageIcon caraIcon = new ImageIcon("Cara.png");
    ImageIcon cruzIcon = new ImageIcon("Cruz.png");
    ImageIcon miniCara = new ImageIcon("miniCara.png");
    ImageIcon miniCruz = new ImageIcon("miniCruz.png");
    Image cara2 = miniCara.getImage();
    Image cruz2 = miniCruz.getImage();
    Image cara = caraIcon.getImage();
    Image cruz = cruzIcon.getImage();




    public int randomizarTirada() {
        int caraOcruz = (int)(Math.random()*2+1);
        return caraOcruz;
    }

    public void realizarTirada() {
        int random = randomizarTirada();

        if (random == 1) {
            lblMoneda.setIcon(new ImageIcon(cara));
            contadorCara++;
            contadorTiradas++;
        }

        else {lblMoneda.setIcon(new ImageIcon(cruz));
        contadorCruz++;
        contadorTiradas++;}

        txtCara.setText(String.valueOf(contadorCara));
        txtCruz.setText(String.valueOf(contadorCruz));
        txtTiradas.setText(String.valueOf(contadorTiradas));
    }

    public void variasTiradas() {
        int random = randomizarTirada();

        if (random == 1) {
            JLabel resultado = new JLabel() ;
            resultado.setIcon(new ImageIcon(cara2));
            panelImagen.setLayout(new FlowLayout());
            panelImagen.add(resultado, Component.LEFT_ALIGNMENT);
            //lblMoneda.setIcon(new ImageIcon(cara));
            contadorCara++;
            contadorTiradas++;
        }

        else {//lblMoneda.setIcon(new ImageIcon(cruz));
            JLabel resultado = new JLabel() ;
            resultado.setIcon(new ImageIcon(cruz2));
            panelImagen.setLayout(new FlowLayout());
            panelImagen.add(resultado, Component.RIGHT_ALIGNMENT);
            contadorCruz++;
            contadorTiradas++;}

        txtCara.setText(String.valueOf(contadorCara));
        txtCruz.setText(String.valueOf(contadorCruz));
        txtTiradas.setText(String.valueOf(contadorTiradas));
    }



    public Tirada() {


        butTirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                realizarTirada();
            }
        });

        realizarTiradasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtRealizarTiradas.removeAll();
                panelImagen.removeAll();
                panelImagen.updateUI();
            int numeroTiradas = Integer.parseInt(txtRealizarTiradas.getText());
            for (int i = 0; i < numeroTiradas; i++) {
                variasTiradas();

            }
            txtRealizarTiradas.setText("");
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Tirada");
        frame.setContentPane(new Tirada().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
