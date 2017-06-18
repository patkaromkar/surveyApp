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
app.controller("myCntrl1", ['$http', ctrl1]);

function ctrl1($http) {
	console.log("Start of ctrl1");
	this.submitLogin = login;
	this.uName = "";
	this.passWd = "";
	this.isCredsInvalid = false;
	this.myHttp = $http;
	console.log("End of ctrl1");
}

function login(mySALoginForm, myHttpObj) {
	console.log("Start of login ");
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
	
	var respPromise = myHttpObj.get('http://127.0.0.1:8887/SA_S2.html'); // Need to host the html files using chrome plugin HTML 200 OK
	respPromise.success(processAfterFormSubmissionSuccessfully);
	respPromise.error(processAfterFormSubmissionErroneous);
	
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
/*********************************Javascript Connecting Screen S1 and S2************************************/
/***********************************************************************************************************/
function processAfterFormSubmissionSuccessfully(dataFromServer, status, headers, config) {
	//alert("Submitting form Succeeded!");
	console.log(dataFromServer);
	document.getElementById("mainArea").innerHTML = dataFromServer;
}

function processAfterFormSubmissionErroneous(dataFromServer, status, headers, config) {
	alert("Submitting form failed!");
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