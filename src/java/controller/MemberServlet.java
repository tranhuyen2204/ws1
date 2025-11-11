package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Member;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Member> members = (List<Member>) session.getAttribute("members");

        if (members == null) {
            members = new ArrayList<>();
            session.setAttribute("members", members);
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String rollNumber = request.getParameter("rollNumber");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            String[] skillArray = request.getParameterValues("skills");
            String skills = (skillArray != null) ? String.join(", ", skillArray) : "None";

            Member newMember = new Member(rollNumber, name, phone, gender, skills);
            members.add(newMember);
        } else if ("clear".equals(action)) {
            members.clear();
        }

        response.sendRedirect("index.jsp");
    }
    
    public List<Member> processAction(List<Member> members, String action,
                                      String rollNumber, String name,
                                      String phone, String gender, String[] skillsArray) {

        if (members == null) {
            members = new ArrayList<>();
        }

        if ("add".equals(action)) {
            String skills = (skillsArray != null) ? String.join(", ", skillsArray) : "None";
            Member newMember = new Member(rollNumber, name, phone, gender, skills);
            members.add(newMember);
        } else if ("clear".equals(action)) {
            members.clear();
        }
        return members;
    }
}
