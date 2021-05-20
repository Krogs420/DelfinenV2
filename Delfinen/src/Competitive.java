public class Competitive extends Timer {
    private int rank;

    public Competitive(int rank, String timer, String discipline, String date) {
        super(timer, discipline, date);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }



}
