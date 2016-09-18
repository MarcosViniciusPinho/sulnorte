package com.sulnorte.frota.dto;

import com.sulnorte.frota.entity.Estado;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoDTOUnitTest {

	@Test
	public void testToEntity(){
		Estado estadoEsperado = new Estado();
		estadoEsperado.setId(1L);
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(1L);
		Estado estadoAtual = estadoDTO.toEntity();
		Assert.assertNotNull(estadoAtual);
		Assert.assertEquals(estadoEsperado, estadoAtual);
	}

	@Test(expected = AssertionError.class)
	public void testToEntityComFalha(){
		Estado estadoEsperado = new Estado();
		estadoEsperado.setId(2L);
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(1L);
		Estado estadoAtual = estadoDTO.toEntity();
		Assert.assertNotNull(estadoAtual);
		Assert.assertEquals(estadoEsperado, estadoAtual);
	}

	@Test
	public void testToDto(){
		Estado estado = new Estado();
		estado.setId(1L);
		EstadoDTO estadoAtual = EstadoDTO.toDto(estado);
		EstadoDTO estadoEsperado = new EstadoDTO();
		estadoEsperado.setId(1L);
		Assert.assertNotNull(estadoAtual);
		Assert.assertEquals(estadoEsperado, estadoAtual);
	}

	@Test(expected = AssertionError.class)
	public void testToDtoComFalha(){
		Estado estado = new Estado();
		estado.setId(2L);
		EstadoDTO estadoAtual = EstadoDTO.toDto(estado);
		EstadoDTO estadoEsperado = new EstadoDTO();
		estadoEsperado.setId(1L);
		Assert.assertNotNull(estadoAtual);
		Assert.assertEquals(estadoEsperado, estadoAtual);
	}

	@Test
	public void testToDtoNull(){
		EstadoDTO estadoAtual = EstadoDTO.toDto(null);
		Assert.assertNull(estadoAtual);
	}

	@Test(expected = AssertionError.class)
	public void testToDtoNullComFalha(){
		EstadoDTO estadoAtual = EstadoDTO.toDto(null);
		Assert.assertNotNull(estadoAtual);
	}

	@Test
	public void testConvertListEntityToListDto(){
		List<Estado> listaEntidade = new ArrayList<Estado>();
		List<EstadoDTO> listaDtoEsperado = new ArrayList<EstadoDTO>();
		Estado estado = new Estado();
		estado.setId(1L);
		listaEntidade.add(estado);
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(1L);
		listaDtoEsperado.add(estadoDTO);
		List<EstadoDTO> listaDtoAtual = EstadoDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test(expected = AssertionError.class)
	public void testConvertListEntityToListDtoComFalha(){
		List<Estado> listaEntidade = new ArrayList<Estado>();
		Estado estado = new Estado();
		estado.setId(2L);
		listaEntidade.add(estado);
		List<EstadoDTO> listaDtoEsperado = new ArrayList<EstadoDTO>();
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(1L);
		listaDtoEsperado.add(estadoDTO);
		List<EstadoDTO> listaDtoAtual = EstadoDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test(expected = NullPointerException.class)
	public void testConvertListEntityToListDtoComFalha2(){
		List<Estado> listaEntidade = new ArrayList<Estado>();
		listaEntidade.add(new Estado());
		List<EstadoDTO> listaDtoEsperado = new ArrayList<EstadoDTO>();
		listaDtoEsperado.add(new EstadoDTO());
		List<EstadoDTO> listaDtoAtual = EstadoDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testConvertListEntityToListDtoNull(){
		List<EstadoDTO> listaDtoEsperado = new ArrayList<EstadoDTO>();
		List<EstadoDTO> listaDtoAtual = EstadoDTO.convertListEntityToListDto(null);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test(expected = AssertionError.class)
	public void testConvertListEntityToListDtoNullComFalha(){
		List<EstadoDTO> listaDtoEsperado = new ArrayList<EstadoDTO>();
		listaDtoEsperado.add(new EstadoDTO());
		List<EstadoDTO> listaDtoAtual = EstadoDTO.convertListEntityToListDto(null);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}
}
