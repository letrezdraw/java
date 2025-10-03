<%@page import="java.util.*"%>
<html>
    <body>
        <% 
            String user = request.getParameter("uname");
            out.println("<h1>Welcome : "+user+"</h1>");
            Date d = new Date();
            out.println("Today date is : "+d);
        %>

        <%=request.getParameter("uname") %>
    </body>
</html>