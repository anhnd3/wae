package vn.wae.spring.dao;

import java.util.List;

import vn.wae.spring.entity.Teammate;

public interface TeamDAO {

	public int saveTeam(Teammate team);

	public int deleteTeam(int teamId);

	public Teammate getTeam(int teamId);

	public List<Teammate> getTeams(int pos, int limit);
}