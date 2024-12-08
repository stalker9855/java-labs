//package com.example.controllers;
//
//import com.example.beans.ExecuteManager;
//
//import jakarta.inject.Inject;
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.core.MediaType;
//
//@Path("/tasks")
//public class TaskController {
//
//    @Inject
//    private ExecuteManager executeManager;
//
//    @GET
//    @Path("/async")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String runAsyncTasks() {
//        executeManager.executeAsyncTasks();
//        return "Asynchronus tasks launched!";
//    }
//
//    @GET
//    @Path("/scheduled")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String runScheduledTask() {
//        executeManager.executeScheduledTask();
//        return "Scheduled tasks launched!";
//    }
//}
