
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import thiagodnf.tds.runner.BSTRunner;
import thiagodnf.tds.runner.LPTRunner;
import thiagodnf.tds.runner.PTRunner;

public class MainClass {
	
	@Parameter(names = { "-t", "--type" }, description = "The type of the tree. The options are [BST | PT | LPT]")
	private String type = "BST";

	@Parameter(names = { "-i", "--input" }, description = "The input", required = true)
	private String input;

	@Parameter(names = { "-g", "--gui" }, description = "Show the tree visualization")
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
		} else if (type.equalsIgnoreCase("PT")) {
			new PTRunner().run(input, gui);
		} else if (type.equalsIgnoreCase("LPT")) {
			new LPTRunner().run(input, gui);
		} else {
			throw new IllegalArgumentException("The tree type is not valid");
		}
	}
}
