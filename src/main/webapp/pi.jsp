<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN">
<%@ page import="fmt.Pi" %>
<html>
<head><title>PI</title></html>
<body>

<% 
long iterations= 0L;
String param= request.getParameter("iter");
try {
if(null != param)	iterations= Long.parseLong(param);

} catch(NumberFormatException ex) {
	out.println(ex);
}

if(0L != iterations) {
	out.println(String.format("<output>Radius=%d, PI=%f</output><br/><br/>", iterations, Math.PI));
	
	//out.println(InfinitePrime.infinitePrimes(start, max)+ "<br/><hr/>");
	Pi.calc(iterations, out);
	out.println("<hr/>");
}
%>

	<h3>Perimeter of Circle</h3>
We can find the perimeter of circle three ways, never perfectly, see <a href="http://dl.dropboxusercontent.com/u/688127/public-web-site/pi.htm">Archimedes' calculations</a>

	<form type="GET" >
	Radius of Circle: <input type="number" name="iter" required="true" /><br/>

	<input type="submit" value="calculate Perimeter" />
	</form>
</body>
</html>
