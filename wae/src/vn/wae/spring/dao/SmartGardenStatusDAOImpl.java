package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.wae.spring.entity.SmartGardenStatus;

@Repository
public class SmartGardenStatusDAOImpl implements SmartGardenStatusDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public SmartGardenStatus getLastStatus() {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM SmartGardenStatus status ORDER BY status.id DESC");
			query.setFirstResult(0);
			query.setMaxResults(1);
			List<SmartGardenStatus> smartGardenStatuses = (List<SmartGardenStatus>) query.getResultList();
			if (!smartGardenStatuses.isEmpty()) {
				return smartGardenStatuses.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new SmartGardenStatus();
	}

	@Override
	public long saveSmartGardenStatus(SmartGardenStatus status) {
		try {
			Session currentSession = getCurrentSession();
			currentSession.saveOrUpdate(status);
			return status.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SmartGardenStatus> getStatuses(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM SmartGardenStatus status ORDER BY status.id DESC");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (List<SmartGardenStatus>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SmartGardenStatus> getStatusByTime(long fromTime, long toTime) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery(
					"FROM SmartGardenStatus status WHERE status.time >= :fromTime AND status.time <= :toTime");
			query.setParameter("fromTime", fromTime);
			query.setParameter("toTime", toTime);

			return (List<SmartGardenStatus>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}
}
