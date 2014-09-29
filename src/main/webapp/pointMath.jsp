<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN">
<%@ page import="fmt.PointMath" %>
<html>
<head><title>Point</title></html>
<body>

<% 
double x1= 0.0, x2= 0.0, y1= 0.0, y2= 0.0, distance= 0.0;
String param= request.getParameter("x1");
try {
if(null != param)	x1= Double.parseDouble(param);
param= request.getParameter("x2");
if(null != param)	x2= Double.parseDouble(param);
param= request.getParameter("y1");
if(null != param)	y1= Double.parseDouble(param);
param= request.getParameter("y2");
if(null != param)	y2= Double.parseDouble(param);
param= request.getParameter("distance");
if(null != param)	distance= Double.parseDouble(param);
} catch(NumberFormatException ex) {
	out.println(ex);
}

if(0.0 != distance) {
	out.println(String.format("<output>PointA x=%.2f y=%.2f<br/>", x1, y1));
	out.println(String.format("PointB x=%.2f y=%.2f<br/>", x2, y2));
	out.println(String.format("distance=%.2f</output><br/>", distance));
	out.println(PointMath.findPointBetweenTwoPoints(x1, y1, x2, y2, distance)+ "<br/><hr />");
}
%>

	<h3>Find Point Between Two Points</h3>
	<form type="GET" >
	Point A:<br/>
	X: <input type="number" name="x1" required="true" />
	Y: <input type="number" name="y1" required="true" />
	<br/>Point B:<br/>
	X: <input type="number" name="x2" required="true" />
	Y: <input type="number" name="y2" required="true" /><br/>
	Distance between Points: <input type="number" name="distance" required="true" /><br/>
	<input type="submit" value="calculate mid-point" />
	</form>
</body>
</html>
