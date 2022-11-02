import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
	public static void main(String args[]) {
		quiz q = new quiz();
		q.logic();

}
}

class quiz{
	Scanner sc = new Scanner(System.in);
	int correctanswer = 0; 
	int wronganswer = 0; 
	public void logic() { // am creating the questions class object
		questions q1 = new questions("1.Which statement is true about Java?", "A. Java is a sequence-dependent programming language ", "B. Java is a code dependent programming language ", "C. Java is a platform-dependent programming language ", "D. Java is a platform-independent programming language ");
        questions q2 = new questions("2.What is the extension of java code files?", " A. .txt", "B. .pdf", "C. .sql", "D. .java");
        questions q3 = new questions("3.Who invented Java Programming? ", "A. Guido van Rossum", "B. James Gosling", "C. Dennis Ritchie", "D. Bjarne Stroustrup");
        questions q4 = new questions("4.Which one of the following is not a Java feature?", "A. Object-oriented", "B. Use of pointers", "C. Portable", "D. Dynamic and Extensible");
        questions q5 = new questions("5.Which of these cannot be used for a variable name in Java?", "A. identifier & keyword", "B. identifier", "C. Keyword", "D. none of the mentioned");
        
        // am using hashmap, in that we will store ques as key and ans as value
        Map<questions,Character> hmap = new HashMap<>();
        hmap.put(q1,'D');
        hmap.put(q2,'D');
        hmap.put(q3,'B');
        hmap.put(q4,'B');
        hmap.put(q5,'C');
        
        //Iterating the map
        //now we have to print these ques then their options and after that ask the user to enter the answer,
        // means which answer is to be correct one..
        for(Map.Entry<questions,Character> map:hmap.entrySet()) {
        	System.out.println(map.getKey().getQuestion());
        	System.out.println(map.getKey().getOption1());
        	System.out.println(map.getKey().getOption2());
        	System.out.println(map.getKey().getOption3());
        	System.out.println(map.getKey().getOption4());
        	
        	// we will ask the user to enter the answer
        	System.out.println("Enter Your Answer: ");
        	Character ans=sc.next().charAt(0);
        	
        	// after that we have to check the like entered ans whatever user has entered, suppose the user has 
        	//entered the answer c or d that answer and the value of the map is means here u can see the ques is q1 and 
        	// these are ans so we have to check the user ans and value of map is both  r equal or not if it is equal means 
        	// answer is crt otherwise ur wrong is wrong..
        	
        	int cans = Character.compare(ans, map.getValue());
        	if(cans == 0) {
        		System.out.println("Correct");
        		correctanswer++;
        	}else {
        		System.out.println("Wrong");
        		wronganswer++;
        	}
        	
     }
        System.out.println();
        System.out.println("-------Result--------");
        System.out.println("Total Questions :" +hmap.size());
        System.out.println("Correct Answers :" +correctanswer);
        System.out.println("Wrong Answers :" +wronganswer); 
         // calculate the percentage
        int percentage =(100*correctanswer)/hmap.size();
        System.out.println("Percentage :" +percentage);
        if(percentage > 95) {
        	System.out.println("Performance is very Good!");
        }
        else if(percentage < 35){
        	System.out.println("Performance is Very low!");
        }
        else {
        	System.out.println("Performance is Average!");
        }
	}
}
