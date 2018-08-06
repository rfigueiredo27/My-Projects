package br.cefetrj.eic.psw.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.cefetrj.eic.psw.dao.RestauranteDao;
import br.cefetrj.eic.psw.models.Restaurante;

public class RestauranteDaoImpl implements RestauranteDao {

	private EntityManager em;
	
	public RestauranteDaoImpl(EntityManager em) {
		this.em = EM.getLocalEm();
	}
	
	
	

	@Override
	public void inserirAtualizar(Restaurante x) {
		if (x.getId() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Restaurante x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Restaurante buscar(Long cod) {
		return em.find(Restaurante.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurante> buscarTodos() {
		String jpql = "SELECT x FROM Restaurante x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Restaurante> buscarPorNome(String name) {
        Query query = em.createQuery("select p FROM Restaurante p where p.name like :name");
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Restaurante> buscarPorDescricao(String descricao) {
        Query query = em.createQuery("select p FROM Restaurante p where p.descricao like :descricao");
        query.setParameter("descricao", "%" + descricao + "%");
        return query.getResultList();
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Restaurante> buscarPorCidade(String cidade) {
        Query query = em.createQuery("select p FROM Restaurante p where p.cidade like :cidade");
        query.setParameter("cidade", "%" + cidade + "%");
        return query.getResultList();
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Restaurante> buscarPorEstado(String estado) {
        Query query = em.createQuery("select p FROM Restaurante p where p.estado like :estado");
        query.setParameter("estado", "%" + estado + "%");
        return query.getResultList();
    }
	
	

}
