package com.silver;

import java.util.ArrayList;
import java.util.List;

public class LiveOrderReport {

	List<String> buyList;
	List<String> sellList;

	public LiveOrderReport() {
		buyList = new ArrayList<>();
		sellList = new ArrayList<>();
	}

	public List<String> getBuyList() {
		return buyList;
	}

	public void setBuyList(List<String> buyList) {
		this.buyList = buyList;
	}

	public List<String> getSellList() {
		return sellList;
	}

	public void setSellList(List<String> sellList) {
		this.sellList = sellList;
	}

}
