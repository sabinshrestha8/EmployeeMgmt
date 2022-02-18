<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <th class="text-center">Date</th>
            <th class="text-center">IsPresent</th>
            <th class="text-center">Action</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td class="text-center">01</td>
                <td class="text-center">Swornima Shrestha</td>
                <td class="text-center">25/02/2021</td>
                <td class="text-center">1</td>
                <td align="center">
                    <a href="" class="btn btn-success btn-sm">Edit</a>
                    <a href="" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </tbody>
    </table>
</div>

<%@ include file="/templates/footer.jsp"%>


