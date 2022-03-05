<%@include file="templates/header.jsp" %>

<c:if test="${user != null}">
    <c:redirect url="employee-view"/>
</c:if>

<div class="container w-100 my-5 bg-light p-4">
    <h1 class="display-5 bg-primary p-3 text-center text-light rounded-3">Employee Management System</h1>
    <div class="mt-4 text-center">
        <h2 class="display-6 mb-2">Welcome!</h2>
        <h5>Sign in to proceed further.</h5>
        <a href="login" class="btn btn-primary btn">Sign in</a>
    </div>
</div>

<%@include file="templates/footer.jsp" %>