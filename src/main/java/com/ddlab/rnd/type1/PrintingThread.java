package com.ddlab.rnd.type1;

public class PrintingThread implements Runnable {

  private Printer printer;
  private String documentName;

  public PrintingThread(Printer printer, String documentName) {
    super();
    this.printer = printer;
    this.documentName = documentName;
  }

  @Override
  public void run() {
    printer.print(documentName);
  }
}
