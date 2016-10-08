package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.facade.IEnderecoFacade;
import com.sulnorte.frota.business.facade.IPortoFacade;
import com.sulnorte.frota.dto.FilialDTO;
import com.sulnorte.frota.dto.PaisDTO;
import com.sulnorte.frota.dto.PortoDTO;
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
public class PortoControllerUnitTest {

	@InjectMocks
	private PortoController portoController;

	@Mock
	private IPortoFacade<Porto> portoFacade;

	@Mock
	private IEnderecoFacade enderecoFacade;

	@Test
	public void testOnList(){
		List<PortoDTO> portoDTOList = new ArrayList<PortoDTO>();
		portoDTOList.add(new PortoDTO());
		ModelAndView mvEsperado = new ModelAndView("cadastro/porto/List");
		mvEsperado.addObject("listarPortos", portoDTOList);
		Mockito.when(this.portoFacade.findAll()).thenReturn(portoDTOList);
		Assert.assertNotNull(this.portoController.onList());
		Assert.assertEquals(mvEsperado.getModel(), this.portoController.onList().getModel());
		Assert.assertEquals(mvEsperado.getViewName(), this.portoController.onList().getViewName());
	}

	@Test
	public void testOnListEmpty(){
		ModelAndView mvEsperado = new ModelAndView("cadastro/porto/List");
		mvEsperado.addObject("listarPortos", new ArrayList<PortoDTO>());
		Mockito.when(this.portoFacade.findAll()).thenReturn(new ArrayList<PortoDTO>());
		Assert.assertNotNull(this.portoController.onList());
		Assert.assertEquals(mvEsperado.getModel(), this.portoController.onList().getModel());
		Assert.assertEquals(mvEsperado.getViewName(), this.portoController.onList().getViewName());
	}

	@Test
	public void testOnPrepareCreate(){
		PaisDTO paisDTO = new PaisDTO();
		FilialDTO filialDTODTO = new FilialDTO();
		List<PaisDTO> paisDTOList = new ArrayList<PaisDTO>();
		paisDTOList.add(paisDTO);
		List<FilialDTO> filialDTOList = new ArrayList<FilialDTO>();
		filialDTOList.add(filialDTODTO);
		ModelAndView mvEsperado = new ModelAndView("cadastro/porto/Form");
		mvEsperado.addObject("listarPaises", paisDTOList);
		mvEsperado.addObject("listarFiliais", filialDTOList);
		mvEsperado.addObject(new PortoDTO());
		Mockito.when(this.enderecoFacade.findAllPais()).thenReturn(paisDTOList);
		Mockito.when(this.portoFacade.findAllFilial()).thenReturn(filialDTOList);
		Assert.assertNotNull(this.portoController.onPrepareCreate());
		Assert.assertEquals(mvEsperado.getModel(), this.portoController.onPrepareCreate().getModel());
		Assert.assertEquals(mvEsperado.getViewName(), this.portoController.onPrepareCreate().getViewName());
	}

	@Test
	public void testOnPrepareCreateEmpty(){
		ModelAndView mvEsperado = new ModelAndView("cadastro/porto/Form");
		mvEsperado.addObject("listarPaises", new ArrayList<PaisDTO>());
		mvEsperado.addObject("listarFiliais", new ArrayList<FilialDTO>());
		mvEsperado.addObject(new PortoDTO());
		Mockito.when(this.enderecoFacade.findAllPais()).thenReturn(new ArrayList<PaisDTO>());
		Mockito.when(this.portoFacade.findAllFilial()).thenReturn(new ArrayList<FilialDTO>());
		Assert.assertNotNull(this.portoController.onPrepareCreate());
		Assert.assertEquals(mvEsperado.getModel(), this.portoController.onPrepareCreate().getModel());
		Assert.assertEquals(mvEsperado.getViewName(), this.portoController.onPrepareCreate().getViewName());
	}

	@Test
	public void testOnPrepareUpdateOrDetail(){
		String viewDetail = "cadastro/porto/Detail";
		String viewForm = "cadastro/porto/Form";
		Long id = 1L;
		PortoDTO portoDTO = new PortoDTO();
		portoDTO.setId(1L);
		PaisDTO paisDTO = new PaisDTO();
		List<PaisDTO> paisDTOList = new ArrayList<PaisDTO>();
		paisDTOList.add(paisDTO);
		List<FilialDTO> filialDTOList = new ArrayList<FilialDTO>();
		filialDTOList.add(new FilialDTO());
		ModelAndView mvEsperadoDetail = new ModelAndView(viewDetail);
		mvEsperadoDetail.addObject("listarPaises", paisDTOList);
		mvEsperadoDetail.addObject("listarFiliais", filialDTOList);
		mvEsperadoDetail.addObject(portoDTO);
		ModelAndView mvEsperadoForm = new ModelAndView(viewForm);
		mvEsperadoForm.addObject("listarPaises", paisDTOList);
		mvEsperadoForm.addObject("listarFiliais", filialDTOList);
		mvEsperadoForm.addObject(portoDTO);
		Mockito.when(this.enderecoFacade.findAllPais()).thenReturn(paisDTOList);
		Mockito.when(this.portoFacade.findAllFilial()).thenReturn(filialDTOList);
		Mockito.when(this.portoFacade.findById(id)).thenReturn(portoDTO);
		Assert.assertNotNull(this.portoController.onPrepareUpdateOrDetail(viewDetail, id));
		Assert.assertEquals(mvEsperadoDetail.getModel(), this.portoController.onPrepareUpdateOrDetail(viewDetail, id).getModel());
		Assert.assertEquals(mvEsperadoDetail.getViewName(), this.portoController.onPrepareUpdateOrDetail(viewDetail, id).getViewName());
		Assert.assertNotNull(this.portoController.onPrepareUpdateOrDetail(viewForm, id));
		Assert.assertEquals(mvEsperadoForm.getModel(), this.portoController.onPrepareUpdateOrDetail(viewForm, id).getModel());
		Assert.assertEquals(mvEsperadoForm.getViewName(), this.portoController.onPrepareUpdateOrDetail(viewForm, id).getViewName());
	}

	@Test
	public void testOnPrepareUpdateOrDetailEmpty(){
		String viewDetail = "cadastro/porto/Detail";
		String viewForm = "cadastro/porto/Form";
		Long id = 1L;
		ModelAndView mvEsperadoDetail = new ModelAndView(viewDetail);
		mvEsperadoDetail.addObject("listarPaises", new ArrayList<PaisDTO>());
		mvEsperadoDetail.addObject("listarFiliais", new ArrayList<FilialDTO>());
		mvEsperadoDetail.addObject(new PortoDTO());
		ModelAndView mvEsperadoForm = new ModelAndView(viewForm);
		mvEsperadoForm.addObject("listarPaises", new ArrayList<PaisDTO>());
		mvEsperadoForm.addObject("listarFiliais", new ArrayList<FilialDTO>());
		mvEsperadoForm.addObject(new PortoDTO());
		Mockito.when(this.enderecoFacade.findAllPais()).thenReturn(new ArrayList<PaisDTO>());
		Mockito.when(this.portoFacade.findAllFilial()).thenReturn(new ArrayList<FilialDTO>());
		Mockito.when(this.portoFacade.findById(id)).thenReturn(new PortoDTO());
		Assert.assertNotNull(this.portoController.onPrepareUpdateOrDetail(viewDetail, id));
		Assert.assertEquals(mvEsperadoDetail.getModel(), this.portoController.onPrepareUpdateOrDetail(viewDetail, id).getModel());
		Assert.assertEquals(mvEsperadoDetail.getViewName(), this.portoController.onPrepareUpdateOrDetail(viewDetail, id).getViewName());
		Assert.assertNotNull(this.portoController.onPrepareUpdateOrDetail(viewForm, id));
		Assert.assertEquals(mvEsperadoForm.getModel(), this.portoController.onPrepareUpdateOrDetail(viewForm, id).getModel());
		Assert.assertEquals(mvEsperadoForm.getViewName(), this.portoController.onPrepareUpdateOrDetail(viewForm, id).getViewName());
	}

	@Test(expected = NullParameterException.class)
	public void testOnPrepareUpdateOrDetailNullParametroUm(){
		Assert.assertNull(this.portoController.onPrepareUpdateOrDetail(null, 1L));
	}

	@Test(expected = NullParameterException.class)
	public void testOnPrepareUpdateOrDetailNullParametroDois(){
		Assert.assertNull(this.portoController.onPrepareUpdateOrDetail("cadastro/porto/Form", null));
	}

	@Test
	public void testGetFacade(){
		Assert.assertNotNull(this.portoController.getFacade());
		Assert.assertEquals(this.portoFacade, portoController.getFacade());
	}

	@Test
	public void testGetPathController(){
		Assert.assertNotNull(this.portoController.getPathController());
		Assert.assertEquals("porto", portoController.getPathController());
	}

	@Test
	public void testConvertDtoToEntity(){
		Assert.assertNotNull(this.portoController.convertDtoToEntity(new PortoDTO()));
		Assert.assertEquals(new Porto(), portoController.convertDtoToEntity(new PortoDTO()));
	}

	@Test(expected = NullParameterException.class)
	public void testConvertDtoToEntityNull(){
		Assert.assertNull(this.portoController.convertDtoToEntity(null));
	}

}
