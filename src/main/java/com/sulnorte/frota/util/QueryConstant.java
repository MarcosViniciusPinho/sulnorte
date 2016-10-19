package com.sulnorte.frota.util;

/**
 * Classe responsável por ser o repositório de script SQL em alguns lugares da aplicação.
 */
public class QueryConstant {

    public static final String FIND_BY_ID_PORTO_ON_ARMADOR_PORTO = "select ap.id_porto from armador_porto ap " +
            "inner join porto p on ap.id_porto=p.id " +
            "where ap.id_porto = ?1";

    public static final String FIND_ALL_IDS_PORTO_ON_ARMADOR_PORTO = "select ap.id_porto from armador_porto ap " +
            "inner join porto p on ap.id_porto=p.id " +
            "where ap.id_armador = ?1";

    private QueryConstant() {}

}