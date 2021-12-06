alert('Loading JS');

(function(){
    jQuery(document).ready(function(){
        alert('heelo');
         var successFn=function(response){
             var json=JSON.stringify(response)
             alert('lineone'+json);

             alert('Success');
             var result=jQuery.parseJSON(json);
             alert('linetwo'+result);
             $(".result").html(result);


                 alert(response);
             };
             var errorFn=function(response){
                 alert('Error');
                 alert(response);
             };


$.ajax({
               type: 'GET',
	           url: '/bin/getjson',
    data:{
        param:'xxxx'
    },

    success:successFn,


    error:errorFn



	    });

    });
}) ();



