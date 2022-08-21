package vga;

public class VGAT {
  private static int vidMemStart=0xB8000;
  private static int vidMemEnd=0xB8000;

  private static int vidMem = 0xB8000;

  private static int linePointer = 0;

  private static byte color = 0x07;

  public static void resetVidMem(){
    vidMem = vidMemStart;
  }

  public static void disableCursor(){
    MAGIC.inline(0x9C);
    MAGIC.inline(0x50);
    MAGIC.inline(0x52);
    MAGIC.inline(0x66);
    MAGIC.inline(0xBA);
    MAGIC.inline(0xD4);
    MAGIC.inline(0x03);
    MAGIC.inline(0xB0);
    MAGIC.inline(0x0A);
    MAGIC.inline(0xEE);
    MAGIC.inline(0x66);
    MAGIC.inline(0x42);
    MAGIC.inline(0xB0);
    MAGIC.inline(0x20);
    MAGIC.inline(0xEE);
    MAGIC.inline(0x5A);
    MAGIC.inline(0x58);
    MAGIC.inline(0x9D);
    MAGIC.inline(0xC3);
  }

  public static void clear(){
    for(int i = 0; i != 1024; i++){
      printChr(' ');
    }
    resetVidMem();
  }

  public static void setColor(byte color1){
    color = color1;
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
  }

  public static void printChr(char c) {
    MAGIC.wMem8(vidMem++, (byte)c);
    MAGIC.wMem8(vidMem++, (byte)color);
    linePointer+=2;
  }
}