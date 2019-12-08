
public class HexCalc extends CalcEngine {

	private String hexDisplayValue = "";

	public void numberPressed(String hex) throws StackUnderflow, IncorrectString {
		switch (hex) {
		case "A":
			super.numberPressed(1);
			super.numberPressed(0);
			break;
		case "B":
			super.numberPressed(1);
			numberPressed(1);
			break;
		case "C":
			super.numberPressed(1);
			super.numberPressed(2);
			break;
		case "D":
			super.numberPressed(1);
			super.numberPressed(3);
			break;
		case "E":
			super.numberPressed(1);
			super.numberPressed(4);
			break;
		case "F":
			super.numberPressed(1);
			super.numberPressed(5);
			break;
		default:
			throw new IllegalArgumentException(hex + "is not a valid hex character");
		}
		hexDisplayValue += hex;
	}
	

	public String getHexDisplayValue() {
		return hexDisplayValue;
	}

	@Override
	public void applyOperator(Character c) {
		hexDisplayValue += c;
		super.applyOperator(c);
	}


	@Override
	public void numberPressed(int number) throws StackUnderflow, IncorrectString {
		hexDisplayValue += number;
		super.numberPressed(number);
	}
	
	@Override
	public void equals() throws IncorrectString, StackUnderflow {
		super.equals();
		hexDisplayValue = Integer.toHexString(Integer.parseInt(this.getDisplayValue())).toUpperCase();
	}
	
	
	@Override
	public void clear() {
		super.clear();
		hexDisplayValue="";
	}
	
	
	public String toHex(String numberString) {
		String hexNumber = "";
		int hexDigit;

		int number = Integer.parseInt(numberString);

		while (number > 0) {

			hexDigit = number % 16;

			switch (hexDigit) {
			case 15:
				hexNumber = "F" + hexNumber;
				break;
			case 14:
				hexNumber = "E" + hexNumber;
				break;
			case 13:
				hexNumber = "D" + hexNumber;
				break;
			case 12:
				hexNumber = "C" + hexNumber;
				break;
			case 11:
				hexNumber = "B" + hexNumber;
				break;
			case 10:
				hexNumber = "A" + hexNumber;
				break;
			default:
				hexNumber = hexDigit + hexNumber;
			}

			number = (number - hexDigit) / 16;
		}
		return hexNumber;
	}

}
