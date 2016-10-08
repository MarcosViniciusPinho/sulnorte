package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.facade.IArmadorFacade;
import com.sulnorte.frota.business.facade.IEnderecoFacade;
import com.sulnorte.frota.business.facade.IPortoFacade;
import com.sulnorte.frota.dto.ArmadorDTO;
import com.sulnorte.frota.dto.PaisDTO;
import com.sulnorte.frota.dto.PortoDTO;
import com.sulnorte.frota.entity.Armador;
import com.sulnorte.frota.entity.Porto;
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
public class ArmadorControllerUnitTest {

	@InjectMocks
	private ArmadorController armadorController;

	@Mock
	private IArmadorFacade<Armador> armadorFacade;

	@Mock
	private IPortoFacade<Porto> portoFacade;

	@Mock
	private IEnderecoFacade enderecoFacade;

	@Test
	public void testOnList(){
		List<ArmadorDTO> armadorDTOList = new ArrayList<ArmadorDTO>();
		armadorDTOList.add(new ArmadorDTO());
		ModelAndView mvEsperado = new ModelAndView("cadastro/armador/List");
		mvEsperado.addObject("listarArmadores", armadorDTOList);
		Mockito.when(this.armadorFacade.findAll()).thenReturn(armadorDTOList);
		Assert.assertNotNull(this.armadorController.onList());
		Assert.assertEquals(mvEsperado.getModel(), this.armadorController.onList().getModel());
		Assert.assertEquals(mvEsperado.getViewName(), this.armadorController.onList().getViewName());
	}

	@Test
	public void testOnListEmpty(){
		ModelAndView mvEsperado = new ModelAndView("cadastro/armador/List");
		mvEsperado.addObject("listarArmadores", new ArrayList<ArmadorDTO>());
		Mockito.when(this.armadorFacade.findAll()).thenReturn(new ArrayList<ArmadorDTO>());
		Assert.assertNotNull(this.armadorController.onList());
		Assert.assertEquals(mvEsperado.getModel(), this.armadorController.onList().getModel());
		Assert.assertEquals(mvEsperado.getViewName(), this.armadorController.onList().getViewName());
	}

	@Test
	public void testOnPrepareCreate(){
		PaisDTO paisDTO = new PaisDTO();
		PortoDTO portoDTO = new PortoDTO();
		List<PaisDTO> paisDTOList = new ArrayList<PaisDTO>();
		paisDTOList.add(paisDTO);
		List<PortoDTO> portoDTOList = new ArrayList<PortoDTO>();
		portoDTOList.add(portoDTO);
		ModelAndView mvEsperado = new ModelAndView("cadastro/armador/Form");
		mvEsperado.addObject("listarPaises", paisDTOList);
		mvEsperado.addObject("listarPortos", portoDTOList);
		mvEsperado.addObject(new ArmadorDTO());
		Mockito.when(this.enderecoFacade.findAllPais()).thenReturn(paisDTOList);
		Mockito.when(this.portoFacade.findAll()).thenReturn(portoDTOList);
		Assert.assertNotNull(this.armadorController.onPrepareCreate());
		Assert.assertEquals(mvEsperado.getModel(), this.armadorController.onPrepareCreate().getModel());
		Assert.assertEquals(mvEsperado.getViewName(), this.armadorController.onPrepareCreate().getViewName());
	}

	@Test
	public void testOnPrepareCreateEmpty(){
		ModelAndView mvEsperado = new ModelAndView("cadastro/armador/Form");
		mvEsperado.addObject("listarPaises", new ArrayList<PaisDTO>());
		mvEsperado.addObject("listarPortos", new ArrayList<PortoDTO>());
		mvEsperado.addObject(new ArmadorDTO());
		Mockito.when(this.enderecoFacade.findAllPais()).thenReturn(new ArrayList<PaisDTO>());
		Mockito.when(this.portoFacade.findAll()).thenReturn(new ArrayList<PortoDTO>());
		Assert.assertNotNull(this.armadorController.onPrepareCreate());
		Assert.assertEquals(mvEsperado.getModel(), this.armadorController.onPrepareCreate().getModel());
		Assert.assertEquals(mvEsperado.getViewName(), this.armadorController.onPrepareCreate().getViewName());
	}

	@Test
	public void testOnPrepareUpdateOrDetail(){
		String viewDetail = "cadastro/armador/Detail";
		String viewForm = "cadastro/armador/Form";
		Long id = 1L;
		ArmadorDTO armadorDTO = new ArmadorDTO();
		armadorDTO.setId(1L);
		PaisDTO paisDTO = new PaisDTO();
		PortoDTO portoDTO = new PortoDTO();
		List<PaisDTO> paisDTOList = new ArrayList<PaisDTO>();
		paisDTOList.add(paisDTO);
		List<PortoDTO> portoDTOList = new ArrayList<PortoDTO>();
		portoDTOList.add(portoDTO);
		ModelAndView mvEsperadoDetail = new ModelAndView(viewDetail);
		mvEsperadoDetail.addObject("listarPaises", paisDTOList);
		mvEsperadoDetail.addObject("listarPortos", portoDTOList);
		mvEsperadoDetail.addObject(armadorDTO);
		ModelAndView mvEsperadoForm = new ModelAndView(viewForm);
		mvEsperadoForm.addObject("listarPaises", paisDTOList);
		mvEsperadoForm.addObject("listarPortos", portoDTOList);
		mvEsperadoForm.addObject(armadorDTO);
		Mockito.when(this.enderecoFacade.findAllPais()).thenReturn(paisDTOList);
		Mockito.when(this.portoFacade.findAll()).thenReturn(portoDTOList);
		Mockito.when(this.armadorFacade.findById(id)).thenReturn(armadorDTO);
		Assert.assertNotNull(this.armadorController.onPrepareUpdateOrDetail(viewDetail, id));
		Assert.assertEquals(mvEsperadoDetail.getModel(), this.armadorController.onPrepareUpdateOrDetail(viewDetail, id).getModel());
		Assert.assertEquals(mvEsperadoDetail.getViewName(), this.armadorController.onPrepareUpdateOrDetail(viewDetail, id).getViewName());
		Assert.assertNotNull(this.armadorController.onPrepareUpdateOrDetail(viewForm, id));
		Assert.assertEquals(mvEsperadoForm.getModel(), this.armadorController.onPrepareUpdateOrDetail(viewForm, id).getModel());
		Assert.assertEquals(mvEsperadoForm.getViewName(), this.armadorController.onPrepareUpdateOrDetail(viewForm, id).getViewName());
	}

	@Test
	public void testOnPrepareUpdateOrDetailEmpty(){
		String viewDetail = "cadastro/armador/Detail";
		String viewForm = "cadastro/armador/Form";
		Long id = 1L;
		ModelAndView mvEsperadoDetail = new ModelAndView(viewDetail);
		mvEsperadoDetail.addObject("listarPaises", new ArrayList<PaisDTO>());
		mvEsperadoDetail.addObject("listarPortos", new ArrayList<PortoDTO>());
		mvEsperadoDetail.addObject(new ArmadorDTO());
		ModelAndView mvEsperadoForm = new ModelAndView(viewForm);
		mvEsperadoForm.addObject("listarPaises", new ArrayList<PaisDTO>());
		mvEsperadoForm.addObject("listarPortos", new ArrayList<PortoDTO>());
		mvEsperadoForm.addObject(new ArmadorDTO());
		Mockito.when(this.enderecoFacade.findAllPais()).thenReturn(new ArrayList<PaisDTO>());
		Mockito.when(this.portoFacade.findAll()).thenReturn(new ArrayList<PortoDTO>());
		Mockito.when(this.armadorFacade.findById(id)).thenReturn(new ArmadorDTO());
		Assert.assertNotNull(this.armadorController.onPrepareUpdateOrDetail(viewDetail, id));
		Assert.assertEquals(mvEsperadoDetail.getModel(), this.armadorController.onPrepareUpdateOrDetail(viewDetail, id).getModel());
		Assert.assertEquals(mvEsperadoDetail.getViewName(), this.armadorController.onPrepareUpdateOrDetail(viewDetail, id).getViewName());
		Assert.assertNotNull(this.armadorController.onPrepareUpdateOrDetail(viewForm, id));
		Assert.assertEquals(mvEsperadoForm.getModel(), this.armadorController.onPrepareUpdateOrDetail(viewForm, id).getModel());
		Assert.assertEquals(mvEsperadoForm.getViewName(), this.armadorController.onPrepareUpdateOrDetail(viewForm, id).getViewName());
	}

	@Test(expected = NullParameterException.class)
	public void testOnPrepareUpdateOrDetailNullParametroUm(){
		Assert.assertNull(this.armadorController.onPrepareUpdateOrDetail(null, 1L));
	}

	@Test(expected = NullParameterException.class)
	public void testOnPrepareUpdateOrDetailNullParametroDois(){
		Assert.assertNull(this.armadorController.onPrepareUpdateOrDetail("cadastro/armador/Form", null));
	}

	@Test
	public void testGetFacade(){
		Assert.assertNotNull(this.armadorController.getFacade());
		Assert.assertEquals(this.armadorFacade, armadorController.getFacade());
	}

	@Test
	public void testGetPathController(){
		Assert.assertNotNull(this.armadorController.getPathController());
		Assert.assertEquals("armador", armadorController.getPathController());
	}

	@Test
	public void testConvertDtoToEntity(){
		Assert.assertNotNull(this.armadorController.convertDtoToEntity(new ArmadorDTO()));
		Assert.assertEquals(new Armador(), armadorController.convertDtoToEntity(new ArmadorDTO()));
	}

	@Test(expected = NullParameterException.class)
	public void testConvertDtoToEntityNull(){
		Assert.assertNull(this.armadorController.convertDtoToEntity(null));
	}

}
