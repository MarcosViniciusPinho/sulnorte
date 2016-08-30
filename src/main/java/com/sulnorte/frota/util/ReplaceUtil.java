package com.sulnorte.frota.util;


import org.apache.commons.lang.StringUtils;

public class ReplaceUtil {

    public static Long somenteNumerosParaCnpj(String cnpj){
        if(StringUtils.isEmpty(cnpj)){
            return null;
        }
        return Long.parseLong(cnpj.replace(".","").replace(".","").replace("/","").replace("-",""));
    }
}
