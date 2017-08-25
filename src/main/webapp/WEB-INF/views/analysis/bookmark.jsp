<%@include file="../header.jsp" %>


<table class="table table-bordered table-hover table-responsive">
    <tr>
        <th>Bookmarker</th>
        <th>Email</th>
        <th>Contact Number</th>
        <th>Message</th>
        <th>Added date</th>
        <th>Action</th>
        
    </tr>
    
    <c:forEach var="bookmarker" items="${bookmarkers}">
        
        <tr>
            
            <td>${bookmarker.firstName} ${bookmarker.lastName}</td>
            <td>${bookmarker.email}</td>
            <td>${bookmarker.contactNO}</td>
            <td>${bookmarker.message}</td>
            <td>${bookmarker.addedDate}</td>
            <td><a href="" class="btn btn-warning">Send Email</a></td>
            
            
        </tr>
    </c:forEach>
   
    
</table>

<%@include file="../footer.jsp" %>