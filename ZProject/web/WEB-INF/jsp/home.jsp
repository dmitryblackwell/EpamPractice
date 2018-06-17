<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
<head>
    <title>Home</title>
    <%@ include file="/WEB-INF/jspf/links.jspf" %>
    <script type="text/javascript" src="script/jquery-ui.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="style/jquery-ui.css">
</head>

<body>

<div id="wrap" class="container">
    <c:set var="title" value="login"/>
    <%@ include file="/WEB-INF/jspf/header.jspf" %>

    <div id="content" class="column span-24 last">

        <c:if test="${requestScope.stations == null}">
            <jsp:forward page="/controller?command=get_stations"/>
        </c:if>


        <script>
            $( function() {
                var stations = [
                    <c:forEach items="${requestScope.stations}" var="station">
                        "${station}",
                    </c:forEach>
                ];
                $( "#start" ).autocomplete({
                    source: stations
                });
                $( "#end" ).autocomplete({
                    source: stations
                });
            } );
        </script>

        <form id="search_form">
            <input type="text" name="start" id="start" placeholder="start station">
            <input type="text" name="end" id="end" placeholder="end station">
            <input type="submit" id="submit">
        </form>

    </div>
</div>

</body>
</html>