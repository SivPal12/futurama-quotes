<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>HelloWorld</title>
</head>
<body>

    <form:form commandName="quote">
        <label>Quote:</label>
        <form:input path="quote" />
        <input type="submit" />
    </form:form>

    <h1>All quotes</h1>
    <c:forEach items="${quotes}" var="quote">
        <p>${quote.quote}</p>
    </c:forEach>


</body>
</html>
