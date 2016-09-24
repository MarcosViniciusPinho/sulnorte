package com.sulnorte.frota.util;

import com.sulnorte.frota.dto.util.ReplaceUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

	@Test(expected = AssertionError.class)
	public void testSomenteNumerosParaCnpjComFalha(){
		Long cnpjSomenteNumeros = 1L;
		String cnpjComMascara = "72.039.912/0001-88";
		Assert.assertNotNull(ReplaceUtil.somenteNumerosParaCnpj(cnpjComMascara));
		Assert.assertEquals(cnpjSomenteNumeros, ReplaceUtil.somenteNumerosParaCnpj(cnpjComMascara));
	}


}
