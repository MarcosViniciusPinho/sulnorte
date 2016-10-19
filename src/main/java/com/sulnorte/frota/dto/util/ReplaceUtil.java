package com.sulnorte.frota.dto.util;


import com.sulnorte.frota.exception.util.ParameterExceptionUtil;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Classe utilitária para retirar caracteres indesejados.
 */
public class ReplaceUtil {

    private ReplaceUtil() {}

    /**
     * Método que retira os pontos('.'), barra('/') e traço('-')
     * @param cnpj cnpj
     * @return Long
     */
    public static Long retirarMascaraPadraoCnpj(String cnpj){
        if(StringUtils.isEmpty(cnpj)){
            return null;
        }
        return Long.parseLong(cnpj.replace(".","").replace(".","").replace("/","").replace("-",""));
    }

    /**
     * Método que retira ponto('.') e troca virgula(',') por ponto('.')
     * @param valor valor
     * @return BigDecimal
     */
    public static BigDecimal retirarMascaraPadraoDecimalBr(String valor){
        if(StringUtils.isEmpty(valor)){
            return null;
        }
        return new BigDecimal(valor.replace(".","").replace(",","."));
    }

    /**
     * Método que retira os colchetes ('[') e (']')
     * @param lista lista
     * @return String
     */
    public static String somenteTexto(Collection lista){
        ParameterExceptionUtil.validateCollectionNull(lista);
        return lista.toString().replace("[","").replace("]","");
    }
}
