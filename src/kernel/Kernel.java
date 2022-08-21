package kernel;

import vga.VGAT;

public class Kernel {

  public static void main() {
    VGAT.clear();

    VGAT.setColor((byte)0x02);
    VGAT.printStr("JumpOS, OS on ");
    VGAT.setColor((byte)0x04);
    VGAT.printStr("Java ");
    VGAT.setColor((byte)0x02);
    VGAT.printStr("by tankarmee");

    VGAT.disableCursor();
  }

}