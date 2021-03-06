<%@ include file="/templates/header.jsp" %>

<h2 class="text-center mt-4 mx-auto">View Employees</h2>
<div class="container w-100 my-4">
    <div class="btn-wrap d-flex flex-row-reverse">
        <a href="department-view" class="btn btn-outline-secondary btn-sm mx-2 my-2">View Department</a>
        <a href="employee-form" class="btn btn-primary btn-sm my-2">Add Employee</a>
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
            <th class="text-center">Dept Name</th>
            <th class="text-center">Action</th>
            <th class="text-center">Attendance</th>
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
                <td class="text-center">${employee.departmentName}</td>
                <td align="center">
                    <a class="btn btn-primary btn-sm" style="width: 35px"
                       href="employee-form?id=${employee.id}"><i class="fas fa-edit"></i>
                    </a>
                    <a class="btn btn-danger btn-sm" style="width: 35px"
                       href="employee-view?id=${employee.id}"><i class="fas fa-trash"></i>
                    </a>
                </td>
                <td align="center" id="attendance${employee.id}">
                    <c:forEach var="attendace" items="${attendances}">
                        <c:if test="${attendace.empId == employee.id}">
                            <c:set var="attended" value="true" scope="page"/>
                        </c:if>
                    </c:forEach>
                    <c:if test="${attended == null}">
                        <button class="btn btn-success btn-sm present present${employee.id} ${employee.id}"
                                style="width: 35px"
                        ><i class="fas fa-check"></i></button>
                        <button class="btn btn-danger btn-sm absent absent${employee.id} ${employee.id}"
                                style="width: 35px"
                        ><i class="fas fa-times"></i></button>
                    </c:if>
                    <c:remove var="attended"/>
                    <a class="btn btn-dark btn-sm" style="width: 35px"
                       href="attendance-view?id=${employee.id}"><i class="fas fa-eye"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    <%@ include file="/assets/script.js" %>
</script>

<%@ include file="/templates/footer.jsp" %>

