<%-- 
    Document   : index
    Created on : Oct 7, 2016, 7:45:24 PM
    Author     : Karthik Reddy
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
          
            
        </style>
    </head>
    <body>
select images of ${picpath[12]}
        <form action="Vk" method="get">
           <input type="hidden" value=${picpath[7]} name="link">
        <div container>          
           <img src="${pageContext.request.contextPath}/images/${picpath[0]}" width="120" height="120" style="border: #00008B 4px solid;">
                <input type="checkbox" name="habits" value=${picpath[6]}>
       <img src="${pageContext.request.contextPath}/images/${picpath[1]}" width="120" height="120" style="border:#00008B 4px solid;">                    
            <input type="checkbox" name="habits" value=${picpath[7]}>
         <img src="${pageContext.request.contextPath}/images/${picpath[2]}" width="120" height="120" style="border: #00008B 4px solid;">
                <input type="checkbox" name="habits" value=${picpath[8]}>
            </div>
            <div container2>
       <img src="${pageContext.request.contextPath}/images/${picpath[3]}" width="120" height="120" style="border:#00008B 4px solid;">                    
        <input type="checkbox" name="habits" value=${picpath[9]}>
        <img src="${pageContext.request.contextPath}/images/${picpath[4]}" width="120" height="120" style="border: #00008B 4px solid;">
                <input type="checkbox" name="habits" value=${picpath[10]}>
       <img src="${pageContext.request.contextPath}/images/${picpath[5]}" width="120" height="120" style="border:#00008B 4px solid;">                    
        <input type="checkbox" name="habits" value=${picpath[11]}>
        </div>
        <input type="submit" value="selectImages">
         </form>    
    </body>
</html>
