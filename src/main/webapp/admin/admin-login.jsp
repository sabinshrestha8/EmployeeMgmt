<%@ include file="/templates/header.jsp" %>

<div class="container w-25 vh-100 d-flex">

    <div class="mb-auto mt-auto w-100 px-4 py-5 shadow bg-body rounded">
        <form action="login" method="post">
            <h2 class="text-center text-primary fs-1">Sign In</h2>
            <input type="hidden" value="${employee.id}" name="id">
            <div class="mb-3">
                <label class="form-label">Email: </label>
                <input type="email" class="form-control" value="${email}" placeholder="admin@admin.com" name="email">
            </div>
            <div class="mb-3">
                <label class="form-label">Password:</label>
                <input type="password" class="form-control" placeholder="admin123" name="password">
            </div>
            <p class="text-danger">${error!=null ? error : ""}</p>
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary mt-3" style="width: 100%">Let me in!</button>
            </div>
        </form>
    </div>
</div>

<%@ include file="/templates/footer.jsp" %>

