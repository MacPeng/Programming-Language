public class DegreeWithAid extends Degree{
    int recreationFee = 100;
    int unionFee = 50;
    int creditFee = 275;
    int credit = 0;
    int initialCost = 0;
    int totalCost = 0;
    public DegreeWithAid(String s) {
        super(s);
        credit = Integer.parseInt(newarr[4]);
    }
    public int Cost() {//compute the cost
        if (credit > 12) {
            credit = 12;
        }
        initialCost = recreationFee + unionFee + creditFee * credit;
        totalCost = initialCost - getFinancialAid();
        if( totalCost >= 0 ) {
            return totalCost;
        }
        else {
            return 0;
        }
    }

    public String setTypes(){
        return "Degree Seeking With Financial Aid Student";
    }
}
