package ClusterManager;

public class Docker {

    static String executeCommand;

    public static void startContainer(Container container) {
        // Execute Start Container command on server
        
        executeCommand = "docker start " + container.getContainerID();
        System.out.println(executeCommand);
    }

    public static void stopContainer(Container container) {
        // Execute Stop Container command on server
            
        executeCommand = "docker stop " + container.getContainerID();
    }
}
