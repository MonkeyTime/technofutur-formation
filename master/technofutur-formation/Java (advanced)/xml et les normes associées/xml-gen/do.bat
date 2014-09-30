@echo off

SET JAVA=C:\Program Files (x86)\Java\jre7
SET HOME=C:\xml

C:
cd %HOME%

IF NOT EXIST html MKDIR html
IF EXIST html\*.html DEL /S /Q html\*.html >nul

SET LIB="lib"

set CP=%JAVA%\lib\tools.jar;%HOME%\lib\xercesImpl.jar;%HOME%\lib\xml-apis.jar;%HOME%\lib\xalan.jar;%HOME%\lib\serializer.jar;

"%JAVA%\bin\java" -cp "%CP%" org.apache.xalan.xslt.Process -IN first.xml -XSL css\xml-main.xsl -OUT html\index.html

pause
