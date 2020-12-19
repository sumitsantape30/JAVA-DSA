package ExceptionHandling;

public class FractionUse {

	// java ke andar ek rule hai, "ya to catch karlo, exception ko aage mat jane do, ya fir mention karo apne signature mai ki hum excepiton throw kar rhe h that's what we call catch or specifier."
	//agar exception throw karna hai to write "throws ZeroDenominatorException', aur agar handle karna hai to try..catch
	// agar try catch nhi krte ho to specify karna padega ki tum throw krte ho exception
	public static void temp() {
		Fraction f1 = new Fraction(20,30);
		f1.print();
		// 2/3
		
		f1.setNumerator(12);
		// 4/1
		int d = f1.getDenominator();
		System.out.println(d);
		f1.print();
		
		f1.setNumerator(10);

		
		int i = 47;
		//to handle exceptions: you try and run some code and usse kuch exception aayi to tum us exception ko catch karlena
		try { //maine try kiya set karne ki agar hogya thik to hogya nhito hum niche agye catch mai
			//i++; = agar yeh kiya to humara i badh jayega aur 48 print karega
			f1.setDenominator(0);// jaisehi jis line pe bhi exception aati hai uske bad ka kuch run nhi hoga so i++ run nhi hoga its going to print 10.
			i++;// this is executed only in case of no exception
			
			//agar exception nhi aayi to sirf try wala code run hoga catch wala nhi hoga
		} catch(ZeroDenominatorException e) { //agar ZeroDenominatorException error ajaye to usse yaha catch karlo
			System.out.println("Hey dont input 0 as denominator");// this is executed only if there's exception
		} finally { //finslly means yaha to ayega hi ayega
			
		}
		System.out.println(i); //Output: 10 coz jis line pe bhi exception aatihai uske bad kuch nhi hoga sidha 'i' print karega.
		
		
		
		
		// 1/3
		f1.print();
//		
		Fraction f2 = new Fraction(3,4);
		f1.add(f2);
		f1.print();
		// f1 => 13/12
		f2.print();
		// f2 => 3/4
//		
		Fraction f3 = new Fraction(4,5);
		f3.multiply(f2);
		f3.print();
		// f3 => 3/5
		f2.print();
		// f2 => 3/4
//		
		Fraction f4 = Fraction.add(f1, f3);
		f1.print();
		f3.print();
		f4.print();
	}
	
	public static void main(String[] args) throws ZeroDenominatorException{
		temp();
		
		//maine bas ek file banayi now this file is going to give us an exception
//		String s = "";
//		File f;
//		try { 
//			f = new File(s);
//			// read file
//		} catch (FileNotFoundException exception) {
//	
//		} finally {
//			f.close(); //try and catch mai jo bhi common code hoga woh finally mai move kar denge.
//		}
		
		
		
	}

}
