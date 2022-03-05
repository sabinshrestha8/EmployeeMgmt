<%@ include file="/templates/header.jsp" %>

<div class="container p-4 w-50 shadow rounded">
    <legend class="display-5 pb-3 fw-bolder text-primary">Add Department</legend>
    <form action="department-form" method="post">
        <div class="row flex-row p-2">
            <div class="col-md align-self-center mb-3">
                <label class="form-label">Name:</label>
                <input type="text" class="form-control" placeholder="AI" name="name" required>
            </div>
        </div>
        <div class="d-flex justify-content-end">
            <button type="submit" class="btn btn-primary px-2">Save</button>
        </div>
    </form>
</div>

<%@ include file="/templates/footer.jsp" %>
