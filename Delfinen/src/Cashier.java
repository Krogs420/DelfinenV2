public class Cashier {

    private int memberFee;
    private int memberFeeTotal;

    Administrator administrator = new Administrator();

    public void memberFeeCalculator(){

        if (administrator.member.isActiveMember() == false) {

            for (int i = 0; i < administrator.getMemberlist().size(); i++) {
                if (administrator.member.getAge() < 18) {
                    memberFee = 1000;
                    memberFee += memberFeeTotal;

                } else if (administrator.member.getAge() >= 18 && administrator.member.getAge() <= 60) {
                    memberFee = 1600;
                    memberFee += memberFeeTotal;

                } else  {
                    memberFee = 1150;
                    memberFee += memberFeeTotal;
                }

            }

        } else{
            memberFee = 500;
            memberFee += memberFeeTotal;
        }
    }

    public void showMemberFeeTotal(){
        memberFeeCalculator();
        System.out.println(memberFeeTotal);

    }

}
