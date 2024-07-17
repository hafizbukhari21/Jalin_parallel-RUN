import Services.MainService;
import util.DateConvertion;

public class Workflow {
    public static void main(String[] args ){
        /*
         * 
         * args[0]=date
         * arg 1 = ENV  1=VIT|2=Staging
         * 
         */
        String date = DateConvertion.DateInputReformated(args[0]);
        String envS = args[1];
        Integer env = Integer.parseInt(envS);


        //Set Process Control Date
        MainService.setProsessControlDate(date, env);

    }
}
