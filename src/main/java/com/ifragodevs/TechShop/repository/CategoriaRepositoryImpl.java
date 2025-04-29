package com.ifragodevs.TechShop.repository;

import java.util.List;

import com.ifragodevs.TechShop.anotations.Repository;
import com.ifragodevs.TechShop.anotations.RepositoryJpa;
import com.ifragodevs.TechShop.entity.Categoria;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@Repository
@RepositoryJpa
public class CategoriaRepositoryImpl implements CrudRepository<Categoria> {

	@Inject
	private EntityManager em;

	@Override
	public List<Categoria> listar() throws Exception {

		List<Categoria> categorias = em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
		return categorias;

	}

	@Override
	public Categoria findById(Integer id) throws Exception {
		Categoria categoria = em.find(Categoria.class, id);
		return categoria;
	}

	@Override
	public void save(Categoria t) {

		if (t.getId() != null && t.getId() > 0) {
			em.merge(t);
		} else {
			em.persist(t);
		}

	}

	@Override
	public void eliminar(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

}
