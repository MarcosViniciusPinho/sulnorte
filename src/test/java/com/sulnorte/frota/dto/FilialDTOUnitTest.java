package com.sulnorte.frota.dto;

import com.sulnorte.frota.entity.Filial;
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
public class FilialDTOUnitTest {

	@Test
	public void testToEntity(){
		Filial filialEsperado = new Filial();
		filialEsperado.setId(1L);
		FilialDTO filialDTO = new FilialDTO();
		filialDTO.setId(1L);
		Filial filialAtual = filialDTO.toEntity();
		Assert.assertNotNull(filialAtual);
		Assert.assertEquals(filialEsperado, filialAtual);
	}

	@Test
	public void testToEntity2(){
		FilialDTO filialDTO = new FilialDTO();
		Assert.assertNotNull(filialDTO.toEntity());
		Assert.assertEquals(new Filial(), filialDTO.toEntity());
	}

	@Test
	public void testToDto(){
		Filial filial = new Filial();
		filial.setId(1L);
		FilialDTO filialAtual = FilialDTO.toDto(filial);
		FilialDTO filialEsperado = new FilialDTO();
		filialEsperado.setId(1L);
		Assert.assertNotNull(filialAtual);
		Assert.assertEquals(filialEsperado, filialAtual);
	}

	@Test
	public void testToDto2(){
		Assert.assertNotNull(FilialDTO.toDto(new Filial()));
		Assert.assertEquals(new FilialDTO(), FilialDTO.toDto(new Filial()));
	}

	@Test(expected = NullParameterException.class)
	public void testToDtoNullComFalha(){
		FilialDTO filialAtual = FilialDTO.toDto(null);
		Assert.assertNull(filialAtual);
	}

	@Test
	public void testConvertListEntityToListDto(){
		List<Filial> listaEntidade = new ArrayList<Filial>();
		List<FilialDTO> listaDtoEsperado = new ArrayList<FilialDTO>();
		Filial filial = new Filial();
		filial.setId(1L);
		listaEntidade.add(filial);
		FilialDTO filialDTO = new FilialDTO();
		filialDTO.setId(1L);
		listaDtoEsperado.add(filialDTO);
		List<FilialDTO> listaDtoAtual = FilialDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testConvertListEntityToListDto2(){
		List<Filial> listaEntidade = new ArrayList<Filial>();
		listaEntidade.add(new Filial());
		List<FilialDTO> listaDtoEsperado = new ArrayList<FilialDTO>();
		listaDtoEsperado.add(new FilialDTO());
		List<FilialDTO> listaDtoAtual = FilialDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test(expected = NullParameterException.class)
	public void testConvertListEntityToListDtoNullComFalha(){
		List<FilialDTO> listaDtoEsperado = new ArrayList<FilialDTO>();
		List<FilialDTO> listaDtoAtual = FilialDTO.convertListEntityToListDto(null);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}
}
