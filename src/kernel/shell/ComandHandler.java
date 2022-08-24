package shell;

import drivers.vga.VGAT;

public class ComandHandler{
    private static String username = "(jumpos)";
    private static byte usernameColor = 0x0A;
    private static int commandLineCount = 0;

    private static char[] commandBuffer = new char[64];
    private static byte pointer = 0;
    private static byte cursorPointer = 0;

    public static void newComandLine(){
        if(commandLineCount != 24){
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

    public static void addCharByByte(byte b){
        char sc = castScancodeToChar(b);
        if(sc != 0){
            if(cursorPointer != 64){
                cursorPointer++;
                VGAT.moveCursor(cursorPointer + username.length(), VGAT.cursorY);
                VGAT.printChr(sc);
            }
        }
        
    }

    private static char castScancodeToChar(int sc){
        char c = 0;
        switch(sc){
            case 0x10:
                c = 'q';
                break;
            case 0x11:
                c = 'w';
                break;
            case 0x12:
                c = 'e';
                break;
            case 0x13:
                c = 'r';
                break;
            case 0x14:
                c = 't';
                break;
            case 0x15:
                c = 'y';
                break;
            case 0x16:
                c = 'u';
                break;
            case 0x17:
                c = 'i';
                break;
            case 0x18:
                c = 'o';
                break;
            case 0x19:
                c = 'p';
                break;
            case 0x1E:
                c = 'a';
                break;
            case 0x1F:
                c = 's';
                break;
            case 0x20:
                c = 'd';
                break;
            case 0x21:
                c = 'f';
                break;
            case 0x22:
                c = 'g';
                break;
            case 0x23:
                c = 'h';
                break;
            case 0x24:
                c = 'j';
                break;
            case 0x25:
                c = 'k';
                break;
            case 0x26:
                c = 'l';
                break;
            case 0x2C:
                c = 'z';
                break;
            case 0x2D:
                c = 'x';
                break;
            case 0x2E:
                c = 'c';
                break;
            case 0x2F:
                c = 'v';
                break;
            case 0x30:
                c = 'b';
                break;
            case 0x31:
                c = 'n';
                break;
            case 0x32:
                c = 'm';
                break;
            case 0x39:
                c = ' ';
                break;
            case 0x1C:
                newComandLine();
            default:
                c = 0;
                break;
        }
        return c;
    }
}