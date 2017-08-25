<%-- 
    Document   : add_client
    Created on : Apr 15, 2017, 5:33:53 PM
    Author     : sarita
--%>

<%@include file="../header.jsp"%>
<c:set var="URL_SITE" value="${pageContext.request.contextPath}"/>
<h1>Add Client</h1>
<form class="container" method="post" action="${URL_SITE}/client/save" >
            
            <div class="form-group">
                <label>Sold item</label>
                <select name="item.id">
                    <c:forEach var="item" items="${items}">
                        <option  value="${item.id}">${item.name}</option>
                    </c:forEach>
                    
                </select>
                
            </div>
            
            <div class="form-group">
                <label>First Name</label>
                <input type="text" name="firstName" class="form-control" placeholder="enter firstname" />
            </div>
            
            <div class="form-group">
                <label>Last Name</label>
                <input type="text" name="lastName" class="form-control" placeholder="enter lastname"  />
            </div>
            
            <div class="form-group">
                <label>Email</label>
                <input type="text" name="email" class="form-control" placeholder="enter email"  />
            </div>
            
            <div class="form-group">
                <label>Contact Number</label>
                <input type="text" name="contactNo" class="form-control" placeholder="enter contact number"  />
            </div>
            
            <div class="form-group">
                <label>Address</label>
                <input type="text" name="address" class="form-control" placeholder="enter address"  />
            </div>
            
            <div class="form-group">
                <label>Status</label>
                <label><input type="checkbox" name="status"/>Remaining</label>
            </div>
            <div class="form-group">
                <label>Message</label>
                <input type="text" name="message" class="form-control" placeholder="enter message"  />
            </div>
            
            <button type="submit" class="btn btn-success">Save</button>
            
            
        </form>
    <%@include file="../footer.jsp"%>
