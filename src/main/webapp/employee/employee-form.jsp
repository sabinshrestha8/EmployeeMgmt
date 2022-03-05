<%@ include file="/templates/header.jsp" %>

<div class="container p-4 w-50 shadow rounded">
    <legend class="display-5 pb-3 fw-bolder text-primary">${action != "Update" ? "Add" : "Update"} Employee</legend>
    <form action="employee-form" method="post">
        <div class="row flex-row p-2">
            <input type="hidden" value="${employee.id}" name="id">
            <div class="col-md-6 mb-3">
                <label class="form-label">Name:</label>
                <input type="text" class="form-control" value="${employee.name}" placeholder="John Doe" name="name">
            </div>
            <div class="col-md-6 mb-3">
                <label class="form-label">Contact:</label>
                <input type="text" class="form-control" value="${employee.contact}" placeholder="9801000000"
                       name="contact">
            </div>
            <div class="col-md-12 align-self-center mb-3">
                <label class="form-label">Address: </label>
                <input type="text" class="form-control" value="${employee.address}" placeholder="Putalisadak"
                       name="address">
            </div>
            <div class="col-md-6 mb-3">
                <label class="form-label">Department Id:</label>
                <select name="departmentId" class="form-select">
                    <option disabled ${empDepartment != null ? "" : "selected"}> --- Select ID ---</option>
                    <c:forEach items="${departments}" var="department">
                        <option ${empDepartment == department.id ? "selected" : ""}
                                value="${department.id}">${department.id} - ${department.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-6 mb-3">
                <label class="form-label">Age:</label>
                <input type="text" class="form-control" value="${employee.age}" placeholder="28" name="age">
            </div>
            <div class="d-flex justify-content-end">
                <button type="submit" class="btn btn-primary">${action}</button>
            </div>
        </div>
    </form>
</div>

<c:remove var="empDepartment" scope="session"/>

<%@ include file="/templates/footer.jsp" %>
