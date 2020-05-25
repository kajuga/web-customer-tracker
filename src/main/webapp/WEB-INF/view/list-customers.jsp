<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customers</title>
    <link type="text/css"
    rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div id="wrapper">

    <div id="header">
        <h2>
            CRM - Customer Relationship Manager
        </h2>
    </div>
</div>
<div id="container">
    <div id="content">

<%--        put new button: Add Customer--%>
    <input type="button" value="Add Customer"
           onclick="window.location.href='showFormAdd'; return false;"
           class="add-button"
           />

<%--        add out html table here--%>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <%-- loop over and print our costomer--%>
            <c:forEach var="tempCustomer" items="${customers}">

                <%-- construst an "update link with customer is"--%>
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}" />
                </c:url>

                <%-- construst an "DELETE" link with customer is"--%>
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}" />
                </c:url>

                <tr>
                    <td> ${tempCustomer.firstName}</td>
                    <td> ${tempCustomer.lastName}</td>
                    <td> ${tempCustomer.email}</td>

                    <%--  display the update link--%>
                    <td><a href="${updateLink}">Update</a>
                    |
                    <a href="${deleteLink}"
                    onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                    </td>


                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
