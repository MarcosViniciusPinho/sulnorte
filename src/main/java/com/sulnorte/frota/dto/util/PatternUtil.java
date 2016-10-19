package com.sulnorte.frota.dto.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Classe utilitária para definir o pattern de algumas informaçoes do sistema.
 */
public class PatternUtil {

    private PatternUtil() {}

    /**
     * Método que define um pattern no formato de CNPJ. Exemplo: 99.999.999/9999-99
     * @param cnpj cnpj
     * @return String
     */
    public static String mascaraPadraoCnpj(Long cnpj){
        if(cnpj == null){
            return null;
        }
        return Pattern.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})").matcher(cnpj.toString()).replaceAll("$1.$2.$3/$4-$5");
    }

    /**
     * Método que define uma pattern no formato de numero decimal. Exemplo: 23.345,49
     * @param valor valor
     * @return String
     */
    public static String mascaraPadraoDecimalBr(BigDecimal valor){
        if(valor == null){
            return null;
        }
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(valor).replace("R$ ","");
    }

}
