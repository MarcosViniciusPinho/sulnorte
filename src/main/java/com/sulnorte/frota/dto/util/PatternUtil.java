package com.sulnorte.frota.dto.util;

import com.sulnorte.frota.exception.util.ParameterExceptionUtil;

import java.util.regex.Pattern;

public class PatternUtil {

    public static String mascaraPadraoCnpj(String cnpj){
        if(cnpj == null){
            ParameterExceptionUtil.validateObjectNull(cnpj);
        }
        boolean cnpjValido = java.util.regex.Pattern.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})").matcher(cnpj).matches();
        if(!cnpjValido){
            //TODO criar uma exceção quando o cnpj não for válido!
        }
        return Pattern.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})").matcher(cnpj).replaceAll("$1.$2.$3/$4-$5");
    }

}
