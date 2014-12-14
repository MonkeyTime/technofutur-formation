<%@include file="partial/header.jsp" %>

     	<header id="header">
	     	<div class="row wrap30">
	     		<div class="box u100">
	     			<p>Index forum</p>
	     		</div>
		    </div>
	 	</header>
	 	
	     <section id="section">
	     	<div class="row wrap30">
	     		<div class="box u100">
	     		
	     			<c:if test="${message != null}">
			     	<div class="row wrap30">
			     		<div class="box u100 txtc">
			     		<p class="alert error">${message}</p>
			     		</div>
			     	</div>
					</c:if>

	     			<div class="row">
	     				<div class="box u100"><a href="/laboClient/index.do">Home</a></div>
	     			</div>
	     		
	     			<!--  foreach Category -->
	     			
	     			<c:forEach var="category" items="${categories}"> 
	     			
	     			<table class="table table-bordered">
					    <thead>
					        <tr>
					            <th class="category"><c:out value="${category.name}"/></th>
					            <th class="counter">Subjects</th>
					            <th class="counter">Messages</th>
					        </tr>
					    </thead>
					
					    <tbody>
					        
					        <!--  foreach Forum from this category -->
					        
					        <c:forEach var="forum" items="${forums}"> 
					        
					        	<c:if test="${category.id == forum.categoryId}">
						        <tr>
						            <td><a href="/laboClient/forum.do?id=${forum.id}"><c:out value="${forum.name}"/></a> <br> ${forum.description}</td>
						            <td>${forum.totalTopics}</td>
						            <td>${forum.totalPosts}</td>
						        </tr>
						        </c:if>

					        </c:forEach>
					        
							<!--  end foreach -->
							
					    </tbody>
					</table>
					
					</c:forEach>
					
					<!--  end foreach -->
					
	     		</div>
	     	</div>
	     	
	     	<c:if test="${user == null}">
	     	
	     	<div class="row wrap30 mt2 mb2 login">
	     		<div class="box u100 txtc">
	     		
	     			<%@include file="registerForm.jsp" %>
	     			
	     		</div>
	     	</div>
	     	
	     	<div class="row wrap30 mb2 register">
	     		<div class="box u100 txtc">
	     		
	     			<%@include file="loginForm.jsp" %>
	     			
	     		</div>
	     	</div>
	     	
	     	</c:if>

	     </section>
	     
<%@include file="partial/footer.jsp" %>