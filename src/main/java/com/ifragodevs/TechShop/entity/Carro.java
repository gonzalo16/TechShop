package com.ifragodevs.TechShop.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carro {

	private List<ItemCarro> items = new ArrayList<>();
	
	public void addItem(ItemCarro item) {
		if(items.contains(item)) {
			Optional<ItemCarro> itemCarroOpt = items.stream().filter(i -> i.equals(item)).findFirst();
			ItemCarro itemCarro = itemCarroOpt.get();
			
			itemCarro.setCantidad(itemCarro.getCantidad() + 1);
		}else {
			this.items.add(item);
		}
	}
	
	public int getTotalItems() {
		return items.stream().mapToInt(i -> i.getImporte()).sum();
	}
}
