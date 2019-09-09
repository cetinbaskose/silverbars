package com.silver;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class SilverbarsTest {

	@Test
	public void registerTest() {

		Order order = new Order(0, 3.0, 300, OrderTypeEnum.BUY);
		Repository repo = new Repository();

		assertTrue(repo.register(order));

	}

	@Test
	public void test() {
      
		Long userId =1L;
       	Double orderQuantity = 3.5;
    	Long pricePerKg =300L;
    	OrderTypeEnum orderType= OrderTypeEnum.BUY;
        
		
		Order order = new Order(userId, orderQuantity, pricePerKg, orderType);
		Repository repo = new Repository();
		
		assertTrue(repo.register(order));
		
		LiveOrderReport liveOrderReport=  repo.summary();

		assertEquals(orderQuantity + "kg for £" + pricePerKg, liveOrderReport.buyList.get(0).toString());
		
	}

}
