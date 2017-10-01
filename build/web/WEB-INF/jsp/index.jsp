<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>Welcome to Spring Web MVC project</title>
           
    </head>

    <body>
        <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>      
           <button id="createPdf" onclick="createPdf()">créer un fichier</button>
         <script type="text/javascript">
                 function createPdf(){

                        xhr = new XMLHttpRequest();
                        xhr.open("GET","createPdf.do", true); 
                        xhr.responseType = "blob";
                        xhr.onload = function (e) {
                            if (this.status === 200) {
                                var file = window.URL.createObjectURL(this.response);
                                var a = document.createElement("a");
                                a.href = file;
                                a.download = this.response.name || "Property Brochure";
                                console.log(file);
                                document.body.appendChild(a);
                                a.click();

                                window.onfocus = function () {                     
                                  document.body.removeChild(a)
                                }
                                $('#pleasewaitDL').modal('hide');
                            };
                        };
                        xhr.send($('#preparedPrintModalForm').serialize());
                   
                 }
    
            </script>
    </body>

</html>

