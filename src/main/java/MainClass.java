import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import thiagodnf.tds.runner.BSTRunner;
import thiagodnf.tds.runner.RDTRunner;

public class MainClass {
	
	@Parameter(names = { "-t", "--type" }, description = "The type of the tree. The options are [BST | RDT]")
	private String type = "BST";

	@Parameter(names = { "-i", "--input" }, description = "The input", required = true)
	private String input;

	@Parameter(names = "-gui", description = "Show the visualization")
	private boolean gui = false;

	@Parameter(names = { "-h", "--help" }, help = true)
	private boolean help;
	
	public static void main(String[] args) {
		
		MainClass main = new MainClass();
       
		JCommander jc = JCommander.newBuilder()
            .addObject(main)
            .programName(MainClass.class.getSimpleName())
            .build();
		
		jc.parse(args);

		if (main.help) {
			jc.usage();
		} else {
			main.run();
		}
	}
	
	public void run() {
		if (type.equalsIgnoreCase("BST")) {
			new BSTRunner().run(input, gui);
		} else if (type.equalsIgnoreCase("RDT")) {
			new RDTRunner().run(input, gui);
		} else {
			throw new IllegalArgumentException("The type of three is not valid");
		}
	}
}
