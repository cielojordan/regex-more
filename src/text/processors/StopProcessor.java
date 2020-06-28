package text.processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import text.ProcessorIF;
import text.annotations.TextProcessor;

@TextProcessor(pattern="stop")
public class StopProcessor implements ProcessorIF{

	@Override
	public String process(String s) {
		
		
		return "Goodbye";
	}
	

}
