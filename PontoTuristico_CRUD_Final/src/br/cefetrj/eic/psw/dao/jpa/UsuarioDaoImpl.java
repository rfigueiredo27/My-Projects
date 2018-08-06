package br.cefetrj.eic.psw.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.cefetrj.eic.psw.dao.UsuarioDao;
import br.cefetrj.eic.psw.models.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private EntityManager em;
	
	public UsuarioDaoImpl(EntityManager em) {
		this.em = EM.getLocalEm();
	}
	
	
	@Override
	public void inserirAtualizar(Usuario x) {
		if (x.getId() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Usuario x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Usuario buscar(Long cod) {
		return em.find(Usuario.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarTodos() {
		String jpql = "SELECT x FROM Usuario x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Usuario> buscarPorNome(String name) {
        Query query = em.createQuery("select p FROM Usuario p where p.name like :name");
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Usuario> buscarPorLogin(String login) {
        Query query = em.createQuery("select p FROM Usuario p where p.login like :login");
        query.setParameter("login", "%" + login + "%");
        return query.getResultList();
    }
	
	

}
