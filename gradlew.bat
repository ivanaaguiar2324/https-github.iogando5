@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem Gradle startup script for Windows
@rem ##########################################################################

set DIR=%~dp0
java -cp "%DIR%\gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
