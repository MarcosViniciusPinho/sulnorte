package com.sulnorte.frota.dto.util;

import com.sulnorte.frota.exception.NullParameterException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplaceUtilUnitTest {

	@Test
	public void testSomenteNumerosParaCnpj(){
		Long cnpjSomenteNumeros = 72039912000188L;
		String cnpjComMascara = "72.039.912/0001-88";
		Assert.assertNotNull(ReplaceUtil.somenteNumerosParaCnpj(cnpjComMascara));
		Assert.assertEquals(cnpjSomenteNumeros, ReplaceUtil.somenteNumerosParaCnpj(cnpjComMascara));
	}

	@Test
	public void testSomenteNumerosParaCnpjComValorNull(){
		Assert.assertNull(ReplaceUtil.somenteNumerosParaCnpj(null));
	}

	@Test
	public void testSomenteTexto(){
		List<String> lista = new ArrayList<>();
		lista.add("Teste");
		String textoEsperado = "Teste";
		Assert.assertNotNull(ReplaceUtil.somenteTexto(lista));
		Assert.assertEquals(textoEsperado, ReplaceUtil.somenteTexto(lista));
	}

	@Test(expected = NullParameterException.class)
	public void testSomenteTextoComFalha(){
		List<String> lista = new ArrayList<>();
		String textoEsperado = "";
		Assert.assertNotNull(ReplaceUtil.somenteTexto(lista));
		Assert.assertEquals(textoEsperado, ReplaceUtil.somenteTexto(lista));
	}

}
