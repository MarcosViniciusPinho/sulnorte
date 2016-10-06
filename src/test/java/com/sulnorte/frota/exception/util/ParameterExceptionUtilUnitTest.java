package com.sulnorte.frota.exception.util;

import com.sulnorte.frota.exception.NullParameterException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParameterExceptionUtilUnitTest {

	@Test(expected = NullParameterException.class)
	public void testValidateObjectNullComFalha(){
		ParameterExceptionUtil.validateObjectNull(null);
	}

	@Test
	public void testValidateObject(){
		ParameterExceptionUtil.validateObjectNull(BigDecimal.ONE);
	}

	@Test(expected = NullParameterException.class)
	public void testValidateCollectionNullComFalha(){
		ParameterExceptionUtil.validateCollectionNull(null);
	}

	@Test
	public void testValidateCollection(){
		List<String> lista = new ArrayList<String>();
		lista.add("A");
		ParameterExceptionUtil.validateCollectionNull(lista);
	}

}
