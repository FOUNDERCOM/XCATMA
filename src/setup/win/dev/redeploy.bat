@echo off
set BASEDIR=%~sdp0
call %BASEDIR%\setEnv.bat

echo removing the old
rmdir /S /Q %TOMCAT_HOME%\webapps\atma >NUL 2>NUL
del /F /Q %TOMCAT_HOME%\webapps\atma.war >NUL
echo deploying the new
copy /Y %PROJECT_HOME%\atma-build\atma-war\target\atma.war %TOMCAT_HOME%\webapps\atma.war
echo done
timeout /t 1 >NUL