package com.sulnorte.frota.dto;

import com.sulnorte.frota.entity.Armador;
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
public class ArmadorDTOUnitTest {

	@Test
	public void testToEntity(){
		Armador armadorEsperado = new Armador();
		armadorEsperado.setId(1L);
		ArmadorDTO armadorDTO = new ArmadorDTO();
		armadorDTO.setId(1L);
		Armador armadorAtual = armadorDTO.toEntity();
		Assert.assertNotNull(armadorAtual);
		Assert.assertEquals(armadorEsperado, armadorAtual);
	}

	@Test
	public void testToDto(){
		Armador armador = new Armador();
		armador.setId(1L);
		ArmadorDTO armadorAtual = ArmadorDTO.toDto(armador);
		ArmadorDTO armadorEsperado = new ArmadorDTO();
		armadorEsperado.setId(1L);
		Assert.assertNotNull(armadorAtual);
		Assert.assertEquals(armadorEsperado, armadorAtual);
	}

	@Test(expected = NullParameterException.class)
	public void testToDtoNullComFalha(){
		ArmadorDTO armadorAtual = ArmadorDTO.toDto(null);
		Assert.assertNull(armadorAtual);
	}

	@Test
	public void testConvertListEntityToListDto(){
		List<Armador> listaEntidade = new ArrayList<Armador>();
		List<ArmadorDTO> listaDtoEsperado = new ArrayList<ArmadorDTO>();
		Armador armador = new Armador();
		armador.setId(1L);
		listaEntidade.add(armador);
		ArmadorDTO armadorDTO = new ArmadorDTO();
		armadorDTO.setId(1L);
		listaDtoEsperado.add(armadorDTO);
		List<ArmadorDTO> listaDtoAtual = ArmadorDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test(expected = NullPointerException.class)
	public void testConvertListEntityToListDtoComFalha(){
		List<Armador> listaEntidade = new ArrayList<Armador>();
		listaEntidade.add(new Armador());
		List<ArmadorDTO> listaDtoEsperado = new ArrayList<ArmadorDTO>();
		listaDtoEsperado.add(new ArmadorDTO());
		List<ArmadorDTO> listaDtoAtual = ArmadorDTO.convertListEntityToListDto(listaEntidade);
		Assert.assertNotNull(listaDtoAtual);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testConvertListEntityToListDtoNull(){
		List<ArmadorDTO> listaDtoEsperado = new ArrayList<ArmadorDTO>();
		List<ArmadorDTO> listaDtoAtual = ArmadorDTO.convertListEntityToListDto(null);
		Assert.assertEquals(listaDtoEsperado, listaDtoAtual);
	}

	@Test
	public void testBeforeFromSaveConvertToArmador(){
		Armador armadorEsperado = new Armador();
		armadorEsperado.setId(1L);
		Armador armadorOther = new Armador();
		armadorOther.setId(1L);
		Armador armadorAtual = ArmadorDTO.beforeFromSaveConvertToArmador(armadorOther);
		Assert.assertNotNull(armadorAtual);
		Assert.assertEquals(armadorEsperado, armadorAtual);
	}

	@Test(expected = NullParameterException.class)
	public void testBeforeFromSaveConvertToArmadorNullComFalha(){
		Assert.assertNotNull(ArmadorDTO.beforeFromSaveConvertToArmador(null));
	}

	@Test
	public void testGetPortosEscolhidos(){
		Porto porto = new Porto();
		porto.setId(1L);
		List<Porto> portoList = new ArrayList<Porto>();
		portoList.add(porto);
		ArmadorDTO armadorDTO = new ArmadorDTO();
		armadorDTO.setPortoList(portoList);
		String textoEsperado = portoList.toString().replace("[","").replace("]","");
		Assert.assertNotNull(armadorDTO.getPortosEscolhidos());
		Assert.assertEquals(textoEsperado, armadorDTO.getPortosEscolhidos());
	}

	@Test(expected = NullParameterException.class)
	public void testGetPortosEscolhidosComFalha(){
		List<Porto> portoList = new ArrayList<Porto>();
		ArmadorDTO armadorDTO = new ArmadorDTO();
		armadorDTO.setPortoList(portoList);
		String textoEsperado = portoList.toString().replace("[","").replace("]","");
		Assert.assertNotNull(armadorDTO.getPortosEscolhidos());
		Assert.assertEquals(textoEsperado, armadorDTO.getPortosEscolhidos());
	}
}
