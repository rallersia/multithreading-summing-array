import java.util.ArrayList;

class CalcThread extends Thread {
    ArrayList<Integer> array;
    int sum;
    int begin;
    int end;

    public CalcThread(ArrayList<Integer> array, int begin, int end) {
        this.array = array;
        sum = 0;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = begin; i <= end; ++i) {
            sum += array.get(i);
        }
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Thread " + getId() + ": from " + begin + " to " + end + " sum is " + sum;
    }
}
