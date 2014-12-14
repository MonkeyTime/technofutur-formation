<%@include file="partial/header.jsp" %>

     	<header id="header">
	     	<div class="row wrap30">
	     		<div class="box u100">
	     			<p>Create topic in <c:out value="${forum.name}"/></p>
	     		</div>
		    </div>
	 	</header>
	     
	    <section id="section">
	     	<div class="row wrap30">
	     		<form action="/laboClient/create.do" method="post">
	     			<input type="text" name="title" class="box u100" placeholder="Your title..." required>
	     			<textarea name="message"  class="box u100 mt2" placeholder="Your content..." required></textarea>
	     			<input type="hidden" value="${forum.id}" />
	     			<input name="topic" class="mt2" type="submit" value="Post topic" />
	     		</form>
	     	</div>
	    </section>
	     
<%@include file="partial/footer.jsp" %>