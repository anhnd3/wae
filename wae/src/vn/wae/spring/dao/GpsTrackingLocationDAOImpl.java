package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.wae.spring.entity.GpsTrackingLocation;

@Repository
public class GpsTrackingLocationDAOImpl implements GpsTrackingLocationDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public long saveLocation(GpsTrackingLocation location) {
		try {
			Session currentSession = getCurrentSession();
			currentSession.saveOrUpdate(location);
			return location.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GpsTrackingLocation> getLocations(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM GpsTrackingLocation");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<GpsTrackingLocation>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GpsTrackingLocation> getLocationsByTime(String fromTime, String toTime) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery(
					"FROM GpsTrackingLocation location WHERE location.time >= :fromTime AND location.time <= :toTime");
			query.setParameter("fromTime", fromTime);
			query.setParameter("toTime", toTime);

			return (ArrayList<GpsTrackingLocation>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

}
