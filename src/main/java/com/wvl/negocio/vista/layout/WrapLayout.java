package com.wvl.negocio.vista.layout;

import java.awt.*;

public class WrapLayout extends FlowLayout {
  public WrapLayout() { super(); }
  public WrapLayout(int align, int hgap, int vgap) { super(align, hgap, vgap); }

  @Override
  public Dimension preferredLayoutSize(Container target) {
    synchronized (target.getTreeLock()) {
      int targetWidth = target.getParent().getSize().width;
      if (targetWidth == 0) targetWidth = Integer.MAX_VALUE;

      Insets insets = target.getInsets();
      int maxWidth = targetWidth - (insets.left + insets.right + getHgap() * 2);

      int rowWidth = 0, rowHeight = 0;
      int width = 0, height = insets.top;

      boolean first = true;
      for (Component c : target.getComponents()) {
        if (!c.isVisible()) continue;

        Dimension d = c.getPreferredSize();
        if (first) first = false;
        else rowWidth += getHgap();

        if (rowWidth + d.width > maxWidth && rowWidth > 0) {
          width = Math.max(width, rowWidth);
          height += rowHeight + getVgap();
          rowWidth = d.width;
          rowHeight = d.height;
        } else {
          rowWidth += d.width;
          rowHeight = Math.max(rowHeight, d.height);
        }
      }
      height += rowHeight + insets.bottom;
      width = Math.max(width, rowWidth) + insets.left + insets.right;

      return new Dimension(width, height);
    }
  }
}