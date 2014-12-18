<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="txtl">
	<h2>Administration</h2>
	<h3>Create Forum Container</h3>
	<form class="form form-aligned" action="/laboClient/index.do" method="post">
		<fieldset>
	   		
	        <div class="control-group">
	        	<label for="container-name">Container name</label>
	            <input type="text" name="container-name" pattern="[*]+{1,55}" placeholder="Container name...." required>
	        </div>
		
			<div class="control-group">
	        	<label>&nbsp;</label>
	        	<input type="hidden" name="action" value="container">
	            <input name="create-container" class="mt2" type="submit" value="Create container" /> <input class="mt2" type="reset" value="Reset" />
	        </div>
	
		</fieldset>
	</form>
	<h3>Create Forum</h3>
	<form class="form form-aligned" action="/laboClient/index.do" method="post">
		<fieldset>
	   		
	        <div class="control-group">
	        	<label for="container-id">In container</label>
	            <select name="container-id" required>
	            <c:forEach var="category" items="${categories}">
	            	<option value="${category.id}">${category.name}</option>
	            </c:forEach>
	            </select>
	        </div>
	        
	        <div class="control-group">
	        	<label for="title">Forum title</label>
	            <input type="text" name="title" pattern="[*]+{1,255}" placeholder="Title..." required>
	        </div>
	        
	        <div class="control-group">
	        	<label for="description">Forum description</label>
	            <input type="text" name="description"  pattern="[*]+{1,2048}" placeholder="Description..." required>
	        </div>
		
			<div class="control-group">
	        	<label>&nbsp;</label>
	        	<input type="hidden" name="action" value="forum">
	            <input name="create-forum" class="mt2" type="submit" value="Create forum" /> <input class="mt2" type="reset" value="Reset" />
	        </div>
	
		</fieldset>
	</form>
</div>