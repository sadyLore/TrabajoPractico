Package FundamentosII;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicio extends JFrame {

    public PantallaInicio() {
        setTitle("YuyoCheck - Inicio");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior con logo y texto
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(new Color(44, 89, 61)); // Verde oscuro

        // Logo
        JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("/FundamentosII/logo_yuyocheck.png")));
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
