import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MayinTarlasi extends JFrame implements ActionListener {

	MyJButton[][] dugmeler;

	Container con;

	public MayinTarlasi() {

		con = this.getContentPane();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		con.setLayout(new GridLayout(10, 10));

		init();

	}

	private void init() {
		dugmeler = new MyJButton[10][10];

		for (int i = 0; i < 10; ++i)
			for (int j = 0; j < 10; ++j) {
				dugmeler[i][j] = new MyJButton(i, j);
				dugmeler[i][j].addActionListener(this);
				con.add(dugmeler[i][j]);
			}
		while_loop: while (!MyJButton.getSayac()) {
			for (int i = 0; i < 10; ++i)
				for (int j = 0; j < 10; ++j) {
					if (!dugmeler[i][j].isMayin())
						dugmeler[i][j].setMayin();
					if (MyJButton.getSayac())
						break while_loop;
				}

		}

		for (int i = 0; i < 10; ++i)
			for (int j = 0; j < 10; ++j) {
				if (dugmeler[i][j].isMayin()) {
					if ((i - 1) >= 0)
						dugmeler[i - 1][j].addSayi();
					if ((j - 1) >= 0)
						dugmeler[i][j - 1].addSayi();
					if ((i + 1) < 10)
						dugmeler[i + 1][j].addSayi();
					if ((j + 1) < 10)
						dugmeler[i][j + 1].addSayi();
					if (((j - 1) >= 0) && ((i - 1) >= 0))
						dugmeler[i - 1][j - 1].addSayi();
					if (((j + 1) < 10) && ((i - 1) >= 0))
						dugmeler[i - 1][j + 1].addSayi();
					if (((j + 1) < 10) && ((i + 1) < 10))
						dugmeler[i + 1][j + 1].addSayi();
					if (((j - 1) >= 0) && ((i + 1) < 10))
						dugmeler[i + 1][j - 1].addSayi();
				}
			}

	}

	public static void main(String[] args) {
		MayinTarlasi my = new MayinTarlasi();
		my.setTitle("Mayin Tarlasi....");
		my.setBounds(100, 100, 500, 500);
		my.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyJButton myjb = (MyJButton) (e.getSource());
		if (myjb.isMayin()) {
			for (int i = 0; i < 10; ++i)
				for (int j = 0; j < 10; ++j) {
					dugmeler[i][j].goster();

				}

		} else {
			myjb.goster();
			if (myjb.getSayi() == 0)
				bosAlan(myjb.getMyX(), myjb.getMyY());

		}
		myjb.disable();

	}

	private void bosAlan(int i, int j) {

		// dugmeler[i][j].goster();

		if (dugmeler[i][j].getSayi() == 0) {
			if ((i - 1) >= 0) {
				if (!dugmeler[i - 1][j].isGorunur())
					if (dugmeler[i - 1][j].getSayi() >= 0) {
						dugmeler[i - 1][j].goster();
						bosAlan(i - 1, j);
					}
			}
			if ((j - 1) >= 0)
				if (!dugmeler[i][j - 1].isGorunur())
					if (dugmeler[i][j - 1].getSayi() >= 0) {
						dugmeler[i][j - 1].goster();
						bosAlan(i, j - 1);
					}
			if ((i + 1) < 10)
				if (!dugmeler[i + 1][j].isGorunur())
					if (dugmeler[i + 1][j].getSayi() >= 0) {
						dugmeler[i + 1][j].goster();
						bosAlan(i + 1, j);
					}
			if ((j + 1) < 10)
				if (!dugmeler[i][j + 1].isGorunur())
					if (dugmeler[i][j + 1].getSayi() >= 0) {
						dugmeler[i][j + 1].goster();
						bosAlan(i, j + 1);
					}
			if (((j - 1) >= 0) && ((i - 1) >= 0))
				if (dugmeler[i - 1][j - 1].isGorunur())
					return;
				else if (dugmeler[i - 1][j - 1].getSayi() >= 0) {
					dugmeler[i - 1][j - 1].goster();
					bosAlan(i - 1, j - 1);
				}
			if (((j + 1) < 10) && ((i - 1) >= 0))
				if (!dugmeler[i - 1][j + 1].isGorunur())
					if (dugmeler[i - 1][j + 1].getSayi() >= 0) {
						dugmeler[i - 1][j + 1].goster();
						bosAlan(i - 1, j + 1);
					}
			if (((j + 1) < 10) && ((i + 1) < 10))
				if (!dugmeler[i + 1][j + 1].isGorunur())
					if (dugmeler[i + 1][j + 1].getSayi() >= 0) {
						dugmeler[i + 1][j + 1].goster();
						bosAlan(i + 1, j + 1);
					}
			if (((j - 1) >= 0) && ((i + 1) < 10))
				if (!dugmeler[i + 1][j - 1].isGorunur())
					if (dugmeler[i + 1][j - 1].getSayi() >= 0) {
						dugmeler[i + 1][j - 1].goster();
						bosAlan(i + 1, j - 1);
					}
		}

	}
}
