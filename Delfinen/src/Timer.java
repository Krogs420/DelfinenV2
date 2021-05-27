public class Timer {
    private int iD;
    private String name;
    private String date;
    private double timer;
    private boolean juniorSenior;

    @Override
    public String toString() {
        return "Timer{" +
                "iD=" + iD +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", timer='" + timer + '\'' +
                '}';
    }

    public Timer(int iD, String name, String date, double timer) {
        this.iD = iD;
        this.name = name;
        this.date = date;
        this.timer = timer;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTimer() {
        return timer;
    }

    public void setTimer(double timer) {
        this.timer = timer;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

//Creators - Christopher
