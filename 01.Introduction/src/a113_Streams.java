import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class a113_Streams {

	public static void main(String[] args) {

		a113_Streams a = new a113_Streams();
		a.StreamCollect();
	}

	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abdelrahman");
		names.add("Mohab");
		names.add("Adham");
		names.add("Mahmoud");
		names.add("Ahmed");

		long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);
		names.stream().filter(s -> s.length() < 6).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() < 6).limit(2).forEach(s -> System.out.println(s));

		long d = Stream.of("Abdelrahman", "Mohab", "Adham", "Mahmoud", "Ahmed").filter(s -> s.startsWith("A")).count();
		System.out.println(d);

	}

	public void streamMap() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abdo");
		names.add("Hoba");
		names.add("Doma");

		Stream.of("Abdelrahman", "Mohab", "Adham", "Mahmoud", "Ahmed").filter(s -> s.endsWith("d"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		
		System.out.println();
		
		List <String> names1 = Arrays.asList("Abdelrahman", "Mohab", "Adham", "Mahmoud", "Ahmed");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		
		System.out.println();
		
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s -> System.out.println(s));

		
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Amr"));
		System.out.println(flag);
	}
	
	public void StreamCollect() {
		List<String> ls = Stream.of("Abdelrahman", "Mohab", "Adham", "Mahmoud", "Ahmed").filter(s -> s.endsWith("d"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		values.stream().distinct().forEach(s -> System.out.println(s));  // removes duplicates
		System.out.println();
		List<Integer> li  = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}

}
