package com.sulnorte.frota.dto;

import com.sulnorte.frota.entity.Rebocador;
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
public class RebocadorDTOUnitTest {

	@Test
	public void testToEntity(){
		Rebocador rebocadorEsperado = new Rebocador();
		rebocadorEsperado.setId(1L);
		RebocadorDTO rebocadorDTO = new RebocadorDTO();
		rebocadorDTO.setId(1L);
		Rebocador rebocadorAtual = rebocadorDTO.toEntity();
		Assert.assertNotNull(rebocadorAtual);
		Assert.assertEquals(rebocadorEsperado, rebocadorAtual);
	}

	@Test
	public void testToEntity2(){
		RebocadorDTO rebocadorDTO = new RebocadorDTO();
		Assert.assertNotNull(rebocadorDTO.toEntity());
		Assert.assertEquals(new Rebocador(), rebocadorDTO.toEntity());
	}

	@Test
	public void testToDto(){
		Rebocador rebocador = new Rebocador();
		rebocador.setId(1L);
		RebocadorDTO rebocadorAtual = RebocadorDTO.toDto(rebocador);
		RebocadorDTO rebocadorEsperado = new RebocadorDTO();
		rebocadorEsperado.setId(1L);
		Assert.assertNotNull(rebocadorAtual);
		Assert.assertEquals(rebocadorEsperado, rebocadorAtual);
	}

	@Test
	public void testToDto2(){
		Assert.assertNotNull(RebocadorDTO.toDto(new Rebocador()));
		Assert.assertEquals(new RebocadorDTO(), RebocadorDTO.toDto(new Rebocador()));
	}

	@Test(expected = NullParameterException.class)
	public void testToDtoNullComFalha(){
		RebocadorDTO rebocadorAtual = RebocadorDTO.toDto(null);
		Assert.assertNull(rebocadorAtual);
	}

	@Test
	public void testConvertListEntityToListDto(){
		List<Rebocador> listaEntidade = new ArrayList<Rebocador>();
		List<RebocadorDTO> listaDtoEsperado = new ArrayList<RebocadorDTO>();
		Rebocador rebocador = new Rebocador();
		rebocador.setId(1L);
		listaEntidade.add(rebocador);
		RebocadorDTO rebocadorDTO = new RebocadorDTO();
		rebocadorDTO.setId(1L);
		listaDtoEsperado.add(rebocadorDTO);
		List<RebocadorDTO> listaDtoAtual = RebocadorDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testConvertListEntityToListDto2(){
		List<Rebocador> listaEntidade = new ArrayList<Rebocador>();
		listaEntidade.add(new Rebocador());
		List<RebocadorDTO> listaDtoEsperado = new ArrayList<RebocadorDTO>();
		listaDtoEsperado.add(new RebocadorDTO());
		List<RebocadorDTO> listaDtoAtual = RebocadorDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testConvertListEntityToListDtoNull(){
		List<RebocadorDTO> listaDtoEsperado = new ArrayList<RebocadorDTO>();
		List<RebocadorDTO> listaDtoAtual = RebocadorDTO.convertListEntityToListDto(null);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testBeforeFromSaveConvertToRebocador(){
		Rebocador rebocadorEsperado = new Rebocador();
		rebocadorEsperado.setId(1L);
		Rebocador rebocadorOther = new Rebocador();
		rebocadorOther.setId(1L);
		Rebocador rebocadorAtual = RebocadorDTO.beforeFromSaveConvertToRebocador(rebocadorOther);
		Assert.assertNotNull(rebocadorAtual);
		Assert.assertEquals(rebocadorEsperado, rebocadorAtual);
	}

	@Test(expected = NullParameterException.class)
	public void testBeforeFromSaveConvertToRebocadorNullComFalha(){
		Assert.assertNotNull(RebocadorDTO.beforeFromSaveConvertToRebocador(null));
	}
}
