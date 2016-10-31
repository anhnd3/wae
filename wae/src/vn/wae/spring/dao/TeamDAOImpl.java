package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.wae.spring.entity.Teammate;

@Repository
public class TeamDAOImpl implements TeamDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int saveTeam(Teammate team) {
		try {
			Session currentSession = getCurrentSession();
			currentSession.saveOrUpdate(team);
			return team.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteTeam(int teamId) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("DELETE FROM Team t WHERE t.id=:teamId");
			query.setParameter("teamId", teamId);
			return query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public Teammate getTeam(int teamId) {
		try {
			Session currentSession = getCurrentSession();
			return currentSession.get(Teammate.class, teamId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Teammate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teammate> getTeams(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM Team");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<Teammate>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

}
