<%@include file="partial/header.jsp" %>
	 	
	 	<header id="header">
	     	<div class="row wrap30">
	     		<div class="box u100 row">
	     			<div class="box u50 fl hidden-phone hidden-tablet"><p>Create topic in <c:out value="${category}"/> > <c:out value="${forum.name}"/></p></div> <div class="box u50 fr txtr"><p>${hellotxt} <c:out value="${user.username}" default="visitor"></c:out> <c:if test="${user != null}"><a href="/laboClient/endsession.do" class="nohref whi"><i class="fa fa-times-circle-o"></i></a></c:if></p></div>
	     		</div>
		    </div>
	 	</header>
	     
	    <section id="section">
	     	<div class="row wrap30">
	     		
	     		<c:if test="${message != null}">
			     	<div class="row wrap30">
			     		<div class="box u100 txtc">
			     		<p class="alert error">${message}</p>
			     		</div>
			     	</div>
					</c:if>
					
					<c:if test="${messageOk != null}">
			     	<div class="row wrap30">
			     		<div class="box u100 txtc">
			     		<p class="alert ok">${messageOk}</p>
			     		</div>
			     	</div>
				</c:if>
				
	     		<form action="/laboClient/create.do" method="post">
	     			<input type="text" name="title" class="box u100" placeholder="Your title..." value="<c:if test="${topic.title != null}">${topic.title}</c:if>" required>
	     			<textarea name="message"  class="box u100 mt2" placeholder="Your content..." required><c:if test="${post.message != null}">${post.message}</c:if></textarea>
	     			<input type="hidden" name="forumId" value="${forum.id}" />
	     			<input type="hidden" name="action" value="${action}" />
	     			<input type="hidden" name="id" value="${topic.id}" />
	     			<input name="topic" class="mt2" type="submit" value="Post topic" />
	     			<input class="mt2" type="reset" value="Reset">
	     		</form>
	     	</div>
	    </section>
	     
<%@include file="partial/footer.jsp" %>