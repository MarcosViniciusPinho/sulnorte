package com.sulnorte.frota.dto;

import com.sulnorte.frota.entity.Porto;
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
public class PortoDTOUnitTest {

	@Test
	public void testToEntity(){
		Porto portoEsperado = new Porto();
		portoEsperado.setId(1L);
		PortoDTO portoDTO = new PortoDTO();
		portoDTO.setId(1L);
		Porto portoAtual = portoDTO.toEntity();
		Assert.assertNotNull(portoAtual);
		Assert.assertEquals(portoEsperado, portoAtual);
	}

	@Test
	public void testToEntity2(){
		PortoDTO portoDTO = new PortoDTO();
		Assert.assertNotNull(portoDTO.toEntity());
		Assert.assertEquals(new Porto(), portoDTO.toEntity());
	}

	@Test
	public void testToDto(){
		Porto porto = new Porto();
		porto.setId(1L);
		PortoDTO portoAtual = PortoDTO.toDto(porto);
		PortoDTO portoEsperado = new PortoDTO();
		portoEsperado.setId(1L);
		Assert.assertNotNull(portoAtual);
		Assert.assertEquals(portoEsperado, portoAtual);
	}

	@Test
	public void testToDto2(){
		Assert.assertNotNull(PortoDTO.toDto(new Porto()));
		Assert.assertEquals(new PortoDTO(), PortoDTO.toDto(new Porto()));
	}

	@Test(expected = NullParameterException.class)
	public void testToDtoNullComFalha(){
		PortoDTO portoAtual = PortoDTO.toDto(null);
		Assert.assertNull(portoAtual);
	}

	@Test
	public void testConvertListEntityToListDto(){
		List<Porto> listaEntidade = new ArrayList<Porto>();
		List<PortoDTO> listaDtoEsperado = new ArrayList<PortoDTO>();
		Porto porto = new Porto();
		porto.setId(1L);
		listaEntidade.add(porto);
		PortoDTO portoDTO = new PortoDTO();
		portoDTO.setId(1L);
		listaDtoEsperado.add(portoDTO);
		List<PortoDTO> listaDtoAtual = PortoDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testConvertListEntityToListDto2(){
		List<Porto> listaEntidade = new ArrayList<Porto>();
		listaEntidade.add(new Porto());
		List<PortoDTO> listaDtoEsperado = new ArrayList<PortoDTO>();
		listaDtoEsperado.add(new PortoDTO());
		List<PortoDTO> listaDtoAtual = PortoDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testConvertListEntityToListDtoNull(){
		List<PortoDTO> listaDtoEsperado = new ArrayList<PortoDTO>();
		List<PortoDTO> listaDtoAtual = PortoDTO.convertListEntityToListDto(null);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testBeforeFromSaveConvertToPorto(){
		Porto portoEsperado = new Porto();
		portoEsperado.setId(1L);
		Porto portoOther = new Porto();
		portoOther.setId(1L);
		Porto portoAtual = PortoDTO.beforeFromSaveConvertToPorto(portoOther);
		Assert.assertNotNull(portoAtual);
		Assert.assertEquals(portoEsperado, portoAtual);
	}

	@Test(expected = NullParameterException.class)
	public void testBeforeFromSaveConvertToPortoNullComFalha(){
		Assert.assertNotNull(PortoDTO.beforeFromSaveConvertToPorto(null));
	}

	@Test
	public void testToString(){
		PortoDTO portoEsperado = new PortoDTO();
		portoEsperado.setId(1L);
		portoEsperado.setNome("Porto");
		List<PortoDTO> portoListEsperado = new ArrayList<PortoDTO>();
		portoListEsperado.add(portoEsperado);
		PortoDTO portoAtual = new PortoDTO();
		portoAtual.setId(1L);
		portoAtual.setNome("Porto");
		List<PortoDTO> portoListAtual = new ArrayList<PortoDTO>();
		portoListAtual.add(portoAtual);
		Assert.assertNotNull(portoListAtual);
		Assert.assertEquals(portoListEsperado, portoListAtual);
	}
}
