<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%-- <%
   request.setCharacterEncoding("utf-8");
   String email = (String)session.getAttribute("email");
%>   --%>   
<script src="./js/jquery-3.js"></script>
<script>
   $(function(){
      if(<%=(String)session.getAttribute("email")%>==null){
         $("#header2").hide();
      }else{
         $("#header").hide();
      }
   })
</script>    
    
<span id = "header">
<%@ include file="../include/header.jsp" %>
</span>
<span id = "header2">
<%@ include file="../include/header2.jsp" %>
</span>
    <!--=========== BEGIN COURSE BANNER SECTION ================-->
    <section id="imgBanner">
      <h2>Gallery</h2>
    </section>
    <!--=========== END COURSE BANNER SECTION ================-->
    
    <!--=========== BEGIN GALLERY SECTION ================-->
        <section id="gallery">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12">
            <div id="gallerySLide" class="gallery_area">
            
                <a href="img/gallery/img-large1.jpg">
                  <img class="gallery_img" src="img/gallery/img-small1.jpg" alt="img" />
                <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large2.jpg">
                  <img class="gallery_img" src="img/gallery/img-small2.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large3.jpg">
                  <img class="gallery_img" src="img/gallery/img-small3.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large4.jpg">
                  <img class="gallery_img" src="img/gallery/img-small4.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large5.jpg">
                  <img class="gallery_img" src="img/gallery/img-small5.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large6.jpg">
                  <img class="gallery_img" src="img/gallery/img-small6.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large7.jpg">
                  <img class="gallery_img" src="img/gallery/img-small7.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large8.jpg">
                  <img class="gallery_img" src="img/gallery/img-small8.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                 <a href="img/gallery/img-large9.jpg">
                  <img class="gallery_img" src="img/gallery/img-small9.jpg" alt="img" />
                <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large10.jpg">
                  <img class="gallery_img" src="img/gallery/img-small10.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large11.jpg">
                  <img class="gallery_img" src="img/gallery/img-small11.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large12.jpg">
                  <img class="gallery_img" src="img/gallery/img-small12.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large13.jpg">
                  <img class="gallery_img" src="img/gallery/img-small13.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large14.jpg">
                  <img class="gallery_img" src="img/gallery/img-small14.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large15.jpg">
                  <img class="gallery_img" src="img/gallery/img-small15.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
                <a href="img/gallery/img-large16.jpg">
                  <img class="gallery_img" src="img/gallery/img-small16.jpg" alt="img" />
                  <span class="view_btn">View</span>
                </a>
            </div>
          </div>
        </div>
      </div>
    </section>   
	<!--=========== END GALLERY SECTION ================-->
<%@ include file="../include/footer.jsp" %>