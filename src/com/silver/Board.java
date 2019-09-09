package com.silver;

public class Board {

	public static void main(String[] args) {

		Order order = new Order(0, 3.0, 300, OrderTypeEnum.BUY);
		Order order3 = new Order(2, 8.0, 320, OrderTypeEnum.BUY);
		Order order4 = new Order(3, 8.0, 320, OrderTypeEnum.BUY);
		Order order5 = new Order(3, 8.0, 300, OrderTypeEnum.BUY);
		Order order6 = new Order(3, 8.0, 400, OrderTypeEnum.BUY);
		Order order11 = new Order(3, 100.0, 400, OrderTypeEnum.BUY);

		Order order2 = new Order(1, 5.0, 110, OrderTypeEnum.SELL);
		Order order7 = new Order(1, 5.0, 200, OrderTypeEnum.SELL);
		Order order8 = new Order(1, 3.0, 330, OrderTypeEnum.SELL);
		Order order9 = new Order(1, 11.0, 200, OrderTypeEnum.SELL);
		Order order10 = new Order(1, 5.0, 330, OrderTypeEnum.SELL);
		Order order12 = new Order(1, 5.0, 70, OrderTypeEnum.SELL);
		Order order13 = new Order(1, 5.0, 500, OrderTypeEnum.SELL);

		Repository repo = new Repository();
		repo.register(order);
		repo.register(order2);
		repo.register(order3);
		repo.register(order4);
		repo.register(order5);
		repo.register(order6);
		repo.register(order7);
		repo.register(order8);
		repo.register(order9);
		repo.register(order10);
		repo.register(order11);
		repo.register(order12);
		repo.register(order13);

		LiveOrderReport report = repo.summary();

		report.getBuyList().forEach(System.out::println);
		System.out.println("------------------------------");
		report.getSellList().forEach(System.out::println);
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		repo.delete(order6);
		repo.delete(order10);
		LiveOrderReport report2 = repo.summary();
		report2.getBuyList().forEach(System.out::println);
		System.out.println("------------------------------");
		report2.getSellList().forEach(System.out::println);

	}

}
