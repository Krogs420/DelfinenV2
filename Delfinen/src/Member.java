public class Member {


    private int iD;
    private String name;
    private int age;
    private String mail;
    private boolean activeMember;
    private int memberFee;
    private boolean memberFeePaid;



    public Member(int iD, String name, int age, String mail, boolean activeMember, boolean motionComp, int memberFee, boolean memberFeePaid) {
        this.iD = iD;
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.activeMember = activeMember;
        this.motionComp = motionComp;
        this.memberFee = memberFee;
        this.memberFeePaid = memberFeePaid;
    }

    @Override
    public String toString() {
        return  "----------------------------------------" +
                "\nMember: " +
                "\nID: " + iD +
                "\nName: " + name +
                "\nAge: " + age +
                "\nMail: " + mail +
                "\nActive Member: " + activeMember +
                "\nMotionComp: " + motionComp +
                "\nYearly Fee: " + memberFee +
                "\nFee paid: " + memberFeePaid +
                "\n----------------------------------------";
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

    public int getMemberFee() {
        return memberFee;
    }

    public void setMemberFee(int memberFee) {
        this.memberFee = memberFee;
    }
}

//Creators - Jeppe

