<%@ page isELIgnored="false" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Employee Management System</title>
</head>
<body>
<h2 class="text-center mt4">Add Employee</h2>
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
</body>
</html>
