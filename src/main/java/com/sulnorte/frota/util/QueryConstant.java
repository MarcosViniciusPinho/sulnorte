package com.sulnorte.frota.util;

public class QueryConstant {

    public static final String FIND_BY_ID_PORTO_ON_ARMADOR_PORTO = "select ap.id_porto from armador_porto ap " +
            "inner join porto p on ap.id_porto=p.id " +
            "where ap.id_porto = ?1";

}
