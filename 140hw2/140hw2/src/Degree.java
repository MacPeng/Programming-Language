public class Degree implements StudentInfo{
    public String id;
    public String age;
    public String creditHour;
    public String firstname;
    public String lastname;
    public int fees;
    public int financialAid;
    public String major;
    public String financialAidStatus;
    public String academicStanding;
    public String type;
    public String[] newarr;


    public Degree(String s) {//check degree seeking students
        if (s != null) {
            newarr = s.split(";");//split the string into different parts
        id = newarr[0];
        firstname = newarr[1];
        lastname = newarr[2];
        age = newarr[3];
        creditHour = newarr[4];
        financialAid = newarr.length > 9 ? Integer.parseInt(newarr[9]) : 0;//check if financial aid is within the input string
        setMajor(newarr[6]);
        setAcademicStanding(newarr[7]);

        }
    }

    public String getid() {
        return id;

    }
    public  String getage() {
        return age;
    }

    public  String getcredit() {
        return creditHour;
    }
    public String getfirstname() {
        return firstname;
    }
    public String getlastname() {
        return lastname;
    }
    public int getfees() {
        return fees;
    }
    public String getaid() {
        return financialAidStatus;
    }
    public String getacademicstanding() {
        return academicStanding;
    }
    public String getmajor() {
        return major;
    }

    public String getType() {
        return type;
    }

    public void setFinancialAid(int s){
        financialAid = s;
    }

    public int  getFinancialAid(){
        return financialAid;
    }

    public void setMajor(String str) {
        switch (str) {
            case "S":
                major = "gaming science";
                break;
            case "M":
                major = "hotel managment";
                break;
            case "A":
                major = "lounge arts";
                break;
            case "E":
                major = "beverage engineering";
                break;
            default:
                major = "major not found";
                break;
        }
    }
    public void setAcademicStanding(String s) {
        switch (s) {
            case "G":
                academicStanding = "Good";
                break;
            case "W":
                academicStanding = "Warning";
                break;
            case "P":
                academicStanding = "Probation";
                break;
            default:
                academicStanding = "Academic Standing Not Found";
                break;
        }

    }

    public void printData(){
        System.out.println("ID number: " + id);
        System.out.println("Name:      " + firstname + " " + lastname);
        System.out.println("Age:       " + age);
        System.out.println();
        System.out.println(firstname + " is a degree-seeking student enrolled in " + creditHour + " credits");
        System.out.println(firstname + " receives $" + getFinancialAid() + " in financial assistance per term");
        System.out.println(firstname + "'s major is " + major);
        System.out.println(firstname + "'s academic standing is " + academicStanding);
        System.out.println();


    }

    public int computeFees(){
        return Math.max(100 + 50 + Math.min(12 * 275, Integer.parseInt(creditHour) * 275) - financialAid, 0);
    }


}

