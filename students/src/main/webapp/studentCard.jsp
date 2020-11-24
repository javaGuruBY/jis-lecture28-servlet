<%@ page import="by.jrr.jis.school.bean.Student" %>

<!DOCTYPE html>
<html lang=en>
<head>
    <meta charset=UTF-8>
    <title>timer</title>
</head>
<body align=center>
<h1> This one will never change! </h1>
<table align=center>
    <tr>
            <td>
                    <img src=https://upload.wikimedia.org/wikipedia/commons/a/a0/Reuni%C3%A3o_com_o_ator_norte-americano_Keanu_Reeves_%28cropped%29.jpg
                         width=150px
                         height=150px />
                </td>
            <td>
                <%
                    Student s = (Student) request.getAttribute("student");
                    out.print(s.getName() + " " + s.getLastName() + " <br />");
                %>
                <br /> +</td>
        </tr>
</table>
</body>
</html>
