public class SeniorCitizen extends NonDegree{
    int assesmentFee = 100;
    int creditFee = 50;
    int credit = 0;
    int all = 0;
    public SeniorCitizen(String s) {
        super(s);
        credit = Integer.parseInt(arr[4]);
    }
    public int Cost() {
        if(credit <= 6){
            all = assesmentFee;
        }else{
            all = assesmentFee + creditFee * (credit-6);
        }
        return all;

    }
    public String setTypes(){
        return "Senior Student";
    }
}
