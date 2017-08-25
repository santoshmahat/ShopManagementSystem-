<%-- 
    Document   : add_item
    Created on : Apr 13, 2017, 2:49:08 PM
    Author     : sarita
--%>

<%@include file="../header.jsp" %>
<c:set var="URL_SITE" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<h1>Add new items</h1>
<form method="post">
    <div>
        <label>Username</label>
        <input type="text" name="username"/>
    </div>
    
     <div>
        <label>Password</label>
        <input type="password" name="password"/>
    </div>
    <button type="submit">login</button>
 </form>


  
<%@include file="../footer.jsp" %>