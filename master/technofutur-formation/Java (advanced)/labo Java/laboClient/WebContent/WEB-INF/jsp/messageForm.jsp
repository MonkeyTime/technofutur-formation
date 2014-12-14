<%@include file="partial/header.jsp" %>

     	<header id="header">
	     	<div class="row wrap30">
	     		<div class="box u100">
	     			<p>Post response</p>
	     		</div>
		    </div>
	 	</header>
	 	
	     <section id="section">
	     	<div class="row wrap30">
	     		<div class="box u100">
	     			<h1 class="mt0">Re: <c:out value="${topic.title}"/></h1>
	     			<form action="/laboClient/response.do" method="post">
	     			<textarea name="message" placeholder="Your content..." required></textarea>
	     			<input type="hidden" value="${topic.id}" />
	     			<input name="response" class="mt2" type="submit" value="Post response" />
	     		</form>
	     		</div>
	     	</div>
	     </section>
	     
<%@include file="partial/footer.jsp" %>