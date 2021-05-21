package q20;

import java.util.HashMap;
import java.util.Map;

public class DataBase {

	public static void main(String[] args) {
		
		Map<String, Double> m = new HashMap<String, Double>();
		m.put("1234#1", 1000.70);
		m.put("553742#3", 10000.50);
		m.put("12#2", 1300.10);
		m.put("4343#1", 1000.80);
		double med = calculaMedia(m, 1); //essa chamada deve calcular a m�dia dos sal�rios dos funcion�rios com c�digo do cargo = 1.
        System.out.println(med);
	}

	public static double calculaMedia(Map<String, Double> g, int cargo) {

		int divisor = 0;
		double mediaTotal = 0;
		
		for(Map.Entry<String, Double> e : g.entrySet()) {
			String key = e.getKey();
			String [] func = key.split("#");
			int c = Integer.parseInt(func[1]);
			
			if(c == cargo) {
				divisor++;
				mediaTotal += e.getValue();
			}
		}
		return mediaTotal/divisor;
	}

}
