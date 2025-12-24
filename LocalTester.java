public class LocalTester {
    public static final int N_K_OUTPUT_LENGTH = 3;
    public static TestHandler testHandler = new TestHandler();
    public static void main(String[] args) {
        StdOut.println("Welcome to the Localized Tester!");
        TesterQuestionEnum questionSelected = null;
        String input = "";
        In in = new In();
        TesterQuestionEnum[] questions = TesterQuestionEnum.values();
       
        while (questionSelected == null) {
            StdOut.println("Please enter the question or question number you would like to test:\n");
            for (int i = 0; i < questions.length; i++) {
                StdOut.println((i + 1) + ". " + questions[i] + " (" + questions[i].getQuestion() + ")");
            }
            StdOut.println((questions.length + 1) + ". Run All Questions");
            
            StdOut.println("");
            input = in.readLine().toLowerCase().replaceAll(" ", "");
            if (input.equals("all") || input.equals("") || input.equals((questions.length + 1) + "")) {
                break;
            }
            questionSelected = isValidQuestion(input);
        }
        if (input.equals("all") || input.equals((questions.length + 1) + "")) {
            for (TesterQuestionEnum question : questions) {
                testHandler.questionDecider(question, question.getArgsPassed().split(" "));
            }
        } else {
            testHandler.questionDecider(questionSelected, questionSelected.getArgsPassed().split(" "));
        }
        testHandler.conclusion();
    }


    public static TesterQuestionEnum isValidQuestion(String input) {
        TesterQuestionEnum[] questions = TesterQuestionEnum.values();
        TesterQuestionEnum questionSelected = null;
        for (int i = 0; i < questions.length; i++) {
            try {
                questionSelected = TesterQuestionEnum.valueOf(input);
                break;
            } catch (Exception e) {
                if (questions[i].getQuestion().toLowerCase().equals(input.toLowerCase()) || input.equals((i + 1) + "")) {
                    questionSelected = questions[i];
                    break;
                }
            }
        }
        return questionSelected;
    }
}
