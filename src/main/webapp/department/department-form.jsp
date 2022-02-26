<%@ include file="/templates/header.jsp" %>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache");   //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxies
%>

<h2 class="text-center my-4">Add Department</h2>
<div class="container w-50 mr-0">
    <form action ="department-form" method="post">
        <input type="hidden" value="${Department.id}" name="id">
        <div class="mb-3">
            <label class="form-label">Name:</label>
            <input type="text" class="form-control" value="${Department.name}" placeholder="AI" name="name">
        </div>
        <button type="submit" class="btn btn-primary">${action}</button>
    </form>
</div>

<%@ include file="/templates/footer.jsp" %>
