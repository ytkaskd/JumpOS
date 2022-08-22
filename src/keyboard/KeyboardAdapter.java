package keyboard;

import vga.VGAT;

public class KeyboardAdapter{
    public static byte keyScanecode = 0x00;

    private static final int keyboardPort = 0x60;

    public static void init(){
        selfTest();
    }

    private static void selfTest(){
        //0xFF - reset and start self-test
        VGAT.printStr("keyboard self-test: ");
        MAGIC.wIOs8(keyboardPort, (byte) 0xEE);

        readSelfTest();

        VGAT.resetColor();

        ComandHandler.newComandLine();
    }

    private static void readSelfTest(){
        if(MAGIC.rIOs8(keyboardPort) != 0xEE){
            VGAT.setColor((byte) 0x0E);
            VGAT.printlnStr("warning");
        } else{
            VGAT.setColor((byte) 0x02);
            VGAT.printlnStr("done");
        }
    }

    public static void handle(){
        switch((int) MAGIC.rIOs8(keyboardPort)){
            case 0x1C:
                ComandHandler.newComandLine();
                MAGIC.wIOs8(keyboardPort, (byte) 0xEE);
                break;
            case 0x10:
                ComandHandler.printCharByByte(MAGIC.rIOs8(keyboardPort));
                MAGIC.wIOs8(keyboardPort, (byte) 0xEE);
                break;
        }
    }
}