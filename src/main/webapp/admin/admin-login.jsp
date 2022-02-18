<%@ include file="/templates/header.jsp"%>

<div class="container w-50 mr-0">
    <h2 class="text-center mt-4">LOGIN IN</h2>
    <form action ="employee-form" method="post">
        <input type="hidden" value="${employee.id}" name="id">
        <div class="mb-3">
            <label class="form-label">Username:</label>
            <input type="text" class="form-control" value="${admin.name}" placeholder="admin" name="name">
        </div>
        <div class="mb-3">
            <label class="form-label">Password:</label>
            <input type="password" class="form-control" value="${admin.password}" placeholder="admin123" name="password">
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
</div>

<%@ include file="/templates/footer.jsp"%>

