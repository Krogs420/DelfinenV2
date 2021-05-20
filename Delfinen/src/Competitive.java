public class Competitive extends Timer {
    private int rank;

    public Competitive(int rank, String timer, String discipline, String date) {
        super(timer, discipline, date);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Competitive{" +
            "rank=" + rank +
            '}';
    }
}
