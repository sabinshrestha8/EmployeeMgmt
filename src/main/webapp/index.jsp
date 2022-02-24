<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp" %>

<c:if test="${user!=null}">
    <c:redirect url="employee-view"/>
</c:if>

<div class="container w-50 my-5 bg-light p-4 rounded-3 shadow-lg">
    <h1 class="display-5 bg-dark p-3 text-center text-light">Employee Management System</h1>
    <div class="mt-4 text-center">
        <h2 class="display-6 mb-2">Welcome!</h2>
        <h5>Sign in to proceed further.</h5>
        <a href="admin" class="btn btn-success btn">Sign in</a>
    </div>
</div>

<%@include file="templates/footer.jsp" %>