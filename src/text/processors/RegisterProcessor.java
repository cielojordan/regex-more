package text.processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import text.ProcessorIF;
import text.annotations.TextProcessor;

@TextProcessor(pattern="register|reg\\s+(.+)")
public class RegisterProcessor implements ProcessorIF{

	@Override
	public String process(String s) {
		
		// REGISTER <NAME>
		
		// HELLO <NAME>
		Pattern p = Pattern.compile("register|reg\\s+(.+)");
		Matcher m = p.matcher(s);
		
		if (m.find())
		{
			return "Hello "+m.group(1)+"!";
		}
		
		return null;
	}
	

}
