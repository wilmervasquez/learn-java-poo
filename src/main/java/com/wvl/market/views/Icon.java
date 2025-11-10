package com.wvl.market.views;

import com.wvl.market.views.frame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Icon {
  public static ImageIcon get(String url) {
    URL iconUrl = MainFrame.class.getResource("/images/"+url+".png");
    ImageIcon originalIcon = new ImageIcon(iconUrl);
    Image scaledImage = originalIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
    return new ImageIcon(scaledImage);
  }
}
