package com.sulnorte.frota.util;


import org.apache.commons.collections.CollectionUtils;
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
        if(CollectionUtils.isEmpty(lista)){
            return null;
        }
        return lista.toString().replace("[","").replace("]","");
    }
}
