package test.thiagodnf.tds.search;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.beforeEach;

import java.util.List;

import org.junit.runner.RunWith;

import com.mscharhag.oleaster.runner.OleasterRunner;

import thiagodnf.tds.search.SubformulasSearch;
import thiagodnf.tds.tree.Tree;
import thiagodnf.tds.tree.rdt.RecursiveDescentTree;

@RunWith(OleasterRunner.class)
@SuppressWarnings({ "rawtypes", "unchecked" })
public class TestSubformulasSearch {{
	
	Tree tree = new RecursiveDescentTree();
	
	String[][] suites = new String[][] {
		{"[->,[V,p,[-,p]],[&,r,q]]", "[p, -p, (p V -p), r, q, (r & q), ((p V -p) -> (r & q))]"},
		{"[-,[&,[V,[-,A4],A1],A3]]", "[A4, -A4, A1, (-A4 V A1), A3, ((-A4 V A1) & A3), -((-A4 V A1) & A3)]"}
	};
	
	beforeEach(() -> {
		tree.setRoot(null);
	});
	
	for (int i = 0; i < suites.length; i++) {
		
		String input = suites[i][0];
		String expected = suites[i][1];
		
			describe("When the input is " + input, () -> {
			
			it("should return " + expected, () -> {
				
				tree.add(input);
				
				List<String> output = new SubformulasSearch().execute(tree);
				
				expect(output.toString()).toEqual(expected);
			});
		});
	}
}}
