@echo off
::java -cp C:\Users\320052128\Downloads\Json\ChatBot\Chatbot_JS_B2_G3\ChatBot\target\ChatBot-1.0-SNAPSHOT.jar com.JSB2G3.ChatBot.ChatBot
mvn clean -q
if %errorlevel%==0 (echo "Success") else (echo "Failure")