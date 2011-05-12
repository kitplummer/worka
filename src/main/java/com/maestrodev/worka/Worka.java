package com.maestrodev.worka;

import java.util.Arrays;
import net.greghaines.jesque.Config;
import net.greghaines.jesque.ConfigBuilder;
import net.greghaines.jesque.Job;
import net.greghaines.jesque.worker.Worker;
import net.greghaines.jesque.worker.WorkerEvent;
import net.greghaines.jesque.worker.WorkerImpl;
import net.greghaines.jesque.worker.WorkerListener;

/**
 * Worka!
 *
 */
public class Worka {

    public static void main(String[] args) {
        final Config config = new ConfigBuilder().withJobPackage("com.maestrodev.worka").build();

        // Start a worker to run jobs from the queue
        final Worker worker = new WorkerImpl(config,
                Arrays.asList("scheduled"), Arrays.asList(ScheduledJob.class));
        worker.addListener(new WorkaListener());
        final Thread workerThread = new Thread(worker);
        workerThread.start();
        System.out.println("Started Worker Thread!");


// Wait a few secs then shutdown
        try {
            Thread.sleep(100000);
        } catch (Exception e) {
        } // Give ourselves time to process
        System.out.println("Stopping Worker Thread.");
        worker.end(true);
        try {
            workerThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class WorkaListener implements WorkerListener {

        public void onEvent(final WorkerEvent event, final Worker worker, final String queue,
                final Job job, final Object runner, final Object result, final Exception ex) {
            System.out.println("Have an event! " + event.toString() + ex);
            throw new RuntimeException("Listener FAIL on queue" + queue);
        }
    }
}
