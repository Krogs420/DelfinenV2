public class Member {


    private int iD;
    private String name;
    private int age;
    private String mail;
    private boolean activeMember;
    private boolean juniorSenior;

    public Member(int iD, String name, int age, String mail, boolean activeMember, boolean juniorSenior, boolean motionComp) {
        this.iD = iD;
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.activeMember = activeMember;
        this.juniorSenior = juniorSenior;
        this.motionComp = motionComp;
    }

    @Override
    public String toString() {
        return "Member: " +
                "ID: " + iD + '\'' +
                "name = " + name + '\'' +
                ", age = " + age +
                ", mail = '" + mail + '\'' +
                ", activeMember = " + activeMember +
                ", juniorSenior = " + juniorSenior +
                ", motionComp = " + motionComp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isActiveMember() {
        return activeMember;
    }

    public void setActiveMember(boolean activeMember) {
        this.activeMember = activeMember;
    }

    public boolean isJuniorSenior() {
        return juniorSenior;
    }

    public void setJuniorSenior(boolean juniorSenior) {
        this.juniorSenior = juniorSenior;
    }

    public boolean isMotionComp() {
        return motionComp;
    }

    public void setMotionComp(boolean motionComp) {
        this.motionComp = motionComp;
    }

    private boolean motionComp;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }
}

