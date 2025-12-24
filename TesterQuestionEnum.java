public enum TesterQuestionEnum {
    INT_TO_BIN("Integer To Binary", 25, "INT_TO_BIN 10 1 0 203 389 312 255 1024 2047 4096 8191"), 
    IS_PALINDROME("Is Palindrome", 25, "IS_PALINDROME racecar hello madam apple a baron aba abba abra ijacn abcd deed noon civic level rotor kayak refer palindrome notapalindrome almostpalindrome"),
    BINOMIAL("Binomial", 25, "BINOMIAL 5,2,10 10,5,252 10,0,1 10,10,1 10,1,10 10,9,10 10,8,45 10,7,120 10,6,210 10,4,210 15,5,3003 20,10,184756"),
    MEMO_BINOMIAL("Binoial with Memoization", 15, "MEMO_BINOMIAL 5,2,10 10,5,252 10,0,1 10,10,1 10,1,10 10,9,10 10,8,45 10,7,120 10,6,210 10,4,210 15,5,3003 20,10,184756 35,13,1476337800 39,11,1676056044 50,25,126410606437752 30,15,155117520"),
    IS_SORTED("Is Sorted", 10, "IS_SORTED 1,2,3,4,5,6,7,8,9,10 10,9,8,7,6,5,4,3,2,1 1,1,1,1,1,1,1,1 1,2,2,3,4,5,6,7,8,9 10,20,30,40,50,60 -10,-5,0,5,10,15,20 3,3,3,2,1,0,-1 1,3,2,4,5,6 100,200,300,400,500,600 -50,-40,-30,-20,-10,0,10 50,40,30,20,10,0,-10 1,2,3,5,4,6,7,8 10,9,8,7,6,5,4,3,2,1,0 0,1,2,3,4,5,6,7,8,9,10,-11,12,13,14,15 15,14,13,12,11,10,9,8,7,6,5,4,3,2,1 5,10,15,-20,25,30,35,40,45,50 -1,2,3,4,5,6,8,7,9,-10");
    
    private final String question;
    private final int maxPoints;
    private final String argsPassed; 

    TesterQuestionEnum(String question, int maxPoints, String argsPassed) {
        this.question = question;
        this.maxPoints = maxPoints;
        this.argsPassed = argsPassed;
    }


    public String getQuestion() {
        return this.question;
    }
    public int getMaxPoints() {
        return this.maxPoints;
    }
    public String getArgsPassed() {
        return this.argsPassed;
    }
}
