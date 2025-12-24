import java.util.Arrays;

public class TestHandler {
    private Tester tester;
    
    public TestHandler() {
        this.tester = new Tester();
    }
    public void mainTestIntToBin(String[] args) {
        this.tester.reset(TesterQuestionEnum.INT_TO_BIN);
        for (int i = 1; i < args.length; i++) {
            testIntToBin(args[i]);
        }
        if (this.tester.hasPassed()) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }    

    public void testIntToBin (String args) {
        int x = 0;
        String expected = "";
        String actual = "";
        try {
            x = Integer.parseInt(args);
            expected = Integer.toBinaryString(x);    
            actual = IntToBin.toBinary(x);
        } catch (NumberFormatException e) {
            this.tester.gotExceptions();
            actual = TesterMessagesEnum.ERROR_TA_ATTENTION.getMessage() + " " + e.getMessage();
        } catch (StackOverflowError e) {
            this.tester.gotExceptions();
            actual = TesterMessagesEnum.ERROR.getMessage() + " Stack Overflow " + e.getMessage();
        } catch (Exception e) {
            this.tester.gotExceptions();
            actual = TesterMessagesEnum.ERROR.getMessage() + " " + e.getMessage();
        }
        tester.test(x + "", expected, actual);
    }

    public void mainTestIsPalindrome(String[] args) {
        this.tester.reset(TesterQuestionEnum.IS_PALINDROME);
        for (int i = 1; i < args.length; i++) {
            testIsPalindrome(args[i]);
        }
        if (this.tester.hasPassed()) {
            this.tester.updatePoints();
        }
        System.out.println(this.tester);
        
    }
    public void testIsPalindrome(String args) {
        String word = "";
        String expected = "";
        String actual = "";
        try {
            word = args;
            expected = (word.length() <= 1 || new StringBuilder(word).reverse().toString().equals(word)) + "";
            actual = Boolean.toString(Palindrome.isPalindrome(word));
        } catch (StackOverflowError e) {
            this.tester.gotExceptions();
            actual = TesterMessagesEnum.ERROR.getMessage() + "Stack Overflow " + e.getMessage();
        } catch (Exception e) {
            this.tester.gotExceptions();
            actual = TesterMessagesEnum.ERROR.getMessage() + e.getMessage();
        }
        this.tester.test(word, expected, actual);
    }

    public void mainTestBinomial(String[] args) {
        this.tester.reset(TesterQuestionEnum.BINOMIAL);

        int [][] values = new int [args.length - 1][LocalTester.N_K_OUTPUT_LENGTH];
        for (int i = 1; i < args.length; i++) {
            String [] arr = args[i].split(",");
            values[i-1][0] = Integer.parseInt(arr[0]);
            values[i-1][1] = Integer.parseInt(arr[1]);
            values[i-1][2] = Integer.parseInt(arr[2]);
        }
        for (int i = 0; i < values.length; i++) {
            testBinomial(values[i]);
        }
        if (this.tester.hasPassed()) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    public void testBinomial(int[] value) {
        int n = value[0];
        int k = value[1];
        String expected = "" + value[2];
        String actual = "";
        try {
            actual += Binomial.binomial(n, k);
        }  catch (StackOverflowError e) {
            this.tester.gotExceptions();
            actual = TesterMessagesEnum.ERROR.getMessage() + "Stack Overflow " + e.getMessage();
        } catch (Exception e) {
            this.tester.gotExceptions();
            actual = TesterMessagesEnum.ERROR.getMessage() + e.getMessage();
        }
        this.tester.test(n + ", " + k, expected, actual);
    }

    public void mainTestMemoBinomial(String[] args) {
        this.tester.reset(TesterQuestionEnum.MEMO_BINOMIAL);
        long [][] values = new long [args.length - 1][LocalTester.N_K_OUTPUT_LENGTH];
        for (int i = 1; i < args.length; i++) {
            String [] arr = args[i].split(",");
            values[i-1][0] = Long.parseLong(arr[0]);
            values[i-1][1] = Long.parseLong(arr[1]);
            values[i-1][2] = Long.parseLong(arr[2]);
        }
        for (int i = 0; i < values.length; i++) {
            testMemoBinomial(values[i]);
        }
        if (this.tester.hasPassed()) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    public void testMemoBinomial(long[] value) {
        long n = value[0];
        long k = value[1];
        String expected = "" + value[2];
        String actual = "";
        try {
            actual += Binomial.binomial((int)n, (int)k);
        } catch (StackOverflowError e) {
            this.tester.gotExceptions();
            actual = TesterMessagesEnum.ERROR + "Stack Overflow " + e.getMessage();
        } catch (Exception e) {
            this.tester.gotExceptions();
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        this.tester.test(n + ", " + k, expected, actual);
    }
 
    public void mainTestIsSorted(String[] args) {
        this.tester.reset(TesterQuestionEnum.IS_SORTED);
        for (int i = 1; i < args.length; i++) {
            testIsSorted(args[i]);
        }
        if (this.tester.hasPassed()) {
            this.tester.updatePoints();
        }
        System.out.println(this.tester);
        
    }
    
    public void testIsSorted(String args) {
        String arrayStr = "";
        String expected = "";
        String actual = "";
        try {
            arrayStr = args;
            String[] strValues = arrayStr.split(",");
            int[] arr = new int[strValues.length];
            for (int i = 0; i < strValues.length; i++) {
                arr[i] = Integer.parseInt(strValues[i]);
            }
            int [] arrClone = arr.clone();
            Arrays.sort(arrClone);
            expected = Arrays.equals(arr, arrClone) + "";
            actual = Boolean.toString(IsSorted.isSorted(arr));
        } catch (StackOverflowError e) {
            this.tester.gotExceptions();
            actual = TesterMessagesEnum.ERROR.getMessage() + "Stack Overflow " + e.getMessage();
        } catch (Exception e) {
            this.tester.gotExceptions();
            actual = TesterMessagesEnum.ERROR.getMessage() + e.getMessage();
        }
        this.tester.test(arrayStr, expected, actual);
    }

    public void conclusion() {
        this.tester.conclusion();
    }

    public void questionDecider(TesterQuestionEnum question, String[] args) {
        switch (question) {
            case INT_TO_BIN:
                this.mainTestIntToBin(args);
                break;
            case IS_PALINDROME:
                this.mainTestIsPalindrome(args);
                break;
            case BINOMIAL:
                this.mainTestBinomial(args);
                break;
            case MEMO_BINOMIAL:
                this.mainTestMemoBinomial(args);
                break;
            case IS_SORTED:
                this.mainTestIsSorted(args);
                break;
            default:
                System.out.println("Invalid Question");
        }
    }
}
