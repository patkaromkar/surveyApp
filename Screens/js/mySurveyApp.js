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
/************************************Test Data for Screen S3************************************************/
/***********************************************************************************************************/
var listOfSurveysQuestions = [
{
	qId : 1, 
	question : "Which are your fav heros in Bollywood ?", 
	questionType : "MCQ", 
	answers : [
				{ansId : 1, ansTitle : "SRK", selected : false}, 
				{ansId : 2, ansTitle : "KRK", selected : false}, 
				{ansId : 3, ansTitle : "Rajesh Khanna", selected : false}, 
				{ansId : 4, ansTitle : "Mithun C", selected : false}
			],
	nextQId : 2,
	prevQId : -1
},

{
	qId : 2, 
	question : "Which are your fav actresses in Bollywood ?", 
	questionType : "MCQ", 
	answers : [
				{ansId : 1, ansTitle : "Tabu", selected : false}, 
				{ansId : 2, ansTitle : "Urmila", selected : false}, 
				{ansId : 3, ansTitle : "Madhuri", selected : false}, 
				{ansId : 4, ansTitle : "Karishma", selected : false}
			],
	nextQId : 3,
	prevQId : 1
},

{
	qId : 3, 
	question : "Which is your fav movie in Bollywood ?", 
	questionType : "SCQ", 
	answers : [
				{ansId : 1, ansTitle : "Sholay", selected : false}, 
				{ansId : 2, ansTitle : "Ek Haseena thi", selected : false}, 
				{ansId : 3, ansTitle : "Bahubali", selected : false}, 
				{ansId : 4, ansTitle : "Shivaji - The Boss", selected : false}
			],
	nextQId : -1,
	prevQId : 2

}
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


/***********************************************************************************************************/
/************************************Javascript for Screen S3***********************************************/
/***********************************************************************************************************/
app.controller("myCntrl3", ctrl3);


function ctrl3() {
	
	this.listOfSurveysQuestions = listOfSurveysQuestions;
	this.dispQuestions = listOfSurveysQuestions[0];
	this.answersSelected = [];
	this.loadQuestion = loadQuestion;
	
}

function loadQuestion(quesetionToBeLoadedId) {
	var currentQId = this.dispQuestions.qId;
	var questionFound;
	for(var i = 0; i<this.listOfSurveysQuestions.length; i++) {
		if (this.listOfSurveysQuestions[i].qId == quesetionToBeLoadedId) {
			questionFound = this.listOfSurveysQuestions[i];
			break;
		}
	}
	
	this.dispQuestions = questionFound;
	
}


/***********************************************************************************************************/