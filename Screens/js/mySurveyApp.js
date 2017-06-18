/***********************************************************************************************************/
/************************************Test Data for Screen S2************************************************/
/***********************************************************************************************************/
var listOfSurveys = [
{surveyId : 1, surveyTitle : "Bollywood Preferences", surveyStatus : "Open"},
{surveyId : 2, surveyTitle : "Survey of Countries for living", surveyStatus : "Open"},
{surveyId : 3, surveyTitle : "Food Survey", surveyStatus : "Closed"},
{surveyId : 4, surveyTitle : "Population Survey", surveyStatus : "Closed"},
{surveyId : 5, surveyTitle : "Survey of Elecronics", surveyStatus : "Open"},
{surveyId : 6, surveyTitle : "Music Survey", surveyStatus : "Open"},
{surveyId : 7, surveyTitle : "India's Political Survey", surveyStatus : "Closed"}
];
/***********************************************************************************************************/


/***********************************************************************************************************/
/************************************Java script for Login Screen S1****************************************/
/***********************************************************************************************************/
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

/***********************************************************************************************************/


/***********************************************************************************************************/
/************************************Javascript for Screen S2***********************************************/
/***********************************************************************************************************/
app.controller("myCntrl2", ctrl2);


function ctrl2() {
	
	this.listOfSurveys = listOfSurveys;
	this.isSurveyParticipitable = isSurveyParticipitable;
}


function isSurveyParticipitable(survey) {
	if (survey.surveyStatus == "Closed") {
		return true;
	} else {
		return false;
	}
}
/***********************************************************************************************************/