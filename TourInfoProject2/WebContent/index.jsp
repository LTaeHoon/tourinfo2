<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	request.setCharacterEncoding("utf-8");
	String email = (String)session.getAttribute("email");
%>      --%>
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
    <!--=========== BEGIN SLIDER SECTION ================-->
    <section id="slider">
      <div class="row">
        <div class="col-lg-12 col-md-12">
          <div class="slider_area">
            <!-- Start super slider -->
            <div id="slides">
              <ul class="slides-container">                          
                <li>
                  <img src="img/slider/2.jpg" alt="img">
                   <div class="slider_caption">
                    <h2>JEJU WELCOMES YOU</h2>
                    <p>A brand new travel awaits you every day in Jejudo Island! Experience the mountains, oceans, foods, and more on your personal journey!</p>
                    <a class="slider_btn" href="touristSites.do">Know More</a>
                  </div>
                  </li>
                <!-- Start single slider-->
                <li>
                  <img src="img/slider/3.jpg" alt="img">
                   <div class="slider_caption slider_right_caption">
                    <h2>BEAUTIFUL ISLAND, JEJU!</h2>
                    <p>
                    Jejudo Island's Perfect Mountain, Sea, Forest!
                    As the highest summit in the country, the views afforded atop Hallasan Mountain are absolutely phenomenal in all seasons.
                    How about traveling to an island of the island? The view of Jeju Island from islands such as Udo Island, Marado Island, Biyangdo Island, and Chujado Island will be fantastic.
                    </p>
                    <a class="slider_btn" href="accommodation.do">Know More</a>
                  </div>
                </li>
                <!-- Start single slider-->
                <li>
                  <img src="img/slider/4.jpg" alt="img">
                   <div class="slider_caption">
                    <h2>Experience an adventure of your very own.</h2>
                    <p>
                    Jejudo Island is heaven for all kinds of leisure activities.
                    If you enjoy active and dynamic leisure, Jejudo Island is perfect for you. 
                    You can’t leave horseback riding, paragliding, or even scuba diving out from a trip to Jejudo Island. 
					Come and enjoy the thrill and excitement of living life to the fullest in Korea’s beautiful and friendly Jejudo Island.
					</p>                
                    <a class="slider_btn" href="cuisine.do">Know More</a>
                  </div>
                </li>
              </ul>
              <nav class="slides-navigation">
                <a href="#" class="next"></a>
                <a href="#" class="prev"></a>
              </nav>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--=========== END SLIDER SECTION ================-->

    <!--=========== BEGIN ABOUT US SECTION ================-->
      <section id="aboutUs">
      <div class="container">
        <div class="row">
        <!-- Start about us area -->
        <div class="col-lg-6 col-md-6 col-sm-6">
          <div class="aboutus_area wow fadeInLeft">
            <h2 class="titile">About Us</h2>
            <p>제주도는 대한민국에서 가장 큰 섬으로, 제주특별자치도에 속하며, 한반도 남쪽 바다 건너에 있다. 섬의 면적은 1833.2㎢인데 이는 대한민국 면적의 1.83%에 해당한다. 중앙의 한라산을 중심으로 완만한 경사를 이루어 동서 73km, 남북 31km의 타원형을 하고 있다. 일주도로 길이는 181km, 해안선은 258km이다. 북쪽 끝은 김녕해수욕장이고, 남쪽 끝은 송악산이며, 서쪽 끝은 수월봉, 동쪽 끝은 성산 일출봉이다. 제주도는 온대 기후에 속하며, 겨울에도 거의 영하로 떨어지지 않고 영상을 유지한다. 한라산, 성산 일출봉, 거문오름 용암동굴계가 학술·문화·관광·생태 등의 가치와 중요성을 인정받아 2007년 6월, 제주 화산섬과 용암 동굴이라는 이름으로 세계자연유산에 등록되었다. 황해와 동해, 동중국해의 경계에 자리잡아 대한민국·중화인민공화국·일본 등 3개 국의 교통상의 요지이자 정치·경제·군사상 중요한 지위에 있다. </p>
          </div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6">
          <div class="newsfeed_area wow fadeInRight">
            <ul class="nav nav-tabs feed_tabs" id="myTab2">
              <li class="active"><a href="#news" data-toggle="tab">News</a></li>
              <li><a href="#events" data-toggle="tab">Events</a></li>         
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
            
              <!-- Start news tab content -->
              <div class="tab-pane fade in active" id="news">                
                <ul class="news_tab">
                  <li>
                    <div class="media">
                      <div class="media-left">
                        <a class="news_img" href="#">
                          <img class="media-object" src="img/news.jpg" alt="img">
                        </a>
                      </div>
                      <div class="media-body">
                       <a href="http://www.planjeju.com/bbs/board.php?bo_table=jejunews&wr_id=43">제주관광공사 , 제주 관광 1월 추천 10선 발표</a>
                       <span class="feed_date">17.01.05</span>
                      </div>
                    </div>                    
                  </li>
                  <li>
                    <div class="media">
                      <div class="media-left">
                        <a class="news_img" href="#">
                          <img class="media-object" src="img/news2.jpg" alt="img">
                        </a>
                      </div>
                      <div class="media-body">
                       <a href="http://www.planjeju.com/bbs/board.php?bo_table=jejunews&wr_id=42">눈 내린 '유네스코 세계자연유산' 거문오름 등반 강추…"제주의 신비 만끽하세요"</a>
                       <span class="feed_date">16.12.27</span>
                      </div>
                    </div>
                  </li>
                  <li>
                    <div class="media">
                      <div class="media-left">
                        <a class="news_img" href="#">
                          <img class="media-object" src="img/news3.jpg" alt="img">
                        </a>
                      </div>
                      <div class="media-body">
                       <a href="http://www.planjeju.com/bbs/board.php?bo_table=jejunews&wr_id=41">코레일 '내일로' 티켓 판매 개시…제주도 여행도 가능</a>
                       <span class="feed_date">16.12.15</span>
                      </div>
                    </div>
                  </li>
                </ul>                
              </div>
              
              
              <!-- Start events tab content -->
              <div class="tab-pane fade " id="events">
                <ul class="news_tab">
                  <li>
                    <div class="media">
                      <div class="media-left">
                        <a class="news_img" href="#">
                          <img class="media-object" src="img/event3.jpg" alt="img">
                        </a>
                      </div>
                      <div class="media-body">
                       <a href="http://buriburi.go.kr/">제주 노리매 매화축제 2017 (2017.02.04 ~ 2017.03.05)</a>
                       <span class="feed_date">17.01.28</span>
                      </div>
                    </div>
                  </li>
                  <li>
                    <div class="media">
                      <div class="media-left">
                        <a class="news_img" href="#">
                          <img class="media-object" src="img/event2.jpg" alt="img">
                        </a>
                      </div>
                      <div class="media-body">
                       <a href="http://buriburi.go.kr/">제주들불축제 2017 (2017.03.02 ~ 2017.03.05)</a>
                       <span class="feed_date">16.12.15</span>              
                      </div>
                    </div>
                  </li>
                  <li>
                    <div class="media">
                      <div class="media-left">
                        <a class="news_img" href="#">
                          <img class="media-object" src="img/event.jpg" alt="img">
                        </a>
                      </div>
                      <div class="media-body">
                       <a href="http://www.herbdongsan.com">제주 허브동산 "별빛놀이" (2016.12.02 ~ 2017.12.31)</a>
                       <span class="feed_date">16.12.01</span>                  
                      </div>
                    </div>
                  </li>                  
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      </div>
    </section>
    <!--=========== END ABOUT US SECTION ================--> 

    <!--=========== BEGIN WHY US SECTION ================-->
  
      <!-- End why us top -->

      <!-- Start why us bottom -->
 
      <!-- End why us bottom -->
   
    <!--=========== END WHY US SECTION ================-->

    <!--=========== BEGIN OUR COURSES SECTION ================-->
    
        <!-- End Our courses content -->
   
    <!--=========== END OUR COURSES SECTION ================-->  

    <!--=========== BEGIN OUR TUTORS SECTION ================-->
   
    <!--=========== END OUR TUTORS SECTION ================-->

    <!--=========== BEGIN STUDENTS TESTIMONIAL SECTION ================-->
   
    <!--=========== END STUDENTS TESTIMONIAL SECTION ================-->    

<%@ include file="../include/footer.jsp" %>