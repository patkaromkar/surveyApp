var app = angular.module("myApp",[]);
	
	app.controller("myCntrl1", ctrl1);
	
	function ctrl1() {
		//this.uName = "Omkar";
		this.submitLogin = login;
		this.isCredsInvalid = false;
		
	}
	
	function login() {
		console.log(this.uName);
		console.log(this.passWd);
		if (this.uName == "omkar" && this.passWd == "asd") {
			console.log("Creds are correct");
			this.isCredsInvalid = false;
			return true;
		} else {
			this.isCredsInvalid = true;
			return false;
		}
		
	}