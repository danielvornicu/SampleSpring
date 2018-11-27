<%--@elvariable id="clients" type="java.util.List<tech.dev.entites.Client>"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
                    <td><a href="client?id=${client.id}">Detail</a></td>
                    <td><a href="deleteClient?id=${client.id}">Supprimer</a></td>
                </tr>
            </c:forEach>
        </table>

        <a href="admin/ajouterClient">Ajouter un client</a>
        <sec:authorize access="isAuthenticated()">
            <c:url var="logout" value="/logout" />
            <form action="${logout}" method="post">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
                <input type="submit" value="Logout">
            </form>
        </sec:authorize>

    </body>
</html>
