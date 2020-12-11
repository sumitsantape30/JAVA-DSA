package lec6;

public class ScopeOfVariables {

	public static void main(String[] args) {

=======================================================
		int i = 10;
		System.out.println(i);
		if (i == 10) {
			int n = 23;
			System.out.println(n);
		}
		System.out.println(n);// yaha error ayega coz 'int n' bracket ke andar initialise hua hai to uska scopre sirf bracket mai hi rahega bracket ke bahar access nhi kr skte.
=====================================================

	}
}
