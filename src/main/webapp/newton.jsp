<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN">
<%@ page import="fmt.newton.PosVelAcc" %>
<%@ page import="fmt.newton.Calculator" %>
<html>
<head><title>Newton</title></html>
<body>

<% 
final float UNKNOWN= -1.0F;
final float GRAVITY= 9.8F; //m/s^2
float p1= 0.0F, p2= UNKNOWN, v1= 0.0F, v2= UNKNOWN, t2= 0.0F;
float t1= 0.0F, a1= GRAVITY, a2= GRAVITY;
String param= request.getParameter("p1");
try {
if(null != param)	p1= Float.parseFloat(param);
param= request.getParameter("p2");
if(null != param && !param.isEmpty())	p2= Float.parseFloat(param);
param= request.getParameter("v1");
if(null != param)	v1= Float.parseFloat(param);
param= request.getParameter("v2");
if(null != param && !param.isEmpty())	v2= Float.parseFloat(param);
param= request.getParameter("t2");
if(null != param)	t2= Float.parseFloat(param);
} catch(NumberFormatException ex) {
	out.println(ex);
}

if(0.0 != t2) {
	out.println(String.format("<output>Initial pos=%.2f vel=%.2f acc=%.2f time=%.2f<br/>", p1, v1, a1, t1));
	PosVelAcc unk= Calculator.getUnknowns(p1, v1, t2);
	out.println(String.format("At Time(%.2f)=%.2f vel=%.2f acc=%.2f time=%.2f</output><br/><hr />", t2, unk.position, unk.velocity, unk.accelertation, unk.time));
}
%>

	<h3>Find Position, Velocity, Acceleration</h3>
	Find Position, Velocity, Acceleration<br/>given gravity and time<br/><br/>
	<form type="GET" >
	Initial:<br/>
	position: <input type="number" name="p1" required="true" />
	velocity: <input type="number" name="v1" required="true" /><br/>
	<br/>Known Values at given time:<br/>
	time: <input type="number" name="t2" required="true" /><br/>
	position: <input type="number" name="p2" required="false" />(leave blank)<br/>
	velocity: <input type="number" name="v2" required="false" />(leave blank)<br/>
	<br/>
	<input type="submit" value="calculate Position" />
	</form>
	<br/><em>This page is dedicated to Carlos Christensen who showed me Newton's Meadow program in 1988</em>
</body>
</html>
