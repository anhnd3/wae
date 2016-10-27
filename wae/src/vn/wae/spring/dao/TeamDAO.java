package vn.wae.spring.dao;

import java.util.List;

import vn.wae.spring.entity.Team;

public interface TeamDAO {

	public int saveTeam(Team team);

	public int deleteTeam(int teamId);

	public Team getTeam(int teamId);

	public List<Team> getTeams(int pos, int limit);
}