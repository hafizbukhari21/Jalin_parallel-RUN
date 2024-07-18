package Services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;



import ObjectMapper.WorkflowMapper;
import util.PropertiesUtil;

public class ConstructJSON_Workflow {
    private final String filename  = "workflowMapper.json";
    private static Properties workflowProp = PropertiesUtil.getInstance().getworkflowProp();
    public WorkflowMapper workflowMapper = new WorkflowMapper();

    
    public WorkflowMapper extractJsonWokrflow(){

        try {

            String content = new String(Files.readAllBytes(Paths.get(workflowProp.getProperty("PATH_WORKFLOW")+ filename )));
            //JSONArray envs = jsonObject.getJSONArray("env");

            //envs.forEach(env-> System.out.println(env));

        
            
        } catch (Exception ex){

        } 

        return null;
    }
    


}
