public class CertificateStudent extends NonDegree{
    int assesmentFee = 700;
    int creditFee = 300;
    int credit = 0;
    public CertificateStudent(String s) {
        super(s);
        credit = Integer.parseInt(arr[4]);
    }
    public int Cost() {
        return assesmentFee + creditFee * credit;
    }

    public String setTypes(){
        return "Certificate Student";
    }
}
