import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Test
  public void team_instantiatesCorrectly_true() {
    Team testTeam = new Team("Hackers");
    assertEquals(true, testTeam instanceof Team);
  }

  @Test
  public void getTeamName_teamInstantiatesWithTeamName_Home() {
    Team testTeam = new Team("Hackers");
    assertEquals("Hackers", testTeam.getTeamName());
  }

  @Test
  public void all_returnsAllInstancesOfTeam_true() {
    Team firstTeam = new Team("Hackers");
    Team secondTeam = new Team("X-Team");
    assertEquals(true, Team.all().contains(firstTeam));
    assertEquals(true, Team.all().contains(secondTeam));
  }

  @Test
  public void clear_emptiesAllTeamsFromList_0() {
    Team testTeam = new Team("Hackers");
    Team.clear();
    assertEquals(Team.all().size(), 0);
  }

  @Test
  public void getId_teamsInstantiateWithAnId_1() {
    Team testTeam = new Team("Hackers");
    assertEquals(1, testTeam.getId());
  }

  @Test
  public void find_returnsTeamWithSameId_secondTeam() {
    Team.clear();
    Team firstTeam = new Team("Home");
    Team secondTeam = new Team("Work");
    assertEquals(Team.find(secondTeam.getId()), secondTeam);
  }
}
