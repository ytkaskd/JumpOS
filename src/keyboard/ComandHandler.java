package keyboard;

import vga.VGAT;

public class ComandHandler{
    private static String username = "(jumpos)";
    private static byte usernameColor = 0x0A;
    private static int commandLineCount = 0;
    private static String command;

    public static void newComandLine(){
        if(command != null){
            VGAT.printlnStr("response");
            command = null;
        } 
        else{
            if(commandLineCount != 25){
                VGAT.endl();
                VGAT.setColor(usernameColor);
                VGAT.printStr(username);
                VGAT.resetColor();
                VGAT.moveCursor(username.length(), commandLineCount + 2);
                commandLineCount += 1;
            } 
            else
            {
                VGAT.moveCursor(username.length(), 0);
                VGAT.resetVidMem();
                commandLineCount = 0;
                newComandLine();
            }
        }
    }

    public static void printCharByByte(byte b){
        VGAT.moveCursor(VGAT.cursorX+1, VGAT.cursorY);
        VGAT.printChr('q');
    }
}