package ObjectMapper;

import java.util.List;

public class WorkflowMapper {
    public List<Env> env;


    public static class Env{
        public String env_name;
        public Integer id;
        public List<Workflow_list> workflow;

        public static class Workflow_list{
            public String workflow_Name;
            public String workflow_id;
            public String workflow_instance;
        }
    }
}


