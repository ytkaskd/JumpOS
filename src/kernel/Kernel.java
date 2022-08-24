package kernel;

import drivers.vga.VGAT;
import drivers.ps2keyboard.KeyboardAdapter;
import shell.ComandHandler;

public class Kernel {

  public static void main() {
    VGAT.clear();
    VGAT.moveCursor(0, 0);
    VGAT.printStr("keyboard self-test: ");

    KeyboardAdapter.init();
    if(KeyboardAdapter.selfTest() == 0xEE){
        VGAT.setColor((byte) 0x0E);
        VGAT.printlnStr("warning");
    } else{
        VGAT.setColor((byte) 0x02);
        VGAT.printlnStr("done");
    }

    ComandHandler.newComandLine();

    while(true){
      ComandHandler.addCharByByte(KeyboardAdapter.getSC());
    }
  }

}