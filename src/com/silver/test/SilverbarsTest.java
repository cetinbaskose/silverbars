package com.silver.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.silver.LiveOrderReport;
import com.silver.Order;
import com.silver.OrderTypeEnum;
import com.silver.Repository;

public class SilverbarsTest {

	@Test
	public void registerTest() {

		Order order = new Order(0, 3.0, 300, OrderTypeEnum.BUY);
		Repository repo = new Repository();

		assertTrue(repo.register(order));

	}
	
	@Test
	public void cancelTest() {

		Order order = new Order(0, 3.0, 300, OrderTypeEnum.BUY);
		Repository repo = new Repository();

		assertTrue(repo.register(order));
		repo.cancel(order);
		
		LiveOrderReport liveOrderReport = repo.summary();
		
		assertTrue(liveOrderReport.getBuyList().isEmpty());
		

	}

	@Test
	public void testBuy() {

		Long userId = 1L;
		Double orderQuantity = 3.5;
		Long pricePerKg = 300L;
		OrderTypeEnum orderType = OrderTypeEnum.BUY;

		Order order = new Order(userId, orderQuantity, pricePerKg, orderType);
		Repository repo = new Repository();

		assertTrue(repo.register(order));

		LiveOrderReport liveOrderReport = repo.summary();

		assertEquals(orderQuantity + "kg for £" + pricePerKg, liveOrderReport.getBuyList().get(0));

	}
	
	@Test
	public void testBuySell() {

		Order order = new Order(0, 3.0, 300, OrderTypeEnum.BUY);
		Order order2 = new Order(2, 8.0, 320, OrderTypeEnum.BUY);
		Order order3 = new Order(3, 8.0, 300, OrderTypeEnum.BUY);

		Order order4 = new Order(1, 5.0, 110, OrderTypeEnum.SELL);
		Order order5 = new Order(1, 7.0, 200, OrderTypeEnum.SELL);
		Order order6 = new Order(1, 3.0, 330, OrderTypeEnum.SELL);
		

		Repository repo = new Repository();
		repo.register(order);
		repo.register(order2);
		repo.register(order3);
		repo.register(order4);
		repo.register(order5);
		repo.register(order6);
		
		LiveOrderReport liveOrderReport = repo.summary();
		
		List<String> ExpectedBuyList =new ArrayList<>();
		List<String> ExpectedSellList =new ArrayList<>();

		ExpectedBuyList.add(8.0 + "kg for £" + 320);
		ExpectedBuyList.add(11.0 + "kg for £" + 300);
		
		ExpectedSellList.add(5.0 + "kg for £" + 110);
		ExpectedSellList.add(7.0 + "kg for £" + 200);
		ExpectedSellList.add(3.0 + "kg for £" + 330);


		assertArrayEquals(ExpectedBuyList.toArray(), liveOrderReport.getBuyList().toArray());
		assertArrayEquals(ExpectedSellList.toArray(), liveOrderReport.getSellList().toArray());

	}

}
