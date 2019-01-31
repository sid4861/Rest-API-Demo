function getEmpById(){
var empIdStr = document.getElementById("fname").value
var empId = parseInt(empIdStr)


var url = new URL("http://localhost:8080/employees/findbyempid?empid=0")
url.searchParams.set('empid', empId)
console.log(url)

	// Create a request variable and assign a new XMLHttpRequest object to it.
var request = new XMLHttpRequest();

// Open a new connection, using the GET request on the URL endpoint
request.open('GET', url, true);

request.onload = function () {
  // Begin accessing JSON data here
	var data = JSON.parse(this.response);
  if (request.status >= 200 && request.status < 400) {
   
		console.log(data.name);
		document.getElementById("name").innerHTML= String(data.name)
		document.getElementById("empid").innerHTML=String(data.empId)
		document.getElementById("email").innerHTML=String(data.email)
	
  } else {
    console.log('error');
  }
  
  }


// Send request
request.send();
}
