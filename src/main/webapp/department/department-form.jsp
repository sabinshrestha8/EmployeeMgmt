<%@ include file="/templates/header.jsp" %>

<h2 class="text-center my-4">Add Department</h2>
<div class="container w-50 mr-0">
    <form action ="employee-form" method="post">
        <input type="hidden" value="${Department.id}" name="id">
        <div class="mb-3">
            <label class="form-label">Name:</label>
            <input type="text" class="form-control" value="${Department.name}" placeholder="AI" name="name">
        </div>
    </form>
</div>

<%@ include file="/templates/footer.jsp" %>
