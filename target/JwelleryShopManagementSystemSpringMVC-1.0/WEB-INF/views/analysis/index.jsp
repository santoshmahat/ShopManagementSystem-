<%@include file="../header.jsp" %>


<c:set var="bookmarkerRow" value="${bookmarkerRows}"/>
<c:set var="enrolledUserRow" value="${enrolledUserRows}"/>


<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand page-scroll" href="">Follow-up</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <!--        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">-->
        <ul class="nav">
            <li><a href="${URL_SITE}/item">.</a></li>
            <li><a href="${URL_SITE}/item">Total view </a></li>
            <li><a href="${URL_SITE}/follow-up/bookmark">Total bookmark<span> :${bookmarkerRow}</span></a></li>
            <li><a href="${URL_SITE}/follow-up/enrolled">Total enrolled<span> :${enrolledUserRow}</span></a></li>
        </ul>
        <!--        </div>-->
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>


<%@include file="../footer.jsp" %>