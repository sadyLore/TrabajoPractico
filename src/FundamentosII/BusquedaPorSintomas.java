
package FundamentosII;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class BusquedaPorSintomas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaBusqueda().setVisible(true));
    }
}

class VentanaBusqueda extends JFrame {
    private JComboBox<String> comboSintomas;
    private DefaultListModel<String> modeloListaPlantas;
    private JList<String> listaPlantas;

    public VentanaBusqueda() {
        setTitle("Buscar Plantas por Síntomas");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] sintomas = {
            "Dolor de cabeza",
            "Dolor muscular / articular",
            "Dolor estomacal / digestivo",
            "Dolor menstrual",
            "Dolor por congestión",
            "Dolor de garganta",
            "Dolor en la piel (externo)"
        };

        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Selecciona un síntoma:"));

        comboSintomas = new JComboBox<>(sintomas);
        panelSuperior.add(comboSintomas);

        JButton botonBuscar = new JButton("Buscar");
        panelSuperior.add(botonBuscar);

        add(panelSuperior, BorderLayout.NORTH);

        modeloListaPlantas = new DefaultListModel<>();
        listaPlantas = new JList<>(modeloListaPlantas);
        add(new JScrollPane(listaPlantas), BorderLayout.CENTER);

        botonBuscar.addActionListener(e -> mostrarPlantas());

        listaPlantas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    String plantaSeleccionada = listaPlantas.getSelectedValue();
                    if (plantaSeleccionada != null) {
                        new VentanaPrincipal(plantaSeleccionada).setVisible(true);
                    }
                }
            }
        });
    }

    private void mostrarPlantas() {
        modeloListaPlantas.clear();
        String sintoma = (String) comboSintomas.getSelectedItem();

        ArrayList<String> plantas = new ArrayList<>();

        if (sintoma.equals("Dolor de cabeza")) {
            plantas.add("Menta");
            plantas.add("Eucalipto");
            plantas.add("Boldo");
        } else if (sintoma.equals("Dolor muscular / articular")) {
            plantas.add("Menta");
            plantas.add("Eucalipto");
            plantas.add("Jengibre");
            plantas.add("Rosa mosqueta");
        } else if (sintoma.equals("Dolor estomacal / digestivo")) {
            plantas.add("Boldo");
            plantas.add("Jengibre");
            plantas.add("Burrito");
            plantas.add("Menta");
            plantas.add("Manzanilla");
        } else if (sintoma.equals("Dolor menstrual")) {
            plantas.add("Manzanilla");
            plantas.add("Jengibre");
            plantas.add("Rosa mosqueta");
        } else if (sintoma.equals("Dolor por congestión")) {
            plantas.add("Eucalipto");
            plantas.add("Menta");
        } else if (sintoma.equals("Dolor de garganta")) {
            plantas.add("Eucalipto");
            plantas.add("Jengibre");
            plantas.add("Manzanilla");
        } else if (sintoma.equals("Dolor en la piel (externo)")) {
            plantas.add("Rosa mosqueta");
        }

        for (String planta : plantas) {
            modeloListaPlantas.addElement(planta);
        }
    }
}

