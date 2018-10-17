package blitz_2019;

import java.util.ArrayList;

public class trajet {
	public static char[] direction = { 'r', 'l', 'u', 'd' };

//int[col, row]
	public static String traject(int[] start, int[] end, String chemin) {
		char[] c = chemin.toCharArray();
		String out = "";
		int[] t = start;
		for (int i = 0; i < c.length; i++) {
			if (c[i] != '?') {
				out += c[i];
				t = deplacement(t, c[i]);
			} else {
				for (int j = 0; j < 4; j++) {
					c[i] = direction[j];
					String temp = new String(c);
					String essai = traject(start, end, temp);

					if (bonChemin(start, end, essai))
						return essai;
				}
			}

		}

		return out;

	}

	public static boolean bonChemin(int[] start, int[] end, String chemin) {
		char[] c = chemin.toCharArray();
		int[] temp = start;
		for (int i = 0; i < c.length; i++) {
			temp = deplacement(temp, c[i]);
			if(0>temp[0]&&temp[0]>4&&0>temp[1]&&temp[1]>4)
				return false;
		}
		boolean out = false;
		if (temp[0] == end[0] && temp[1] == end[1])
			out = true;
		return out;
	}

	public static int[] deplacement(int[] place, char mouvement) {
		int[] out = place.clone();

		if (mouvement == 'r') {
			out[0] += 1;
		} else if (mouvement == 'l') {
			out[0] -= 1;
		} else if (mouvement == 'u') {
			out[1] -= 1;
		} else if (mouvement == 'd') {
			out[1] += 1;
		}

		return out;

	}

	public static void main(String[] args) {
		int[] start = { 0, 0 };
		int[] end = { 4, 4 };
//reponse rrrddd
		String p = traject(start, end, "r?d?drdd");
		System.out.println(p);

		int[] start2 = { 1, 3 };
		int[] end2 = { 1, 1 };
		String p2 = traject(start2, end2, "ru??ur");
		System.out.println(p2);
	}
}
