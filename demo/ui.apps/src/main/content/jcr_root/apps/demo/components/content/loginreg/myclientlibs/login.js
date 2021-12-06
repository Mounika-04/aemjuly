alert('myjs called');
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
$(document).ready(function() {
 alert("ready function");
         $("#somebutton").click(function() {
		 alert("button called");
             var uname=$('#uname').val();
             var password=$('#psw').val();
             servletCall(uname,password);
         });

     });
     function servletCall(x,y) {

	 alert("servlet called");
         alert("x value--"+x+"y value--"+y);
         $.post(
             "/bin/loginServlet", 
             {uname : x},
             {password:y},
             function(result) {
			 alert("result=="+result);

         });
     };


