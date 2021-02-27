package com.example.demo.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Component
public class InternetHealthMetrics implements HealthIndicator {
    @Override
    public Health health() {
        Health health=null;
        health=checkInternet()==true ? Health.up().withDetail("success","active internet connection").build()
                :Health.down().withDetail("error code","inactive internet connection").build();
        return health;
    }
    private boolean checkInternet() {
        boolean flag = false;
        URL url = null;
        try {
            url = new URL("https://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            flag=true;
        } catch (Exception e) {
            flag=false;
            e.printStackTrace();
        }
        return flag;
    }
}
