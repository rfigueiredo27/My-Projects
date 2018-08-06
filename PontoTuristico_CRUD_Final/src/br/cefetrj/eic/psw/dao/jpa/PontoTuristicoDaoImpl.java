package br.cefetrj.eic.psw.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.cefetrj.eic.psw.dao.PontoTuristicoDao;
import br.cefetrj.eic.psw.models.PontoTuristico;

public class PontoTuristicoDaoImpl implements PontoTuristicoDao {

	private EntityManager em;
	
	public PontoTuristicoDaoImpl(EntityManager em) {
		this.em = EM.getLocalEm();
	}
	
	
	@Override
	public void inserirAtualizar(PontoTuristico x) {
		if (x.getId() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(PontoTuristico x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public PontoTuristico buscar(Long cod) {
		return em.find(PontoTuristico.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PontoTuristico> buscarTodos() {
		String jpql = "SELECT x FROM PontoTuristico x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public List<PontoTuristico> buscarPorNome(String name) {
        Query query = em.createQuery("select p FROM PontoTuristico p where p.name like :name");
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<PontoTuristico> buscarPorDescricao(String descricao) {
        Query query = em.createQuery("select p FROM PontoTuristico p where p.descricao like :descricao");
        query.setParameter("descricao", "%" + descricao + "%");
        return query.getResultList();
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<PontoTuristico> buscarPorCidade(String cidade) {
        Query query = em.createQuery("select p FROM PontoTuristico p where p.cidade like :cidade");
        query.setParameter("cidade", "%" + cidade + "%");
        return query.getResultList();
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<PontoTuristico> buscarPorEstado(String estado) {
        Query query = em.createQuery("select p FROM PontoTuristico p where p.estado like :estado");
        query.setParameter("estado", "%" + estado + "%");
        return query.getResultList();
    }
	
	
	

}
