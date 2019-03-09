package com.ddlab.rnd.type2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPingParallel {

  public static void main(String[] args) {
    String[] hostList = {
      "http://crunchify.com",
      "http://yahoo.com",
      "http://www.ebay.com",
      "http://google.com",
      "http://www.example.co",
      "https://paypal.com",
      "http://bing.com/",
      "http://techcrunch.com/",
      "http://mashable.com/",
      "http://thenextweb.com/",
      "http://wordpress.com/",
      "http://wordpress.org/",
      "http://example.com/",
      "http://sjsu.edu/",
      "http://ebay.co.uk/",
      "http://google123.co.uk/",
      "http://wikipedia.org/",
      "http://en.wikipedia.org"
    };
    ExecutorService executor = Executors.newFixedThreadPool(hostList.length);
    ParallelPinger parallelPinger = new ParallelPinger();
    for (int i = 0; i < hostList.length; i++) {
      String url = hostList[i];
      UrlPingThread pingThread = new UrlPingThread(parallelPinger, url);
      Thread th = new Thread(pingThread);
      executor.execute(th);
    }
    executor.shutdown();
    // Wait until all threads are finish
    while (!executor.isTerminated()) {}

    System.out.println("\nFinished all threads");
  }
}
