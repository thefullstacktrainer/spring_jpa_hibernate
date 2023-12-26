// com.excelr.util.EntityManagerFactoryUtil.java
package com.excelr.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gamersZonePU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
