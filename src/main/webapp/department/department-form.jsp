<%@ include file="/templates/header.jsp" %>

<h2 class="text-center my-4">Add Department</h2>
<div class="container w-50 mr-0">
    <form action="department-form" method="post">
        <div class="mb-3">
            <label class="form-label">Name:</label>
            <input type="text" class="form-control" placeholder="AI" name="name">
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>

<%@ include file="/templates/footer.jsp" %>
