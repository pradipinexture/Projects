<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

        <script type='text/javascript'>
         $(document).ready(function() {
            //option A
            var a=0;
            $("form").submit(function(e){
                if(++a>=4){
                }
                else{
                	e.preventDefault(e);
                }
            });
        });
        </script>
    </head>

    <body>
        <form action="http://google.com" method="post">
          Search <input type='text' name='q' />
          <input type='submit'/>
        </form>
    </body>
</html>