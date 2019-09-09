package com.silver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Repository {

	private List<Order> orderList;

	public boolean register(Order order) {
		return orderList.add(order);

	}

	public void delete(Order o) {
		orderList.remove(o);

	}

	public Repository() {
		orderList = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Repository [orderList=" + orderList + "]";
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public LiveOrderReport summary() {
		LiveOrderReport liveOrderReport = new LiveOrderReport();
		List<String> formattedBuyList = liveOrderReport.getBuyList();
		List<String> formattedSellList = liveOrderReport.getSellList();
		
		Map<Long, Double> groupedBuyList = orderList.stream().filter(o-> o.getOrderType() == OrderTypeEnum.BUY)
				.collect(Collectors.groupingBy(Order::getPricePerKg, Collectors.summingDouble(Order::getOrderQuantity)));
		
		groupedBuyList.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())) 			
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new)).forEach((k,v)->{
					String formattedOrder = v + "kg for £" + k;
					formattedBuyList.add(formattedOrder);
				});

		
		
		Map<Long, Double> groupedSellList = orderList.stream().filter(o-> o.getOrderType() == OrderTypeEnum.SELL)
				.collect(Collectors.groupingBy(Order::getPricePerKg, Collectors.summingDouble(Order::getOrderQuantity)));
		
		groupedSellList.entrySet().stream()
				.sorted(Map.Entry.comparingByKey()) 			
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new)).forEach((k,v)->{
					String formattedOrder = v + "kg for £" + k;
					formattedSellList.add(formattedOrder);
				});
		
		
		return liveOrderReport;

	}

}
