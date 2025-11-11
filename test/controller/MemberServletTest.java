package controller;

import model.Member;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class MemberServletTest {

    private MemberServlet servlet;

    @Before
    public void setUp() {
        servlet = new MemberServlet();
    }

    @Test
    public void testMemberConstructorAndGetters() {
        Member m = new Member("HE181586", "Phạm Gia Bảo", "0397346526", "Male", "Java, HTML");

        assertThat(m.getRollNumber(), is("HE181586"));
        assertThat(m.getName(), is("Phạm Gia Bảo"));
        assertThat(m.getPhone(), is("0397346526"));
        assertThat(m.getGender(), is("Male"));
        assertThat(m.getSkills(), is("Java, HTML"));
    }


    @Test
    public void testAddMember() {
        List<Member> members = new ArrayList<>();
        String[] skills = {"Java", "HTML"};

        members = servlet.processAction(members, "add",
                "HE181586", "Phạm Gia Bảo", "0397346526", "Male", skills);

        assertThat(members.size(), is(1));
        assertThat(members.get(0).getName(), is("Phạm Gia Bảo"));
        assertThat(members.get(0).getSkills(), is("Java, HTML"));
    }


    @Test
    public void testAddMemberWithoutSkills() {
        List<Member> members = new ArrayList<>();

        members = servlet.processAction(members, "add",
                "HE181587", "Lan", "0123456789", "Female", null);

        assertThat(members.size(), is(1));
        assertThat(members.get(0).getSkills(), is("None"));
    }


    @Test
    public void testClearMembers() {
        List<Member> members = new ArrayList<>();
        members.add(new Member("HE181586", "Bảo", "0397346526", "Male", "Java"));

        members = servlet.processAction(members, "clear", null, null, null, null, null);

        assertThat(members.isEmpty(), is(true));
    }
}
