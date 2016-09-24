package com.sulnorte.frota.dto.util;


import com.sulnorte.frota.exception.util.ParameterExceptionUtil;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;

public class ReplaceUtil {

    public static Long somenteNumerosParaCnpj(String cnpj){
        if(StringUtils.isEmpty(cnpj)){
            return null;
        }
        return Long.parseLong(cnpj.replace(".","").replace(".","").replace("/","").replace("-",""));
    }

    public static String somenteTexto(Collection lista){
        ParameterExceptionUtil.validateCollectionNull(lista);
        return lista.toString().replace("[","").replace("]","");
    }
}
