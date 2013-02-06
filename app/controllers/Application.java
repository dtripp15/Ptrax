package controllers;

import models.Team;
import play.data.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
	
	static Form<Team> teamForm = form(Team.class);		
  
	public static Result index() {
		return redirect(routes.Application.teams());
    }

	public static Result teams() {
		  return ok(
				  views.html.index.render(Team.all(), teamForm)
				  );
		  }
	
	public static Result newTeam() {
		  Form<Team> filledForm = teamForm.bindFromRequest();
		  if(filledForm.hasErrors()) {
			  return badRequest(
					  views.html.index.render(Team.all(), teamForm)
					  );
		  } else {
			  Team.create(filledForm.get());
			  return redirect(routes.Application.teams());
		  }
	  }	
	public static Result deleteTeam(Long id) {
		  Team.delete(id);
		  return redirect(routes.Application.teams());
	  }	
}