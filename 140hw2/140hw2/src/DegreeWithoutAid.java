public class DegreeWithoutAid extends Degree{
    int recreationFee = 100;
    int unionFee = 50;
    int creditFee = 275;
    int credit = 0;
    public DegreeWithoutAid(String s) {
        super(s);
        credit = Integer.parseInt(newarr[4]);
    }
    public int Cost() {
        if(credit>12){
            credit = 12;
        }
            return recreationFee + unionFee + creditFee * credit;

    }

    public String setTypes(){
        return "Degree Seeking Without Financial Aid Student";
    }

}
