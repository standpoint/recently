<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.Date"%>
<%@taglib uri="/WEB-INF/tlds/mylib.tld" prefix="mynamespace"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      Hello,${param["p"]} ${param["q"]}<br>
      <c:if test = "${param.p == 'aaa'}">
          Works
      </c:if>

      
      <mynamespace:hello name="Vasya">
          sdfhggshjdgdshgshdgsdhjgsdghsdf
          hjsfdhjsjhsdfjhsdfhdfhsdfhdshd
      </mynamespace:hello>
      <jsp:useBean id="cars" class="dddd.Cars"/>
        
       <table>
         <c:forEach var="car" items="${cars}">
            <tr><td> <c:out value="${car.name}"/> </td></tr>
         </c:forEach>
      </table>
     <c:catch var ="catchException">
       The exception will be thrown inside the catch:<br>
       <%= 20 %> <br>
       <% int x = 5/0;%>
       <%= 10 %>
   </c:catch>
   <c:if test = "${catchException!=null}">
     The exception is : ${catchException} <br><br>
     There is an exception: ${catchException.message} <br>
 </c:if>


    </body>
</html>
