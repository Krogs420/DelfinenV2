import java.io.FileNotFoundException;

public class Cashier {

    private int memberFee;

    Administrator administrator = new Administrator();

    public Cashier() throws FileNotFoundException {
    }

    public int memberFeeCalculator() {

        memberFee = 0;

        for (int i = 0; i < administrator.getMemberlist().size(); i++) {

            //if (administrator.getMemberlist().get(i).isActiveMember()) {

                if (administrator.getMemberlist().get(i).getAge() < 18) {
                    memberFee = 1000;

                } else if (administrator.getMemberlist().get(i).getAge() >= 18 &&
                        administrator.getMemberlist().get(i).getAge() <= 60) {
                    memberFee = 1600;

                } else {
                    memberFee = 1150;
                }

            } //else {
               // memberFee = 500;
           // }

        //}
        return memberFee;
    }

    public void showMemberFeeTotal() {
        int result = memberFeeCalculator();
        System.out.println(result);

    }

}
