<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/templates/header.jsp"%>

<h2 class="text-center mt-4 mx-auto">View Employees</h2>
<div class="container w-75 my-4">
    <div class="btn-wrap d-flex flex-row-reverse">
        <a href="attendance-view" class="btn btn-secondary btn-sm mx-2">View Attendance</a>
        <a href="employee-form" class="btn btn-primary btn-sm">Add Employee</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th class="text-center">Id</th>
            <th class="text-center">Name</th>
            <th class="text-center">Contact</th>
            <th class="text-center">Address</th>
            <th class="text-center">Age</th>
            <th class="text-center">Join Date</th>
            <th class="text-center">Department Id</th>
            <th class="text-center">Action</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${employees}" var="employee">
            <tr>
                <td class="text-center">${employee.id}</td>
                <td class="text-center">${employee.name}</td>
                <td class="text-center">${employee.contact}</td>
                <td class="text-center">${employee.address}</td>
                <td class="text-center">${employee.age}</td>
                <td class="text-center">${employee.joinDate}</td>
                <td class="text-center">${employee.departmentId}</td>
                <td align="center">
                    <a class="btn btn-success btn-sm"
                       href="${pageContext.request.contextPath}/employee-form?id=${employee.id}">Edit</a>
                    <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/employee-view?id=${employee.id}">Delete</a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="/templates/footer.jsp"%>

