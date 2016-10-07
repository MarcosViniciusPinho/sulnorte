package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.service.IEstadoService;
import com.sulnorte.frota.business.service.IMunicipioService;
import com.sulnorte.frota.business.service.IPaisService;
import com.sulnorte.frota.dto.EstadoDTO;
import com.sulnorte.frota.dto.MunicipioDTO;
import com.sulnorte.frota.dto.PaisDTO;
import com.sulnorte.frota.entity.Estado;
import com.sulnorte.frota.entity.Municipio;
import com.sulnorte.frota.entity.Pais;
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
public class EnderecoFacadeUnitTest {

	@InjectMocks
	private EnderecoFacade enderecoFacade;

	@Mock
	public IPaisService paisService;

	@Mock
	public IEstadoService estadoService;

	@Mock
	public IMunicipioService municipioService;


	@Test
	public void testFindByEstadoPerPais(){
		Long idPais = 1L;
		PaisDTO pais = new PaisDTO();
		pais.setId(idPais);
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(1L);
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList.add(estadoDTO.toEntity());
		List<EstadoDTO> estadoDTOList = new ArrayList<EstadoDTO>();
		estadoDTOList.add(estadoDTO);
		Mockito.when(this.paisService.getOne(idPais)).thenReturn(pais.toEntity());
		Mockito.when(this.estadoService.findByPais((pais.toEntity()))).thenReturn(estadoList);
		Assert.assertNotNull(this.enderecoFacade.findByEstadoPerPais(idPais));
		Assert.assertEquals(estadoDTOList, this.enderecoFacade.findByEstadoPerPais(idPais));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByEstadoPerPaisComFalha(){
		Long idPais = 1L;
		PaisDTO pais = new PaisDTO();
		pais.setId(idPais);
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(1L);
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList.add(estadoDTO.toEntity());
		List<EstadoDTO> estadoDTOList = new ArrayList<EstadoDTO>();
		estadoDTOList.add(estadoDTO);
		Mockito.when(this.paisService.getOne(idPais)).thenReturn(null);
		Mockito.when(this.estadoService.findByPais((pais.toEntity()))).thenReturn(estadoList);
		Assert.assertNotNull(this.enderecoFacade.findByEstadoPerPais(idPais));
		Assert.assertEquals(estadoDTOList, this.enderecoFacade.findByEstadoPerPais(idPais));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByEstadoPerPaisComFalha2(){
		Long idPais = 1L;
		PaisDTO pais = new PaisDTO();
		pais.setId(idPais);
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(1L);
		List<EstadoDTO> estadoDTOList = new ArrayList<EstadoDTO>();
		estadoDTOList.add(estadoDTO);
		Mockito.when(this.paisService.getOne(idPais)).thenReturn(pais.toEntity());
		Mockito.when(this.estadoService.findByPais((pais.toEntity()))).thenReturn(null);
		Assert.assertNotNull(this.enderecoFacade.findByEstadoPerPais(idPais));
		Assert.assertEquals(estadoDTOList, this.enderecoFacade.findByEstadoPerPais(idPais));
	}

	@Test(expected = NullPointerException.class)
	public void testFindByEstadoPerPaisComFalha3(){
		Long idPais = 1L;
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList.add(new EstadoDTO().toEntity());
		List<EstadoDTO> estadoDTOList = new ArrayList<EstadoDTO>();
		estadoDTOList.add(new EstadoDTO());
		Mockito.when(this.paisService.getOne(idPais)).thenReturn(new PaisDTO().toEntity());
		Mockito.when(this.estadoService.findByPais((new PaisDTO().toEntity()))).thenReturn(estadoList);
		Assert.assertNotNull(this.enderecoFacade.findByEstadoPerPais(idPais));
		Assert.assertEquals(estadoDTOList, this.enderecoFacade.findByEstadoPerPais(idPais));
	}

	@Test
	public void testFindByMunicipioPerEstado(){
		Long idEstado = 1L;
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(idEstado);
		MunicipioDTO municipioDTO = new MunicipioDTO();
		municipioDTO.setId(1L);
		List<Municipio> municipioList = new ArrayList<Municipio>();
		municipioList.add(municipioDTO.toEntity());
		List<MunicipioDTO> municipioDTOList = new ArrayList<MunicipioDTO>();
		municipioDTOList.add(municipioDTO);
		Mockito.when(this.estadoService.getOne(idEstado)).thenReturn(estadoDTO.toEntity());
		Mockito.when(this.municipioService.findByEstadoOrderByNomeAsc(estadoDTO.toEntity())).thenReturn(municipioList);
		Assert.assertNotNull(this.enderecoFacade.findByMunicipioPerEstado(idEstado));
		Assert.assertEquals(municipioDTOList, this.enderecoFacade.findByMunicipioPerEstado(idEstado));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByMunicipioPerEstadoComFalha(){
		Long idEstado = 1L;
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(idEstado);
		MunicipioDTO municipioDTO = new MunicipioDTO();
		municipioDTO.setId(1L);
		List<Municipio> municipioList = new ArrayList<Municipio>();
		municipioList.add(municipioDTO.toEntity());
		List<MunicipioDTO> municipioDTOList = new ArrayList<MunicipioDTO>();
		municipioDTOList.add(municipioDTO);
		Mockito.when(this.estadoService.getOne(idEstado)).thenReturn(null);
		Mockito.when(this.municipioService.findByEstadoOrderByNomeAsc(estadoDTO.toEntity())).thenReturn(municipioList);
		Assert.assertNotNull(this.enderecoFacade.findByMunicipioPerEstado(idEstado));
		Assert.assertEquals(municipioDTOList, this.enderecoFacade.findByMunicipioPerEstado(idEstado));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByMunicipioPerEstadoComFalha2(){
		Long idEstado = 1L;
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(idEstado);
		MunicipioDTO municipioDTO = new MunicipioDTO();
		municipioDTO.setId(1L);
		List<MunicipioDTO> municipioDTOList = new ArrayList<MunicipioDTO>();
		municipioDTOList.add(municipioDTO);
		Mockito.when(this.estadoService.getOne(idEstado)).thenReturn(estadoDTO.toEntity());
		Mockito.when(this.municipioService.findByEstadoOrderByNomeAsc(estadoDTO.toEntity())).thenReturn(null);
		Assert.assertNotNull(this.enderecoFacade.findByMunicipioPerEstado(idEstado));
		Assert.assertEquals(municipioDTOList, this.enderecoFacade.findByMunicipioPerEstado(idEstado));
	}

	@Test(expected = NullPointerException.class)
	public void testFindByMunicipioPerEstadoComFalha3(){
		Long idEstado = 1L;
		List<MunicipioDTO> municipioDTOList = new ArrayList<MunicipioDTO>();
		municipioDTOList.add(new MunicipioDTO());
		List<Municipio> municipioList = new ArrayList<Municipio>();
		municipioList.add(new MunicipioDTO().toEntity());
		Mockito.when(this.estadoService.getOne(idEstado)).thenReturn(new EstadoDTO().toEntity());
		Mockito.when(this.municipioService.findByEstadoOrderByNomeAsc(new EstadoDTO().toEntity())).thenReturn(municipioList);
		Assert.assertNotNull(this.enderecoFacade.findByMunicipioPerEstado(idEstado));
		Assert.assertEquals(municipioDTOList, this.enderecoFacade.findByMunicipioPerEstado(idEstado));
	}

	@Test
	public void testFindAllPais(){
		PaisDTO paisDTO = new PaisDTO();
		paisDTO.setId(1L);
		List<Pais> paisList = new ArrayList<Pais>();
		paisList.add(paisDTO.toEntity());
		List<PaisDTO> paisDTOList = new ArrayList<PaisDTO>();
		paisDTOList.add(paisDTO);
		Mockito.when(this.paisService.findAll()).thenReturn(paisList);
		Assert.assertNotNull(this.enderecoFacade.findAllPais());
		Assert.assertEquals(paisDTOList, this.enderecoFacade.findAllPais());
	}

	@Test(expected = NullParameterException.class)
	public void testFindAllPaisComFalha(){
		PaisDTO paisDTO = new PaisDTO();
		paisDTO.setId(1L);
		List<PaisDTO> paisDTOList = new ArrayList<PaisDTO>();
		paisDTOList.add(paisDTO);
		Mockito.when(this.paisService.findAll()).thenReturn(null);
		Assert.assertNotNull(this.enderecoFacade.findAllPais());
		Assert.assertEquals(paisDTOList, this.enderecoFacade.findAllPais());
	}

}
