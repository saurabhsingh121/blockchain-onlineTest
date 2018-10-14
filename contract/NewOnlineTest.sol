pragma solidity ^0.4.17;

contract NewOnlineTest{

    struct Question{
        uint questionNo;
        string question;
        uint correctOption;
        mapping(uint => string) optionList;
    }

    struct User{
        string userId;
        string userName;
        string testId;
        uint score;
    }
    address public admin;
    Question[] public questions;
    User[] public users;
    int public questCounter = -1;
    int public userCounter = -1;

    function NewOnlineTest() public {
        admin = msg.sender;
    }

    modifier adminAccess() {
        require(msg.sender == admin);
        _;
    }

    //function for setting up the question
    //admin will have access to set question
    function setQuestion(uint _questionNo, string _question,
                        uint _correctOption) public adminAccess{
        Question memory newQuestion = Question({
            questionNo: _questionNo,
            question: _question,
            correctOption: _correctOption
        });
        questions.push(newQuestion);
        questCounter++;
    }

    //function for setting up the option list of the question
    function setOptionList(uint index, string option1, string option2,
                        string option3, string option4) public adminAccess{
                            Question storage thisQuestion = questions[index];
                            thisQuestion.optionList[1] = option1;
                            thisQuestion.optionList[2] = option2;
                            thisQuestion.optionList[3] = option3;
                            thisQuestion.optionList[4] = option4;
                        }

    //function for getting up the option list
    function getOptionList(uint index, uint _optionNo) public view returns(string){
        Question storage thisQuestion = questions[index];
        return thisQuestion.optionList[_optionNo];
    }

    //function for storing the user profile inside the blockchain
    function setUserProfile(string _userId, string _userName, string _testId) public adminAccess{
                                User memory newUser = User({
                                    userId: _userId,
                                    userName: _userName,
                                    testId: _testId,
                                    score: 0
                                });
                                users.push(newUser);
                                userCounter++;
                            }

    //function for setting up the score of the user
    function setScore(uint index, bool result) public adminAccess{
        User storage thisUser = users[index];
        if(result){
            thisUser.score +=  1;
        }
    }

    //function for getting the score
    function getScore(uint index) public view returns(uint){
        User storage thisUser = users[index];
        return thisUser.score;
    }

}
