<%@ page isELIgnored = "false" %>
<html>
<body>
<h1>Hello ${name}</h1>
<h1>Hello ${login}</h1>

<p>
    <%
        out.print(getServletContext().getAttribute("attributeFromListener"));
    %>
</p>
</body>
</html>
