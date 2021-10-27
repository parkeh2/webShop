<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
   String name = "듀크";
   public String getName(){ return name;}
%>    
<%
//자바코드 service 메서드에 들어간다. 요청시마다 수행
String myname = "park";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>선언문 연습</title>
  </head>
  <body>
      <h1>안녕하세요..service메서드에 들어간다. 출력된다. <%=name %>님!!</h1>
  </body>
</html>
