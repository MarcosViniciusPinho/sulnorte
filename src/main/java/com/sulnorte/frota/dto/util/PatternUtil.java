package com.sulnorte.frota.dto.util;

import com.sulnorte.frota.exception.util.ParameterExceptionUtil;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.regex.Pattern;

public class PatternUtil {

    public static String mascaraPadraoCnpj(String cnpj){
        if(StringUtils.isEmpty(cnpj)){
            ParameterExceptionUtil.validateObjectNull(cnpj);
        }
        boolean cnpjValido = java.util.regex.Pattern.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})").matcher(cnpj).matches();
        if(!cnpjValido){
            //TODO criar uma exceção quando o cnpj não for válido!
        }
        return Pattern.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})").matcher(cnpj).replaceAll("$1.$2.$3/$4-$5");
    }

    public static String mascaraPadraoDecimalBr(BigDecimal valor){
        if(valor == null){
            return null;
        }
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(valor).replace("R$ ","");
    }

}
