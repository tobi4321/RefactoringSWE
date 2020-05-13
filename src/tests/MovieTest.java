package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import classes.*;

public class MovieTest {

	private Movie movie;
	
	@Before
	public void setUp(){
		movie = new Movie("Janis stinkt",0);
	}

	@Test
	public void getPriceCode() {
		assertEquals(0,movie.getPriceCode());
	}
	
	@Test
	public void getTitle() 
	{
		assertEquals("Janis stinkt",movie.getTitle());
	}
	@Test
	public void getCharge() 
	{
		assertEquals(14.0,movie.getCharge(10),0);
	}

}
