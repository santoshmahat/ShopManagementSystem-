<%@include file="../header.jsp"%>
<c:set var="item" value="${items}" />
<c:set var="URL_SITE" value="${pageContext.request.contextPath}"/>
 <form method="post" action="${URL_SITE}/item/update?iid=${item.id}">
            <div>
                <label> Name</label>
                <input type="text" name="name" value="${item.name}" class="form-control" placeholder="enter name" />
            </div>
            
            <div>
                <label>Price</label>
                <input type="number"  name="price" value="${item.price}"  class="form-control" placeholder="enter price"/>
            </div>
            
            
             <button type="submit" class="btn btn-success">Save</button>  
        </form>
<%@include file="../footer.jsp"%>