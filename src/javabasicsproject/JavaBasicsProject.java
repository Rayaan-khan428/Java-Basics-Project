/**
 * Programmer: Rayaan Khan
 * Date: 2020-09-24v
 * Project: JavaUnitOne.java
 * Program Name: JavaUnitOne
 */

package javabasicsproject;
import java.util.Scanner; // Scanner class
import static java.lang.System.out; // shorten output statement

public class JavaBasicsProject {
    
    // In game Currency - Global Variable
    static int tokens = 10; 
    
    // Activating Scanner Classes - Global
    static Scanner scanS = new Scanner(System.in);
    static Scanner scanN = new Scanner(System.in);
    
    public static void main(String[] args) throws InterruptedException {                
        introduction(); // takes person back to intro        
    }
     
    /**
     * Method Name: introduction
     * Description: This is where all the code for the introduction part
     * of the game is stored.
     * @throws java.lang.InterruptedException
     */   
    public static void introduction () throws InterruptedException {
        out.println("\nWeclome to Carnival fun Land!"
                + "\nwe have three games pick which game you want to play!"
                + "\t\t\t\t You Have: " + tokens + " tokens");
        out.println("1) Pig \n2) Gamble \n3) Popper \n4) Exit"); // menu        
        String answer = scanS.nextLine(); // checks which game is chosen
        
        //changes answer to lowercase & switch case can process number input
        switch (answer.toLowerCase())                                                         
        {
            case "pig":
            case "1":
                pigGame(); // initializes pig game
                break;
                               
            case "gamble":
            case "2":
                gambleGame(); // initializes gambleGame
                break;
                                       
            case "popper":
            case "3":
                popperGame(); // initializes Poppper game
                break;

            case "exit":
            case "4":
                out.println("\nHave a great day and we at"
                        + "\b\nCarnival Fun Land hope you have"
                        + "\na terrific day!"
                        + "\n\n- BYE FOR NOW -\n"
                        + " __      __\n" 
                        + "( _\\    /_ )\n" 
                        + " \\ _\\  /_ / \n" 
                        + "  \\ _\\/_ /_ _\n" 
                        + "  |_____/_/ /|\n" 
                        + "  (  (_)__)J-)\n" 
                        + "  (  /`.,   /\n" 
                        + "   \\/  ;   /\n" 
                        + "    | === |"); // ASCII ART (PEACE)
                Thread.sleep(2000);
                System.exit(0); // ends entire program
                break; // not sure if still wanted this it's useless
                                
            default:
                out.println("you did not choose anything from the list");
                introduction(); // takes person back to intro
                break;
                
        } // Ending of switch case statement              
    } //method ending
        
    /**
     * Method Name: pigGame
     * Description: This is where all the code for the pig game is stored
     * @throws java.lang.InterruptedException
     */
    public static void pigGame() throws InterruptedException {
        
        int dieRoll; // equal to random number generated
        int totalReal = 0; // total number from all the rolls for real player
        int totalBot = 0; // total number from all the rolls for bot
        String rollAgain; // see weather or not the user wants to roll another
        boolean flagPlayer = true; // for player loop nested in main loop
        boolean flagBot = true; // for bot loop nested in main loop
        boolean flagCheck1; // error trapping function             
        
        Thread.sleep(1000); // wait 1 second                                             
        out.println("\t\t\t\tWELCOME TO PIG");
        out.println("\nRules:"
                + "\nThe goal is to roll a higher sum than your opponent. "
                + "\nEach time you roll the value gets added to your score"
                + "\nFirst to reach 20 points WINS 10 tolkens. However, if you"
                + "\nroll a 1 your score will reset to 0 "
                + "and you loose your turn :("
                + "\n\nalright let us begin!");       
        /*
        Player Loop
        This do while loop allows for error trapping, it also holds the logic
        for when it is the players turn in the game
        */
        
        do {
            out.println("Press Enter to roll");
            scanS.nextLine();
            
            dieRoll = ((int)(Math.random()*6)+1 ); // roll random number 1-6           

            if (dieRoll == 1) { // checks if there is a 1 rolled
                out.println("You rolled a 1 \t\t\t\tscore: 0"
                        + "\n\nIt is Player 2's turn\n");                               
                totalReal = 0;  // sets score to 0     
                Thread.sleep(2000); // wait 2 seconds
                break; // breaks out of player loop                                   
            }

            else { // if a number other than 1 is rolled                   
                totalReal += dieRoll; // adds number to score
                out.println("You rolled a " + dieRoll                            
                        + "\t\t\t\t\t\tScore: " + totalReal);               
                /* 
                asking player if they want to roll again loop allows the code 
                to repeat if user enters an option that is not recognized. 
                */   
                
                do {   
                    out.print("\nWould you like to roll another time?"
                            + "\n1) Yes"
                            + "\n2) No --> ");                   
                    rollAgain = scanS.nextLine(); // scans for yes or no

                    switch (rollAgain.toLowerCase()) 
                    {
                        case "yes":
                        case "1":
                            flagPlayer = true; // Player is playing again
                            flagCheck1 = false; // player answered correctly
                            break;

                        case "no":
                        case "2":
                            flagPlayer = false; // Player is not playing again
                            flagCheck1 = false; // player answered correctly
                            break;

                        default:
                            out.println("You did not select a valid answer");
                            flagPlayer = false; // Player entered wrong answer
                            flagCheck1 = true; // activates error trapping          
                            break;
                    }
                } while (flagCheck1 == true); // ending of error trap loop
            } // ending of else statement
        } while (flagPlayer == true); // ending of player loop

        /*
        Bot Loop: loop for bots Intelligence, also includes score checking, 
        which checks to see who won and who lost. the artifical inteligence 
        will keep rolling untill it has a higher score than the player.
        */
        
        do { 
            out.println("\nPlayer 2 is rolling");
            dieRoll = ((int)(Math.random()*6)+1); // roll random number 1-6 
            totalBot += dieRoll; // adds dice # to totoal score                        
            Thread.sleep(500); // wait .5 seconds                       
            
            if (dieRoll == 1){ // checks if there is a 1 rolled
                out.println("Player 2 rolled a 1\n");
                totalBot = 0; // sets score to 0 for Bot since it rolled 1
                flagBot = false; // to not repeat loop      
                                
                if (totalBot <= totalReal) { // checks whose score is greater
                    out.println("\nYOU WIN"
                        + "\nPlayer 2's score: " + totalBot 
                        + "\nYour Score: " + totalReal
                        + "\n\nYou get 10 tokens!");
                    tokens += 10; // adds 10 tokens
                    Thread.sleep(1000); // wait 1 seconds                                                
                    introduction(); // takes person back to intro
                }                
            }
                        
            if (totalBot > totalReal) { // Bot logic
                out.println("Player 2 rolled a: " + dieRoll);
                out.println("Player 2 will not roll again");
                out.println("\nPlayer 2's final score is: " + totalBot);                
                out.println("\nPlayer 2 won\nfor now we have to take 10 tokens"
                        + "\nBetter luck next time!");
                // makes sure tokens do not go into negative.
                if (tokens-10 < 0) 
                    tokens = 0;
                else 
                    tokens -= 10;
                Thread.sleep(1000); // wait 1 seconds
                introduction(); // takes person back to intro
            }

            else { // bot will roll again since its score is less then player
                out.println("Player 2 rolled a: " + totalBot
                        + "\t\t\t\tScore: " + totalBot);
                out.println("Player 2 will roll again");
                Thread.sleep(1000); // wait 1 second
            } // ending of else statement             
        } while (flagBot == true); // ending of loop for bot    
    } //method ending
    
    /**
     * Method Name: gambleGame
     * Description: This is where all the code for the Gamble Game is stored
     * @throws java.lang.InterruptedException
     */    
    public static void gambleGame () throws InterruptedException {
                
        int diceRollSum; // the sum of the two dice rolled
        int diceOne; // dice 1 value
        int diceTwo; // dice 2 value
        int tokenAmountBet; // how many tokens the user bets
        int exactNumber; // exact number the player rolled
        boolean betType1 = false; // sum will be larger than 6
        boolean betType2 = false; // sum will be an even number
        boolean betType3 = false; // sum will be a specic number
        boolean errorTrap = false; // repeats if bet exceeds amount of tokens
        boolean errorTrapMenu; // error trap for menu             
        String betType; // type of bet placed
        
        // first checks is player has more than 0 tokens
        
        if (tokens == 0) {
            out.println("Sorry you dont have enough tokens"
                    + "\nto play this game. Try playing Pig or"
                    + "\nPopper to gain some some tokens.");
            Thread.sleep(1500); // wait 1.5 sec before loading menu
            introduction(); // takes person back to intro
        }
        
        out.println("\t\t\t\tWelcome to GAMBLE");        
        out.println("\nHOW TO PLAY:"
                + "\n\nYou will roll two dices, the sum you will bet on "
                + "with tokens."
                + "\nYou can bet that the sum will be larger than 6 "
                + "You win 2 times what you bet"
                + "\nYou can bet that the sum will be even "
                + "You win 2 times what you bet"
                + "\nBet on the sum being a specific number "
                + "You will win 7 TIMES what you bet!");
        
        do { // outer loop for error trapping
            
            out.println("\nWhat bet would you like to place? "
                    + "\t\t\t\t\t\t You have: " + tokens + " tokens" 
                    + "\n1) sum will be larger than 6"
                    + "\n2) sum will be an even number"
                    + "\n3) sum will be a specific number");
            betType = scanS.nextLine(); // option selected

            // input changes to lowercase & switch can process number input
            switch (betType.toLowerCase())                                                 
            {
                case "1": 
                case "one":
                    errorTrapMenu = false;
                    betType1 = true;
                    break;

                case "2":
                case "two":
                    errorTrapMenu = false;
                    betType2 = true;
                    break;

                case "3":
                case "three":
                    errorTrapMenu = false;
                    betType3 = true;
                    break;

                default:
                    out.println("\nyou did not choose anything from the list");
                    errorTrapMenu = true;
                    break;
            } // Ending of switch case statement        
        } while(errorTrapMenu == true); // ending of error trapping loop
        
        do { // Outer loop for error trap
            while (betType1 == true) { // beginning of betType loop            
                
                out.print("\nHow many tokens would you like too bet? ");
                tokenAmountBet = scanN.nextInt(); // saves input      
                
                if (tokenAmountBet > tokens) { // checks if user entered right
                    errorTrap = true; // entered ammount greater
                    break;
                }
                
                out.println("rolling dices one moment");
                diceOne = ((int)(Math.random()*6)+1); // random number 1-6
                diceTwo = ((int)(Math.random()*6)+1); // random number 1-6
                diceRollSum = diceOne + diceTwo; // sum of the die roll
                Thread.sleep(2000); // wait 2 second
                               
                out.println("\nFirst dice landed on a " + diceOne
                        + "\nSecond dice landed on a " + diceTwo
                        + "\nThe sum is " + diceRollSum);
                Thread.sleep(500); // wait .5 second
                                
                if (diceRollSum > 6) { // comparing results
                    tokens = tokens + tokenAmountBet*2; //subtracts amount bet
                    out.println("You rolled a number greater than 6 "
                            + "you get 2 times your initial bet!");
                    Thread.sleep(1000); // wait 1 second
                    betType1 = false; // betType is over to avoid any errors
                    introduction(); // takes person back to intro
                }

                else {
                    tokens -= tokenAmountBet; // subtracting amount bet
                    out.println("The sum was less than 6! "
                            + "You loose " + tokenAmountBet + " tokens");                    
                    Thread.sleep(1000); // wait 1 second
                    betType1 = false; // betType is over to avoid any errors
                    introduction(); // takes person back to intro
                } // else statement ending         
            } // Bet type 1 loop ending
            
            while (betType2 == true) {               
                
                out.print("\nHow many tokens would you like too bet? ");
                tokenAmountBet = scanN.nextInt(); // saves input         
                
                if (tokenAmountBet > tokens) { // checks if user entered right 
                    errorTrap = true; // entered ammount greater
                    break; 
                }
                
                out.println("rolling dices one moment");
                diceOne = ((int)(Math.random()*6)+1); // random number 1-6
                diceTwo = ((int)(Math.random()*6)+1); // random number 1-6
                diceRollSum = diceOne + diceTwo; // sum of the die roll
                Thread.sleep(2000); // wait 2 second
                               
                out.println("\nFirst dice landed on a " + diceOne
                        + "\nSecond dice landed on a " + diceTwo
                        + "\nThe sum is " + diceRollSum);
                Thread.sleep(500); // wait .5 second
                
                if (diceRollSum % 2 == 0) { // checks if number is even
                    tokens += tokenAmountBet*2;
                    out.println("You won the bet!"
                            + "\nthe die roll added to an even number"
                            + "\nYou get " + tokenAmountBet  + " tokens");
                    Thread.sleep(1000); // wait 1 second
                    betType2 = false;
                    introduction(); // takes person back to intro
                }
                
                else {
                    tokens -= tokenAmountBet; // subtracts Amount
                    out.println("The number was not even"
                            + " You loose " + tokenAmountBet + " tokens");
                    Thread.sleep(1000); // wait 1 second
                    betType2 = false; // set to false to avoid glitches
                    introduction(); // takes person back to intro
                } // else statement ending
            } // betType2 ending
            
            while (betType3 == true) {
                
                out.println("How many tokens would you like too bet?");
                tokenAmountBet = scanN.nextInt();           
                
                if (tokenAmountBet > tokens) { // checks if user entered right
                    errorTrap = true; // entered ammount greater
                    break;
                }
                
                out.println("What number do you predict the sum will be?");
                exactNumber = scanN.nextInt(); // scans for exact number
                
                out.println("rolling dices one moment");
                diceOne = ((int)(Math.random()*6)+1); // roll random number 1-6
                diceTwo = ((int)(Math.random()*6)+1); // roll random number 1-6
                diceRollSum = diceOne + diceTwo; // sum of the die roll
                Thread.sleep(2000); // wait 2 second
                               
                out.println("\nFirst dice landed on a " + diceOne
                        + "\nSecond dice landed on a " + diceTwo
                        + "\nThe sum is " + diceRollSum);
                Thread.sleep(500); // wait .5 second
                
                if (exactNumber == diceRollSum) {
                    tokens += tokenAmountBet*7; // times by 7 and adds to tokens
                    out.println("You won the bet!"
                            + "\nthe sum of the dice was what you predicted"
                            + "\nYou get " + tokenAmountBet  + " tokens");
                    Thread.sleep(1000); // wait 1 second
                    betType3 = false;
                    introduction(); // takes person back to intro
                }
                
                else {
                    out.println("\nWhat were you thinking?? did you really"
                            + "\njust bet precious tokens on a number, when you"
                            + "\nonly had a 8.33% chance of correctly landing "
                            + "\nthe dice!"
                            + "\nYou should spend your time on better stuff.");
                    tokens -= tokenAmountBet; // subtracts amount
                    Thread.sleep(1000); // wait 1 second
                    betType3 = false;
                    introduction(); // takes person back to intro
                }               
            }
        } while (errorTrap == true); // error trap ending
                            
    } //method ending
    
    /**
     * Method Name: popperGame
     * Description: This is where all the code for the popper game is stored
     * @throws java.lang.InterruptedException
     */      
    public static void popperGame() throws InterruptedException {               
        
        String nameOne, nameTwo; // name of players
        String answer; // yes or no
        int diceRollOne, diceRollTwo; // the two dice rolls, one for each player
        int scoreOne = 50, scoreTwo = 50; // begins with 50 points                                         
        int roundNum = 0; // round number
        boolean questionOneE = false, questionTwoE = false; // for errorTraping
        boolean checkName1, checkName2; // make sure user entered a name
        boolean flag = true; // for error trapping
        boolean questionDone1 = false; // continue dice rolls after QA
        boolean questionDone2 = false; // continue dice rolls after QA
        
        // intro
        Thread.sleep(1000); // wait 1 second
        out.println("\t\t\tWELCOME TOO POPPER");
        out.println("\nPopper is a game where you and one other player get "
                + "\nto take turns rolling a dice, the goal is to be the last "
                + "\nperson to reach 0, if you win you get an astounding 100 "
                + "\ntokens. If you lose, well you lose all your tokens. "
                + "\nSo read below for the rules and letÃ¢â‚¬â„¢s play!");
        out.println("\nPress any key to see rules");
        scanS.nextLine(); // waits for player to press key
        
        out.println("1)You and your opponent will start off with 50 points");
        
        Thread.sleep(2000); // 2 second delay                                                            
        out.println("\n2)Each person will take a turn rolling the dice. "
                + "If you "
                + "\nroll a number smaller than your opponent you will lose"
                + "\npoints depending on what the opponent rolled. ");  
        
        Thread.sleep(4500); // 4.5 second delay
        out.println("\n3)However if you find yourself in dire need too recover"
                + "\nsome points. You can ask the genie to present "
                + "you a question"
                + ".\nIf you are able to answer the question correctly "
                + "you will \nhave 10 points added back to your score. "
                + "If you answer wrong\nthe game simply continues.");      
      
        out.println("\n\nPress Enter to Begin");
        scanS.nextLine();
        Thread.sleep(500); // wait .5 seconds
        
        out.println("\n\t  Starting Game");
        
        do {
            out.println("\nPlayer 1 what would you like to be called? ");
            nameOne = scanS.nextLine(); // asking for name of player1
            
            // if someone presses enter by accident and skips name select
            switch (nameOne)
            {
                case "": // entered nothing
                    System.out.println("Please Enter a Name");
                    checkName1 = true; // makes it loop back to the question
                    break;
                
                default:
                    checkName1 = false; // means the person entered a name
                    break;
            }
        } while (checkName1 == true);
        
        do {                        
            out.println("\nPlayer 2 what would you like to be called? ");
            nameTwo = scanS.nextLine(); // asking for name of player2
            
            // if someone presses enter by accident and skips name select
            switch (nameTwo)
            {
                case "": // entered nothing
                    System.out.println("\nPlease Enter a name to play");
                    checkName2 = true; // makes it loop back to the question
                    break;
                
                default:
                    checkName2 = false; // means the person entered a name
                    break;
            }            
        } while (checkName2 == true); // error trapping loop ends
        
        do { // error trapping loop
            roundNum += 1; // advances 1 round each time the loop begins
            out.println("\nStarting round: " + roundNum);
            
            out.println("\n" + nameOne + " it's your turn press enter to roll");
            scanS.nextLine(); // waits for enter
            diceRollOne = (int)(6*Math.random()) + 1; // rolls dice
            out.println("You rolled a " + diceRollOne); // print
            
            out.println("\n" + nameTwo +" it's your turn press enter to roll");
            scanS.nextLine(); // waits for enter
            diceRollTwo = (int)(6*Math.random()) + 1; // rolls dice
            out.println("You rolled a " + diceRollTwo); // print
                                                                                             
            // Score Checking code below                      
            if (diceRollOne == diceRollTwo) {
                out.println("\nYou Both landed on the same Number"
                        + "\nyou both will remain at the same score!");
            }
            
            else if (diceRollOne < diceRollTwo) {
                out.println( "\n" + nameOne + ", unfortunetly " + nameTwo 
                        + " rolled higher"
                        + "\nYou loose " + diceRollTwo + " points");
                scoreOne -= diceRollTwo; // subtracts higher roll from score
                Thread.sleep(1000); //sleep 1 second
                out.print("\n" + nameOne + " Score: " + scoreOne
                        +  "\n" + nameTwo + " Score: " + scoreTwo);
            }
            
            else {
                out.println( "\n" + nameTwo + ", unfortunetly " + nameOne 
                        + " rolled higher"
                        + "\nYou loose " + diceRollOne + " points");
                scoreTwo -= diceRollOne; // subtracts higher roll from score
                Thread.sleep(1000); //sleep 1 second
                out.print("\n" + nameOne + " Score: " + scoreOne                        
                        + "\n" + nameTwo + " Score: " + scoreTwo);                
            }
            
            if (scoreOne <= 0) {
                out.println("\n\n" + nameTwo + " wins"
                        + " You loose 10 tokens");
                tokens -= 10; // removes 10 tokens
                Thread.sleep(5000); // wait 5 seconds
                introduction(); // takes person back to intro            
                break;
            }
            
            else if (scoreTwo <= 0) {
                out.println("\n\n" + nameOne + " WINS"
                        + " You win 50 tokens!");
                tokens += 50; // adds 50 tokens
                Thread.sleep(5000); // wait 5 seconds
                introduction(); // takes person back to intro
                break;
            } 
            
            // does userOne want to get asked a question for points?
            while (questionDone1 == false) { // wont ask again                            
                if (scoreOne >= 30 && scoreOne <= 35) {
                    do { // loop is for error trapping                
                        out.print("\n\n\n" + nameOne + " would you "
                                + "like too answer "
                                + "a question"+ "\nto get 10 points? "
                                + "\n\nplease enter \n1) yes\n2) no");
                        answer = scanS.nextLine(); // scans for yes or no                        
                        // processes input
                        switch (answer.toLowerCase()) 
                        {
                            case "yes":
                            case "1":
                                /* 
                                calls for questions & sets it equal to score
                                upon return of value
                                */ 
                                scoreOne = questionsPlayerOne(scoreOne);
                                questionDone1 = true; // dont repeat
                                break;

                            case "no":
                            case "2":
                                questionDone1 = true; // dont repeat
                                // lets the game continue
                                break;

                            default:
                                out.println("select a valid answer");
                                questionOneE = true; // error trapping          
                                break;
                        }
                    } while (questionOneE == true); // question one end
                }
                else 
                    break; // if it isn't between the score range it moves on
                
            }           
            // does userTwo want to get asked a question?
            while (questionDone2 == false) { // wont ask again                            
                if (scoreTwo >= 30 && scoreTwo <= 35) {
                    do { // loop is for error trapping                
                        out.println("\n" + nameTwo + " would you "
                                + "like too answer "
                                + "a question"+ "\nto get 10 points? "
                                + "\nplease enter yes or no");
                        answer = scanS.nextLine(); // stores answer

                        switch (answer.toLowerCase()) 
                        {
                            case "yes":
                            case "1":
                                /* 
                                calls for questions & sets it equal to score
                                upon return of value
                                */ 
                                scoreTwo = questionsPlayerTwo(scoreTwo);
                                questionDone2 = true;
                                break;

                            case "no":
                            case "2":
                                questionDone2 = true;
                                // lets the game continue
                                break;

                            default:
                                out.println("select a valid answer");
                                questionTwoE = true; // error trapping          
                                break;
                        }
                    } while (questionTwoE == true);
                }
                else 
                    break; // if it isn't between the score range it resets
               
            }                        
        } while (flag == true); // error trapping loop ending               
    } // method ending
    
    /**
     * Method Name: questionsPlayerOne
     * Description: this is where the questions are stored that ask the player
     * a question that if correct get 10 additional points.
     * @param scoreOne
     * @return scoreOne
     * @throws InterruptedException 
     */
    public static int questionsPlayerOne (int scoreOne) 
            throws InterruptedException {
        
        String answerToQuestion; // input for answer
        boolean errorTrapping; // for errorTrapping
                            
            out.println("\n\nwhat would 1 divided by 0 be?"
                    + "\na)0"
                    + "\nb)Undefined"
                    + "\nc)0 divided by 0 is 0, the opposite of nothing"
                    + "\nis 42. 42/42 = 1. so the opposite of 1 is -1"
                    + "\nhard to do");
            Thread.sleep(1000); // wait 1 second
            out.println("\nenter 'a', 'b', or 'c'");
            answerToQuestion = scanS.nextLine(); // stores answer by player
        
        do {
            switch (answerToQuestion.toLowerCase())
            {
                case "a": // entered wrong
                    out.println("wrong, the game shall continue");
                    errorTrapping = false;
                    Thread.sleep(1000); // wait 1 second
                    break;

                case "b": // entered right
                    out.println("Correct we will add 10 points to your score!");
                    errorTrapping = false;
                    scoreOne += 10;
                    out.println("\nyour score is now " + scoreOne);
                    Thread.sleep(1500); // wait 1.5 seconds
                    break;

                case "c": // entered wrong
                    errorTrapping = false;
                    out.println("wrong, the game shall continue");
                    Thread.sleep(1000); // wait 1 second
                    break;

                default:
                    out.println("You did not select anything");
                    Thread.sleep(1000); // wait 1 second
                    errorTrapping = true;
            }
        } while (errorTrapping == true); // error trapping loop
        return (scoreOne);
    } // method ending
    
    /**
     * Method Name: questionsPlayerTwo
     * Description: this is where the questions are stored that ask the player
     * a question that if correct get 10 additional points.
     * @param scoreTwo
     * @return scoreTwo
     * @throws InterruptedException 
     */
    public static int questionsPlayerTwo (int scoreTwo) 
            throws InterruptedException {
        
        String answerToQuestion; // input for answer
        boolean errorTrapping; // for errorTrapping
                            
            out.println("\n\nwhen was Albert Enstien born?"
                    + "\na) March 14, 1979"
                    + "\nb) March 14, 1879"
                    + "\nc) January 7, 1778"
                    + "\n\n enter 'a', 'b', or 'c'");
            answerToQuestion = scanS.nextLine();
        
        do {
            switch (answerToQuestion.toLowerCase())
            {
                case "a": // entered wrong
                    errorTrapping = false;
                    out.println("wrong, the game shall continue");
                    Thread.sleep(1500); // wait 1.5 second
                    break;

                case "b": // entered right
                    out.println("Correct we will add 10 points to your score!");
                    errorTrapping = false;
                    scoreTwo += 10; // adds 10 points to score
                    out.println("\nyour score is now " + scoreTwo);
                    Thread.sleep(1500); // wait 1.5 seconds
                    break;

                case "c": // entered wrong
                    errorTrapping = false; // dont loop
                    Thread.sleep(1500); // wait 1.5 second
                    out.println("wrong, the game shall continue");
                    break;

                default:
                    errorTrapping = true; // need to loop again
                    Thread.sleep(1000); // wait 1 second
                    out.println("You did not select anything");
                    break;                    
            }
        } while (errorTrapping == true); // error trapping loop             
        return (scoreTwo);
    } //method ending
} // Main Ending

