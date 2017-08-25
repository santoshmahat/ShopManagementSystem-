<%-- 
    Document   : index
    Created on : Apr 15, 2017, 3:07:59 PM
    Author     : sarita
--%>

<%@include file="../header.jsp"%>
<c:set var="URL_SITE" value="${pageContext.request.contextPath}"/>
<table class="table table-responsive table-hover ">

            <tr class="bg-primary">
                <th>Id</th>
                <th>Price</th>
                <th>Name</th>
                <th>Added Date</th>
                <th>Action</th>
            </tr>


            <c:forEach var="item" items="${items}">
                <tr>
                    <td>${item.id} </td> 
                    <td> ${item.name}</td>
                    <td>${item.price} </td>
                    <td> ${item.addedDate}</td>
                    <td>
                        <a href="${URL_SITE}/item/edit?iid=${item.id}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span>Edit</a>
                        <a href="${URL_SITE}/item/delete?action=delete&iid=${item.id}" onclick="return confirm('Are you sure to delete ?')" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>Delete</a>
                    </td>

                </tr>


            </c:forEach>
        </table>
    <%@include file="../footer.jsp"%>
