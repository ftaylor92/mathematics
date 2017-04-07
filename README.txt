see ProcFile to start locally
http://localhost:8080/
http://localhost:8080/euclid.jsp

URLs:
http://mathematics.fmtmac.cloudbees.net/pointMath.jsp
http://mathematics.fmtmac.cloudbees.net/euclid.jsp
http://mathematics.fmtmac.cloudbees.net/germain.jsp
http://mathematics.fmtmac.cloudbees.net/goldbach.jsp
http://mathematics.fmtmac.cloudbees.net/newton.jsp
http://mathematics.fmtmac.cloudbees.net/pi.jsp

for fmtmac2 cloudbees account:
http://mathematics.fmtmac2.cloudbees.net
mvn clean compile package
fails: bees app:deploy target/mathematics.war - fmtmac2/mathematics
goto: cloudbees site, then hit Apps, Mathematics, upload WAR file, select target/mathematics.war

for heroku:
git init
git add pom.xml README.txt src/
git status
git remote add origin https://github.com/ftaylor92/mathematics.git
git push -u origin master
git pull
heroku create
heroku apps:rename <app-name>
git push heroku master
mvn clean compile package
 
heroku config
vi system.properties
git add system.properties 
git commit -m "system.properties"
git push heroku master
heroku ps:scale web=1
heroku open

