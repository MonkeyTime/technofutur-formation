-- Se connecter en admin pour démarrer la PDB
CONNECT sys/forma1300 as sysdba

-- Visualiser le nom de la CDB (optionnel)
SELECT instance_name FROM v$instance ;

-- Visualiser les PDB existantes et le mode dans lequel elles se trouvent
-- Si le mode = MOUNTED, exécuter la commande suivante
-- Si le mode = WREAD WRITE, tout est en ordre
SELECT name, open_mode FROM v$pdbs ;

-- IF "MOUNTED" ...
ALTER PLUGGABLE DATABASE MyOraclePDB OPEN ;

-- Se connecter à la PDB à partir de la CDB
ALTER SESSION SET CONTAINER = MyOraclePDB ;

-- Créer un user local dans la PDB
CREATE USER hr IDENTIFIED BY hr ;

-- Donner tous les droits au user créé
-- Notamment les droits de se connecter...
GRANT ALL PRIVILEGES TO hr ;

-- Se connecter avec le user créé, directement à la PDB
CONNECT hr/hr@localhost:1521/MyOraclePDB