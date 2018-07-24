<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Affichage liste clients</title>
</head>
    <body>
        <table>
            <thead>
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
            </tr>
            </thead>
            <c:forEach items="${clients}" var="client">
                <tr>
                    <td>${client.nom}</td>
                    <td>${client.prenom}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
