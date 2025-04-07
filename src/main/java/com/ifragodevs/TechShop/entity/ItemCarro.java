package com.ifragodevs.TechShop.entity;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarro {

	private int cantidad;
	
	private Producto producto;
	
	public int getImporte() {
		return cantidad * producto.getPrecio();
	}

	@Override
	public boolean equals(Object obj) {
		//Verifica si el objeto comparado es la misma instancia que el actual
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		//Verifica si obj es de la misma clase que el objeto actual
		if (getClass() != obj.getClass())
			return false;
		
		ItemCarro other = (ItemCarro) obj;
		
		return Objects.equals(producto.getId(), other.producto.getId()) && 
				Objects.equals(producto.getNombre(), other.producto.getNombre());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
