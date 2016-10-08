package com.sulnorte.frota.dto;

import com.sulnorte.frota.entity.SituacaoRebocador;
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
public class SituacaoRebocadorDTOUnitTest {

	@Test
	public void testToEntity(){
		SituacaoRebocador situacaoRebocadorEsperado = new SituacaoRebocador();
		situacaoRebocadorEsperado.setId(1L);
		SituacaoRebocadorDTO situacaoRebocadorDTO = new SituacaoRebocadorDTO();
		situacaoRebocadorDTO.setId(1L);
		SituacaoRebocador situacaoRebocadorAtual = situacaoRebocadorDTO.toEntity();
		Assert.assertNotNull(situacaoRebocadorAtual);
		Assert.assertEquals(situacaoRebocadorEsperado, situacaoRebocadorAtual);
	}

	@Test
	public void testToEntity2(){
		SituacaoRebocadorDTO situacaoRebocadorDTO = new SituacaoRebocadorDTO();
		Assert.assertNotNull(situacaoRebocadorDTO.toEntity());
		Assert.assertEquals(new SituacaoRebocador(), situacaoRebocadorDTO.toEntity());
	}

	@Test
	public void testToDto(){
		SituacaoRebocador situacaoRebocador = new SituacaoRebocador();
		situacaoRebocador.setId(1L);
		SituacaoRebocadorDTO situacaoRebocadorAtual = SituacaoRebocadorDTO.toDto(situacaoRebocador);
		SituacaoRebocadorDTO situacaoRebocadorEsperado = new SituacaoRebocadorDTO();
		situacaoRebocadorEsperado.setId(1L);
		Assert.assertNotNull(situacaoRebocadorAtual);
		Assert.assertEquals(situacaoRebocadorEsperado, situacaoRebocadorAtual);
	}

	@Test
	public void testToDto2(){
		Assert.assertNotNull(SituacaoRebocadorDTO.toDto(new SituacaoRebocador()));
		Assert.assertEquals(new SituacaoRebocadorDTO(), SituacaoRebocadorDTO.toDto(new SituacaoRebocador()));
	}

	@Test(expected = NullParameterException.class)
	public void testToDtoNullComFalha(){
		SituacaoRebocadorDTO situacaoRebocadorAtual = SituacaoRebocadorDTO.toDto(null);
		Assert.assertNull(situacaoRebocadorAtual);
	}

	@Test
	public void testConvertListEntityToListDto(){
		List<SituacaoRebocador> listaEntidade = new ArrayList<SituacaoRebocador>();
		List<SituacaoRebocadorDTO> listaDtoEsperado = new ArrayList<SituacaoRebocadorDTO>();
		SituacaoRebocador situacaoRebocador = new SituacaoRebocador();
		situacaoRebocador.setId(1L);
		listaEntidade.add(situacaoRebocador);
		SituacaoRebocadorDTO situacaoRebocadorDTO = new SituacaoRebocadorDTO();
		situacaoRebocadorDTO.setId(1L);
		listaDtoEsperado.add(situacaoRebocadorDTO);
		List<SituacaoRebocadorDTO> listaDtoAtual = SituacaoRebocadorDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testConvertListEntityToListDto2(){
		List<SituacaoRebocador> listaEntidade = new ArrayList<SituacaoRebocador>();
		listaEntidade.add(new SituacaoRebocador());
		List<SituacaoRebocadorDTO> listaDtoEsperado = new ArrayList<SituacaoRebocadorDTO>();
		listaDtoEsperado.add(new SituacaoRebocadorDTO());
		List<SituacaoRebocadorDTO> listaDtoAtual = SituacaoRebocadorDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test(expected = NullParameterException.class)
	public void testConvertListEntityToListDtoNullComFalha(){
		List<SituacaoRebocadorDTO> listaDtoEsperado = new ArrayList<SituacaoRebocadorDTO>();
		List<SituacaoRebocadorDTO> listaDtoAtual = SituacaoRebocadorDTO.convertListEntityToListDto(null);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}
}
