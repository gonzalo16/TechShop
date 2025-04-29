package com.ifragodevs.TechShop.repository;

import java.util.List;

import com.ifragodevs.TechShop.anotations.Repository;
import com.ifragodevs.TechShop.anotations.RepositoryJpa;
import com.ifragodevs.TechShop.entity.Usuario;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@Repository
@RepositoryJpa
public class UsuarioRepositoryImpl implements UsuarioRepository {

	@Inject
	private EntityManager em;

	@Override
	public List<Usuario> listar() throws Exception {
		return em.createQuery("from Usuario", Usuario.class).getResultList();
	}

	@Override
	public Usuario findById(Integer id) throws Exception {
		return em.find(Usuario.class, id);
	}

	@Override
	public void save(Usuario t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario findByUsername(String username) throws Exception {

		return em.createQuery("select u from Usuario u where u.username = :username", Usuario.class)
				.setParameter("username", username).getSingleResult();
	}

}
