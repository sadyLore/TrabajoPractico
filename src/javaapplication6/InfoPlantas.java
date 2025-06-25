// Versión simplificada del Módulo 2: Muestra todas las plantas al iniciar (sin necesidad de seleccionar)
package javaapplication6;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// la clase se llama infoPlantas atienda eso para evitar errores,
public class InfoPlantas{
    public static void main(String[] args) {
  // el swingutilities tiene metodos estaticos y ayudan a trabajar bien con la interfaz , para manejar mejor los hilos/secuencias
    //dentro del invokeLater que es um metodo de la clase swingutilities se crea la pantalla principal, basicamente ayuda a que los comandos se ejecuten en orden, para que no haya comportamiento erraticos
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }  // y despues es crear la ventana que usaremos
}
// 2DA CLASE
class VentanaPrincipal extends JFrame {
    private ArrayList<Planta> listaPlantas;

    public VentanaPrincipal() {
        //titulo de la ventana
        setTitle("Ficha Técnica de Plantas Medicinales");
        //para que al cerrar la ventana se termine el programa.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);// esto es para centrar la ventana en la pantalla
      
        
        //aca ya empezamos con la lista de plantas con los daots
        listaPlantas = cargarPlantas();

        JPanel plantasPanel = new JPanel(); // aca basicamente es para que cada info vaya ujna detras de la otra
        plantasPanel.setLayout(new BoxLayout(plantasPanel, BoxLayout.Y_AXIS));
        plantasPanel.setBackground(Color.WHITE);

        for (Planta planta : listaPlantas) { //aca se crea una ficha para cada planta con todos sus datos
            plantasPanel.add(crearFicha(planta));
            plantasPanel.add(Box.createVerticalStrut(15));// espacio de separacion
        }
        //se pone el panel de plantas dentro de un panel con scroll, ese que se puede subir y bajar para que pueda desplazarse si hay muchas plantas.
        JScrollPane scrollPane = new JScrollPane(plantasPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane);
    }
// PRIMER METODO
    private JPanel crearFicha(Planta planta) {
    JLabel imagenLabel = new JLabel();// esto es para ver la imagen , hule ta
    imagenLabel.setPreferredSize(new Dimension(150, 150));
    ImageIcon icon = new ImageIcon(planta.getRutaImagen());
    Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
    imagenLabel.setIcon(new ImageIcon("menta.jpg")); // Aquí asignamos la imagen escalada correctamente

    JPanel infoPanel = new JPanel(); //panel que contiene etiquetas con la información textual de la planta. Usa layout vertical.
    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
    infoPanel.setBackground(Color.WHITE); //color azul claro
    infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));//borde vacio
    infoPanel.add(new JLabel("Nombre común: " + planta.getNombreComun()));
    infoPanel.add(new JLabel("Nombre científico: " + planta.getNombreCientifico()));
    infoPanel.add(new JLabel("Parte utilizada: " + planta.getParteUtilizada()));
    infoPanel.add(new JLabel("Formas de uso: " + planta.getFormaUso()));
    infoPanel.add(new JLabel("Beneficios: " + planta.getBeneficios()));
    JLabel advertenciasLabel = new JLabel("Advertencia: " + planta.getAdvertencias());
    advertenciasLabel.setForeground(Color.RED);
    infoPanel.add(advertenciasLabel);
    
    JPanel fichaPanel = new JPanel(new BorderLayout(10, 10)); //panel principal que combina la imagen (a la izquierda) y la información (al centro) con un layout de tipo BorderLayout
    fichaPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    fichaPanel.setBackground(Color.WHITE);
    fichaPanel.add(imagenLabel, BorderLayout.WEST);
    fichaPanel.add(infoPanel, BorderLayout.CENTER);

    return fichaPanel;
}
// 2DO METODO, se crea la lista de plantas con sus datos correspondientes
  private ArrayList<Planta> cargarPlantas() {
    ArrayList<Planta> lista = new ArrayList<>();

    lista.add(new Planta("Menta", "Mentha piperita", "Hojas",
            "Infusión, aceite esencial",
            "Alivia dolores, ayuda digestión",
            "Evitar en niños menores de 2 años",
            "menta.jpg"));

    lista.add(new Planta("Manzanilla", "Matricaria chamomilla", "Flores",
            "Infusión",
            "Relajante, ayuda en cólicos",
            "Evitar en personas alérgicas a compuestas",
            "manzanilla.jpg"));

    lista.add(new Planta("Eucalipto", "Eucalyptus globulus", "Hojas",
            "Inhalaciones, infusión, ungüentos",
            "Descongestionante, alivia problemas respiratorios",
            "No usar en exceso, evitar en embarazadas",
            "eucalipto.jpg"));

    lista.add(new Planta("Jengibre", "Zingiber officinale", "Raíz",
            "Infusión, fresco, en polvo",
            "Antiinflamatorio, mejora digestión, ayuda contra náuseas",
            "Evitar en casos de úlceras o anticoagulantes",
            "jengibre.jpg"));

    lista.add(new Planta("Rosa mosqueta", "Rosa rubiginosa", "Frutos y semillas",
            "Aceite, infusión",
            "Regenera piel, rica en vitamina C",
            "Evitar en personas con alergia a rosas",
            "rosamosqueta.jpg"));

    lista.add(new Planta("Boldo", "Peumus boldus", "Hojas",
            "Infusión",
            "Estimula hígado, ayuda en digestión pesada",
            "Evitar en embarazo y lactancia, no usar por más de 2 semanas",
            "boldo.jpg"));

    lista.add(new Planta("Burrito", "Aloysia polystachya", "Hojas",
            "Infusión",
            "Alivia malestares estomacales y cólicos",
            "Evitar el uso prolongado o en dosis altas",
            "burrito.jpg"));

    return lista;
}
}
// 3ra clase
class Planta {
    private String nombreComun;
    private String nombreCientifico;
    private String parteUtilizada;
    private String formaUso;
    private String beneficios;
    private String advertencias;
    private String rutaImagen;
// construcxtor
    public Planta(String nombreComun, String nombreCientifico, String parteUtilizada,
                  String formaUso, String beneficios, String advertencias, String rutaImagen) {
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.parteUtilizada = parteUtilizada;
        this.formaUso = formaUso;
        this.beneficios = beneficios;
        this.advertencias = advertencias;
        this.rutaImagen = rutaImagen;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public String getParteUtilizada() {
        return parteUtilizada;
    }

    public String getFormaUso() {
        return formaUso;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public String getAdvertencias() {
        return advertencias;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
}