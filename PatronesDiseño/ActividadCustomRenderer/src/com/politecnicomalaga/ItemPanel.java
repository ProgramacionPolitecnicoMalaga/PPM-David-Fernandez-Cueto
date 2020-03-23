package com.politecnicomalaga;

import com.politecnicomalaga.Modelo.Item;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ItemPanel extends JPanel implements ListCellRenderer<Item> {

    private JLabel lblAutor;
    private JLabel lblFecha;
    private JTextArea txtAreaTexto;
    private JLabel lblTema;
    public ItemPanel(){
        //setMinimumSize(new Dimension(100,100));
        setLayout(new BorderLayout(10,10));

        lblAutor = new JLabel();
        lblFecha = new JLabel();
        lblTema = new JLabel();
        txtAreaTexto = new JTextArea();
        txtAreaTexto.setWrapStyleWord(true);
        txtAreaTexto.setLineWrap(true);

        Border margenAutorFecha = new EmptyBorder(10,10,0,10);
        Border margenTexto = new EmptyBorder(0,10,20,10);
        lblAutor.setBorder(margenAutorFecha);
        lblFecha.setBorder(margenAutorFecha);
        lblTema.setBorder(margenAutorFecha);
        txtAreaTexto.setBorder(margenTexto);

        add(lblAutor, BorderLayout.WEST);
        add(lblFecha, BorderLayout.EAST);
        add(lblTema, BorderLayout.NORTH);
        add(txtAreaTexto, BorderLayout.SOUTH);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Item> jList, Item item, int i, boolean isSelected, boolean cellHasFocus) {

        lblAutor.setText(item.getTitulo());
        lblFecha.setText(item.getFecha().toString());
        lblTema.setText(item.getTema());
        txtAreaTexto.setText(item.getTexto());
        txtAreaTexto.setSize(jList.getWidth(),Short.MAX_VALUE);
        lblTema.setOpaque(true);


        switch (lblTema.getText()) {
            case "IT" :
                lblTema.setBackground(Color.RED);
                break;
            case "Desarrollo" :
                lblTema.setBackground(Color.GREEN);
                break;
            case "Mantenimiento" :
                lblTema.setBackground(Color.blue);
                break;
            case "General" :
                lblTema.setBackground(Color.gray);
                break;
            default:
                lblTema.setBackground(null);
        }



        if (isSelected){
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(Color.WHITE);
        }

        if (cellHasFocus){
            txtAreaTexto.setFont(new Font("SansSerif",Font.BOLD,14));
        } else {
            txtAreaTexto.setFont(new Font("SansSerif",Font.PLAIN,10));
        }

        return this;
    }
}
