package test;

import org.junit.Test;

import main.ListaMascotas;

public class TestException {
	
	
	@Test(expected = RuntimeException.class)
	public void testIndexOutOfRange(){
		ListaMascotas lst = new ListaMascotas();
		lst.checkIndex(-1);
	}
	
	
	
	
}
