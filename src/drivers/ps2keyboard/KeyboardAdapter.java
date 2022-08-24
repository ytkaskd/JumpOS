package drivers.ps2keyboard;

import drivers.vga.VGAT;

public class KeyboardAdapter{
    private static final int PS2port = 0x60;

    public static void init(){

    }

    public static byte selfTest(){
        MAGIC.wIOs8(PS2port, (byte) 0xEE);
        return MAGIC.rIOs8(PS2port);
    }

    public static byte getSC(){
        byte sc = MAGIC.rIOs8(PS2port);
        MAGIC.wIOs8(PS2port, (byte) 0x00);
        return sc;
    }

    // private static void readSelfTest(){
    //     if( != 0xEE){
    //         VGAT.setColor((byte) 0x0E);
    //         VGAT.printlnStr("warning");
    //     } else{
    //         VGAT.setColor((byte) 0x02);
    //         VGAT.printlnStr("done");
    //     }
    // }
}