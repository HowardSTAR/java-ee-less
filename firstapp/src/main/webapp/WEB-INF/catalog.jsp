<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

    <body>
    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>
    <h1>Это каталог товаров</h1>

        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Price</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="product" items="${requestScope.products}">
                    <tr>
                        <th scope="row">
                            <c:out value="${product.id}"/>
                        </th>
                        <td>
                            <c:out value="${product.name}"/>
                        </td>
                        <td>
                            <c:out value="${product.description}"/>
                        </td>
                        <td>
                            <c:out value="${product.price}"/>
                        </td>
                        <td>
                            <c:url value="/#" var="todoEditUrl">
                                <c:param name="id" value="${product.id}"/>
                            </c:url>
                            <a class="btn btn-success" href="${todoEditUrl}"><i class="fas fa-edit"></i></a>
                            <a class="btn btn-danger" href="#"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
