<%@include file="partial/header.jsp" %>
	 	
	 	<header id="header">
	     	<div class="row wrap30">
	     		<div class="box u100 row">
	     			<div class="box u50 fl hidden-phone hidden-tablet"><p>Post response</p></div> <div class="box u50 txtr fr"><p>${hellotxt} <c:out value="${user.username}" default="visitor"></c:out> <c:if test="${user != null}"><a href="/laboClient/endsession.do" class="nohref whi"><i class="fa fa-times-circle-o"></i></a></c:if></p></div>
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
				
	     		<div class="box u100">
	     			<h1 class="mt0">Re: <c:out value="${topic.title}"/></h1>
	     			<form action="/laboClient/response.do" method="post">
	     			<textarea name="message" placeholder="Your content..." required></textarea>
	     			<input type="hidden" name="topicId" value="${topic.id}" />
	     			<input name="response" class="mt2" type="submit" value="Post response" />
	     			<input class="mt2" type="reset" value="Reset">
	     		</form>
	     		</div>
	     	</div>
	     </section>
	     
<%@include file="partial/footer.jsp" %>