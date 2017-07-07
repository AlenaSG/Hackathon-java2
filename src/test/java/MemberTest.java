import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {

  @Test
  public void Member_instantiatesCorrectly_true() {
    Member myMember = new Member("Victor Ogurtcov");
    assertEquals(true, myMember instanceof Member);
  }

  @Test
  public void Member_instantiatesWithName_String() {
    Member myMember = new Member("Victor Ogurtcov");
    assertEquals("Victor Ogurtcov", myMember.getName());
  }

  @Test
  public void all_returnsAllInstancesOfMember_true() {
    Member firstMember = new Member("Victor Ogurtcov");
    Member secondMember = new Member("Andrey Arkharov");
    assertEquals(true, Member.all().contains(firstMember));
    assertEquals(true, Member.all().contains(secondMember));
  }

  @Test
  public void clear_emptiesAllMembersFromArrayList_0() {
  Member myMember = new Member("Victor Ogurtcov");
  Member.clear();
  assertEquals(0, Member.all().size());
  }

  @Test
  public void getId_membersInstantiateWithAnID_1() {
    Member.clear();
    Member myMember = new Member("Victor Ogurtcov");
    assertEquals(1, myMember.getId());
  }

}
