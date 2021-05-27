import java.util.Comparator;

public class TimeComparator2 implements Comparator<Competitive> {
    public int compare(Competitive o1, Competitive o2) {
        return (int) (o1.getTimer() - o2.getTimer());
    }
}
