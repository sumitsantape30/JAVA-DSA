package classesAndobjects;

public class Fractionuse {

	public static void main(String[] args) {
		Fraction f1 = new Fraction(20,30); //this says I want to create a fraction f1, which represents a fraction 20/30
		f1.print(); // hum simplified form mai store karre, Output: 2/3
		
		
		f1.setNumerator(12); //fraction bana diya ab uska numerator change karna hai isliye setter, humne numerator 12 set kardiya
		// 12/3= 4/1= 4 (simplified)
		
		int d = f1.getDenominator(); // denominator ki value access karne keliye, abhi denominator 1 hai
		System.out.println(d); // yaha denominator ko print karre, Output: 1
		f1.print(); // Output: 4
		
		//yaha humne firse numerator and denominator ki values set kardi
		f1.setNumerator(10); 
		f1.setDenominator(30);
		f1.print(); //Output: 10/30 = 1/3
		// yaha tak humara f1 1/3 ho chuka hai
		
		
		Fraction f2 = new Fraction(3,4);
		f1.add(f2); //mai 1/3(f1) ko bolra ki apne andar 3/4(f2) ko add krle, (Hum basically f1 ko change karre, f1= f1+ f2)
		f1.print(); //f1 = 13/12 (addition ke bad f1 update hogya but mera f2 wale rahega)
		f2.print(); //f2= 3/4, addition ke bad f2 wahi rahega, coz hum f2 ko f1 ke andar add karre the
		//'add' function f1 pe call hora means kisi object pe call hora so non static hai
		
		
		Fraction f3 = new Fraction(4,5);// humara f3= 4/5
		f3.multiply(f2); //we calling multiply on f3 and saying hey multiply yourself with f2,( f3 ke andar f2 ko multiply karre, f3 change hojayega and f2 same hi rahega)
		f3.print(); // f3 mai f2 multiply hora so f3 update hoga, Output: 4/5 * 3/4 = 12/20 = 3/5(Simplify)
		f2.print();  // f2 will stay what it was, which is 3/4
		
		
		//Variation of the add
		// f1 and f3 ko add karke f4 mai store karre and it returns a new fraction(f4), so f1 and f3 change nhi hoga but unka result(f4) will become new fraction
		// hum 'add' class(Fraction) ke upar karre call so static hai, usko do fraction dere un dono ko add krke humara f4 aajata hai
		Fraction f4 = Fraction.add(f1, f3); //f1= 13/12 and f2= 3/5
		f1.print(); //humara f1 won't change, Output: 13/12
		f3.print(); //f3 won't change, Output: 3/5
		f4.print(); // f4= 101/60
	}

}

Output:
2/3
1
4
1/3
13/12
3/4
3/5
3/4
13/12
3/5
101/60

