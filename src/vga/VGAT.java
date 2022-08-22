package vga;

public class VGAT {
  public static final int WIDTH = 80;
  public static final int HEIGHT = 25;

  public static int cursorX = 0, cursorY = 0;

  private static int vidMemStart=0xB8000;
  private static int vidMemEnd=0xB8000;

  public static int vidMem = 0xB8000;

  private static int linePointer = 0;
  
  private static byte defaultColor = 0x0F;
  private static byte color = 0x0F;

  public static void resetVidMem(){
    vidMem = vidMemStart;
  }

  public static void clear(){
    for(int i = 0; i != 25 * 80; i++){
      MAGIC.wMem8(vidMem++, (byte) ' ');
      MAGIC.wMem8(vidMem++, (byte) color);
    }
    resetVidMem();
  }

  public static void enableCursor( byte cursorStart, byte cursorEnd){
    MAGIC.wIOs8(0x3D4, (byte) 0x0A);
	  MAGIC.wIOs8(0x3D5, (byte) ((MAGIC.rIOs8(0x3D5) & 0xC0) | cursorStart));
 
	  MAGIC.wIOs8(0x3D4, (byte) 0x0B);
	  MAGIC.wIOs8(0x3D5, (byte) ((MAGIC.rIOs8(0x3D5) & 0xE0) | cursorEnd));
  }

  public static void disableCursor(){
    MAGIC.wIOs8(0x3D4, (byte) 0x0A);
    MAGIC.wIOs8(0x3D5, (byte) 0x20);
  }

  public static void moveCursor(int x, int y){
    cursorX = x;
    cursorY = y;
    int pos = cursorY * WIDTH + cursorX;
 
    MAGIC.wIOs8(0x3D4, (byte)0x0F);
    MAGIC.wIOs8(0x3D5, (byte)(pos & 0xFF));
    MAGIC.wIOs8(0x3D4, (byte)0x0E);
	  MAGIC.wIOs8(0x3D5, (byte)((pos >> 8) & 0xFF));
  }

  public static void cursorToNewLine(){
      //move cursor to new line
      cursorX = 0;
      cursorY += 1;
      moveCursor(cursorX, cursorY);
  }


  public static void setColor(byte newColor){
    color = newColor;
  }
  public static void resetColor(){
    color = defaultColor;
  }

  public static void printStr(String str) {
    int i;
    for (i=0; i!=str.length(); i++) printChr(str.charAt(i));
  }

  public static void printlnStr(String str) {
    int i;
    for (i=0; i!=str.length(); i++) printChr(str.charAt(i));
    endl();
  }

  public static void endl(){
    vidMem -= linePointer;
    vidMem += 160;
    linePointer = 0;
  }

  public static void printChr(char c) {
    MAGIC.wMem8(vidMem++, (byte)c);
    MAGIC.wMem8(vidMem++, (byte)color);
    linePointer+=2;
  }
}