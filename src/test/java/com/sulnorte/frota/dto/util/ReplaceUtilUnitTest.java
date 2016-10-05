package com.sulnorte.frota.dto.util;

import com.sulnorte.frota.exception.NullParameterException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplaceUtilUnitTest {

	@Test
	public void testRetirarMascaraPadraoCnpj(){
		Long cnpjSomenteNumeros = 72039912000188L;
		String cnpjComMascara = "72.039.912/0001-88";
		Assert.assertNotNull(ReplaceUtil.retirarMascaraPadraoCnpj(cnpjComMascara));
		Assert.assertEquals(cnpjSomenteNumeros, ReplaceUtil.retirarMascaraPadraoCnpj(cnpjComMascara));
	}

	@Test
	public void testRetirarMascaraPadraoCnpjNull(){
		Assert.assertNull(ReplaceUtil.retirarMascaraPadraoCnpj(null));
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

	@Test
	public void testRetirarMascaraPadraoDecimalBr(){
		BigDecimal valorEsperado = new BigDecimal("736482.32");
		Assert.assertNotNull(ReplaceUtil.retirarMascaraPadraoDecimalBr("736.482,32"));
		Assert.assertEquals(valorEsperado, ReplaceUtil.retirarMascaraPadraoDecimalBr("736.482,32"));
	}

	@Test
	public void testRetirarMascaraPadraoDecimalBrNull(){
		Assert.assertNull(ReplaceUtil.retirarMascaraPadraoDecimalBr(null));
	}

}
