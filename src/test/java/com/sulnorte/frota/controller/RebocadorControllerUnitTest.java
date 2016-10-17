package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.facade.IArmadorFacade;
import com.sulnorte.frota.business.facade.IEnderecoFacade;
import com.sulnorte.frota.business.facade.IPortoFacade;
import com.sulnorte.frota.business.facade.IRebocadorFacade;
import com.sulnorte.frota.dto.ArmadorDTO;
import com.sulnorte.frota.dto.PropulsaoDTO;
import com.sulnorte.frota.dto.RebocadorDTO;
import com.sulnorte.frota.dto.SituacaoRebocadorDTO;
import com.sulnorte.frota.entity.Armador;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RebocadorControllerUnitTest {

	@InjectMocks
	private RebocadorController rebocadorController;

	@Mock
	private IRebocadorFacade<Rebocador> rebocadorFacade;

	@Mock
	private IArmadorFacade<Armador> armadorFacade;

	@Mock
	private IPortoFacade<Porto> portoFacade;

	@Mock
	private IEnderecoFacade enderecoFacade;

	@Test
	public void testOnList(){
		List<RebocadorDTO> rebocadorDTOList = new ArrayList<RebocadorDTO>();
		rebocadorDTOList.add(new RebocadorDTO());
		ModelAndView mvEsperado = new ModelAndView("cadastro/rebocador/List");
		mvEsperado.addObject("listarRebocadores", rebocadorDTOList);
		Mockito.when(this.rebocadorFacade.findAll()).thenReturn(rebocadorDTOList);
		Assert.assertNotNull(this.rebocadorController.onList());
		Assert.assertEquals(mvEsperado.getModel(), this.rebocadorController.onList().getModel());
		Assert.assertEquals(mvEsperado.getViewName(), this.rebocadorController.onList().getViewName());
	}

	@Test
	public void testOnListEmpty(){
		ModelAndView mvEsperado = new ModelAndView("cadastro/rebocador/List");
		mvEsperado.addObject("listarRebocadores", new ArrayList<RebocadorDTO>());
		Mockito.when(this.rebocadorFacade.findAll()).thenReturn(new ArrayList<RebocadorDTO>());
		Assert.assertNotNull(this.rebocadorController.onList());
		Assert.assertEquals(mvEsperado.getModel(), this.rebocadorController.onList().getModel());
		Assert.assertEquals(mvEsperado.getViewName(), this.rebocadorController.onList().getViewName());
	}

	@Test
	public void testOnPrepareCreate(){
		ArmadorDTO armadorDTO = new ArmadorDTO();
		PropulsaoDTO propulsaoDTO = new PropulsaoDTO();
		SituacaoRebocadorDTO situacaoRebocadorDTO = new SituacaoRebocadorDTO();
		List<ArmadorDTO> armadorDTOList = new ArrayList<ArmadorDTO>();
		armadorDTOList.add(armadorDTO);
		List<PropulsaoDTO> propulsaoDTOList = new ArrayList<PropulsaoDTO>();
		propulsaoDTOList.add(propulsaoDTO);
		List<SituacaoRebocadorDTO> situacaoRebocadorDTOList = new ArrayList<SituacaoRebocadorDTO>();
		situacaoRebocadorDTOList.add(situacaoRebocadorDTO);
		ModelAndView mvEsperado = new ModelAndView("cadastro/rebocador/Form");
		mvEsperado.addObject("listarArmadores", armadorDTOList);
		mvEsperado.addObject("listarPropulsoes", propulsaoDTOList);
		mvEsperado.addObject("listarSituacoes", situacaoRebocadorDTOList);
		mvEsperado.addObject(new RebocadorDTO());
		Mockito.when(this.armadorFacade.findAll()).thenReturn(armadorDTOList);
		Mockito.when(this.rebocadorFacade.findAllPropulsao()).thenReturn(propulsaoDTOList);
		Mockito.when(this.rebocadorFacade.findAllSituacao()).thenReturn(situacaoRebocadorDTOList);
		Assert.assertNotNull(this.rebocadorController.onPrepareCreate());
		Assert.assertEquals(mvEsperado.getModel(), this.rebocadorController.onPrepareCreate().getModel());
		Assert.assertEquals(mvEsperado.getViewName(), this.rebocadorController.onPrepareCreate().getViewName());
	}

	@Test
	public void testOnPrepareCreateEmpty(){
		ModelAndView mvEsperado = new ModelAndView("cadastro/rebocador/Form");
		mvEsperado.addObject("listarArmadores", new ArrayList<ArmadorDTO>());
		mvEsperado.addObject("listarPropulsoes", new ArrayList<PropulsaoDTO>());
		mvEsperado.addObject("listarSituacoes", new ArrayList<SituacaoRebocadorDTO>());
		mvEsperado.addObject(new RebocadorDTO());
		Mockito.when(this.armadorFacade.findAll()).thenReturn(new ArrayList<ArmadorDTO>());
		Mockito.when(this.rebocadorFacade.findAllPropulsao()).thenReturn(new ArrayList<PropulsaoDTO>());
		Mockito.when(this.rebocadorFacade.findAllSituacao()).thenReturn(new ArrayList<SituacaoRebocadorDTO>());
		Assert.assertNotNull(this.rebocadorController.onPrepareCreate());
		Assert.assertEquals(mvEsperado.getModel(), this.rebocadorController.onPrepareCreate().getModel());
		Assert.assertEquals(mvEsperado.getViewName(), this.rebocadorController.onPrepareCreate().getViewName());
	}

	@Test
	public void testOnPrepareUpdateOrDetail(){
		String viewDetail = "cadastro/rebocador/Detail";
		String viewForm = "cadastro/rebocador/Form";
		Long id = 1L;
		RebocadorDTO rebocadorDTO = new RebocadorDTO();
		rebocadorDTO.setId(1L);
		ArmadorDTO armadorDTO = new ArmadorDTO();
		PropulsaoDTO propulsaoDTO = new PropulsaoDTO();
		SituacaoRebocadorDTO situacaoRebocadorDTO = new SituacaoRebocadorDTO();
		List<ArmadorDTO> armadorDTOList = new ArrayList<ArmadorDTO>();
		armadorDTOList.add(armadorDTO);
		List<PropulsaoDTO> propulsaoDTOList = new ArrayList<PropulsaoDTO>();
		propulsaoDTOList.add(propulsaoDTO);
		List<SituacaoRebocadorDTO> situacaoRebocadorDTOList = new ArrayList<SituacaoRebocadorDTO>();
		situacaoRebocadorDTOList.add(situacaoRebocadorDTO);
		ModelAndView mvEsperadoDetail = new ModelAndView(viewDetail);
		mvEsperadoDetail.addObject("listarArmadores", armadorDTOList);
		mvEsperadoDetail.addObject("listarPropulsoes", propulsaoDTOList);
		mvEsperadoDetail.addObject("listarSituacoes", situacaoRebocadorDTOList);
		mvEsperadoDetail.addObject(rebocadorDTO);
		ModelAndView mvEsperadoForm = new ModelAndView(viewForm);
		mvEsperadoForm.addObject("listarArmadores", armadorDTOList);
		mvEsperadoForm.addObject("listarPropulsoes", propulsaoDTOList);
		mvEsperadoForm.addObject("listarSituacoes", situacaoRebocadorDTOList);
		mvEsperadoForm.addObject(rebocadorDTO);
		Mockito.when(this.armadorFacade.findAll()).thenReturn(armadorDTOList);
		Mockito.when(this.rebocadorFacade.findAllPropulsao()).thenReturn(propulsaoDTOList);
		Mockito.when(this.rebocadorFacade.findAllSituacao()).thenReturn(situacaoRebocadorDTOList);
		Mockito.when(this.rebocadorFacade.findById(id)).thenReturn(rebocadorDTO);
		Assert.assertNotNull(this.rebocadorController.onPrepareUpdateOrDetail(viewDetail, id));
		Assert.assertEquals(mvEsperadoDetail.getModel(), this.rebocadorController.onPrepareUpdateOrDetail(viewDetail, id).getModel());
		Assert.assertEquals(mvEsperadoDetail.getViewName(), this.rebocadorController.onPrepareUpdateOrDetail(viewDetail, id).getViewName());
		Assert.assertNotNull(this.rebocadorController.onPrepareUpdateOrDetail(viewForm, id));
		Assert.assertEquals(mvEsperadoForm.getModel(), this.rebocadorController.onPrepareUpdateOrDetail(viewForm, id).getModel());
		Assert.assertEquals(mvEsperadoForm.getViewName(), this.rebocadorController.onPrepareUpdateOrDetail(viewForm, id).getViewName());
	}

	@Test
	public void testOnPrepareUpdateOrDetailEmpty(){
		String viewDetail = "cadastro/rebocador/Detail";
		String viewForm = "cadastro/rebocador/Form";
		Long id = 1L;
		ModelAndView mvEsperadoDetail = new ModelAndView(viewDetail);
		mvEsperadoDetail.addObject("listarArmadores", new ArrayList<ArmadorDTO>());
		mvEsperadoDetail.addObject("listarPropulsoes", new ArrayList<PropulsaoDTO>());
		mvEsperadoDetail.addObject("listarSituacoes", new ArrayList<SituacaoRebocadorDTO>());
		mvEsperadoDetail.addObject(new RebocadorDTO());
		ModelAndView mvEsperadoForm = new ModelAndView(viewForm);
		mvEsperadoForm.addObject("listarArmadores", new ArrayList<ArmadorDTO>());
		mvEsperadoForm.addObject("listarPropulsoes", new ArrayList<PropulsaoDTO>());
		mvEsperadoForm.addObject("listarSituacoes", new ArrayList<SituacaoRebocadorDTO>());
		mvEsperadoForm.addObject(new RebocadorDTO());
		Mockito.when(this.armadorFacade.findAll()).thenReturn(new ArrayList<ArmadorDTO>());
		Mockito.when(this.rebocadorFacade.findAllPropulsao()).thenReturn(new ArrayList<PropulsaoDTO>());
		Mockito.when(this.rebocadorFacade.findAllSituacao()).thenReturn(new ArrayList<SituacaoRebocadorDTO>());
		Mockito.when(this.rebocadorFacade.findById(id)).thenReturn(new RebocadorDTO());
		Assert.assertNotNull(this.rebocadorController.onPrepareUpdateOrDetail(viewDetail, id));
		Assert.assertEquals(mvEsperadoDetail.getModel(), this.rebocadorController.onPrepareUpdateOrDetail(viewDetail, id).getModel());
		Assert.assertEquals(mvEsperadoDetail.getViewName(), this.rebocadorController.onPrepareUpdateOrDetail(viewDetail, id).getViewName());
		Assert.assertNotNull(this.rebocadorController.onPrepareUpdateOrDetail(viewForm, id));
		Assert.assertEquals(mvEsperadoForm.getModel(), this.rebocadorController.onPrepareUpdateOrDetail(viewForm, id).getModel());
		Assert.assertEquals(mvEsperadoForm.getViewName(), this.rebocadorController.onPrepareUpdateOrDetail(viewForm, id).getViewName());
	}

	@Test(expected = NullParameterException.class)
	public void testOnPrepareUpdateOrDetailNullParametroUm(){
		Assert.assertNull(this.rebocadorController.onPrepareUpdateOrDetail(null, 1L));
	}

	@Test(expected = NullParameterException.class)
	public void testOnPrepareUpdateOrDetailNullParametroDois(){
		Assert.assertNull(this.rebocadorController.onPrepareUpdateOrDetail("cadastro/rebocador/Form", null));
	}

	@Test
	public void testGetFacade(){
		Assert.assertNotNull(this.rebocadorController.getFacade());
		Assert.assertEquals(this.rebocadorFacade, rebocadorController.getFacade());
	}

	@Test
	public void testGetPathController(){
		Assert.assertNotNull(this.rebocadorController.getPathController());
		Assert.assertEquals("rebocador", rebocadorController.getPathController());
	}

	@Test
	public void testConvertDtoToEntity(){
		Assert.assertNotNull(this.rebocadorController.convertDtoToEntity(new RebocadorDTO()));
		Assert.assertEquals(new Rebocador(), rebocadorController.convertDtoToEntity(new RebocadorDTO()));
	}

	@Test(expected = NullParameterException.class)
	public void testConvertDtoToEntityNull(){
		Assert.assertNull(this.rebocadorController.convertDtoToEntity(null));
	}

}
