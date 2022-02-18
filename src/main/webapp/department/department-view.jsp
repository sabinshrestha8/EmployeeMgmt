<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/templates/header.jsp" %>
<h2 class="text-center mt-4 mx-auto">View Departments</h2>
<div class="container w-50 my-4">
    <div class="btn-wrap d-flex flex-row-reverse">
        <a href="employee-view" class="btn btn-secondary btn-sm mx-2">View Employee</a>
        <a href="department-form" class="btn btn-primary btn-sm">Add Department</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th class="text-center">Id</th>
            <th class="text-center">Name</th>
            <th class="text-center">Action</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${departments}" var="department" >
                <tr>
                    <td class="text-center">01</td>
                    <td class="text-center">flutter</td>
                    <td align="center" style="width: 40%">
                        <a class="btn btn-success btn-sm" href="">Edit</a>
                        <a class="btn btn-danger btn-sm" href="">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/templates/footer.jsp" %>
