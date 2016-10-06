package com.sulnorte.frota.dto;

import com.sulnorte.frota.entity.Municipio;
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
public class MunicipioDTOUnitTest {

	@Test
	public void testToEntity(){
		Municipio municipioEsperado = new Municipio();
		municipioEsperado.setId(1L);
		MunicipioDTO municipioDTO = new MunicipioDTO();
		municipioDTO.setId(1L);
		Municipio municipioAtual = municipioDTO.toEntity();
		Assert.assertNotNull(municipioAtual);
		Assert.assertEquals(municipioEsperado, municipioAtual);
	}

	@Test(expected = NullPointerException.class)
	public void testToEntityComFalha(){
		Assert.assertNotNull(new MunicipioDTO().toEntity());
		Assert.assertEquals(new Municipio(), new MunicipioDTO().toEntity());
	}

	@Test
	public void testToDto(){
		Municipio municipio = new Municipio();
		municipio.setId(1L);
		MunicipioDTO municipioAtual = MunicipioDTO.toDto(municipio);
		MunicipioDTO municipioEsperado = new MunicipioDTO();
		municipioEsperado.setId(1L);
		Assert.assertNotNull(municipioAtual);
		Assert.assertEquals(municipioEsperado, municipioAtual);
	}

	@Test(expected = NullPointerException.class)
	public void testToDtoComFalha(){
		Assert.assertNotNull(MunicipioDTO.toDto(new Municipio()));
		Assert.assertEquals(new MunicipioDTO(), MunicipioDTO.toDto(new Municipio()));
	}

	@Test(expected = NullParameterException.class)
	public void testToDtoNullComFalha(){
		MunicipioDTO municipioAtual = MunicipioDTO.toDto(null);
		Assert.assertNull(municipioAtual);
	}

	@Test
	public void testConvertListEntityToListDto(){
		List<Municipio> listaEntidade = new ArrayList<Municipio>();
		List<MunicipioDTO> listaDtoEsperado = new ArrayList<MunicipioDTO>();
		Municipio municipio = new Municipio();
		municipio.setId(1L);
		listaEntidade.add(municipio);
		MunicipioDTO municipioDTO = new MunicipioDTO();
		municipioDTO.setId(1L);
		listaDtoEsperado.add(municipioDTO);
		List<MunicipioDTO> listaDtoAtual = MunicipioDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test(expected = NullPointerException.class)
	public void testConvertListEntityToListDtoComFalha(){
		List<Municipio> listaEntidade = new ArrayList<Municipio>();
		listaEntidade.add(new Municipio());
		List<MunicipioDTO> listaDtoEsperado = new ArrayList<MunicipioDTO>();
		listaDtoEsperado.add(new MunicipioDTO());
		List<MunicipioDTO> listaDtoAtual = MunicipioDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test(expected = NullParameterException.class)
	public void testConvertListEntityToListDtoNullComFalha(){
		List<MunicipioDTO> listaDtoEsperado = new ArrayList<MunicipioDTO>();
		List<MunicipioDTO> listaDtoAtual = MunicipioDTO.convertListEntityToListDto(null);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}
}
