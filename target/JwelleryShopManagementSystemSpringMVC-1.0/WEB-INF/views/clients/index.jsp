<%-- 
    Document   : index
    Created on : Apr 16, 2017, 11:10:50 AM
    Author     : sarita
--%>




<%@include file="../header.jsp"%>



<table class="table table-bordered table-hover table-responsive">
    <tr class="bg-primary">
                <th>Client Name</th>
                <th>Item</th>
                <th>Email</th>
                <th>Contact Number</th>
                <th>Address</th>
                <th>Message</th>
                <th>Sold Date</th>
                <th>Payment</th>
                <th>Action</th>
            </tr>
            
        
            <c:forEach var="client" items="${clients}">
                
                    <c:choose>
                        <c:when test="${client.status}">
                            <tr class="bg-danger"> 
                        </c:when>
                        <c:otherwise>
                        <tr>
                        </c:otherwise>
                    </c:choose>
                    <td>${client.firstName} ${client.lastName} </td> 
                    <td>${client.item.name} </td>
                    <td>${client.email} </td>
                    <td>${client.contactNo}</td>
                    <td>${client.address}</td>
                    <td>${client.message}</td>
                    <td>${client.addDate} </td>
                    <td>
                        <c:choose>
                            <c:when test="${client.status}">
                               Remaining
                            </c:when>
                            <c:otherwise>
                                Success
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="edit?cid=${client.id}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span>Edit</a>
                        <a href="delete?action=delete&cid=${client.id}" class="btn btn-danger" onclick="return confirm('Are you sure to delete ?')"><span class="glyphicon glyphicon-trash"></span>Delete</a>
                        <c:choose>
                            <c:when test="${client.status}">
                                <a href="#" class="btn btn-warning">Send Email</a>
                            </c:when>
                            <c:otherwise>
                                
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                

            </c:forEach>
            
        </table>
<a href="add">Add new client</a>
   <%@include file="../footer.jsp"%>
