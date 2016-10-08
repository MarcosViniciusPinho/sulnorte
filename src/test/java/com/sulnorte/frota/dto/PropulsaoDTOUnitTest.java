package com.sulnorte.frota.dto;

import com.sulnorte.frota.entity.Propulsao;
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
public class PropulsaoDTOUnitTest {

	@Test
	public void testToEntity(){
		Propulsao propulsaoEsperado = new Propulsao();
		propulsaoEsperado.setId(1L);
		PropulsaoDTO propulsaoDTO = new PropulsaoDTO();
		propulsaoDTO.setId(1L);
		Propulsao propulsaoAtual = propulsaoDTO.toEntity();
		Assert.assertNotNull(propulsaoAtual);
		Assert.assertEquals(propulsaoEsperado, propulsaoAtual);
	}

	@Test
	public void testToEntity2(){
		PropulsaoDTO propulsaoDTO = new PropulsaoDTO();
		Assert.assertNotNull(propulsaoDTO.toEntity());
		Assert.assertEquals(new Propulsao(), propulsaoDTO.toEntity());
	}

	@Test
	public void testToDto(){
		Propulsao propulsao = new Propulsao();
		propulsao.setId(1L);
		PropulsaoDTO propulsaoAtual = PropulsaoDTO.toDto(propulsao);
		PropulsaoDTO propulsaoEsperado = new PropulsaoDTO();
		propulsaoEsperado.setId(1L);
		Assert.assertNotNull(propulsaoAtual);
		Assert.assertEquals(propulsaoEsperado, propulsaoAtual);
	}

	@Test
	public void testToDto2(){
		Assert.assertNotNull(PropulsaoDTO.toDto(new Propulsao()));
		Assert.assertEquals(new PropulsaoDTO(), PropulsaoDTO.toDto(new Propulsao()));
	}

	@Test(expected = NullParameterException.class)
	public void testToDtoNullComFalha(){
		PropulsaoDTO propulsaoAtual = PropulsaoDTO.toDto(null);
		Assert.assertNull(propulsaoAtual);
	}

	@Test
	public void testConvertListEntityToListDto(){
		List<Propulsao> listaEntidade = new ArrayList<Propulsao>();
		List<PropulsaoDTO> listaDtoEsperado = new ArrayList<PropulsaoDTO>();
		Propulsao propulsao = new Propulsao();
		propulsao.setId(1L);
		listaEntidade.add(propulsao);
		PropulsaoDTO propulsaoDTO = new PropulsaoDTO();
		propulsaoDTO.setId(1L);
		listaDtoEsperado.add(propulsaoDTO);
		List<PropulsaoDTO> listaDtoAtual = PropulsaoDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testConvertListEntityToListDto2(){
		List<Propulsao> listaEntidade = new ArrayList<Propulsao>();
		listaEntidade.add(new Propulsao());
		List<PropulsaoDTO> listaDtoEsperado = new ArrayList<PropulsaoDTO>();
		listaDtoEsperado.add(new PropulsaoDTO());
		List<PropulsaoDTO> listaDtoAtual = PropulsaoDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test(expected = NullParameterException.class)
	public void testConvertListEntityToListDtoNullComFalha(){
		List<PropulsaoDTO> listaDtoEsperado = new ArrayList<PropulsaoDTO>();
		List<PropulsaoDTO> listaDtoAtual = PropulsaoDTO.convertListEntityToListDto(null);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}
}
