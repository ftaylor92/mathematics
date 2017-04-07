<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="fmt.euclid.InfinitePrime" %>
<html>
<head><title>Euclid</title></html>
<body>

<% 
long maxPrime= 0L, max= 0L, start= 0L;
String param= request.getParameter("maxPrime");
try {
if(null != param)	maxPrime= Long.parseLong(param);
param= request.getParameter("max");
if(null != param)	max= Long.parseLong(param);
param= request.getParameter("start");
if(null != param)	start= Long.parseLong(param);

} catch(NumberFormatException ex) {
	out.println(ex);
}

if(0L != max) {
	out.println(String.format("<output>start=%d max=%d maxPrime=%d<br/><br/>", start, max, maxPrime));
	
	out.println(InfinitePrime.infinitePrimes(start, max)+ "<br/><hr/>");
	out.println(InfinitePrime.euclidPrimes(maxPrime)+ "</output><br/><hr/>");
}
%>

	<h3>Are there infinite primes?</h3>
	Are there infinite primes?<br/>
	Prove it!<br/>
	<form type="GET" >
	starting Number: <input type="number" name="start" required="true" />
	max: <input type="number" name="max" required="true" /><br/>
	<br/>Euclid said that there are infinite primes because (all previous primes multiplied+1) is the next prime.<br/>
This demonstration proves that Euclid was wrong.<br/>
	max Prime: <input type="number" name="maxPrime" required="true" /> (suggested: 200)<br/>
	<input type="submit" value="get primes" />
	</form>
</body>
</html>
