package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.service.IPropulsaoService;
import com.sulnorte.frota.business.service.IRebocadorService;
import com.sulnorte.frota.business.service.ISituacaoRebocadorService;
import com.sulnorte.frota.dto.PropulsaoDTO;
import com.sulnorte.frota.dto.RebocadorDTO;
import com.sulnorte.frota.dto.SituacaoRebocadorDTO;
import com.sulnorte.frota.entity.Propulsao;
import com.sulnorte.frota.entity.Rebocador;
import com.sulnorte.frota.entity.SituacaoRebocador;
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
public class RebocadorFacadeUnitTest {

	@InjectMocks
	private RebocadorFacade<Rebocador> rebocadorFacade;

	@Mock
	private IRebocadorService rebocadorService;

	@Mock
	private IPropulsaoService propulsaoService;

	@Mock
	private ISituacaoRebocadorService situacaoRebocadorService;


	@Test
	public void testFindAll(){
		RebocadorDTO rebocadorDTO = new RebocadorDTO();
		rebocadorDTO.setId(1L);
		List<Rebocador> rebocadorList = new ArrayList<Rebocador>();
		rebocadorList.add(rebocadorDTO.toEntity());
		List<RebocadorDTO> rebocadorDTOList = new ArrayList<RebocadorDTO>();
		rebocadorDTOList.add(rebocadorDTO);
		Mockito.when(this.rebocadorService.findAllByOrderByNomeAsc()).thenReturn(rebocadorList);
		Assert.assertNotNull(this.rebocadorFacade.findAll());
		Assert.assertEquals(rebocadorDTOList, this.rebocadorFacade.findAll());
	}

	@Test
	public void testFindAll2(){
		List<Rebocador> rebocadorList = new ArrayList<Rebocador>();
		List<RebocadorDTO> rebocadorDTOList = new ArrayList<RebocadorDTO>();
		rebocadorList.add(new Rebocador());
		rebocadorDTOList.add(new RebocadorDTO());
		Mockito.when(this.rebocadorService.findAllByOrderByNomeAsc()).thenReturn(rebocadorList);
		Assert.assertNotNull(this.rebocadorFacade.findAll());
		Assert.assertEquals(rebocadorDTOList, this.rebocadorFacade.findAll());
	}

	@Test
	public void testFindAllEmpty(){
		Mockito.when(this.rebocadorService.findAllByOrderByNomeAsc()).thenReturn(new ArrayList<Rebocador>());
		Assert.assertNotNull(this.rebocadorFacade.findAll());
		Assert.assertEquals(new ArrayList<RebocadorDTO>(), this.rebocadorFacade.findAll());
	}

	@Test
	public void testFindAllPropulsao(){
		PropulsaoDTO propulsaoDTO = new PropulsaoDTO();
		propulsaoDTO.setId(1L);
		List<PropulsaoDTO> propulsaoDTOList = new ArrayList<PropulsaoDTO>();
		propulsaoDTOList.add(propulsaoDTO);
		List<Propulsao> propulsaoList = new ArrayList<Propulsao>();
		propulsaoList.add(propulsaoDTO.toEntity());
		Mockito.when(this.propulsaoService.findAll()).thenReturn(propulsaoList);
		Assert.assertNotNull(this.rebocadorFacade.findAllPropulsao());
		Assert.assertEquals(propulsaoDTOList, this.rebocadorFacade.findAllPropulsao());
	}

	@Test
	public void testFindAllPropulsao2(){
		List<PropulsaoDTO> propulsaoDTOList = new ArrayList<PropulsaoDTO>();
		propulsaoDTOList.add(new PropulsaoDTO());
		List<Propulsao> propulsaoList = new ArrayList<Propulsao>();
		propulsaoList.add(new Propulsao());
		Mockito.when(this.propulsaoService.findAll()).thenReturn(propulsaoList);
		Assert.assertNotNull(this.rebocadorFacade.findAllPropulsao());
		Assert.assertEquals(propulsaoDTOList, this.rebocadorFacade.findAllPropulsao());
	}

	@Test(expected = NullParameterException.class)
	public void testFindAllPropulsaoComFalha(){
		PropulsaoDTO propulsaoDTO = new PropulsaoDTO();
		propulsaoDTO.setId(1L);
		List<PropulsaoDTO> propulsaoDTOList = new ArrayList<PropulsaoDTO>();
		propulsaoDTOList.add(propulsaoDTO);
		Mockito.when(this.propulsaoService.findAll()).thenReturn(new ArrayList<Propulsao>());
		Assert.assertNotNull(this.rebocadorFacade.findAllPropulsao());
		Assert.assertEquals(propulsaoDTOList, this.rebocadorFacade.findAllPropulsao());
	}

	@Test
	public void testFindAllSituacao(){
		SituacaoRebocadorDTO situacaoRebocadorDTO = new SituacaoRebocadorDTO();
		situacaoRebocadorDTO.setId(1L);
		List<SituacaoRebocador> situacaoRebocadorList = new ArrayList<SituacaoRebocador>();
		situacaoRebocadorList.add(situacaoRebocadorDTO.toEntity());
		List<SituacaoRebocadorDTO> situacaoRebocadorDTOList = new ArrayList<SituacaoRebocadorDTO>();
		situacaoRebocadorDTOList.add(situacaoRebocadorDTO);
		Mockito.when(this.situacaoRebocadorService.findAll()).thenReturn(situacaoRebocadorList);
		Assert.assertNotNull(this.rebocadorFacade.findAllSituacao());
		Assert.assertEquals(situacaoRebocadorDTOList, this.rebocadorFacade.findAllSituacao());
	}

	@Test
	public void testFindAllSituacao2(){
		List<SituacaoRebocador> situacaoRebocadorList = new ArrayList<SituacaoRebocador>();
		situacaoRebocadorList.add(new SituacaoRebocador());
		List<SituacaoRebocadorDTO> situacaoRebocadorDTOList = new ArrayList<SituacaoRebocadorDTO>();
		situacaoRebocadorDTOList.add(new SituacaoRebocadorDTO());
		Mockito.when(this.situacaoRebocadorService.findAll()).thenReturn(situacaoRebocadorList);
		Assert.assertNotNull(this.rebocadorFacade.findAllSituacao());
		Assert.assertEquals(situacaoRebocadorDTOList, this.rebocadorFacade.findAllSituacao());
	}

	@Test(expected = NullParameterException.class)
	public void testFindAllSituacaoComFalha(){
		List<SituacaoRebocadorDTO> situacaoRebocadorDTOList = new ArrayList<SituacaoRebocadorDTO>();
		situacaoRebocadorDTOList.add(new SituacaoRebocadorDTO());
		Mockito.when(this.situacaoRebocadorService.findAll()).thenReturn(new ArrayList<SituacaoRebocador>());
		Assert.assertNotNull(this.rebocadorFacade.findAllSituacao());
		Assert.assertEquals(situacaoRebocadorDTOList, this.rebocadorFacade.findAllSituacao());
	}

	@Test
	public void testFindById(){
		Long idRebocador = 1L;
		RebocadorDTO rebocadorDTO = new RebocadorDTO();
		rebocadorDTO.setId(1L);
		Mockito.when(this.rebocadorService.getOne(idRebocador)).thenReturn(rebocadorDTO.toEntity());
		Assert.assertNotNull(this.rebocadorFacade.findById(idRebocador));
		Assert.assertEquals(rebocadorDTO, this.rebocadorFacade.findById(idRebocador));
	}

	@Test
	public void testFindById2(){
		Long idRebocador = 1L;
		Mockito.when(this.rebocadorService.getOne(idRebocador)).thenReturn(new Rebocador());
		Assert.assertNotNull(this.rebocadorFacade.findById(idRebocador));
		Assert.assertEquals(new RebocadorDTO(), this.rebocadorFacade.findById(idRebocador));
	}

	@Test(expected = NullParameterException.class)
	public void testFindByIdComFalha(){
		Long idRebocador = 1L;
		Mockito.when(this.rebocadorService.getOne(idRebocador)).thenReturn(null);
		Assert.assertNotNull(this.rebocadorFacade.findById(idRebocador));
		Assert.assertEquals(new RebocadorDTO(), this.rebocadorFacade.findById(idRebocador));
	}

	@Test
	public void testSave(){
		Rebocador rebocador = new Rebocador();
		rebocador.setId(1L);
		Mockito.when(this.rebocadorService.save(rebocador)).thenReturn(new Rebocador());
		this.rebocadorFacade.save(rebocador);
	}

	@Test
	public void testSave2(){
		Mockito.when(this.rebocadorService.save(new Rebocador())).thenReturn(new Rebocador());
		this.rebocadorFacade.save(new Rebocador());
	}

	@Test(expected = NullParameterException.class)
	public void testSaveNullComFalha(){
		Mockito.when(this.rebocadorService.save(new Rebocador())).thenReturn(null);
		this.rebocadorFacade.save(null);
	}

	@Test
	public void testDelete(){
		Long idRebocador = 1L;
		this.rebocadorFacade.delete(idRebocador);
	}

	@Test(expected = NullParameterException.class)
	public void testDeleteNullComFalha(){
		this.rebocadorFacade.delete(null);
	}

}
