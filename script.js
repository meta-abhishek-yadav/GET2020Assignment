
var firstName,lastName,fatherName,email,classOfStudent,age;
function updateData(x){
	document.getElementById("updateForm").elements[0].value=document.getElementById(x.value).elements[0].value;
	document.getElementById("updateForm").elements[1].value=document.getElementById(x.value).elements[1].value;
	document.getElementById("updateForm").elements[2].value=document.getElementById(x.value).elements[2].value;
	document.getElementById("updateForm").elements[3].value=document.getElementById(x.value).elements[3].value;
	document.getElementById("updateForm").elements[4].value=document.getElementById(x.value).elements[4].value;
	document.getElementById("updateForm").elements[5].value=document.getElementById(x.value).elements[5].value;
	document.getElementById("updateForm").elements[6].value=document.getElementById(x.value).elements[3].value;
	document.getElementById("updateForm").style="display:block";
	document.getElementById("panel1").style="display:none";
	//document.write(document.getElementById("previousEmail").value);

	//window.location.href='update.jsp';
	}
function xyz()
{

	//document.getElementById("updateForm").submit();
	//document.getElementById("updateForm").style="display:none";
	//document.getElementById("panel1").style="display:block";
}
function showStudentMethod()
{
document.getElementById("showStudentForm").submit();
}