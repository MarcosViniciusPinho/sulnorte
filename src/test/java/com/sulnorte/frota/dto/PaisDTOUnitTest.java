package com.sulnorte.frota.dto;

import com.sulnorte.frota.entity.Pais;
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
public class PaisDTOUnitTest {

	@Test
	public void testToEntity(){
		Pais paisEsperado = new Pais();
		paisEsperado.setId(1L);
		PaisDTO paisDTO = new PaisDTO();
		paisDTO.setId(1L);
		Pais paisAtual = paisDTO.toEntity();
		Assert.assertNotNull(paisAtual);
		Assert.assertEquals(paisEsperado, paisAtual);
	}

	@Test
	public void testToEntity2(){
		Assert.assertNotNull(new PaisDTO().toEntity());
		Assert.assertEquals(new Pais(), new PaisDTO().toEntity());
	}

	@Test
	public void testToDto(){
		Pais pais = new Pais();
		pais.setId(1L);
		PaisDTO paisAtual = PaisDTO.toDto(pais);
		PaisDTO paisEsperado = new PaisDTO();
		paisEsperado.setId(1L);
		Assert.assertNotNull(paisAtual);
		Assert.assertEquals(paisEsperado, paisAtual);
	}

	@Test
	public void testToDto2(){
		Assert.assertNotNull(PaisDTO.toDto(new Pais()));
		Assert.assertEquals(new PaisDTO(), PaisDTO.toDto(new Pais()));
	}

	@Test(expected = NullParameterException.class)
	public void testToDtoNullComFalha(){
		PaisDTO paisAtual = PaisDTO.toDto(null);
		Assert.assertNull(paisAtual);
	}

	@Test
	public void testConvertListEntityToListDto(){
		List<Pais> listaEntidade = new ArrayList<Pais>();
		List<PaisDTO> listaDtoEsperado = new ArrayList<PaisDTO>();
		Pais pais = new Pais();
		pais.setId(1L);
		listaEntidade.add(pais);
		PaisDTO paisDTO = new PaisDTO();
		paisDTO.setId(1L);
		listaDtoEsperado.add(paisDTO);
		List<PaisDTO> listaDtoAtual = PaisDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testConvertListEntityToListDto2(){
		List<Pais> listaEntidade = new ArrayList<Pais>();
		listaEntidade.add(new Pais());
		List<PaisDTO> listaDtoEsperado = new ArrayList<PaisDTO>();
		listaDtoEsperado.add(new PaisDTO());
		List<PaisDTO> listaDtoAtual = PaisDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test(expected = NullParameterException.class)
	public void testConvertListEntityToListDtoNullComFalha(){
		List<PaisDTO> listaDtoEsperado = new ArrayList<PaisDTO>();
		List<PaisDTO> listaDtoAtual = PaisDTO.convertListEntityToListDto(null);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}
}
