import java.util.Comparator;

public class TimeComparator implements Comparator<TrialTimer> {
    public int compare(TrialTimer o1, TrialTimer o2) {
        return (int) (o1.getTimer() - o2.getTimer());
    }
}