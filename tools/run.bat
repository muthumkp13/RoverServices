d ..
call cmd /c "call java -jar  target/rover.jar"
-timeout 100
call cmd /c "start chrome "http://localhost:8080/roverservices/swagger-ui.html#""
-:: netstat -ano | findstr :11099
-:: taskkill /PID 13900 /F 