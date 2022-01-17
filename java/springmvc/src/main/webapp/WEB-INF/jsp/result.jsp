<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>
   <body>

      <h2>Submitted Student Information</h2>
      <table>
         <tr>
            <td>Name</td>
            <td>${name}</td>
         </tr>
         <tr>
            <td>Age</td>
            <td>${age}</td>
         </tr>
         <tr>
            <td>ID</td>
            <td>${id}</td>
         </tr>
      </table>  
      <form:form method = "GET" action = "/springmvc/redirectStudent">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Redirect to Student"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
</html>