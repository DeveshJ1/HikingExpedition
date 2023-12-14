
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class BSTMountainAdventure {
    public static void main(String[] args) {
        if (args.length == 0 )
		{
			System.err.println("Usage Error: the program expects file name as an argument.\n");
			System.exit(1);
		}
		
		//verify that command line argument contains a name of an existing file 
		File temp = new File(args[0]); 
		if (!temp.exists())
		{
			System.err.println("Error: the file "+temp.getAbsolutePath()+" does not exist.\n");
			System.exit(1);
		}
		if (!temp.canRead())
		{
			System.err.println("Error: the file "+temp.getAbsolutePath()+
											" cannot be opened for reading.\n");
			System.exit(1);
		}
        String inputFile = args[0];
        BSTMountain mountain = new BSTMountain();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	
                String[] tokens = line.trim().split("\\s+");
                if (tokens.length >= 1) {
                    String label = tokens[0];
                    List<String> supplies = new ArrayList<>();
                    List<String> obstacles = new ArrayList<>();
                    boolean obstacleEncountered = false;
                    for (int i = 1; i < tokens.length; i++) {
                        if ((tokens[i].equalsIgnoreCase("food") || tokens[i].equalsIgnoreCase("raft") || tokens[i].equalsIgnoreCase("axe")) ) {
                        	if(!obstacleEncountered) 
                        	{
                                supplies.add(tokens[i].toLowerCase());	
                        	}
                        	continue;
                        } else if (tokens[i].equalsIgnoreCase("fallen") && i + 1 < tokens.length && tokens[i + 1].equalsIgnoreCase("tree")) {
                           obstacles.add("fallen tree");
                           obstacleEncountered=true;
                            i++;
                        } else if (tokens[i].equalsIgnoreCase("river")) {
                            obstacles.add("river");
                            obstacleEncountered=true;

                        }
                    }

                    RestStop restStop = new RestStop(label, supplies, obstacles);
                    mountain.insert(restStop);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }
        List<List<String>> paths = mountain.getSafePaths();
        for (List<String> path : paths) {
            System.out.println(String.join(" ", path));
        }
    }
}

