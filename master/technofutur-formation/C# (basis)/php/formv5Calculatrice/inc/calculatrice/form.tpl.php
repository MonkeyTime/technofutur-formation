<?php 
if(!isset($_POST['submit'])) { ?>

    <h1>Super calculatrice</h1>
                    
    <div class="calculatrice">
        
        <form class="form" method="post" action="">
            
            <label>Choisir un chiffre ou un nombre</label>
            <input type="number" name="choice" placeholder="First number" />

            <label>Opération</label>
            <select name="operator">
                <option value="add">Addition</option>
                <option value="sou">Soustraction</option>
                <option value="mul">Multiplication</option>
                <option value="div">Division</option>
                <option value="mod">Modulo</option>
            </select>

            <label>Choisir un chiffre ou un nombre</label>
            <input type="number" name="operand" placeholder="Second number" />

            <label>&nbsp;</label>
            <input type="submit" name="submit" value="Calculer" />
            
        </form>
        
    </div>

<?php } ?>