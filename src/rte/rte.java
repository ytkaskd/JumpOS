package java.lang;
import rte.SClassDesc;

public class Object {
  public final SClassDesc _r_type=null;
  public final Object _r_next=null;
  public final int _r_relocEntries=0, _r_scalarSize=0;
}

package java.lang;

public class String {
  private char[] value;
  private int count;
  @SJC.Inline
  public int length() {
    return count;
  }
  @SJC.Inline
  public char charAt(int i) {
    return value[i];
  }
}

package rte;

public class SArray {
  public final int length=0, _r_dim=0, _r_stdType=0;
  public final Object _r_unitType=null;
}

package rte;

public class SClassDesc {
  public SClassDesc parent;
  public SIntfMap implementations;
}

package rte;

public class SIntfDesc {
}

package rte;

public class SIntfMap {
  public SIntfDesc owner;
  public SIntfMap next;
}

package rte;

public class SMthdBlock {
}

package rte;

public class DynamicRuntime {
  public static Object newInstance(int scalarSize, int relocEntries,
      SClassDesc type) { while(true); }

  public static SArray newArray(int length, int arrDim, int entrySize,
      int stdType, Object unitType) { while(true); }

  public static void newMultArray(SArray[] parent, int curLevel,
      int destLevel, int length, int arrDim, int entrySize, int stdType,
      Object unitType) { while(true); }

  public static boolean isInstance(Object o, SClassDesc dest,
      boolean asCast) { while(true); }

  public static SIntfMap isImplementation(Object o, SIntfDesc dest,
      boolean asCast) { while(true); }

  public static boolean isArray(SArray o, int stdType,
      Object unitType, int arrDim, boolean asCast) { while(true); }

  public static void checkArrayStore(Object dest,
      SArray newEntry) { while(true); }
}
