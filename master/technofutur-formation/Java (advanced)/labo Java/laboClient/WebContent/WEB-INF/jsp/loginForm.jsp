<form class="form form-aligned" action="/laboClient/index.do" method="post">
	<fieldset>
   		
        <div class="control-group">
        	<label for="username">Username</label>
            <input type="text" name="username" placeholder="Username..." required>
        </div>
        
        <div class="control-group">
        	<label for="password">Password</label>
            <input type="password" name="password" placeholder="Password..." required>
        </div>
	
		<div class="control-group">
        	<label>&nbsp;</label>
            <input name="login" class="mt2" type="submit" value="Login" /> <input class="mt2" type="reset" value="Clear" />
        </div>

	</fieldset>
</form>