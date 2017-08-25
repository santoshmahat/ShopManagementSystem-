<%-- 
    Document   : bookmark
    Created on : May 16, 2017, 7:23:32 PM
    Author     : sarita
--%>
<%@include file="../header.jsp" %>

        <h1>Bookmark</h1>
        
        <div id="form">
            <form method="post" action="${URL_SITE}/main/bookmark/add" class="form-group">
               <div>
                <input type="text" name="firstName" placeholder="enter your first name" class="form-control" required="required"/>
               </div> 
                
               <div>
                <input type="text" name="lastName" placeholder="enter your last name" class="form-control" required="required"/>
               </div> 
               
                <div>
                <input type="email" name="email" placeholder="enter your email" class="form-control" required="required"/>
                </div>
                
                <div>
                <input type="text" name="contactNO" placeholder="enter your contact number" class="form-control" required="required"/>
                </div>
                
                <div>
                    <textarea name="message" class="form-control" placeholder="write some message"></textarea>
                </div>
               
               <div>
                   <button type="submit" id="submit-btn" class="btn btn-success" onclick="return confirm('Thank you you have bookmark successfully')">Submit</button>
               </div>
            </form>
                
            
        </div>
               
<!--               <div id="bookmark">
                   <h1>Thank you you have bookmark successfully</h1>
               </div>
               -->
               
               
               
<!--               <script>
                   $(document).on("ready",function(){
                     
                    $("#submit-btn").on("click",function(){
                        $("#form").hide;
                        $("#bookmark").show();
                        
                        
                    });
                    
        
                   });
                   
               </script>       -->
   
      <%@include file="../footer.jsp" %>