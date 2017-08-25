<%-- 
    Document   : add_item
    Created on : Apr 13, 2017, 2:49:08 PM
    Author     : sarita
--%>

<%@include file="../header.jsp" %>
<c:set var="URL_SITE" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<h1>Add new items</h1>
        <form method="post" id="itemForm" action="${URL_SITE}/item/save">
            <div>
                <label> Name</label>
                <input type="text" name="name" class="form-control" placeholder="enter name" required="required"/>
            </div>
            
            <div>
                <label>Price</label>
                <input type="number"  name="price" class="form-control" placeholder="enter price" required="required"/>
            </div>
            
           
          
            
            <button type="submit" class="btn btn-success">Save</button>
        </form>
  
<%@include file="../footer.jsp" %>