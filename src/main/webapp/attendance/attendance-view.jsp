<%@ include file="/templates/header.jsp"%>

<h2 class="text-center mt-4 mx-auto">View Attendance</h2>
<div class="container w-75 my-4">
    <div class="btn-wrap d-flex flex-row-reverse">
        <a href="department-view" class="btn btn-secondary btn-sm mx-2">View Department</a>
        <a href="employee-view" class="btn btn-primary btn-sm">View Employee</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th class="text-center">Employee Id</th>
            <th class="text-center">Employee Name</th>
            <th class="text-center">Attendance</th>
            <th class="text-center">Date</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="total" value="0" scope="page"/>
            <c:forEach var="attendance" items="${attendances}" varStatus="loop">
                <c:if test="${attendance.isPresent}">
                    <c:set var="total" value="${total+1}" scope="page"/>
                </c:if>
                <tr>
                    <td class="text-center">${attendance.empId}</td>
                    <td class="text-center">${attendance.empName}</td>
                    <td class="text-center">${attendance.isPresent?"Present":"Absent"}</td>
                    <td class="text-center">${attendance.date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p class="text-end me-2">Total Attendance: ${total}</p>
</div>

<%@ include file="/templates/footer.jsp"%>


