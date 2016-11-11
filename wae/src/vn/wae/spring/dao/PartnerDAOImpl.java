package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.wae.spring.entity.Partner;

@Repository
public class PartnerDAOImpl implements PartnerDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int savePartner(Partner partner) {
		try {
			Session currentSession = getCurrentSession();
			currentSession.saveOrUpdate(partner);
			return partner.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deletePartner(int partnerId) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("DELETE FROM Partner p WHERE p.id=:partnerId");
			query.setParameter("partnerId", partnerId);
			return query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public Partner getPartner(int partnerId) {
		try {
			Session currentSession = getCurrentSession();
			return currentSession.get(Partner.class, partnerId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Partner();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Partner> getPartners(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM Partner");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<Partner>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Partner> getPartnersAvailable(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM Partner p where p.status = true");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<Partner>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

}
