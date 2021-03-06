
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Satisfy' rel='stylesheet' type='text/css'/>
<link rel="stylesheet" type = "text/css" href="{% static 'css_style/style.css'%}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">E-Books</a>	
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="Home.html">Home</a></li>
    </ul>
  </div>
</nav>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<script language="javascript">
function validate(objForm){
	
	if(objForm.fullName.value.length == 0){
		alert("please fill all the fields");
		return false;
	}
	if(!(validateEmail(objForm.email.value))) 
		return false;
	
    if(!(phonenumber(objForm.mobile.value))) 
    	 return false;
    if(objForm.pwd.value.length == 0) 
    	return false;
	return true;
}
function validateEmail(emailField){
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if (reg.test(emailField.value) == false) 
    {
        alert('Invalid Email Address');
        return false;
    }
    return true;
}
function phonenumber(inputtxt)
{
  var phoneno = /^\d{10}$/;
  if(inputtxt.value.match(phoneno))
        {
      return true;
        }
      else
        {
        alert("Invalid mobile number");
        return false;
        }
}
</script>
<body>
<center><h1><b><i>Registration</i></b> </h1></center>
<form  name = "objForm" action = "register" method = "post"  modelAttribute="user" onSubmit = "return validate(this)">
<br>
<div class = "col-xs-3">
</div>
<div class = "container">
	<div class ="row">
		<div class = "col-xs-6" enctype="multipart/form-data">
				<div class = "form-group">
					<label style = "align:left">FullName</label>
					<input type ="text"  class="form-control" name = "fullName" placeholder = "fullname" /><br>
					<label>Email :</label><input type = "text" name = "email"  class = "form-control" placeholder="example@domain.com"><br>
					<label>Mobile Number:</label><input type ="number" name = "mobilenumber"  class = "form-control" placeholder = "phone number"><br>
					<label> Password :</label><input type = "password" name= "password"  class = "form-control" placeholder ="password"><br>
					<center>
					<input type = "submit" class="btn btn-primary" value ="submit"/>
					</center>
				</div>
		</div>
	</div>
</div>
</form>
</body>
</html>