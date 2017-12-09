@echo off
set BASEDIR=%~sdp0
call %BASEDIR%\setEnv.bat

echo removing the old
rmdir /S /Q %TOMCAT_HOME%\webapps\cxatma >NUL 2>NUL
del /F /Q %TOMCAT_HOME%\webapps\cxatma.war >NUL
echo deploying the new
copy /Y %PROJECT_HOME%\cxatma-build\cxatma-war\target\cxatma.war %TOMCAT_HOME%\webapps\cxatma.war
echo done
timeout /t 1 >NUL