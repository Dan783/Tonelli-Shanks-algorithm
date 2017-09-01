public class TSAlgorithm {
    private int Q;
    private int R;
    private int S;
    private int n;
    private int p;
    private int z;
    private int c;
    private int t;
    private int M;
    private int b;

    public TSAlgorithm(int n, int p) {
        this.n = n;
        this.p = p;
    }

    private void setS() {
        ConsistPrime prime = new ConsistPrime(p - 1);
        prime.partition();
        S = prime.get2Count();
        System.out.println("S :" + S);
    }

    private void setQ() {
        ConsistPrime prime = new ConsistPrime(p - 1);
        prime.partition();
        Q = prime.numbetWithout2();
        System.out.println("Q :" + Q);
    }

    private void setZ() {
        Vichet first = new Vichet(p);
        for (int i = 0; i < p; i++) {
            if (first.checkNeVichet(i)) {
                z = i;
                break;
            }
        }
        System.out.println("Z :" + z);
    }

    private void setC() {
        setZ();
        setQ();
        c = ((int) Math.pow(z, Q)) % p;
        System.out.println("c :" + c);
    }

    private void setR() {
        int buffer = n;
        for (int i = 2; i <= (Q + 1) / 2; i++) {
            buffer = buffer * n % p;
        }
        R = buffer;
        System.out.println("R :" + R);
    }

    private void setT() {
        int buffer = n;
        for (int i = 2; i <= Q; i++) {
            buffer = buffer * n % p;
        }
        t = buffer;
        System.out.println("t :" + t);
    }

    private void setM() {
        M = S;
        System.out.println("M :" + M);
    }

    private void setB(int i) {
        b = count(c, (int) Math.pow(2, (M - i - 1)));
        System.out.println("b :" + b);
    }

    private int count(int number, int degree) {
        int buffer = number;
        for (int i = 2; i <= degree; i++) {
            buffer = buffer * number % p;
        }
        return buffer;
    }

    public int solve() {
        setS();
        if (S == 1) {
            return R = (int) Math.pow(n, (p / 4));
        } else {
            setC();
            setR();
            setT();
            setM();
            for (int i = 0; i < M; i++) {
                if (t == 1) {
                    return R;
                }
                System.out.println(i);
                if (count(t, (int) Math.pow(2, i)) == 1) {
                    setB(i);
                    R = (R * b) % p;
                    System.out.println("R :" + R);
                    System.out.println("t :" + t);
                    t = (t * b * b) % p;
                    System.out.println("t :" + t);
                    c = (b * b) % p;
                    System.out.println("c :" + c);
                    M = i;
                    System.out.println("M :" + M);
                    if (t == 1) {
                        return R;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        TSAlgorithm one = new TSAlgorithm(12, 73);
        System.out.println("x = " + one.solve());
    }
}
