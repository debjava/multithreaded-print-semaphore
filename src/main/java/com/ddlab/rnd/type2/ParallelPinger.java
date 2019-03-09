package com.ddlab.rnd.type2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ParallelPinger {

  // At a time, you can ping upto 3 urls
  private Semaphore semaphore = new Semaphore(3);

  public void pingParallely(String url) {
    try {
      semaphore.acquire();
      new UrlPinger().ping(url);
      TimeUnit.SECONDS.sleep(3);
      System.out.println("----------------------------------------------");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
    }
  }
}
