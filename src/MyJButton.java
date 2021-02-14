import java.awt.Color;

import javax.swing.JButton;

public class MyJButton extends JButton {

	private static int sayac = 20;
	private boolean mayin = false, gorunur = false;
	private int sayi = 0;
	private int x, y;

	public MyJButton(int i, int j) {
		x = i;
		y = j;

	}

	public void setMayin() {
		if (sayac > 0) {
			switch ((int) (Math.random() * 10)) {
			case 0:
				mayin = false;
				break;
			case 1:
				mayin = true;
				--sayac;
				sayi = -1;
				System.out.println(x + " " + y + " " + sayac);
				break;
			}
		}
	}

	public boolean isMayin() {
		// TODO Auto-generated method stub
		return mayin;
	}

	public static boolean getSayac() {
		if (sayac == 0)
			return true;
		else
			return false;
	}

	public int getSayi() {

		return sayi;
	}

	public void addSayi() {
		++sayi;
	}

	public void goster() {
		if (isMayin()) {
			setBackground(Color.RED);
			setText("M");
			this.disable();
		} else {
			setBackground(Color.WHITE);
			setText(getString());
			this.disable();
		}
		gorunur = true;
	}

	private String getString() {
		if (sayi == 0)
			return "";
		return Integer.toString(sayi) + "";
	}

	public int getMyX() {

		return x;
	}

	public int getMyY() {

		return y;
	}

	public boolean isGorunur() {

		return gorunur;
	}
}
