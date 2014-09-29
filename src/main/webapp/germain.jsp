<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN">
<%@ page import="fmt.germain.Germian" %>
<html>
<head><title>Germain</title></html>
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
	out.println(String.format("<output>Max Prime Number=%d<br/><br/>", iterations));
	
	//out.println(InfinitePrime.infinitePrimes(start, max)+ "<br/><hr/>");
	Germian.infinitePrimes(iterations, out);
	out.println("</output><hr/>");
}
%>

	<h3>Sophie Germain Primes</h3>
Archimedes said: if p is prime, so is a number between p and 2*(all primes multiplied by each other)+1 infinitely.<br/>
One cannot prove Archimedes wrong logically.<br/>
This demonstration proves Germian false.  NOT!<br/>

	<form type="GET" >
	Max Prime Number: <input type="number" name="iter" required="true" /> (suggested: 40)<br/>

	<input type="submit" value="get primes" />
	</form>
</body>
</html>
