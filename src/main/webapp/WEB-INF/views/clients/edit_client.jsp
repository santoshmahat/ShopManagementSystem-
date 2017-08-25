<%-- 
    Document   : add_client
    Created on : Apr 15, 2017, 5:33:53 PM
    Author     : sarita
--%>

<%@include file="../header.jsp"%>




<c:set var="URL_SITE" value="${pageContext.request.contextPath}"/>
<c:set var="client" value="${clients}"/>

        
<h1>Edit client</h1>   
        
        
        
        <form method="post" action="${URL_SITE}/client/update?cid=${client.id}" >
            
            <div>
                <label>Sold item</label>
                <select name="item.id">
                    <c:forEach var="item" items="${items}">
                        <option  value="${item.id}">${item.name}</option>
                    </c:forEach>
                    
                </select>
                
            </div>
            <div>
                <label>First Name</label>
                <input type="text" name="firstName" value="${client.firstName}" class="form-control" placeholder="enter firstname" />
            </div>
            
            <div>
                <label>Last Name</label>
                <input type="text" name="lastName" value="${client.lastName}" class="form-control" placeholder="enter lastname"  />
            </div>
            
            <div>
                <label>Email</label>
                <input type="text" name="email" value="${client.email}"  class="form-control" placeholder="enter email"  />
            </div>
            
            <div>
                <label>Contact Number</label>
                <input type="text" name="contactNo" value="${client.contactNo}"  class="form-control" placeholder="enter contact number"  />
            </div>
            
            <div>
                <label>Address</label>
                <input type="text" name="address" value="${client.address}"  class="form-control" placeholder="enter address"  />
            </div>
            
             <div>
                <label>Status</label>
                <label><input type="checkbox" value="${client.status}" name="status"/>Remaining</label>
            </div>
            
            <div>
                <label>Message</label>
                <input type="text" name="message" value="${client.message}" class="form-control" placeholder="enter firstname"  />
            </div>
            
            <button type="submit">Save</button>
            
            
        </form>
    
<%@include file="../footer.jsp"%>
