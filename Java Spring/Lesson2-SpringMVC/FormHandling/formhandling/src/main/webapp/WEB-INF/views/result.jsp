<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>
   <body>

      <h2>Submitted Student Information</h2>
      <form:form method = "POST" action = "/formhandling/displayName" modelAttribute="name">
         <table>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
</html>