<%@include file="partial/header.jsp" %>

		<header id="header">
	     	<div class="row wrap30">
	     		<div class="box u100">
	     			<p>Forum <c:out value="${forum.name}"/></p>
	     		</div>
		    </div>
	 	</header>
	 	
	     <section id="section">
	     	<div class="row wrap30">
	     		<div class="box u100">
	     			
	     			<div class="row">
	     				<div class="box u80"><a href="/laboClient/index.do">Home</a> > <a href="/laboClient/forum.do?id=${forum.id}">Forum <c:out value="${forum.name}"/></a></div><div class="box u20 txtr"><a href="/laboClient/create.do?forum=${forum.id}" class="btn">Create topic</a></div>
	     			</div>
	     			
	     			<table class="table forum-home">
					    <thead>
					        <tr>
					            <th>Subjects</th>
					            <th>Responses</th>
					            <th>Author</th>
					            <th>Views</th>
					            <th>Latest message</th>
					        </tr>
					    </thead>
					
					    <tbody>
					        
					        <!--  foreach subject from this forum -->
					        
					        <c:forEach var="topic" items="${topics}"> 
					               
					        <tr>
					            <td><a href="/laboClient/subject.do?id=${topic.id}&forum=${forum.id}"><c:out value="${topic.title}"/></a></td>
					            <td>${topic.totalReplies}</td>
					            <td><c:out value="${topic.createdBy}"/></td>
					            <td>${topic.totalViews}</td>
					            <td>${topic.lastPostTime}, <c:out value="${topic.lastPostBy}"/></td>
					        </tr>
					        
					        </c:forEach>
					        
							<!--  end foreach -->
							
					    </tbody>
					</table>
					
					<div class="row">
	     				<div class="box u100 txtr mt2"><a href="/laboClient/create.do?forum=${forum.id}" class="btn">Create topic</a></div>
	     			</div>
	     			
	     		</div>
	     	</div>
	     </section>
	     
<%@include file="partial/footer.jsp" %>