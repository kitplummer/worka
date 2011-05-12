/*
 * 
 */
package com.maestrodev.worka;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;


/**
 *
 * @author kplummer
 */
public class ScheduledJob implements Runnable {

    private final Object test;

    public ScheduledJob(final Object test) {
        this.test = test;
        System.out.println("WorkaAction! " + this.test.toString());
        JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON( this.test );
        System.out.println("JSON: " + jsonObject.getString("test"));
    }

    public void run() {
        System.out.println("WorkaAction.run()" + this.test);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
}
