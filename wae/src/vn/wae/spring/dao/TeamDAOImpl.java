package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import vn.wae.spring.entity.Team;

public class TeamDAOImpl implements TeamDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int saveTeam(Team team) {
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
	public Team getTeam(int teamId) {
		try {
			Session currentSession = getCurrentSession();
			return currentSession.get(Team.class, teamId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Team();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> getTeams(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM Team");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<Team>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

}
