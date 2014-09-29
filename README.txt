svn co --username=ftaylor92 https://svn-fmtmac.forge.cloudbees.com/mathematics/

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


