public class Competitive extends Timer {
    private int rank;
    private String placeOfComp;

    @Override
    public String toString() {
        return super.toString() +
                "Competitive{" +
                "rank=" + rank +
                ", placeOfComp='" + placeOfComp + '\'' +
                '}';
    }

    public Competitive(int iD, String name, String date, double timer, int rank, String placeOfComp) {
        super(iD, name, date, timer);
        this.rank = rank;
        this.placeOfComp = placeOfComp;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPlaceOfComp() {
        return placeOfComp;
    }

    public void setPlaceOfComp(String placeOfComp) {
        this.placeOfComp = placeOfComp;
    }


}

//Creators - Christopher
