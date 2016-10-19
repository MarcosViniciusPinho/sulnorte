package com.sulnorte.frota.exception.util;

import com.sulnorte.frota.exception.NullParameterException;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;

/**
 * Classe que serve para validar se os parametros sao nulos ou vazios.
 */
public class ParameterExceptionUtil {

    private ParameterExceptionUtil() {}

    /**
     * Método que serve para validar se o objeto informado é nulo.
     * @param valor valor
     */
    public static void validateObjectNull(Object valor){
        if(valor == null){
            throw new NullParameterException("Parametro objeto nulo.");
        }
    }

    /**
     * Método que serve para validar se a lista informada é nula.
     * @param lista lista
     */
    public static void validateCollectionNull(Collection lista){
        if(CollectionUtils.isEmpty(lista)) {
            throw new NullParameterException("Parametro collection nulo.");
        }
    }

}
