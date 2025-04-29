package com.ifragodevs.TechShop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.ifragodevs.TechShop.anotations.CarroCompra;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@CarroCompra
public class Carro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<ItemCarro> items;
	
	@Inject
	private transient Logger logger;
	
	@PostConstruct
	public void inicializar() {
		this.items = new ArrayList<>();
		logger.info("Inicializando el carro de compras!!");
	}
	
	@PreDestroy
	public void destruir() {
		logger.info("Destruyendo el carro de compras");
	}
	
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
