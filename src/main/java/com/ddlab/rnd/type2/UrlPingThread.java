package com.ddlab.rnd.type2;

public class UrlPingThread implements Runnable {

  private ParallelPinger parallelPinger;
  private String url;

  public UrlPingThread(ParallelPinger parallelPinger, String url) {
    super();
    this.parallelPinger = parallelPinger;
    this.url = url;
  }

  @Override
  public void run() {
    parallelPinger.pingParallely(url);
  }
}
