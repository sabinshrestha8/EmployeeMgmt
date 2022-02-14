<%@ include file="/templates/header.jsp"%>

<h2 class="text-center mt-4 mx-auto">View Employees</h2>
<div class="container w-50 my-4">
    <div class="btn-wrap d-flex flex-row-reverse">
        <a href="" class="btn btn-secondary btn-sm mx-2">View Attendance</a>
        <a href="" class="btn btn-primary btn-sm">Add Employee</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th class="text-center">Name</th>
            <th class="text-center">Contact</th>
            <th class="text-center">Address</th>
            <th class="text-center">Age</th>
            <th class="text-center">Join Date</th>
            <th class="text-center">Department Id</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td class="text-center">Sabin Shrestha</td>
                <td class="text-center">9852354751</td>
                <td class="text-center">Bode</td>
                <td class="text-center">21</td>
                <td class="text-center">24/02/2020</td>
                <td class="text-center">05</td>
            </tr>
        </tbody>
    </table>
</div>

<%@ include file="/templates/footer.jsp"%>

