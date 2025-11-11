<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="model.Member" %>

<%
    HttpSession sessionObj = request.getSession();
    List<Member> members = (List<Member>) sessionObj.getAttribute("members");
    if (members == null) {
        members = new ArrayList<>();
        sessionObj.setAttribute("members", members);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Workshop 1 - Coding Club</title>
        <style>
            .no-border {
                border: none;
                padding: 5px;
            }
            .bordered, .bordered th, .bordered td {
                border: 2px solid black;
                border-collapse: collapse;
                padding: 5px;
            }
            .bordered th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <h2>Workshop 1 of HE181093 - Nguyễn Minh Kiên</h2>
        <h3>List of Coding Club</h3>

        <form action="MemberServlet" method="post">
            <table class="no-border">
                <tr>
                    <td><label>Enter RollNumber:</label></td>
                    <td><input type="text" name="rollNumber" required></td>
                </tr>
                <tr>
                    <td><label>Enter Name:</label></td>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <td><label>Enter Phone Number:</label></td>
                    <td><input type="text" name="phone" required></td>
                </tr>
                <tr>
                    <td><label>Gender:</label></td>
                    <td>
                        <input type="radio" id="male" name="gender" value="Male" required>
                        <label for="male">Male</label>
                        <input type="radio" id="female" name="gender" value="Female">
                        <label for="female">Female</label>
                    </td>
                </tr>
                <tr>
                    <td><label>Skill:</label></td>
                    <td>
                        <input type="checkbox" id="c" name="skills" value="C">
                        <label for="c">C</label>

                        <input type="checkbox" id="java" name="skills" value="Java">
                        <label for="java">Java</label>

                        <input type="checkbox" id="python" name="skills" value="Python">
                        <label for="python">Python</label>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button type="submit" name="action" value="add">Add</button>
                        <button type="reset">New</button>
                    </td>
                </tr>
            </table>
        </form>

        <br>

        <table class="bordered">
            <tr>
                <th>No</th>
                <th>Rollnumber</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Phone</th>
                <th>Skill</th>
            </tr>
            <%
                int index = 1;
                for (Member member : members) {
            %>
            <tr>
                <td><%= index++ %></td>
                <td><%= member.getRollNumber() %></td>
                <td><%= member.getName() %></td>
                <td><%= member.getGender() %></td>
                <td><%= member.getPhone() %></td>
                <td><%= member.getSkills() %></td>
            </tr>
            <% } %>
        </table>

        <br>
        <form action="MemberServlet" method="post">
            <button type="submit" name="action" value="clear">Clear List</button>
        </form>

    </body>
</html>
