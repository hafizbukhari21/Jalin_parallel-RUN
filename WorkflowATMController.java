import java.util.Properties;

import Services.WorkflowServices;
import util.PropertiesUtil;

public class WorkflowATMController {
    private static Properties workflowProp = PropertiesUtil.getInstance().getworkflowProp();
    public static void main(String[] args ){
        
        /*
         * EOD
         * Invoice
         * Recon
         * ATU_unmask
         * BRI_Outbound
         * 
         * env =args[0] 1 VIT | 2 Staging
         * workflow_instance ID  = args[1]
         * process_id = args[2]
         */
        Integer env = Integer.parseInt(args[0]);
        String worfklow_instance = args[1];
        Integer process_id = Integer.parseInt(args[2]);

        String workflowId= "";

        switch (process_id) {
            case 8:
                //Run ATM Controller
                workflowId = workflowProp.getProperty("workflow_id_atmController");;
                WorkflowServices.GenerateReport(worfklow_instance, env, workflowId);
                break;
            case 9:
                
                //Run EJ    
                break;
            case 10:
                //Run Mandiri Specifict
                break;
        
            default:
                break;
        }
        
    }
}
