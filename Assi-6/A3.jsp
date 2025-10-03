<html>
<body>
<% if (request.getParameter("num") != null) {
    String num = request.getParameter("num");
    StringBuilder words = new StringBuilder();
    for (char c : num.toCharArray()) {
        int d = c - '0';
        switch(d) {
            case 0: words.append("Zero "); break;
            case 1: words.append("One "); break;
            case 2: words.append("Two "); break;
            case 3: words.append("Three "); break;
            case 4: words.append("Four "); break;
            case 5: words.append("Five "); break;
            case 6: words.append("Six "); break;
            case 7: words.append("Seven "); break;
            case 8: words.append("Eight "); break;
            case 9: words.append("Nine "); break;
        }
    }
    out.println(num + " - " + words.toString().trim());
} %>
</body>
</html>
