//package com.gmc_team.e_commerse_platform.Intercipter;
//
//import org.hibernate.resource.jdbc.spi.StatementInspector;
//import org.slf4j.MDC;
//import org.springframework.util.StringUtils;
//
//public class Interceptor implements StatementInspector {
//
//    @Override
//    public String inspect(String sql) {
//
//        if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
//            // select utilisateu0_.
//            final String entityName = sql.substring(7, sql.indexOf("."));
//            final String onlineshop = MDC.get("onlineshop");
//            if (StringUtils.hasLength(entityName)
//                    && !entityName.toLowerCase().contains("online_shop")
//                    && !entityName.toLowerCase().contains("roles")
//                    && StringUtils.hasLength(onlineshop)) {
//
//                if (sql.contains("where")) {
//                    sql = sql + " and " + entityName + ".identreprise = " + onlineshop;
//                } else {
//                    sql = sql + " where " + entityName + ".identreprise = " + onlineshop;
//                }
//            }
//        }
//        return sql;
//    }
//}
