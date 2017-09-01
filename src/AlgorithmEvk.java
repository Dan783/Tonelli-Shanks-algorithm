/**
 * Created by Dan on 18.03.2017.
 */
public class AlgorithmEvk {
    private int firstNumber;
    private int secondNumber;

    public AlgorithmEvk(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public boolean check() {
        AlgorithmEvk algor = new AlgorithmEvk(this.firstNumber, this.secondNumber);
        if (start(algor.getFirstNumber(), algor.getSecondNumber()) == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int start(int firstNumber, int secondNumber) {
        if (secondNumber == 0) return firstNumber;
        int k = firstNumber % secondNumber;
        return start(secondNumber, k);
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setFirstNumber(int Number) {
        this.firstNumber = Number;
    }

    public void setSecondNumber(int Number) {
        this.secondNumber = Number;
    }
}



