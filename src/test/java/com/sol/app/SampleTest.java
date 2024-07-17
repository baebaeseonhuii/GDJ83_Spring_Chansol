package com.sol.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleTest extends DefaultTest{

	@BeforeClass
	public static void beforeAll() throws Exception {
		System.out.println("==== Before All ====");
	}
	
	@Test
	public void t1() throws Exception {
		System.out.println("t1 메서드");
		fail("--- t1 실패 ---");
		
	}
	
	@Test
	public void t2() throws Exception {
		System.out.println("t2 메서드");
		assertEquals(0, 0);
	}
	
	@Before
	public void before() throws Exception {
		System.out.println("**** Before ****");
	}
	
	@After
	public void after() throws Exception {
		System.out.println("**** After ****\n");
	}

	@AfterClass
	public static void afterAll() throws Exception {
		System.out.println("---- After all ----");
	}	

}
