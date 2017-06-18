var app = angular.module("myApp",[]);
	
	app.controller("myCntrl1", ctrl1);
	
	function ctrl1() {
		console.log("Start of ctrl1");
		this.submitLogin = login;
		this.uName = "";
		this.passWd = "";
		
		this.isCredsInvalid = false;
		console.log("End of ctrl1");
	}
	
	function login(mySALoginForm) {
		console.log("Start of login >"+this.uName+"<");
		this.isCredsInvalid = false;
		var isUnameEmpty = checkIfEmtpy(mySALoginForm.uname.$viewValue);
		if (isUnameEmpty) {
			mySALoginForm.uname.$invalid = true;
		} 
		
		var isPwdEmpty = checkIfEmtpy(mySALoginForm.pwd.$viewValue);
		if (isPwdEmpty) {
			mySALoginForm.pwd.$invalid = true;
		}
		
		if (mySALoginForm.uname.$invalid || mySALoginForm.pwd.$invalid) {
			mySALoginForm.$invalid = true;
		} 
		
		if (!mySALoginForm.$invalid) {
			if (this.uName == "omkar" && this.passWd == "asd") {
				console.log("Creds are correct");
				this.isCredsInvalid = false;
				
			} else {
				this.isCredsInvalid = true;
				
			}
		}
		
		console.log("End of login() this.isCredsInvalid => "+this.isCredsInvalid);
		return this.isCredsInvalid;
		
	}
	
	function checkIfEmtpy(myVal) {
		console.log("Inside checkIfEmpty()");
		if (myVal == "") {
			return true;
		} else {
			return false;
		}
		
	}