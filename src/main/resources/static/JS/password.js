function validMatch()
{
    
   let password=document.getElementById("password").value;
   let  confirmpassword=document.getElementById("confirmpassword").value;
    let  confirmmessage=document.getElementById("confirmmessage");
    if(password!==confirmpassword)
    {
       confirmmessage.style.color="red";
       confirmmessage.innerHTML="confirm password does not match with password ";
       return false;
    }
    else
    {    
        confirmmessage.style.color="green";
        confirmmessage.innerHTML="password match !";
        return true;
    }

}
function validPassword()	
{
     let password=document.getElementById("password").value;
     let  pattern=/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
     let  message=document.getElementById("message");
    if(!pattern.test(password))
    {
       message.style.color="red";
       message.innerHTML="password must be at least 8 character long and include the<br> uppercase , lowercase ,number and special character ";
       return false;
    }
    else
    {
        message.style.color="green";
        message.innerHTML="Strong password";
        return true;
    }
}
function validForm(event)
{
	console.log("hello");
	const isValidPassword=validPassword();
	const isValidMatch=validMatch();
	 if (!isValidMatch || !isValidPassword) 
	 {
		alert("Please fix password error before submitting form");
        event.preventDefault();
        return false;
     }
    return true;
}
