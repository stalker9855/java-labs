package com.example.controllers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.beans.MetadataBean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.AnnotatedType;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@RequestScoped
@Controller
@Path("metadata")
public class MetadataController {
  @Inject
  private MetadataBean metadataBean;

  @Inject
  Models models;

  @Inject
  private BeanManager beanManager;

@GET
    @Path("{beanName}")
    @View("metadata.xhtml")
    public void showMetadata(@PathParam("beanName") String beanName) {
Set<Bean<?>> beans = metadataBean.getBeans(); 

        Map<String, String> metadata = new HashMap<>();
        boolean found = false;

        for (Bean<?> bean : beans) {
            String beanNameFromBean = bean.getName();
            if (beanNameFromBean != null && beanNameFromBean.equals(beanName)) {
                Class<?> beanClass = bean.getBeanClass();

                StringBuilder fieldsInfo = new StringBuilder();
                for (Field field : beanClass.getDeclaredFields()) {
                    fieldsInfo.append(field.getName()).append(" (").append(field.getType().getName()).append(")\n");
                }

                StringBuilder methodsInfo = new StringBuilder();
                for (Method method : beanClass.getDeclaredMethods()) {
                    methodsInfo.append(method.getName()).append(" (");
                    String params = Arrays.stream(method.getParameterTypes())
                            .map(Class::getName)
                            .collect(Collectors.joining(", "));
                    methodsInfo.append(params).append(")\n");
                }

                String beanInfo = "Scope: " + bean.getScope().getName() +
                                  "\nClass: " + bean.getBeanClass().getName() +
                                  "\nFields:\n" + fieldsInfo.toString() +
                                  "\nMethods:\n" + methodsInfo.toString();
                
                metadata.put(beanNameFromBean, beanInfo); 
                found = true;
                break; 
            }
        }

        if (!found) {
            metadata.put(beanName, "No such bean found.");
        }

        models.put("metadata", metadata);
    }

}
