<%@include file="partial/header.jsp" %>

		<header id="header">
		    <div class="row wrap30">
	     		<div class="box u100 row">
	     			<div class="box u50 hidden-phone hidden-tablet fl"><p><c:out value="${category}"/> - forum <c:out value="${forum.name}"/></p></div> <div class="box u50 txtr fr"><p>${hellotxt} <c:out value="${user.username}" default="visitor"></c:out> <c:if test="${user != null}"><a href="/laboClient/endsession.do" class="nohref whi"><i class="fa fa-times-circle-o"></i></a></c:if></p></div>
	     		</div>
		    </div>
	 	</header>
	 	
	     <section id="section">
	     	<div class="row wrap30">
	     		<div class="box u100 row">
	     			
	     			<div class="box u80"><h1 class="mt0"><c:out value="${topic.title}"/></h1></div> <div class="box u20 txtr"><a href="/laboClient/response.do?subject=${topic.id}" class="btn">Post response</a></div>
	     			
	     			<div class="row">
	     				<div class="box u100"><a href="/laboClient/index.do">Home</a> > <c:out value="${category}"/> > <a href="/laboClient/forum.do?id=${forum.id}">Forum <c:out value="${forum.name}"/></a> > <a href="/laboClient/subject.do?id=${topic.id}&forum=${forum.id}"><c:out value="${topic.title}"/></a></div>
	     			</div>
	     			
	     			<table class="table">
					    <thead>
					        <tr>
					            <th>User</th>
					            <th>Date</th> 
					            <th class="right">Response</th>
					        </tr>
					    </thead>
					
					    <tbody>
					          
					        <tr>
					            <td><c:out value="${topic.createdBy}"/></td>
					            <td><c:out value="${topic.creationTime}"/></td>
					            <td><c:out value="${posts[0].message}"/></td>
					        </tr>

					        <!-- Foreach post -->
					       
					        <c:forEach var="post" items="${posts}">
					        
						        <c:if test="${posts[0].id < post.id}">
						        <tr class="separator">
						            <td><c:out value="${post.userName}"/></td>
						            <td><c:out value="${post.creationTime}"/></td>
						            <td><c:out value="${post.message}"/></td>
						        </tr>
						        </c:if>
					        
					        </c:forEach>
					        
							<!--  end foreach -->
							
					    </tbody>
					</table>
					
					<div class="box u100 txtr mt4"><a href="/laboClient/response.do?subject=${topic.id}" class="btn">Post response</a></div>

	     		</div>
	     	</div>
	     </section>
	     
<%@include file="partial/footer.jsp" %>