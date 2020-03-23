package com.politecnicomalaga;

import com.politecnicomalaga.DAO.DAOitemsBD;
import com.politecnicomalaga.Modelo.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentanaPrincipal {
    private JPanel pnlMain;
    private JButton btnEliminar;
    private JButton btnNuevo;
    private JList lstItems;
    private JButton butActualizar;
    private VentanaPrincipal estaVentana;
    private DAOitemsBD daOitemsBD = new DAOitemsBD();
    private ArrayList<Item> items = daOitemsBD.cargarItems();
    private DefaultListModel<Item> lstModel = new DefaultListModel<>();


    public void cargarLista(ArrayList<Item> items) {
        for (int f = 0; f < items.size(); f++) {
            lstModel.add(f, items.get(f));
            switch (items.get(3).toString()) {
                case "IT" :

            }
        }
        lstItems.setModel(lstModel);
        lstItems.setCellRenderer(new ItemPanel());
        lstItems.setFixedCellWidth(pnlMain.getWidth());

        lstItems.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Estiramos la celda a 1000 px de altura
                lstItems.setFixedCellHeight(1000);
                // Asignamos el valor -1 para que se recalcule la altura
                lstItems.setFixedCellHeight(-1);
            }
        });
    }

    public VentanaPrincipal() throws SQLException, ClassNotFoundException {
            //DefaultListModel<Item> lstModel = new DefaultListModel<>();

            //ArrayList<Item> items = daOitemsBD.cargarItems();

            cargarLista(items);



            btnNuevo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Dialogo dialogo = null;
                    try {
                        dialogo = new Dialogo(estaVentana);
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }

                    dialogo.setLocationRelativeTo(SwingUtilities.getRoot((Component) actionEvent.getSource()));
                    dialogo.pack();
                    dialogo.setVisible(true);
                }
            });
            btnEliminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Object item = lstItems.getSelectedValue();
                    String titulo = ((Item) item).getTitulo();
                    try {
                        daOitemsBD.eliminarItemBD(titulo);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });

        butActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lstModel.clear();
                try {
                    items = daOitemsBD.cargarItems();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                cargarLista(items);
            }
        });
    }

        public ArrayList<Item> getItems () {
        return items;
        }


    public Container getPanel() {
        return pnlMain;
    }
}




