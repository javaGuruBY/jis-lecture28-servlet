<%-- <%@ directive %> --%>
<%@ page import="by.jrr.jis.service.Counter" %>
<%@ page import="by.jrr.jis.Person" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<%@ include file="menu.html" %>

<hr/>
<h2>Expression Language (EL)</h2>
<table border="1">
    <tr>
        <td><%= ((Person) request.getAttribute("person")).getName() %>
        </td>
        <td><%= ((Person) request.getAttribute("person")).getDog().getName() %>
        </td>
    </tr>
    <tr>
        <td>${person.getName()}</td>
        <td>${person.getDog().getName()}</td>
    </tr>
    <tr>
        <td>${person.name}</td>
        <td>${person.dog.name}</td>
    </tr>
</table>
<h2> JSTL tags -JSP Standard Tag Library </h2>
<h3>iteration</h3>
<ul>
    <li> ${person.hostelDogs.get(0).name} </li>
    <li> ${person.hostelDogs.get(1).name} </li>
    <li> ${person.hostelDogs.get(2).name} </li>
    <li> ${person.hostelDogs.get(3).name} </li>
    <li> ${person.hostelDogs.get(4).name} </li>
</ul>

<h3>loop</h3>
<ul>
    <c:forEach var="dog" items="${person.hostelDogs}">
        <li>${dog.name}</li>
    </c:forEach>
</ul>

<ul>
    <c:forEach var="dog" items="${person.hostelDogs}" varStatus="dogCount">
        <li># ${dogCount.count} - ${dog.name}</li>
    </c:forEach>
</ul>

<h3>if</h3>
<c:if test="${person.name eq 'personName'}">
    <h1> secret content </h1>
    <%@ include file="menu.html" %>
</c:if>

<h3>switch/case if /else</h3>

<h3> filter </h3>
<c:forEach var="dog" items="${person.hostelDogs}">
    <c:choose>
        <c:when test="${dog.age == 10}">
            <li># ${dog.age} - ${dog.name}</li>
        </c:when>

        <c:when test="${dog.age == 12}">
            <li># ${dog.age} - ${dog.name}</li>
        </c:when>

        <c:otherwise>
            <li># not valid filter</li>
        </c:otherwise>
    </c:choose>
</c:forEach>

<h3>set value</h3>
<c:set var="personName" value="name" />
<p>${personName}</p>

<c:set var="personName" value="${person.dog.name}" />
<p>${personName}</p>

<p>${person.name = "new name"}</p>
<p>${person.name}</p>

<h3> include with params </h3>
<c:import url="dynamicMenu.jsp">
    <c:param name="menuName" value="Hello from parent page" />
</c:import>

<c:import url="https://google.com" />

</body>
</html>
