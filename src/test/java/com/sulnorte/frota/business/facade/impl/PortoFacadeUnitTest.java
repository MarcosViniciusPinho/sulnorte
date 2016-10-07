package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.service.IFilialService;
import com.sulnorte.frota.business.service.IPortoService;
import com.sulnorte.frota.business.service.IRebocadorService;
import com.sulnorte.frota.dto.FilialDTO;
import com.sulnorte.frota.dto.PortoDTO;
import com.sulnorte.frota.entity.Filial;
import com.sulnorte.frota.entity.Porto;
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
public class PortoFacadeUnitTest {

	@InjectMocks
	private PortoFacade<Porto> portoFacade;

	@Mock
	private IPortoService portoService;

	@Mock
	private IFilialService filialService;

	@Mock
	private IRebocadorService rebocadorService;

	
	@Test
	public void testFindAllPortoNaoUsado(){
		Porto porto = new Porto();
		porto.setId(1L);
		List<PortoDTO> listaEsperada = new ArrayList<PortoDTO>();
		listaEsperada.add(PortoDTO.toDto(porto));
		List<Porto> portoList = new ArrayList<Porto>();
		portoList.add(porto);
		Mockito.when(this.portoService.findAllByOrderByNomeAsc()).thenReturn(portoList);
		Mockito.when(this.portoService.findByIdPortoOnArmador(porto.getId())).thenReturn(null);
		Mockito.when(this.rebocadorService.findFirstByPortoId(porto.getId())).thenReturn(null);
		Assert.assertNotNull(this.portoFacade.findAll());
		Assert.assertEquals(listaEsperada, this.portoFacade.findAll());
	}

	@Test(expected = NullParameterException.class)
	public void testFindAllPortoNaoUsadoComFalha(){
		Long idPorto = 1l;
		List<PortoDTO> listaEsperada = new ArrayList<PortoDTO>();
		listaEsperada.add(PortoDTO.toDto(new Porto()));
		List<Porto> portoList = new ArrayList<Porto>();
		portoList.add(new Porto());
		Mockito.when(this.portoService.findAllByOrderByNomeAsc()).thenReturn(portoList);
		Mockito.when(this.portoService.findByIdPortoOnArmador(idPorto)).thenReturn(null);
		Mockito.when(this.rebocadorService.findFirstByPortoId(idPorto)).thenReturn(null);
		Assert.assertNotNull(this.portoFacade.findAll());
		Assert.assertEquals(listaEsperada, this.portoFacade.findAll());
	}

	@Test
	public void testFindAllPortoUsadoInArmadorAndRebocador(){
		Porto porto = new Porto();
		porto.setId(1L);
		PortoDTO portoDTO = new PortoDTO();
		portoDTO.setId(1L);
		portoDTO.setUsado(Boolean.TRUE);
		List<PortoDTO> listaEsperada = new ArrayList<PortoDTO>();
		listaEsperada.add(portoDTO);
		List<Porto> portoList = new ArrayList<Porto>();
		portoList.add(porto);
		Rebocador rebocador = new Rebocador();
		rebocador.setPorto(porto);
		Mockito.when(this.portoService.findAllByOrderByNomeAsc()).thenReturn(portoList);
		Mockito.when(this.portoService.findByIdPortoOnArmador(porto.getId())).thenReturn(1L);
		Mockito.when(this.rebocadorService.findFirstByPortoId(porto.getId())).thenReturn(rebocador);
		Assert.assertNotNull(this.portoFacade.findAll());
		Assert.assertEquals(listaEsperada, this.portoFacade.findAll());
	}

	@Test(expected = NullParameterException.class)
	public void testFindAllPortoUsadoInArmadorAndRebocadorComFalha(){
		Long idPorto = 1L;
		PortoDTO portoDTO = new PortoDTO();
		portoDTO.setId(idPorto);
		portoDTO.setUsado(Boolean.TRUE);
		List<PortoDTO> listaEsperada = new ArrayList<PortoDTO>();
		listaEsperada.add(portoDTO);
		List<Porto> portoList = new ArrayList<Porto>();
		portoList.add(new Porto());
		Rebocador rebocador = new Rebocador();
		rebocador.setPorto(new Porto());
		Mockito.when(this.portoService.findAllByOrderByNomeAsc()).thenReturn(portoList);
		Mockito.when(this.portoService.findByIdPortoOnArmador(idPorto)).thenReturn(1L);
		Mockito.when(this.rebocadorService.findFirstByPortoId(idPorto)).thenReturn(rebocador);
		Assert.assertNotNull(this.portoFacade.findAll());
		Assert.assertEquals(listaEsperada, this.portoFacade.findAll());
	}

	@Test
	public void testFindAllPortoUsadoInRebocador(){
		PortoDTO portoDTO = new PortoDTO();
		portoDTO.setId(1L);
		portoDTO.setUsado(Boolean.TRUE);
		List<PortoDTO> listaEsperada = new ArrayList<PortoDTO>();
		listaEsperada.add(portoDTO);
		List<Porto> portoList = new ArrayList<Porto>();
		portoList.add(portoDTO.toEntity());
		Rebocador rebocador = new Rebocador();
		rebocador.setPorto(portoDTO.toEntity());
		Mockito.when(this.portoService.findAllByOrderByNomeAsc()).thenReturn(portoList);
		Mockito.when(this.portoService.findByIdPortoOnArmador(portoDTO.toEntity().getId())).thenReturn(null);
		Mockito.when(this.rebocadorService.findFirstByPortoId(portoDTO.toEntity().getId())).thenReturn(rebocador);
		Assert.assertNotNull(this.portoFacade.findAll());
		Assert.assertEquals(listaEsperada, this.portoFacade.findAll());
	}

	@Test(expected = NullParameterException.class)
	public void testFindAllPortoUsadoInRebocadorComFalha(){
		Long idPorto = 1L;
		PortoDTO portoDTO = new PortoDTO();
		portoDTO.setId(idPorto);
		portoDTO.setUsado(Boolean.TRUE);
		List<PortoDTO> listaEsperada = new ArrayList<PortoDTO>();
		listaEsperada.add(portoDTO);
		List<Porto> portoList = new ArrayList<Porto>();
		portoList.add(new Porto());
		Rebocador rebocador = new Rebocador();
		rebocador.setPorto(portoDTO.toEntity());
		Mockito.when(this.portoService.findAllByOrderByNomeAsc()).thenReturn(portoList);
		Mockito.when(this.portoService.findByIdPortoOnArmador(idPorto)).thenReturn(null);
		Mockito.when(this.rebocadorService.findFirstByPortoId(idPorto)).thenReturn(rebocador);
		Assert.assertNotNull(this.portoFacade.findAll());
		Assert.assertEquals(listaEsperada, this.portoFacade.findAll());
	}

	@Test
	public void testFindAllPortoUsadoInArmador(){
		PortoDTO portoDTO = new PortoDTO();
		portoDTO.setId(1L);
		portoDTO.setUsado(Boolean.TRUE);
		List<PortoDTO> listaEsperada = new ArrayList<PortoDTO>();
		listaEsperada.add(portoDTO);
		List<Porto> portoList = new ArrayList<Porto>();
		portoList.add(portoDTO.toEntity());
		Mockito.when(this.portoService.findAllByOrderByNomeAsc()).thenReturn(portoList);
		Mockito.when(this.portoService.findByIdPortoOnArmador(portoDTO.toEntity().getId())).thenReturn(1L);
		Mockito.when(this.rebocadorService.findFirstByPortoId(portoDTO.toEntity().getId())).thenReturn(null);
		Assert.assertNotNull(this.portoFacade.findAll());
		Assert.assertEquals(listaEsperada, this.portoFacade.findAll());
	}

	@Test(expected = NullParameterException.class)
	public void testFindAllPortoUsadoInArmadorComFalha(){
		Long idPorto = 1L;
		PortoDTO portoDTO = new PortoDTO();
		portoDTO.setId(idPorto);
		portoDTO.setUsado(Boolean.TRUE);
		List<PortoDTO> listaEsperada = new ArrayList<PortoDTO>();
		listaEsperada.add(portoDTO);
		List<Porto> portoList = new ArrayList<Porto>();
		portoList.add(new Porto());
		Mockito.when(this.portoService.findAllByOrderByNomeAsc()).thenReturn(portoList);
		Mockito.when(this.portoService.findByIdPortoOnArmador(idPorto)).thenReturn(idPorto);
		Mockito.when(this.rebocadorService.findFirstByPortoId(idPorto)).thenReturn(null);
		Assert.assertNotNull(this.portoFacade.findAll());
		Assert.assertEquals(listaEsperada, this.portoFacade.findAll());
	}

	@Test
	public void testFindAllEmpty(){
		Mockito.when(this.portoService.findAllByOrderByNomeAsc()).thenReturn(new ArrayList<Porto>());
		Assert.assertNotNull(this.portoFacade.findAll());
		Assert.assertEquals(new ArrayList<PortoDTO>(), this.portoFacade.findAll());
	}

	@Test
	public void testFindByIdPortoNaoUsado(){
		Long idPorto = 1L;
		Porto porto = new Porto();
		porto.setId(idPorto);
		Mockito.when(this.portoService.getOne(porto.getId())).thenReturn(porto);
		Mockito.when(this.portoService.findByIdPortoOnArmador(porto.getId())).thenReturn(null);
		Mockito.when(this.rebocadorService.findFirstByPortoId(porto.getId())).thenReturn(null);
		Assert.assertNotNull(this.portoFacade.findById(idPorto));
		Assert.assertEquals(PortoDTO.toDto(porto), this.portoFacade.findById(idPorto));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByIdPortoNaoUsadoComFalha(){
		Long idPorto = 1L;
		Mockito.when(this.portoService.getOne(idPorto)).thenReturn(new Porto());
		Mockito.when(this.portoService.findByIdPortoOnArmador(idPorto)).thenReturn(null);
		Mockito.when(this.rebocadorService.findFirstByPortoId(idPorto)).thenReturn(null);
		Assert.assertNotNull(this.portoFacade.findById(idPorto));
		Assert.assertEquals(PortoDTO.toDto(new Porto()), this.portoFacade.findById(idPorto));
	}

	@Test
	public void testFindByIdPortoUsadoInArmadorAndRebocador(){
		Long idPorto = 1L;
		Porto porto = new Porto();
		porto.setId(idPorto);
		Rebocador rebocador = new Rebocador();
		rebocador.setPorto(porto);
		Mockito.when(this.portoService.getOne(porto.getId())).thenReturn(porto);
		Mockito.when(this.portoService.findByIdPortoOnArmador(porto.getId())).thenReturn(idPorto);
		Mockito.when(this.rebocadorService.findFirstByPortoId(porto.getId())).thenReturn(rebocador);
		Assert.assertNotNull(this.portoFacade.findById(idPorto));
		Assert.assertEquals(PortoDTO.toDto(porto), this.portoFacade.findById(idPorto));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByIdPortoUsadoInArmadorAndRebocadorComFalha(){
		Long idPorto = 1L;
		Rebocador rebocador = new Rebocador();
		rebocador.setPorto(new Porto());
		Mockito.when(this.portoService.getOne(idPorto)).thenReturn(new Porto());
		Mockito.when(this.portoService.findByIdPortoOnArmador(idPorto)).thenReturn(idPorto);
		Mockito.when(this.rebocadorService.findFirstByPortoId(idPorto)).thenReturn(rebocador);
		Assert.assertNotNull(this.portoFacade.findById(idPorto));
		Assert.assertEquals(PortoDTO.toDto(new Porto()), this.portoFacade.findById(idPorto));
	}

	@Test
	public void testFindByIdPortoUsadoInRebocador(){
		Long idPorto = 1L;
		Porto porto = new Porto();
		porto.setId(idPorto);
		Rebocador rebocador = new Rebocador();
		rebocador.setPorto(porto);
		Mockito.when(this.portoService.getOne(idPorto)).thenReturn(porto);
		Mockito.when(this.portoService.findByIdPortoOnArmador(idPorto)).thenReturn(null);
		Mockito.when(this.rebocadorService.findFirstByPortoId(idPorto)).thenReturn(rebocador);
		Assert.assertNotNull(this.portoFacade.findById(idPorto));
		Assert.assertEquals(PortoDTO.toDto(porto), this.portoFacade.findById(idPorto));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByIdPortoUsadoInRebocadorComFalha(){
		Long idPorto = 1L;
		Rebocador rebocador = new Rebocador();
		rebocador.setPorto(new Porto());
		Mockito.when(this.portoService.getOne(idPorto)).thenReturn(new Porto());
		Mockito.when(this.portoService.findByIdPortoOnArmador(idPorto)).thenReturn(null);
		Mockito.when(this.rebocadorService.findFirstByPortoId(idPorto)).thenReturn(rebocador);
		Assert.assertNotNull(this.portoFacade.findById(idPorto));
		Assert.assertEquals(PortoDTO.toDto(new Porto()), this.portoFacade.findById(idPorto));
	}

	@Test
	public void testFindByIdPortoUsadoInArmador(){
		Long idPorto = 1L;
		Porto porto = new Porto();
		porto.setId(idPorto);
		Mockito.when(this.portoService.getOne(idPorto)).thenReturn(porto);
		Mockito.when(this.portoService.findByIdPortoOnArmador(idPorto)).thenReturn(idPorto);
		Mockito.when(this.rebocadorService.findFirstByPortoId(idPorto)).thenReturn(null);
		Assert.assertNotNull(this.portoFacade.findById(idPorto));
		Assert.assertEquals(PortoDTO.toDto(porto), this.portoFacade.findById(idPorto));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByIdPortoUsadoInArmadorComFalha(){
		Long idPorto = 1L;
		Mockito.when(this.portoService.getOne(idPorto)).thenReturn(new Porto());
		Mockito.when(this.portoService.findByIdPortoOnArmador(idPorto)).thenReturn(idPorto);
		Mockito.when(this.rebocadorService.findFirstByPortoId(idPorto)).thenReturn(null);
		Assert.assertNotNull(this.portoFacade.findById(idPorto));
		Assert.assertEquals(PortoDTO.toDto(new Porto()), this.portoFacade.findById(idPorto));
	}

	@Test
	public void testFindAllFilial(){
		FilialDTO filialDTO = new FilialDTO();
		filialDTO.setId(1L);
		List<FilialDTO> filialDTOList = new ArrayList<FilialDTO>();
		filialDTOList.add(filialDTO);
		List<Filial> filialList = new ArrayList<Filial>();
		filialList.add(filialDTO.toEntity());
		Mockito.when(this.filialService.findAllByOrderByNomeAsc()).thenReturn(filialList);
		Assert.assertNotNull(this.portoFacade.findAllFilial());
		Assert.assertEquals(filialDTOList, this.portoFacade.findAllFilial());
	}

	@Test(expected = NullParameterException.class)
	public void testFindAllFilialComFalha(){
		FilialDTO filialDTO = new FilialDTO();
		filialDTO.setId(1L);
		List<FilialDTO> filialDTOList = new ArrayList<FilialDTO>();
		filialDTOList.add(filialDTO);
		Mockito.when(this.filialService.findAllByOrderByNomeAsc()).thenReturn(new ArrayList<Filial>());
		Assert.assertNotNull(this.portoFacade.findAllFilial());
		Assert.assertEquals(filialDTOList, this.portoFacade.findAllFilial());
	}

	@Test
	public void testFindAllFilial2(){
		List<FilialDTO> filialDTOList = new ArrayList<FilialDTO>();
		filialDTOList.add(new FilialDTO());
		List<Filial> filialList = new ArrayList<Filial>();
		filialList.add(new FilialDTO().toEntity());
		Mockito.when(this.filialService.findAllByOrderByNomeAsc()).thenReturn(filialList);
		Assert.assertNotNull(this.portoFacade.findAllFilial());
		Assert.assertEquals(filialDTOList, this.portoFacade.findAllFilial());
	}

	@Test
	public void testSave(){
		Porto porto = new Porto();
		porto.setId(1L);
		Mockito.when(this.portoService.save(porto)).thenReturn(new Porto());
		this.portoFacade.save(porto);
	}

	@Test
	public void testSave2(){
		Mockito.when(this.portoService.save(new Porto())).thenReturn(new Porto());
		this.portoFacade.save(new Porto());
	}

	@Test(expected = NullParameterException.class)
	public void testSaveNullComFalha(){
		Mockito.when(this.portoService.save(new Porto())).thenReturn(null);
		this.portoFacade.save(null);
	}

	@Test
	public void testDelete(){
		Long idPorto = 1L;
		this.portoFacade.delete(idPorto);
	}

	@Test(expected = NullParameterException.class)
	public void testDeleteNullComFalha(){
		this.portoFacade.delete(null);
	}

}
