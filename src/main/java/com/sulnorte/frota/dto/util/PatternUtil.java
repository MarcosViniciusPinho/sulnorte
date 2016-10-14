package com.sulnorte.frota.dto.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

public class PatternUtil {

    public static String mascaraPadraoCnpj(Long cnpj){
        if(cnpj == null){
            return null;
        }
        return Pattern.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})").matcher(cnpj.toString()).replaceAll("$1.$2.$3/$4-$5");
    }

    public static String mascaraPadraoDecimalBr(BigDecimal valor){
        if(valor == null){
            return null;
        }
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(valor).replace("R$ ","");
    }

}
