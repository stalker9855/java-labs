package com.example.beans;

import com.example.websockets.TaskWebSocket;

import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.enterprise.concurrent.ManagedScheduledExecutorService;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class ExecuteManager {

    @Resource
    private ManagedExecutorService executorService;

    @Resource
    private ManagedScheduledExecutorService scheduledExecutorService;

    public void executeAsyncTasks() {
        executorService.submit(() -> {
            TaskWebSocket.broadcast("Task 1 started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            TaskWebSocket.broadcast("Task 1 completed");
        });

        executorService.submit(() -> {
            TaskWebSocket.broadcast("Task 2 started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            TaskWebSocket.broadcast("Task 2 completed");
        });
    }

    public void executeScheduledTask() {
        scheduledExecutorService.schedule(() -> {
            TaskWebSocket.broadcast("Scheduled task started");
            TaskWebSocket.broadcast("Scheduled task completed");
        }, 3, java.util.concurrent.TimeUnit.SECONDS);
    }
}
