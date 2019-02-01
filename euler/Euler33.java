package euler;

public class Euler33 {
	
	public static void main(String[] args) {
		
		
		for (int d = 11; d <= 99; d++) {
			for (int n = 10; n <= d - 1; n++) {
				
				int amateurn = n, amateurd = d;
				
				if (amateurn / 10 == amateurd / 10) {
					amateurn %= 10;
					amateurd %= 10;
				} else if (amateurn / 10 == amateurd % 10) {
					amateurn %= 10;
					amateurd /= 10;
				}
				
				if (amateurn == 0)
					amateurn = 1;
				if (amateurd == 0)
					amateurd = 1;
					
				if (amateurn % 10 == amateurd / 10) {
					amateurn /= 10;
					amateurd %= 10;
				} else if (amateurn % 10 == amateurd % 10) {
					amateurn /= 10;
					amateurd /= 10;
				}
				
				if (amateurn == 0)
					amateurn = 1;
				if (amateurd == 0)
					amateurd = 1;
				
				if ( (n != amateurn || d != amateurd)
						&& (n % 10 != 0 && n % 10 != 0)   ) {
				
					if ((d * amateurn) == (n * amateurd)) {
						System.out.println(amateurn + " / " + amateurd + " == " + n + " / " + d);
					}
				
				}
				
				
			}
		}
		
		
	}
	
}

