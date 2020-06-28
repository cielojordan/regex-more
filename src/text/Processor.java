package text;

import java.util.HashMap;
import java.util.List;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import text.annotations.TextProcessor;


public class Processor 
{
	private HashMap<String, ProcessorIF> map = new HashMap<String, ProcessorIF>();
	
	public Processor() throws Exception
	{
		// scan for @TextProcessor annotations
		// store them in a map
		ScanResult results = new FastClasspathScanner("text.processors").scan();		
		List<String> allResults = results.getNamesOfClassesWithAnnotation(TextProcessor.class);
		System.out.println(allResults);
		for (String s : allResults)
		{
			Class c = Class.forName(s);
			TextProcessor tp = (TextProcessor) c.getAnnotation(TextProcessor.class);				
							
			map.put(tp.pattern(), (ProcessorIF) c.newInstance());
		}
	}
	
	public void process(String s)
	{
		// find pattern that matches s
		// find the processor thats meant to handle it
		// do it
		
		for (String pattern : map.keySet())
		{
			if (s.matches(pattern))
			{
				ProcessorIF pif = map.get(pattern);
				String reply = pif.process(s);
				System.out.println(reply);
				return;
			}
		}
		
		System.out.println("No matches");
	}
}
