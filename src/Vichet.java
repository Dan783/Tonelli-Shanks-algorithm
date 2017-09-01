import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Dan on 20.04.2017.
 */
public class Vichet {
    private int module;
    private ArrayList<Integer> list1 = new ArrayList<>();
    private ArrayList<Integer> list2 = new ArrayList<>();

    public Vichet(int module) {
        this.module = module;
    }

    public boolean checkNeVichet(int number) {
        int buffer = number;
        for (int i = 2; i <= (module - 1) / 2; i++) {
            buffer = buffer * number % module;
        }
        if (buffer == (module - 1)) {
            return true;
        }
        return false;

    }

    public boolean checkVichet(int number) {
        int buffer = number;
        for (int i = 2; i <= (module - 1) / 2; i++) {
            buffer = buffer * number % module;
        }
        if (buffer == 1) {
            return true;
        }
        return false;
    }

    public void allVichet() {
        for (int i = 0; i < (module - 1) / 2; i++) {
            int buffer = i;
            for (int j = 2; j <= (module - 1) / 2; j++) {
                buffer = buffer * i % module;
            }
            if (buffer == 1) {
                list1.add(i);
            }
        }
    }

    public void getAllVichet() {
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("Вычет : " + list1.get(i));
        }
    }

    public void allNeVichet() {
        for (int i = 0; i < (module - 1) / 2; i++) {
            int buffer = i;
            for (int j = 2; j <= module; j++) {
                buffer = buffer * i % module;
            }
            if (buffer == (module - 1)) {
                list2.add(i);
            }
        }
    }

    public void getAllNeVichet() {
        for (int i = 0; i < list2.size(); i++) {
            System.out.println("Не вычет : " + list2.get(i));
        }
    }
}



