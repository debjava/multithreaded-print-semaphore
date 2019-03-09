package com.ddlab.rnd.type1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Printer {

  // At a time, only 3 printing can be done
  private Semaphore semaphore = new Semaphore(3);

  public void print(String documentName) {
    try {
      semaphore.acquire();
      System.out.println("Printing document -> " + documentName);
      TimeUnit.SECONDS.sleep(5);
      System.out.println("Completed printing document -> " + documentName);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
    }
  }
}
