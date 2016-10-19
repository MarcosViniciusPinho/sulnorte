package com.sulnorte.frota.exception.util;

import com.sulnorte.frota.exception.NullParameterException;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;

/**
 * Classe que serve para validar se os parametros sao nulos ou vazios.
 */
public class ParameterExceptionUtil {

    private ParameterExceptionUtil() {}

    public static void validateObjectNull(Object valor){
        if(valor == null){
            throw new NullParameterException("Parametro objeto nulo.");
        }
    }

    public static void validateCollectionNull(Collection lista){
        if(CollectionUtils.isEmpty(lista)) {
            throw new NullParameterException("Parametro collection nulo.");
        }
    }

}
