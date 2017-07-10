
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //new route for new members, to create them within teams
    get("teams/:id/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      model.put("team", team);
      model.put("template", "templates/team-members-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //new route for creating and adding members inside teams
    post("/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.queryParams("teamId")));
      String name = request.queryParams("name");
      Member newMember = new Member(name);
      team.addMember(newMember);
      model.put("team", team);
      model.put("template", "templates/team-member-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:team_id/members/:member_id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":team_id")));
      model.put("team", team);
      Member member = Member.find(Integer.parseInt(request.params(":member_id")));
      model.put("member", member);
      model.put("template", "templates/member.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String teamName = request.queryParams("teamName");
      Team newTeam = new Team(teamName);
      model.put("template", "templates/team-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.all());
      model.put("template", "templates/teams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      model.put("team", team);
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());




  }
}
