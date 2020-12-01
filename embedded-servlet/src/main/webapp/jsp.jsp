<%-- <%@ directive %> --%>
<%@ page import="by.jrr.jis.service.Counter" %>
<%@ page isELIgnored="false" %>
<%
    //Scriptlet = java code
%>
<%= Math.getExponent(4.0)
        //Expression
%>
<%!
    //Declaration
%>
<html>
<body>

<p>Scriptlet code</p>
<% out.println(Counter.getCount()); %>

<p>Expression code</p>
<%= Counter.getCount() %>

<% int count = 0; %>
<%= ++count %>

<%! int count2 = 9; %>
<%= count2 %>

<p> Lorum ipsum doru <%=count%> tra ta ta</p>

<hr/>
<h2> JFYI </h2>
<p> Implicit objects </p>
<%
    out.print("");          // JspWriter
    request.getCookies();   // HttpServletRequest
    response.getStatus();   // HttpServletResponse
    session.isNew();        // HttpSession
    application.getServerInfo(); // ServletContext
    config.getServletName();// ServletConfig
//    exception             // Throwable
//    pageContext           // PageContext
    page.getClass();        // Object
%>
<p> usage </p>
<% Float one = new Float(42.5); %>
<% pageContext.setAttribute("foo", one); %>

<%= pageContext.getAttribute("foo") %>

<% Float two = new Float(2.0); %>
<% pageContext.setAttribute("foo", two, PageContext.SESSION_SCOPE); %>

<%= pageContext.getAttribute("foo", PageContext.SESSION_SCOPE) %>
<%= session.getAttribute("foo") %>

<%= pageContext.getAttribute("mail", PageContext.APPLICATION_SCOPE) %>
<%= application.getAttribute("mail") %>

<%= pageContext.findAttribute("foo") %>
<h2> end of JFYI </h2>
<hr/>

<%@include file="menu.html" %>



</body>
</html>
