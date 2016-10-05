package com.sulnorte.frota.dto.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatternUtilUnitTest {

	@Test
	public void testMascaraPadraoCnpj(){
		String cnpjEsperado = "72.039.912/0001-88";
		Assert.assertNotNull(PatternUtil.mascaraPadraoCnpj(72039912000188L));
		Assert.assertEquals(cnpjEsperado, PatternUtil.mascaraPadraoCnpj(72039912000188L));
	}

	@Test
	public void testMascaraPadraoCnpjNull(){
		Assert.assertNull(PatternUtil.mascaraPadraoCnpj(null));
	}

	@Test
	public void testMascaraPadraoDecimalBr(){
		String valorEsperado = "87.765,32";
		Assert.assertNotNull(PatternUtil.mascaraPadraoDecimalBr(new BigDecimal("87765.32")));
		Assert.assertEquals(valorEsperado, PatternUtil.mascaraPadraoDecimalBr(new BigDecimal("87765.32")));
	}

	@Test
	public void testMascaraPadraoDecimalBrNull(){
		Assert.assertNull(PatternUtil.mascaraPadraoDecimalBr(null));
	}

}
