<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Creation d'un client</title>
</head>
<body>
    <form:form method="POST" commandName="client" action="creerClient">
        <p>
            <label>Nom :</label>
            <form:input path="nom" />
        </p>
        <p>
            <label>Prenom :</label>
            <form:input path="prenom" />
        </p>
        <input type="submit" value="Creer">
    </form:form>
</body>
</html>
