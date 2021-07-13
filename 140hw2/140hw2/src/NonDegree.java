public class NonDegree implements StudentInfo{
    public String id;
    public String age;
    public String creditHour;
    public String firstname;
    public String lastname;
    public int fees;
    public String major;
    public String financialAidStatus;
    public String academicStanding;
    public String type;
    public String [] arr;

    public NonDegree(String s){
        if(s!=null){
            arr = s.split(";");
        }

        id = arr[0];
        firstname =  arr[1];
        lastname = arr[2];
        age = arr[3];
        creditHour = arr[4];
        type = "non-degree seeking";
        academicStanding = "N/A";

    }

    public String getid() {
        return  id;
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

    public  void setmajor(String s) {
        switch (s) {
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

     public void printData(){
        System.out.println("ID number: " + id);
        System.out.println("Name:      " + firstname + " " + lastname);
        System.out.println("Age:       " + age);
        System.out.println();
        System.out.println(firstname + " is a non-degree-seeking student enrolled in " + creditHour + " credits");
        if(!arr[6].equals("S")){
            if(arr[7].equals("S"))System.out.println(firstname + "'s type of certificate being pursued is gaming Science");
            else if(arr[7].equals("M"))System.out.println(firstname+ "'s type of certificate being pursued is hotel Management");
            else if(arr[7].equals("A"))System.out.println(firstname + "'s type of certificate being pursued is lounge Arts");
            else if(arr[7].equals("E"))System.out.println(firstname + "'s type of certificate being pursued is beverage Engineering");
        }else if(arr[6].equals("S")){
            System.out.println(firstname + " is a senior citizen");
        }
        System.out.println();
    }

    public int computeFees(){
        if(!arr[6].equals("C")){
          if(Integer.parseInt(creditHour)>6) {
              return 100 + 50 * (Integer.parseInt(creditHour)- 6);
          }else{
              return 100;
          }
        }else{
            return 700 + 300 * Integer.parseInt(creditHour);
        }
    }

}
