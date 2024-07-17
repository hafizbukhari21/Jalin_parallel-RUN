import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import Services.HellperExec;
import Services.MainService;
import Services.SendTelegram;
import util.DatabaseUtil;
import util.DateConvertion;
import util.LogUtil;
import util.PropertiesUtil;
import util.ScheduleTask;


class Main {
  
    public static void main(String[] args ){
      

      /*
       * arg 0 = Date YYYYMMDD
       * arg 1 = ENV  1=VIT|2=Staging
       * arg 2 = MultipleDate 1=NO | 2=Yes
       * arg 3 = Proses Id 
       */

      //Integer env = Integer.parseInt(args[0]);
      String date = DateConvertion.DateInputReformated(args[0]);
      String envS = args[1]; //1=VIT 2=Staging
      int multipleDate = Integer.parseInt(args[2]); //1=NO 2=Yes
      int prosesId = Integer.parseInt(args[3]);
      int env = Integer.parseInt(envS) ;

      //Initial Dev
      MainService.initial();
      
      switch (prosesId) {
          case 4:
            //Delete Some RT_Clearing
            MainService.clearingRTClearing(env);
          break;
      
          case 5:
            //Push Source 1 Bisa multiple Date
            MainService.pushSourceOne(date,env,multipleDate);
          break;
          
          case 6:
            //Check Source 1 Udah Naik atau belum
            MainService.checkSourceOne(env);
          break;
          
          case 7:
            //Run Helper Baru Singgle Date
            runhelper(envS, multipleDate, date);
          break;

          default:
          break;
      }

      
    }

    public static void runhelper(String envS, Integer multipleDate, String date){
      HellperExec hExec = new HellperExec() ;
      String datePrev = DateConvertion.SetDate(date, false);
      String dateNext =DateConvertion.SetDate(date, true);

      if(multipleDate == 2){
        hExec.Run("2000",date, envS);
        hExec.Run("2000",datePrev, envS);
        hExec.Run("2000",dateNext, envS);
      }
      else hExec.Run("2000",date, envS);      
    }
    
}






/*
 * 1 Delete rt_clearing Transaction data, Processed_fee, Processed_que_batch, Process_que_Trx, recon_result, Recons_source_que, summary(Plan with filter),
 * 2 Push Source 2000 to Source_data_que (Helper)
 * 3 Delete Source 2000 once Done
 * 4 Push Source 1
 */