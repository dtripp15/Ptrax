package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Team extends Model {

	@Id
	public Long id;
	
	public Long leagueid;
	
	public Long divisionid;
	
	public String team_name;
	
	public static Finder<Long,Team> find = new Finder(
			Long.class, Team.class
			);
	
	public static List<Team> all() {
		return find.all();
	}
	
	public static void create(Team team) {
		team.save();
	}
	
	public static void delete(Long id) {
		find.ref(id).delete();
	}
	
}
