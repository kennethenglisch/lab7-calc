

public class HexCalc extends CalcEngine{
	
	public void numberPressed(String hex) {
		switch (hex) {
		case "A":
			numberPressed(10);
			break;
		case "B":
			numberPressed(11);
			break;
		case "C":
			numberPressed(12);
			break;
		case "D":
			numberPressed(13);
			break;
		case "E":
			numberPressed(14);
			break;
		case "F":
			numberPressed(15);
			break;

		default:
			break;
		}
	}
	
	@Override
	public void numberPressed(int number) {
		if(buildingDisplayValue) {
            // Incorporate this digit.
            displayValue = displayValue + number;
        }
        else {
            // Start building a new number.
            displayValue += number;
            buildingDisplayValue = true;
        }
	}
	
	public String toHex(String numberString){
        String hexNumber = "";
        int hexDigit;
        
        int number = Integer.parseInt(numberString);

        while (number > 0) {

            hexDigit = number%16;

            switch(hexDigit){
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
                default: hexNumber = hexDigit + hexNumber;
            }

            number = (number - hexDigit) / 16;
        }
        return hexNumber;
    }
	
	
}
