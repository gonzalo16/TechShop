package com.ifragodevs.TechShop.repository;

import java.util.List;

import com.ifragodevs.TechShop.anotations.Repository;
import com.ifragodevs.TechShop.anotations.RepositoryJpa;
import com.ifragodevs.TechShop.entity.Producto;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@Repository
@RepositoryJpa
public class ProductoRepositoryImpl implements CrudRepository<Producto>{

	@Inject
	private EntityManager em;
				
	@Override
	public List<Producto> listar() throws Exception {
		return em.createQuery("from Producto",Producto.class).getResultList();
	}

	@Override
	public Producto findById(Integer id) throws Exception {
		return em.find(Producto.class, id);
	}

	@Override
	public void save(Producto t) throws Exception {
		if(t.getId() != null && t.getId() > 0) {
			em.merge(t);
		}else {
			em.persist(t);
		}
	}
	

	@Override
	public void eliminar(Integer id) throws Exception {
		Producto productoParaBorrar = findById(id);
		em.remove(productoParaBorrar);
	}
}
