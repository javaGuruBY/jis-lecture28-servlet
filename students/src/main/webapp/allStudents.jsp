<%@ page import="java.util.List" %>
<%@ page import="by.jrr.jis.school.bean.Student" %>

<!DOCTYPE html>
<html lang=en>
<head>
    <meta charset=UTF-8>
    <title>timer</title>
</head>
<body align=center>
<h1> Max changed servlets </h1>
<p> Here goes message:
    <%
        out.print(request.getAttribute("message"));
    %>
</p>
<table align=center>
    <tr>
            <th>id</th>
            <th>name</th>
            <th>lastName</th>
            <th>email</th>
            <th>age</th>
        </tr>
    <%
        List<Student> studentList = (List<Student>) request.getAttribute("studentList");
        for (Student s : studentList) {
            out.print("" +
                    "    <tr>\n" +
                            "        <td>" + s.getId() + "</td>\n" +
                            "        <td><a href=\"/school/student/"+(s.getId()) +"\">" + s.getName() + "</a></td>\n" +
                            "        <td>" + s.getLastName() + "</td>\n" +
                            "        <td>" + s.getAge() + "</td>\n" +
                            "    </tr>\n");
        }

    %>

        <tr>
            <th>id</th>
            <th>name</th>
            <th>lastName</th>
            <th>email</th>
            <th>age</th>
        </tr>
    </table>
</body>
</html>
