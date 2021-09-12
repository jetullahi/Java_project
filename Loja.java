
public class Loja {

	public Loja(Tabela board, Lojtari player, Pengesa barrier, Pamja display) {
		display.update(board);
	}

	public void checkPlayer(Lojtari player, Tabela board, Pamja display) { 
		boolean continuee = true;
		do {
			Pozita newPosition = display.readPlayerPosition(player);
			if (board.isValidPosition(newPosition)) {
				board.updatePlayerPosition(player, newPosition);
				display.update(board);
				System.out.printf("Lojtari u vendos ne poziten %dx%d", display.getxPosition(), display.getyPosition());
				System.out.println();
				continuee = false;
			} else {
				display.showMessage("Pozite jo valide!!!");
				continuee = true;
			}

		} while (continuee);

	}

	public void checkBarrier(Pengesa barrier, Tabela board, Pamja display) { 
		boolean continuee = true;
		do {
			Pozita barrierPosition = display.putBarrierInABox(barrier);
			if (board.isValidPosition(barrierPosition)) {
				board.BarrierPosition(barrier, barrierPosition);
				display.update(board);
				System.out.printf("Pengesa u vendos ne poziten %dx%d", display.getxPosition(), display.getyPosition());
				System.out.println();
				continuee = false;
			} else {
				display.showMessage("Pozite jo valide!!!");
				continuee = true;
			}
		} while (continuee);
	}

	public void play(Lojtari player, Pengesa barrier, Tabela board, Pamja display) {
		checkPlayer(player, board, display);
		checkBarrier(barrier, board, display);

		display.movePlayer(player, board.getCurrentPlayerPosition(), board);

	}

	public static void main(String[] args) {

	 	System.out.println(
				"Se pari incializoni tabelen me pas pozicioni lojtarin dhe pengesen!\n");

		Pamja display = new Pamja("Move player");
		Tabela board = display.initializeBoard();
		Pengesa barrier = new Pengesa("O");
		Lojtari player = new Lojtari("X"); 

		Loja game = new Loja(board, player, barrier, display);
		game.play(player, barrier, board, display);

	}

}



