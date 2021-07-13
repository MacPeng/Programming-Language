import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.*;
//There is a printdata function in Degree class for degree seeking students and there is another printdata function in nonDegree class
// for non degree seeking students.
//Also computeFees has been implemented in Degree class and nonDegree class.
//In the main function I used function call for report1 and report2.


public class Main {
    public static int totalFinancialfees = 0;
    public static int totalNonFinancialfees = 0;
    public static int totalCertificatefees = 0;
    public static int totalSeniorfees = 0;
    public static int totalFees = 0;

    public static void report2(){
        totalFees = totalFinancialfees + totalNonFinancialfees + totalCertificatefees + totalSeniorfees;
        System.out.println();
        System.out.println("Summary of student fees assessed:");
        System.out.println();
        System.out.println("Degree-seeking students without financial assistance: $"+totalNonFinancialfees);
        System.out.println("Degree-seeking students with financial assistance: $"+totalFinancialfees);
        System.out.println("Certificate students: $"+totalCertificatefees);
        System.out.println("Senior citizens: $"+totalSeniorfees);
        System.out.println("Total fees assessed: $"+totalFees);
    }



    public static void main(String[] args) throws FileNotFoundException{
        try{
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("/Users/mikepeng/IdeaProjects/140hw2/src/hw2.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                String[] newarr = strLine.split(";");
                if(newarr[5].equals("Y")){//check for degree seeking with financial aid students and compute fees for them
                    Degree degree1 =  new Degree(strLine);
                    if (newarr[8].equals("Y")) {
                        DegreeWithAid aidStudent = new DegreeWithAid(strLine);
                        aidStudent.fees = aidStudent.Cost();
                        aidStudent.setFinancialAid(Integer.parseInt(newarr[9]));
                        totalFinancialfees += Math.max(0, aidStudent.totalCost);
                        aidStudent.type = aidStudent.setTypes();
                    }
                    else {//check for degree seeking without financial aid students and compute fees for them
                        DegreeWithoutAid noAidStudent = new DegreeWithoutAid(strLine);
                        noAidStudent.fees = noAidStudent.Cost();
                        noAidStudent.setFinancialAid(0);
                        noAidStudent.type = noAidStudent.setTypes();
                        totalNonFinancialfees += noAidStudent.Cost();
                    }
                    //degree1.printData();
                    System.out.println(degree1.firstname + " " + degree1.lastname + " $" + degree1.computeFees() );
                }else{
                    NonDegree nondegree1 = new NonDegree(strLine);

                    if (newarr[6].equals("C")) {//check for certificate students and compute fees for them
                        CertificateStudent certificated = new CertificateStudent(strLine);
                        certificated.type = certificated.setTypes();
                        certificated.setmajor(newarr[7]);
                        totalCertificatefees += certificated.Cost();

                    } else {//check for senior students and compute fees for them
                        SeniorCitizen senior = new SeniorCitizen(strLine);
                        totalSeniorfees += senior.Cost();
                        senior.financialAidStatus = String.format("%s receives no financial aid", senior.firstname);
                        senior.type = senior.setTypes();
                    }
                    //nondegree1.printData();
                    System.out.println(nondegree1.firstname + " " + nondegree1.lastname + " $" + nondegree1.computeFees() );
                }

            }
            //computeFees();
            report2();

            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

    }
}
