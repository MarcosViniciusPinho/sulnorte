package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.service.IArmadorService;
import com.sulnorte.frota.business.service.IRebocadorService;
import com.sulnorte.frota.dto.ArmadorDTO;
import com.sulnorte.frota.entity.Armador;
import com.sulnorte.frota.entity.Rebocador;
import com.sulnorte.frota.exception.NullParameterException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArmadorFacadeUnitTest {

	@InjectMocks
	private ArmadorFacade<Armador> armadorFacade;

	@Mock
	private IArmadorService armadorService;

	@Mock
	private IRebocadorService rebocadorService;


	@Test
	public void testFindAllArmadorNaoUsado(){
		Armador armador = new Armador();
		armador.setId(1L);
		List<ArmadorDTO> listaEsperada = new ArrayList<ArmadorDTO>();
		listaEsperada.add(ArmadorDTO.toDto(armador));
		List<Armador> armadorList = new ArrayList<Armador>();
		armadorList.add(armador);
		Mockito.when(this.armadorService.findAllByOrderByNomeAsc()).thenReturn(armadorList);
		Mockito.when(this.rebocadorService.findFirstByArmadorId(armador.getId())).thenReturn(null);
		Assert.assertNotNull(this.armadorFacade.findAll());
		Assert.assertEquals(listaEsperada, this.armadorFacade.findAll());
	}

	@Test(expected = NullParameterException.class)
	public void testFindAllArmadorNaoUsadoComFalha(){
		List<ArmadorDTO> listaEsperada = new ArrayList<ArmadorDTO>();
		listaEsperada.add(ArmadorDTO.toDto(new Armador()));
		List<Armador> armadorList = new ArrayList<Armador>();
		armadorList.add(new Armador());
		Mockito.when(this.armadorService.findAllByOrderByNomeAsc()).thenReturn(armadorList);
		Mockito.when(this.rebocadorService.findFirstByArmadorId(1L)).thenReturn(null);
		Assert.assertNotNull(this.armadorFacade.findAll());
		Assert.assertEquals(listaEsperada, this.armadorFacade.findAll());
	}

	@Test
	public void testFindAllArmadorUsado(){
		Armador armador = new Armador();
		armador.setId(1L);
		ArmadorDTO armadorDTO = new ArmadorDTO();
		armadorDTO.setId(1L);
		armadorDTO.setUsado(Boolean.TRUE);
		List<ArmadorDTO> listaEsperada = new ArrayList<ArmadorDTO>();
		listaEsperada.add(armadorDTO);
		List<Armador> armadorList = new ArrayList<Armador>();
		armadorList.add(armador);
		Rebocador rebocador = new Rebocador();
		rebocador.setArmador(armador);
		Mockito.when(this.armadorService.findAllByOrderByNomeAsc()).thenReturn(armadorList);
		Mockito.when(this.rebocadorService.findFirstByArmadorId(armador.getId())).thenReturn(rebocador);
		Assert.assertNotNull(this.armadorFacade.findAll());
		Assert.assertEquals(listaEsperada, this.armadorFacade.findAll());
	}

	@Test(expected = NullParameterException.class)
	public void testFindAllArmadorUsadoComFalha(){
		List<ArmadorDTO> listaEsperada = new ArrayList<ArmadorDTO>();
		listaEsperada.add(new ArmadorDTO());
		List<Armador> armadorList = new ArrayList<Armador>();
		armadorList.add(new Armador());
		Rebocador rebocador = new Rebocador();
		rebocador.setArmador(new Armador());
		Mockito.when(this.armadorService.findAllByOrderByNomeAsc()).thenReturn(armadorList);
		Mockito.when(this.rebocadorService.findFirstByArmadorId(1L)).thenReturn(rebocador);
		Assert.assertNotNull(this.armadorFacade.findAll());
		Assert.assertEquals(listaEsperada, this.armadorFacade.findAll());
	}

	@Test
	public void testFindAllEmpty(){
		Mockito.when(this.armadorService.findAllByOrderByNomeAsc()).thenReturn(new ArrayList<Armador>());
		Assert.assertNotNull(this.armadorFacade.findAll());
		Assert.assertEquals(new ArrayList<ArmadorDTO>(), this.armadorFacade.findAll());
	}

	@Test
	public void testFindByIdArmadorNaoUsado(){
		Long idArmador = 1L;
		Armador armador = new Armador();
		armador.setId(idArmador);
		Mockito.when(this.armadorService.getOne(idArmador)).thenReturn(armador);
		Mockito.when(this.rebocadorService.findFirstByArmadorId(idArmador)).thenReturn(null);
		Assert.assertNotNull(this.armadorFacade.findById(idArmador));
		Assert.assertEquals(ArmadorDTO.toDto(armador), this.armadorFacade.findById(idArmador));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByIdArmadorNaoUsadoComFalha(){
		Long idArmador = 1L;
		Mockito.when(this.armadorService.getOne(idArmador)).thenReturn(new Armador());
		Mockito.when(this.rebocadorService.findFirstByArmadorId(idArmador)).thenReturn(null);
		Assert.assertNotNull(this.armadorFacade.findById(idArmador));
		Assert.assertEquals(ArmadorDTO.toDto(new Armador()), this.armadorFacade.findById(idArmador));
	}

	@Test
	public void testFindByIdArmadorUsado(){
		Long idArmador = 1L;
		ArmadorDTO armadorDTO = new ArmadorDTO();
		armadorDTO.setId(idArmador);
		armadorDTO.setUsado(Boolean.TRUE);
		Rebocador rebocador = new Rebocador();
		rebocador.setArmador(armadorDTO.toEntity());
		Mockito.when(this.armadorService.getOne(idArmador)).thenReturn(armadorDTO.toEntity());
		Mockito.when(this.rebocadorService.findFirstByArmadorId(idArmador)).thenReturn(rebocador);
		Assert.assertNotNull(this.armadorFacade.findById(idArmador));
		Assert.assertEquals(armadorDTO, this.armadorFacade.findById(idArmador));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByIdArmadorUsadoComFalha(){
		Long idArmador = 1L;
		Rebocador rebocador = new Rebocador();
		ArmadorDTO armadorDTO = new ArmadorDTO();
		rebocador.setArmador(armadorDTO.toEntity());
		Mockito.when(this.armadorService.getOne(idArmador)).thenReturn(armadorDTO.toEntity());
		Mockito.when(this.rebocadorService.findFirstByArmadorId(idArmador)).thenReturn(rebocador);
		Assert.assertNotNull(this.armadorFacade.findById(idArmador));
		Assert.assertEquals(armadorDTO, this.armadorFacade.findById(idArmador));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByIdNullComFalha(){
		Assert.assertNull(this.armadorFacade.findById(null));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByIdComFalha(){
		Long idArmador = 1L;
		Mockito.when(this.armadorService.getOne(idArmador)).thenReturn(null);
		Assert.assertNotNull(this.armadorFacade.findById(idArmador));
	}

	@Test
	public void testSave(){
		Armador armador = new Armador();
		armador.setId(1L);
		Mockito.when(this.armadorService.save(armador)).thenReturn(new Armador());
		this.armadorFacade.save(armador);
	}

	@Test
	public void testSave2(){
		Mockito.when(this.armadorService.save(new Armador())).thenReturn(new Armador());
		this.armadorFacade.save(new Armador());
	}

	@Test(expected = NullParameterException.class)
	public void testSaveNullComFalha(){
		Mockito.when(this.armadorService.save(new Armador())).thenReturn(null);
		this.armadorFacade.save(null);
	}

	@Test
	public void testDelete(){
		Long idArmador = 1L;
		this.armadorFacade.delete(idArmador);
	}

	@Test(expected = NullParameterException.class)
	public void testDeleteNullComFalha(){
		this.armadorFacade.delete(null);
	}

}
