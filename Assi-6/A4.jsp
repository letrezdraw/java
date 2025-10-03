<html>
<body>
<%
String n1 = request.getParameter("num1");
String n2 = request.getParameter("num2");
String op = request.getParameter("op");
if (n1 != null && n2 != null && op != null) {
    double a = Double.parseDouble(n1);
    double b = Double.parseDouble(n2);
    double res = 0;
    String ops = "";
    switch(op) {
        case "add": res = a + b; ops = "+"; break;
        case "sub": res = a - b; ops = "-"; break;
        case "mul": res = a * b; ops = "*"; break;
        case "div": if (b != 0) { res = a / b; ops = "/"; } else { out.println("Error: Division by zero"); return; } break;
    }
    out.println(a + " " + ops + " " + b + " = " + res);
}
%>
</body>
</html>
