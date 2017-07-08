/***********************************************************************************************************/
/************************************Test Data for Screen S2************************************************/
/***********************************************************************************************************/
var listOfSurveys = [
{surveyId : 1, surveyTitle : "Bollywood Preferences", surveyStatus : "Open", surveyDesc : "Your Bollywood preferences"},
{surveyId : 2, surveyTitle : "Survey of Countries for living", surveyStatus : "Open", surveyDesc : "This is survey to know which is the best country to live in"},
{surveyId : 3, surveyTitle : "Food Survey", surveyStatus : "Closed", surveyDesc : "This survey is to know your food preference"},
{surveyId : 4, surveyTitle : "Population Survey", surveyStatus : "Closed", surveyDesc : "Survey to know more information about the population"},
{surveyId : 5, surveyTitle : "Survey of Elecronics", surveyStatus : "Open", surveyDesc : "Your Electronic preferences"},
{surveyId : 6, surveyTitle : "Music Survey", surveyStatus : "Open", surveyDesc : "Your music preferences"},
{surveyId : 7, surveyTitle : "India's Political Survey", surveyStatus : "Closed", surveyDesc : "Survey to know about political likes and dislikes"}
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
	nextQId : 4,
	prevQId : 2

},

{
	qId : 4,
	question : "kjbdjkdsgk",
	questionType : "MCQ",
	answers : [
				{ansId : 1, ansTitle : "kdskgk saasgla aklsga", selected:false},
				{ansId : 2, ansTitle : "mash", selected:false},
				{ansId : 3, ansTitle : "dskdshg s", selected:false}
			],
	nextQId:-1,
	prevQId:3}
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


/***********************************************************************************************************/
/************************************Java script for Login Screen S4****************************************/
/***********************************************************************************************************/
app.controller("myCntrl4", ctr4);
function ctr4() {
	
	this.listOfSurveys = listOfSurveys;
	this.selectSurvey4Manag = selectSurvey4Manag;
	this.deleteSurvey = deleteSurvey;
	
}

function selectSurvey4Manag(surveyId) {
	//alert(surveyId);
	this.surveyToBeManaged = surveyId;
}

function deleteSurvey(surveyId){
	for (var i=0; i<this.listOfSurveys.length; i++) {
		if(this.listOfSurveys[i].surveyId === surveyId) {
			//delete this.listOfSurveys[i];
			this.listOfSurveys.splice(i,1);
			break;
		}
	}
		
}
/***********************************************************************************************************/

/***********************************************************************************************************/
/************************************Java script for Login Screen S5****************************************/
/***********************************************************************************************************/
app.controller("myCntrl5", ctr5);

var QUESTION_TYPES = [
	{queType :"MCQ", qTypeDesc : "Multiple Choice Question"}, 
	{queType :"SCQ", qTypeDesc : "Single Choice Question"}
	];
	
var blankNewSurvey = {surveyId : -2, surveyTitle : "", surveyStatus : "Not Created", surveyDesc : ""};
var listOfQs = [];
var listOfAs = [];

var blankAns = {
	ansId : -99, ansTitle : "", selected : false
};


var blankQue = {
	qId : -99, 
	question : "", 
	questionType : "", 
	answers : [
				blankAns
			],
	nextQId : -99,
	prevQId : -99
};

function ctr5() {
	this.listOfSurveys = listOfSurveys;
	this.survey = blankNewSurvey;
	this.createSurvey = createSurvey;
	this.isSurveyCreated = false;
	this.createBtnName = "Create";
	this.qTypes = QUESTION_TYPES;
	this.addMoreA = addMoreA;
	this.listOfQs = listOfQs;
	this.listOfAs = listOfAs;
	this.addMoreQ = addMoreQ;
	this.blankAnswer = blankAns;
	this.blankQuestion = blankQue;
	this.selectedQType = this.qTypes[0];
	this.checkIfEmptyQ = checkIfEmptyQ;
	this.createBlankA = createBlankA;
	this.createBlankQ = createBlankQ;
	this.remA = remA;
}

function createSurvey() {
	this.survey.surveyId = this.listOfSurveys.length+1;
	this.survey.surveyStatus = "Open";
	this.listOfSurveys.push(this.survey);
	this.isSurveyCreated = true;
	this.createBtnName = "Created !!!"
	this.selectedQType = this.qTypes[0];
	this.blankAnswer = blankAns;
	this.blankQuestion = blankQue;
}

function createBlankQnA() {
	createBlankA();
	createBlankQ();
	
}

function createBlankQ() {
	blankQue = {
		qId : -99, 
		question : "", 
		questionType : "", 
		answers : [
					blankAns
				],
		nextQId : -99,
		prevQId : -99
	};
	this.blankQuestion = blankQue;
}

function createBlankA() {

	blankAns = {
		ansId : -99, ansTitle : "", selected : false
	};
	this.blankAnswer = blankAns;
}

function addMoreA() {
	if (this.blankAnswer.ansTitle === "") {
		alert("Answer cannot be blank. Please fill in an answer for the question.");
		return;
	}
	this.blankAnswer.ansId = this.listOfAs.length+1;
	this.listOfAs.push(this.blankAnswer);
	this.blankQuestion.answers = this.listOfAs;
	this.createBlankA();
}

function addMoreQ() {
	var allOk = this.checkIfEmptyQ();
	if (!allOk) {
		return false;
	} else {
		this.blankQuestion.questionType = this.selectedQType.queType;
		this.listOfQs.push(this.blankQuestion);
		this.createBlankQnA();
	}
}

function checkIfEmptyQ() {
	if (this.blankQuestion.question === "") {
		alert("Question cannot be empty. Please fill in a question for your survey.");
		return false;
	}
	//this.blankQuestion.answers[0].ansId
	var ansIsEmpty = false;
	if (this.blankQuestion.answers.length == 1) {
		if (this.blankQuestion.answers[0].ansId == -99) {
			ansIsEmpty = true;
		}
	} else if (this.blankQuestion.answers.length == 0) {
		ansIsEmpty = true;
	} else {
		ansIsEmpty = false;
	}
	
	if (ansIsEmpty) {
		alert("Question must have atleast one answer. Please fill in an answer for the question.");
		return false;
	}
	/*if (this.blankAnswer.ansTitle === "") {
		alert("Question must have atleast one answer. Please fill in an answer for the question.");
		return;
	}*/
	
	return true;
}

function remA(ansIndex) {
	this.listOfAs.splice(ansIndex, 1);
	this.blankQuestion.answers = this.listOfAs;
}
/***********************************************************************************************************/