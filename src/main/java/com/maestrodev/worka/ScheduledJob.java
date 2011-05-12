/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maestrodev.worka;

/**
 *
 * @author kplummer
 */
import java.util.List;


/**
 * Complicated construtor to test JSON serialization.
 *
 * @author Greg Haines
 */
public class ScheduledJob implements Runnable {

    private final Object test;

    public ScheduledJob(final Object test) {
        this.test = test;
        System.out.println("WorkaAction! " + this.test);

    }

    public void run() {
        System.out.println("WorkaAction.run()" + this.test);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
}
