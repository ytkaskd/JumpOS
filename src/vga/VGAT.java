package vga;

public class VGAT {
  private static int vidMemStart=0xB800;
  private static int vidMemEnd=0xB8000;

  private static int vidMem = 0xB8000;

  private static int linePointer = 0;

  private static byte color = 0x07;

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