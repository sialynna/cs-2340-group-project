package tests;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import classes.Location;
import classes.Pace;

/**
 * This test checks the updateLocation() method in the Location class
 *@author Christopher Whittemore
 */

public class LocationTest extends TestCase {
	
	Pace pace;
	Location loc;
	@Before
	protected void setUp()
	{
		pace = new Pace();
		loc = new Location(0, pace);
	}
	
	//Test the easy pace setting
	@Test
	public void testPaceEasy()
	{
		pace.setPace(1);
		loc.updateLocation();
		assertEquals("Easy Pace Fails", 15.0, loc.getLocation());
		loc.updateLocation();
		assertEquals("Easy Pace Fails", 30.0, loc.getLocation());
	}
	
	//Test the normal pace setting
	@Test
	public void testPaceNormal()
	{
		pace.setPace(2);
		loc.updateLocation();
		assertEquals("Normal Pace Fails", 25.0, loc.getLocation());
		loc.updateLocation();
		assertEquals("Normal Pace Fails", 50.0, loc.getLocation());
	}
	
	//Test the grueling pace setting
	@Test
	public void testPaceGrueling()
	{
		pace.setPace(3);
		loc.updateLocation();
		assertEquals("Grueling Pace Fails", 40.0, loc.getLocation());
		loc.updateLocation();
		assertEquals("Grueling Pace Fails", 80.0, loc.getLocation());
	}
	
	//Test changing the pace between moves
	@Test
	public void testPaceChange()
	{
		pace.setPace(1);
		loc.updateLocation();
		assertEquals("Easy Ini Fails", 15.0, loc.getLocation());
		pace.setPace(2);
		loc.updateLocation();
		assertEquals("Normal Change Fails", 40.0, loc.getLocation());
		pace.setPace(3);
		loc.updateLocation();
		assertEquals("Grueling Change Fails", 80.0, loc.getLocation());
	}
	
	//Test setting the landmark correctly
	@Test
	public void testSetLandmark()
	{
		pace.setPace(3);
		loc.updateLocation();
		loc.updateLocation();
		loc.updateLocation();
		assertEquals("Location wrong after 3 moves", 120.0, loc.getLocation());
		assertEquals("Landmark is wrong", 0, loc.getLandmarkAt());
		loc.updateLocation();
		assertEquals("Location wrong after arriving at landmark 1", 140.0, loc.getLocation());
		assertEquals("Landmark is wrong after arriving at landmark 1", 1, loc.getLandmarkAt());
	}
}
