package com.wvl.market.views.frame;

import com.wvl.market.views.Icon;
import com.wvl.market.views.dialog.DialogProductCreate;
import com.wvl.market.views.button.PrimaryButton;
import com.wvl.market.views.panel.SidebarPanel;
import com.wvl.market.views.table.ProductTable;
import com.wvl.market.views.theme.UIConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MainFrame extends JFrame {
  public MainFrame() {
    super();
    // config
    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(900, 600);
    setLocationRelativeTo(null);
    setUIFont(UIConstants.FONT_SERIF);
    setBackground(Color.RED);

    DialogProductCreate dialogProductCreate = new DialogProductCreate(this);

    JButton btn = new PrimaryButton("Crear");
    JButton btn2 = new PrimaryButton("Actualizar");
    JButton buttonDelete = new JButton();
    JButton btn4 = new PrimaryButton("Limpiar");
    JPanel panel = new JPanel();

    URL iconUrl = MainFrame.class.getResource("/images/LucidePlus.png");
    if (iconUrl != null) {
      ImageIcon originalIcon = new ImageIcon(iconUrl);
      Image scaledImage = originalIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
      btn.setIcon(new ImageIcon(scaledImage));
    } else {
      System.err.println("No se encontró el icono: /images/LucidePlay.png");
    }

    buttonDelete.setIcon(Icon.get("LucideTrash2"));
    buttonDelete.setBackground(Color.RED);

    panel.add(btn);
    panel.add(btn2);
    panel.add(buttonDelete);
    panel.add(btn4);

    ProductTable productTable = new ProductTable();

    btn2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        productTable.reloadProducts();
      }
    });

    btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dialogProductCreate.open();
      }
    });
    // Status Bar
    JPanel statusBar = new JPanel();
    JLabel lblProducts = new JLabel(12 + "");
    lblProducts.setFont(new Font("Geist", Font.BOLD, 14));

    statusBar.add(lblProducts);
    statusBar.add(new JLabel(" Products"));

    // navegacion
    SidebarPanel sidebar = new SidebarPanel();

    // menu bar
    JMenuBar menuBar = new JMenuBar();


    JMenu menuArchivo = new JMenu("Archivo");
    JMenu menuEditar = new JMenu("Editar");
    JMenu menuAyuda = new JMenu("Ayuda");
    menuArchivo.setFont(UIConstants.FONT_SERIF);

    menuBar.add(new JMenu("Servicios"));
    menuBar.add(new JMenu("Tratamientos"));
    menuBar.add(new JMenu("View"));

    JMenuItem itemNuevo = new JMenuItem("Nuevo");
    itemNuevo.setFont(UIConstants.FONT_SERIF);
    JMenuItem itemAbrir = new JMenuItem("Abrir");
    JMenuItem itemSalir = new JMenuItem("Salir");
    itemSalir.setActionCommand("Ctrl+C");
    itemSalir.addActionListener(e -> System.exit(0));

    // Añadir ítems al menú "Archivo"
    menuArchivo.add(itemNuevo);
    menuArchivo.add(new JMenuItem("Exportar como csv"));
    menuArchivo.add(itemAbrir);
    menuArchivo.addSeparator(); // línea divisoria
    menuArchivo.add(itemSalir);

    menuBar.add(menuArchivo);
    menuBar.add(menuEditar);
    menuBar.add(menuAyuda);

    // Establecer la barra de menú en el frame

    // Añadir menús a la barra
    menuBar.add(menuArchivo);
    menuBar.add(menuEditar);
    menuBar.add(menuAyuda);



    add(sidebar, BorderLayout.WEST);
    add(statusBar, BorderLayout.SOUTH);
    add(panel, BorderLayout.NORTH);
    add(productTable.getScrollPane(), BorderLayout.CENTER);
    setVisible(true);
  }
  private JButton crearBoton(String texto) {
    JButton btn = new JButton(texto);
    btn.setFocusPainted(false);
    btn.setForeground(Color.WHITE);
    btn.setBackground(new Color(60, 63, 65));
    btn.setBorderPainted(false);
    btn.setFont(new Font("SansSerif", Font.BOLD, 14));
    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

    // Efecto hover (cuando pasa el mouse)
    btn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        btn.setBackground(new Color(90, 93, 95));
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        btn.setBackground(new Color(60, 63, 65));
      }
    });

    return btn;
  }
  public static void setUIFont(Font font) {
    java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get(key);
      if (value instanceof Font) {
        UIManager.put(key, font);
      }
    }
  }
}
