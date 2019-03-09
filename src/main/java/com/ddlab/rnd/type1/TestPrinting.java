package com.ddlab.rnd.type1;

public class TestPrinting {

  public static void main(String[] args) {
    Printer printer = new Printer();
    for (int i = 0; i < 10; i++) {
      PrintingThread printingThread = new PrintingThread(printer, "PDF-" + i);
      Thread th = new Thread(printingThread);
      th.start();
    }
  }
}
