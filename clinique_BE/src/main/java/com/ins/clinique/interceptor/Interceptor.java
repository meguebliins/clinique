package com.ins.clinique.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.CallbackException;
import org.hibernate.type.Type;
import org.springframework.web.servlet.HandlerInterceptor;

public class Interceptor implements org.hibernate.Interceptor {

/*
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        System.out.println("fyhftyftyu******************************");

        // Intercepter les appels à la base de données ici
        // Pour des besoins de démonstration, nous utilisons un exemple simplifié
        if (request.getRequestURI().contains("/patient/all")) {
            // Exemple de modification d'une requête SQL
            modifySQL(request.getParameter("sqlQuery"));
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

        return true;
    }*/

    @Override
    public boolean onLoad(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        return org.hibernate.Interceptor.super.onLoad(entity, id, state, propertyNames, types);
    }

    private void modifySQL(String sqlQuery) {
        // Modifier la requête SQL ici selon les besoins
        // Cet exemple ne traite que des requêtes SELECT
        if (sqlQuery.toLowerCase().startsWith("select")) {
            if(sqlQuery.contains("where")){
                sqlQuery =sqlQuery+" and entrepriseid= 1";
            }
            else{
                sqlQuery =sqlQuery+" where entrepriseid= 1";
            }
//            String modifiedQuery = "SELECT * FROM modified_table";
            // Exemple : Remplacer la requête originale par une nouvelle requête
            // À ce stade, cela ne tient pas compte des paramètres ni des cas plus complexes
            System.out.println("Original SQL Query: " + sqlQuery);
            System.out.println("Modified SQL Query: " + sqlQuery);
        }
    }

}
