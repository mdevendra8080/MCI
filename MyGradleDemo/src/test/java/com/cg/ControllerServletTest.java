package com.cg;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.beans.CarDTO;
import com.cg.dao.CarDAO;

public class ControllerServletTest {

	@Mock
	private CarDAO daoRef;	
	
	@InjectMocks
	private ControllerServlet myServlet;
	
	@Before
	public void setup(){
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testProcessRequest() throws ServletException, IOException {
		
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response =  Mockito.mock(HttpServletResponse.class);
		
		// WHEN THEN PATTERN
		
		Mockito.when(request.getParameter("action")).thenReturn("viewCarList");
		
		//Mockito.when(request1.getParameter("action")).thenReturn("viewCarList");
		
		// DATA FIXURE
		
		List<CarDTO> cars = new LinkedList();
		CarDTO car = new CarDTO();
		
		car.setId(10);
		car.setMake("MAKE ME");
		car.setModel("XYZ");
		car.setModelYear("2017");
		
		Mockito.when(daoRef.findAll()).thenReturn(cars);
		
		// EXECUTION
		myServlet.processRequest(request, response);
		
		//VERIFICATION
		
		Mockito.verify(request).getParameter("action");
		Mockito.verify(daoRef).findAll();
		
		System.out.println("Who I am ?::"+daoRef.getClass());
		//fail("Not yet implemented");
	}
	
	@Test
	public void findAll(){
		
	}

	
}
