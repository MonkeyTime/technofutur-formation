<form class="form form-aligned" action="/laboClient/index.do" method="post">
	<fieldset>
   		
        <div class="control-group">
        	<label for="username">Username</label>
            <input type="text" name="username" placeholder="Username..." required>
        </div>
        
        <div class="control-group">
        	<label for="password1">Password</label>
            <input type="password" name="password1" placeholder="Password..." required>
        </div>
        
        <div class="control-group">
        	<label for="password2">Retype password</label>
            <input type="password" name="password2" placeholder="Password..." required>
        </div>
        
        <div class="control-group">
        	<label for="firstname">Firstname</label>
            <input type="text" name="firstname" placeholder="Firstname...">
        </div>
        
        <div class="control-group">
        	<label for="lastname">Lastname</label>
            <input type="text" name="lastname" placeholder="Lastname...">
        </div>
        
        <div class="control-group">
        	<label for="email">Email</label>
        	<input type="email" name="email" placeholder="You email..." required>
		</div>
		
		<div class="control-group">
        	<label>&nbsp;</label>
            <input name="register" class="mt2" type="submit" value="Register" /> <input class="mt2" type="reset" value="Clear" />
        </div>

	</fieldset>
</form>