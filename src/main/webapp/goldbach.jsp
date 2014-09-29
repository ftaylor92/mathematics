<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN">
<%@ page import="fmt.goldbach.Conjecture" %>
<html>
<head><title>Goldbach</title></html>
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
	out.println(String.format("<output>Max Prime Number=%d</output><br/><br/>", iterations));
	
	//out.println(InfinitePrime.infinitePrimes(start, max)+ "<br/><hr/>");
	Conjecture.goldbachConjecture(iterations, out);
	out.println("<hr/>");
}
%>

	<h3>Goldbach Conjecture</h3>
Goldbach conjecture: All primes are two primes added.<br/>
This demonstration proves Goldbach false.<br/>

	<form type="GET" >
	Max Prime Number: <input type="number" name="iter" required="true" /> (suggested: 20)<br/>

	<input type="submit" value="get primes" />
	</form>
</body>
</html>
