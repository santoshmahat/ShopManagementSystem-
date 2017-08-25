<%-- 
    Document   : enrolled_user
    Created on : May 18, 2017, 11:48:36 AM
    Author     : sarita
--%>
<%@include file="../header.jsp" %>

        <h1>Enrolled User</h1>
        
        <div>
            <form class="form-group" method="post" action="${pageContext.request.contextPath}/follow-up/enrolled/add">
                <div>
<!--                    <select name="" onchange="fetchData(this)">
                        <c:forEach var="bookmarker" items="${bookmarkers}">
                            
                            <option value="" id="bookmarker_id"  name="bookmarker_id"  class="form-control">${bookmarker.id}</option>  
                        </c:forEach>
                    </select>-->
           <input type="text" id="bookmarker_id" name="bookmarker.id" onkeyup="fetchData()" class="form-control"/>
                </div>
                
                <div>
                    <label>First Name</label>
                    <input type="text" id="first_name" name="firstName" class="form-control"/>
                </div>
                
                <div>
                    <label>Last Name</label>
                    <input type="text" id="last_name" name="lastName" class="form-control"/>
                </div>
                
                 <div>
                    <label>Email</label>
                    <input type="text" id="email" name="email" class="form-control"/>
                 </div>
                
                <div>
                    <label>Contact Number</label>
                    <input type="text" id="contact_no" name="contactNO" class="form-control"/>
                </div>
                
                <div>
                    <label>Payment</label> <input type="checkbox" name="payment"> 
                </div>
                
                <div>
                    <label>Status</label><input type="checkbox" name="status"> 
                </div>
                <button type="submit" id="add_btn" class="btn btn-primary" onclick="return confirm('Information save successfully')">Add</button>
            </form>
        </div>
        
        <script>
            
          function fetchData(){
            $.ajax({
                type:"get",
                url:"http://localhost:8080/${pageContext.request.contextPath}/follow-up/getJSON",
                data:"bookmarker_id="+$("#bookmarker_id").val(),
                  dataType: "json",
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                       
                       
                       $("#first_name").val(data.firstName  );
                       $("#last_name").val(data.lastName  );
                       $("#email").val(data.email ); 
                       $("#contact_no").val(data.contactNumber ); 
                        

                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert("some error occured" + errorThrown);
                    }
               
                
                
            });
            }
        </script>
        
        <div>
          
             <table class="table table-bordered table-hover table-responsive">
    <tr class="bg-primary">
        <th>Enrooled User</th>
        <th>Email</th>
        <th>Contact Number</th>
        <th>Status</th>
        <th>Added date</th>
        
        
    </tr>
    
    <c:forEach var="enrolledUser" items="${enrolledUsers}">
        
        <tr>
            
            <td>${enrolledUser.firstName} ${enrolledUser.lastName}</td>
            <td>${enrolledUser.email}</td>
            <td>${enrolledUser.contactNO}</td>
            <td>${enrolledUser.status}</td>
            <td>${enrolledUser.addedDate}</td>
           
       </tr>
        
    </c:forEach>
        
            
        </div>
           
        
        
        
        
    <%@include file="../footer.jsp" %>
