<%@ include file="/templates/header.jsp"%>

<h2 class="text-center mt-4">Add Employee</h2>
<div class="container w-50 mr-0">
    <form action ="employee-form" method="post">
        <input type="hidden" value="${Employee.id}" name="id">
        <div class="mb-3">
            <label class="form-label">Name:</label>
            <input type="text" class="form-control" value="${employee.name}" placeholder="John Doe" name="employee-name">
        </div>
        <div class="mb-3">
            <label class="form-label">Contact:</label>
            <input type="text" class="form-control" value="${employee.contact}" placeholder="9801000000" name="contact">
        </div>
        <div class="mb-3">
            <label class="form-label">Address: </label>
            <input type="text" class="form-control" value="${employee.address}" placeholder="Putalisadak" name="address">
        </div>
        <div class="mb-3">
            <label class="form-label">Age:</label>
            <input type="text" class="form-control" value="${employee.age}" placeholder="28" name="age">
        </div>
        <div class="mb-3">
            <label class="form-label">Join Date: </label>
            <input type="text" class="form-control" value="${employee.joinDate}" placeholder="20/02/2020" name="join-date">
        </div>
        <div class="mb-3">
            <label class="form-label">Department Id:</label>
            <input type="text" class="form-control" value="${employee.departmentId}" placeholder="2" name="department-id">
        </div>
        <button type="submit" class="btn btn-primary">${action}</button>
    </form>
</div>

<%@ include file="/templates/footer.jsp"%>
