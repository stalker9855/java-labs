//package com.example.runners;
//
//import com.example.beans.ExecuteManager;
//
//import jakarta.annotation.PostConstruct;
//import jakarta.ejb.Singleton;
//import jakarta.ejb.Startup;
//import jakarta.inject.Inject;
//
//@Singleton
//@Startup
//public class ExecutorRunner {
//
//    @Inject
//    private ExecuteManager executeManager;
//
//    @PostConstruct
//    public void init() {
//        System.out.println("Запуск асинхронних завдань");
//        executeManager.executeAsyncTasks();
//
//        System.out.println("Запуск запланованого завдання");
//        executeManager.executeScheduledTask();
//    }
//}
