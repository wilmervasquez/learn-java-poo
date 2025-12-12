package com.wvl.utils;

import javax.swing.*;
import java.net.URI;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageNetwork {
  private static final String CACHE_DIR = ".cache/";

  static {
    new File(CACHE_DIR).mkdirs();
  }

  public static ImageIcon getImage(String url) {
    try {
      String fileName = url.hashCode() + ".png";
      File localFile = new File(CACHE_DIR, fileName);

      if (localFile.exists()) {
        // 🔥 Carga desde disco
        BufferedImage img = ImageIO.read(localFile);
        return new ImageIcon(img);
      }

      // ⬇️ Descarga desde internet
      BufferedImage img = ImageIO.read(new URI(url).toURL());
      ImageIO.write(img, "png", localFile); // 🧠 Guarda en disco
      return new ImageIcon(img);

    } catch (Exception e) {
      System.err.println("Error cargando imagen: " + e.getMessage());
      return new ImageIcon();
    }
  }
}

