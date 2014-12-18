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
	     		<div class="box u100">
	     		
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
	     			
	     			<div class="row">
	     				<div class="box u80"><a href="/laboClient/index.do">Home</a> > <c:out value="${category}"/> > <a href="/laboClient/forum.do?id=${forum.id}">Forum <c:out value="${forum.name}"/></a></div><div class="box u20 txtr"><a href="/laboClient/create.do?forum=${forum.id}" class="btn">Create topic</a></div>
	     			</div>
	     			
	     			<table class="table forum-home">
					    <thead>
					        <tr>
					            <th>Subjects</th>
					            <th class="hidden-phone hidden-tablet">Responses</th>
					            <th>Author</th>
					            <th class="hidden-phone">Views</th>
					            <th>Latest message</th>
					            <c:if test="${user != null}">
					            <th>Action</th>
					            </c:if>
					        </tr>
					    </thead>
					
					    <tbody>
					        
					        <!--  foreach subject from this forum -->
					        
					        <c:forEach var="topic" items="${topics}"> 
					               
					        <tr>
					            <td><a href="/laboClient/subject.do?id=${topic.id}&forum=${forum.id}"><c:out value="${topic.title}"/></a></td>
					            <td class="hidden-phone hidden-tablet">${topic.totalReplies}</td>
					            <td><c:out value="${topic.createdBy}"/></td>
					            <td class="hidden-phone">${topic.totalViews}</td>
					            <td>${topic.lastPostTime}, <c:out value="${topic.lastPostBy}"/></td>
					            <c:if test="${user != null}">
					            <td>
					              <a href="/laboClient/forum.do?action=delete&subject=${topic.id}&forum=${forum.id}" onclick="confirm('Are you sure to want to delete topic: ${topic.id}') ? self.location.href='/laboClient/forum.do?action=delete&subject=${topic.id}&forum=${forum.id}' : ''; return false;">Delete</a>
					            - <a href="/laboClient/forum.do?action=edit&subject=${topic.id}&forum=${forum.id}">Edit</a>
					            </td>
					            </c:if>
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