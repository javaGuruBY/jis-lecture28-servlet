<%@ page isELIgnored = "false" %>
<html>
<body>
<h1>Hello ${name}</h1>
<h2>${message}</h2>
<p>${email}</p>

<h3> short form</h3>
<p>boss: ${bossEmail}</p>
<h3> java code form</h3>
<%
    out.print(request.getAttribute("bossEmail"));
%>


<p>
    <%
        out.print(getServletContext().getInitParameter("bossEmail"));
    %>
</p>

<p>
    <%
        out.print(getServletContext().getAttribute("attributeFromListener"));
    %>
</p>
</body>
</html>
