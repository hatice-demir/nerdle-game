package nerdle;

//import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;

import static java.util.Arrays.fill;

public class Functions {
	private String chosenEq;
	public Functions() {
		// TODO Auto-generated constructor stub
	}

	//generate random values from 0-(upperbound-1)
	public static int randomElement(int upperbound) {
		Random rand = new Random(); //instance of random class
		return rand.nextInt(upperbound);
	}

	//checks similarity between input and chosen equation
	//returns an int array. //0-black(no match) //1-yellow(match but not correct place //2-green(full match)
	public int[] check(String input, String eq){
		int[] colors = new int[input.length()];

		if(eq.equals(input)) {			//if input and chosen eq is same then fill the array with green and return
			fill(colors, 2);
			return colors;
		}

		// checking for every element of input
		for (int i=0; i< input.length(); i++ ) {
			if(eq.indexOf(input.charAt(i)) == i){		//if there is match, and they are in same index
				colors[i] = 2;							//then color is green(2)
				eq = eq.substring(0, eq.indexOf(input.charAt(i))) + "$" + eq.substring(eq.indexOf(input.charAt(i)) + 1); //remove matched index to prevent more matches
				continue;
			}

			if(eq.indexOf(input.charAt(i)) == -1) {		//if there is no match
				colors[i] = 0;							//then color is black(0)
				//eq = eq.substring(0, eq.indexOf(input.charAt(i))) + "$" + eq.substring(eq.indexOf(input.charAt(i)) + 1);
				continue;
			}
			else {		//if nth happened then it means it should be yellow
				colors[i] = 1;
				eq = eq.substring(0, eq.indexOf(input.charAt(i))) + "$" + eq.substring(eq.indexOf(input.charAt(i)) + 1);
			}
		}

		return colors;
	}

	//method that checks whether given equation is valid or not
	public static boolean isValidEq(String eq){
		String[] t = eq.split("(?=[-+*/()=])|(?<=[^-+/=][-+*/=])|(?<=[()])");		//splitting equation into an array
		//System.out.println(Arrays.toString(t));
		String operators= "+-*/";

		if(eq.contains(" "))		//if any character of input string is not filled then return false
			return false;

		if(t.length != 5 && t.length != 7)		//if split eq does not contain 3 nums and 2 ops (length=5) or 4 nums and 3 ops(length=7)
			return false;						//then return false

		if(t.length == 5){		//if 1 operator

			//if(second element is not an operator OR fourth is not '=')
			//then input is invalid
			if(!operators.contains(t[1]) || !t[3].equals("="))
				return false;

			//if any of numbers is an operator
			//then input is invalid
			operators = operators.concat("=");
			if(operators.contains(t[0]) || operators.contains(t[2]) || operators.contains(t[4]))
				return false;


			//if given result is not correct, then input is invalid
			if(applyOp(t[1].charAt(0), Integer.parseInt(t[0]), Integer.parseInt(t[2])) != Integer.parseInt(t[4]))
				return false;

		}

		if(t.length == 7){		//same as above with 2 operators

			//if(second and fourth element is not an operator OR sixth is not '=')
			//then input is invalid
			if(!operators.contains(t[1]) || !operators.contains(t[3]) || !t[5].equals("="))
				return false;


			//if any of numbers is an operator
			//then input is invalid
			operators = operators.concat("=");
			if(operators.contains(t[0]) || operators.contains(t[2]) || operators.contains(t[4]) || operators.contains(t[6]))
				return false;



			//if given result is not correct, then input is invalid
			if(applyOp(t[3].charAt(0), applyOp(t[1].charAt(0), Integer.parseInt(t[0]),
					Integer.parseInt(t[2])), Integer.parseInt(t[4])) != Integer.parseInt(t[6]))
				return false;

		}
		return true;
	}

	//method that returns proper equation for the game
	public String generateEquation(){
		String eq = "";
		int n1,n2,n3,result,nod1,nod2,nod3,nodr,numOfOp;
		char[] operators = {'+', '-', '*', '/'};
		boolean isOk = false;

		numOfOp = randomElement(2) + 1; //random choose for number of operations

		//while loop that works till it generates a proper equation
		while(!isOk){

			if(numOfOp == 1){		//1 operation
				//random choose of operator and numbers and lengths of chosen numbers
				char op = operators[randomElement(4)];
				n1 = randomElement(1000);
				nod1 = String.valueOf(n1).length();
				n2 = randomElement(1000);
				nod2 = String.valueOf(n2).length();

				if(op == '/'){		//if chosen operation is division
					while(n2 == 0){			//changing n2 till it is not zero
						n2 = randomElement(1000);
						nod2 = String.valueOf(n2).length();
					}
					n1 = lcm(n1,n2);		//changing n1 as least common multiplier of n1 and n2 to make them dividable
					nod1 = String.valueOf(n1).length();
				}

				result = applyOp(op, n1, n2);		//applying operation
				nodr = String.valueOf(result).length();

				if(result < 0)		//if result is negative then generate new equation
					continue;

				if (nod1 + nod2 + nodr + 2 < 5)		//if total length is less than 4
					continue;						//then adding zeros to in front of numbers is not enough to make eq OK

				if(nod1 + nod2 + nodr + 2 == 5) {        //if total length is 5 then add zeros to in front of numbers
					if (n1 == 0 || n2 == 0)						//if one of chosen numbers is 0 then generate new equation
						continue;								//to prevent them to be 00
					eq = "0" + n1 + op + "0" + n2 + "=" + result;
				}

				if(nod1 + nod2 + nodr + 2 == 6) {        //if total length is 6 then add only one zero to number which has fewer digits
					if (n1 == 0 || n2 == 0)							//if one of chosen numbers is 0 then generate new equation
						continue;									//to prevent them to be 00
					if (nod1 < nod2)
						eq = "" + n2 + op + "0" + n1 + "=" + result;
					else
						eq = "" + n1 + op + "0" + n2 + "=" + result;
				}

				if(nod1 + nod2 + nodr + 2 > 9)		//if total length is greater than 9 then generate new equation
					continue;

				if(eq.isEmpty())		//if nth happened then equation with 1 operator is ready to go
					eq = "" + n1 + op + n2 + "=" + result;

				isOk = true;		//for breaking loop
			}

			else{		//same as above but with 2 operations
				char op1 = operators[randomElement(4)];
				char op2 = operators[randomElement(4)];
				n1 = randomElement(1000);
				nod1 = String.valueOf(n1).length();
				n2 = randomElement(1000);
				nod2 = String.valueOf(n2).length();
				n3 = randomElement(1000);
				nod3 = String.valueOf(n3).length();

				if(op2 == '/'){
					while(n3 == 0){
						n3 = randomElement(1000);
						nod3 = String.valueOf(n3).length();
					}
					n2 = lcm(n2,n3);
					nod2 = String.valueOf(n2).length();
				}

				if(op1 == '/'){
					while(n2 == 0){
						n2 = randomElement(1000);
						nod2 = String.valueOf(n2).length();
					}
					n1 = lcm(n1,n2);
					nod1 = String.valueOf(n1).length();
				}



				result = applyOp(op2, applyOp(op1, n1, n2), n3);
				nodr = String.valueOf(result).length();

				if(result < 0)
					continue;

				if(nod1 + nod2 + nod3 + nodr + 3 > 9)
					continue;

				eq = "" + n1 + op1 + n2 + op2 + n3 + "=" + result;
				isOk = true;
			}
		}
		return eq;
	}

    // method that applies given operation between given numbers and returns result
    public static int applyOp(char op, int a, int b) {
        switch (op) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }

	//method that returns the least common multiplier of given numbers
	public static int lcm(int number1, int number2) {
		if (number1 == 0 || number2 == 0) {
			return 0;
		}
		int absNumber1 = Math.abs(number1);
		int absNumber2 = Math.abs(number2);
		int absHigherNumber = Math.max(absNumber1, absNumber2);
		int absLowerNumber = Math.min(absNumber1, absNumber2);
		int lcm = absHigherNumber;
		while (lcm % absLowerNumber != 0) {
			lcm += absHigherNumber;
		}
		return lcm;
	}

	public String getChosenEq() {
		return chosenEq;
	}

	public void setChosenEq(String chosenEq) {
		this.chosenEq = chosenEq;
	}
}

