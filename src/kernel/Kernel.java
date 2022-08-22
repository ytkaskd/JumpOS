package kernel;

import vga.VGAT;
import keyboard.KeyboardAdapter;

public class Kernel {
  public static void main() {
    VGAT.clear();
    VGAT.moveCursor(0, 0);
    KeyboardAdapter.init();

    while(true){
      KeyboardAdapter.handle();
    }
  }

}