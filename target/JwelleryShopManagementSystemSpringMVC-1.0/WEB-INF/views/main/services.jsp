<%-- 
    Document   : services
    Created on : May 12, 2017, 8:29:04 AM
    Author     : sarita
--%>
<%@include file="../header.jsp"  %> 

<h1>Services</h1>





<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <a class="navbar-brand page-scroll" href="">Management System</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
<!--        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">-->
            <ul class="nav">
                <li><a href="${URL_SITE}/item">.</a></li>
                <li><a href="${URL_SITE}/item">Add item</a></li>
                <li><a href="${URL_SITE}/client">Add customer</a></li>
                <li><a href="${URL_SITE}/item/index">item details</a></li>
                <li><a href="${URL_SITE}/client/index">Customer details</a></li>
                <li><a href="${URL_SITE}/follow-up">Follow-up analysis</a></li>
                <li><a href="${URL_SITE}/logout"><button>Logout</button></a></li>
            </ul>
<!--        </div>-->
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>


<%@include file="../footer.jsp"  %>