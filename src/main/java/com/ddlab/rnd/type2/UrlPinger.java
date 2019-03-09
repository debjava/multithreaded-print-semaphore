package com.ddlab.rnd.type2;

import java.net.HttpURLConnection;
import java.net.URL;

public class UrlPinger {

  public void ping(String url) {
    String result = "";
    int code = 200;
    try {
      URL siteURL = new URL(url);
      HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
      connection.setRequestMethod("GET");
      connection.setConnectTimeout(3000);
      connection.connect();

      code = connection.getResponseCode();
      if (code == 200) {
        result = "-> Green <-\t" + "Code: " + code;
        ;
      } else {
        result = "-> Yellow <-\t" + "Code: " + code;
      }
    } catch (Exception e) {
      result = "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();
    }
    System.out.println(url + "\t\tStatus:" + result);
  }

  public static void main(String[] args) {
    String uri = "http://www.google.com";
    UrlPinger pinger = new UrlPinger();
    pinger.ping(uri);
  }
}
