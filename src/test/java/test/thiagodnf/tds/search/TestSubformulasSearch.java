package test.thiagodnf.tds.search;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.beforeEach;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

import java.util.List;

import org.junit.runner.RunWith;

import com.mscharhag.oleaster.runner.OleasterRunner;

import thiagodnf.tds.search.SubformulasSearch;
import thiagodnf.tds.tree.LogicalParseTree;
import thiagodnf.tds.tree.Tree;

@RunWith(OleasterRunner.class)
@SuppressWarnings({ "rawtypes", "unchecked" })
public class TestSubformulasSearch {{
	
	Tree tree = new LogicalParseTree();
	
	String[][] suites = new String[][] {
		{"(a -> b)", "[a, b, (a \u2192 b)]"},
		{"(p V ~q) -> (r & q)", "[p, q, ¬q, (p ∨ ¬q), r, (r ∧ q), ((p ∨ ¬q) → (r ∧ q))]"},
		{"(p -> (q V r)) -> (p & ~p)", "[p, q, r, (q ∨ r), (p → (q ∨ r)), ¬p, (p ∧ ¬p), ((p → (q ∨ r)) → (p ∧ ¬p))]"}
	};
	
	beforeEach(() -> {
		tree.setRoot(null);
	});
	
	for (int i = 0; i < suites.length; i++) {
		
		String input = suites[i][0];
		String expected = suites[i][1];
		
			describe("When the input is " + input, () -> {
			
			it("should return " + expected, () -> {
				
				List<String> inputs = tree.parseInput(input);
				
				tree.add(inputs);
				
				List<String> output = new SubformulasSearch().execute(tree);
				
				expect(output.toString()).toEqual(expected);
			});
		});
	}
}}
