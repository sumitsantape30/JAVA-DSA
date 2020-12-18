package classesAndobjects;

public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) { //this constructor takes two arguments numerator and denominator, and argument dene ke bad apne numerator anddenominator ko set karlega
		this.numerator = numerator; //we set the numerator to be numerator
		if (denominator == 0) { //agar denominator 0 hua to allow nhi karna chahiye coz something/0 valid nhi hota.
			// TODO error out
		}
		this.denominator = denominator; // we set the denominator to be denominator
		// if I am passing 20 30 numerator 20 set hua denominator 30 set hua but isko simplify karna padega.
		simplify(); //this simplify function should convert 20/30 to 2/3, jaisehi humara numerator denominator koi change krta hai  we need simplify function
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public void setNumerator(int n) {
		this.numerator = n;
		simplify(); //change hui value isliye simplify call karna padega
	}
	
	
	public void setDenominator(int d)  {
		if (d == 0){ //agar muje kisine bola ki denominator zero set karde, mai karunga nhi
			//TODO Error out
			return;
		}
		this.denominator = d;
		this.simplify(); //value change hui so simplify call karna padega.
	}
	
	public void print() {
		if (denominator == 1) { //agar denominator just 1 hai to hum bas numerator print karre
			System.out.println(numerator);
		} else { 
			System.out.println(numerator + "/" + denominator);
		}
	}
	
	private void simplify() { //hum chahte hai simplify function sirf iss class mai access ho, iske bahar nhi coz iska jis function mai numerator/denominator change hora wahipe hai.
		//we need to find what is the greatest value that divides a and b
		// gcd sabka 1 hota hi hai so start from 2
		// 2 se leke jo bhi smaller hai donomese wahatk ja rhe and as soon as we find 'i' which divides numerator and denominator, we put the gcd to be i.
		int gcd = 1;
		int smaller = Math.min(numerator, denominator);
		for (int i = 2; i <= smaller; i++) {
			if (numerator % i == 0 && denominator % i == 0) {
				gcd = i; //finally gcd ke andar woh last i hoga jisne dono ke divide kiya hoga
			}
		}
		//jo gcd aya hoga usko numerator and denominator se divide kardo, humara number simplify hojayega.
		numerator = numerator/gcd;
		denominator = denominator/gcd;
	}
	
	public static Fraction add(Fraction f1, Fraction f2) { // you are getting passed two fractions f1 and f2, and we are creating new fraction f to store the result.
		int newNum = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
		int newDen = f1.denominator * f2.denominator;
		Fraction f = new Fraction(newNum, newDen); // we are creating new denominator and new numerator and new fraction and returning that fraction f
		return f;
	}
	
	public void add(Fraction f2) { //f1.add(f2) = a1/b1 + a2/b2 = (a1*b2) + (b1*a2)/b1*b2;
		this.numerator = this.numerator * f2.denominator + this.denominator*f2.numerator;
		this.denominator = this.denominator * f2.denominator;
		simplify();
	}
	
	public void multiply(Fraction f2) {
		this.numerator = this.numerator * f2.numerator; //jiske upar call hua numerator multiplied by f2 ka numerator.
		this.denominator = this.denominator * f2.denominator; //jiske upar call hua usko denominator multiplied by f2 ka denominator
		simplify();
	}
	
}

