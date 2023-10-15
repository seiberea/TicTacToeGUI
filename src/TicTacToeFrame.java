import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame
{
    private JPanel mainPanel, titlePanel, infoPanel, playerOnePanel, gamePanel, playerTwoPanel, buttonPanel;
    private JLabel titleLabel, playerOneLabel, playerTwoLabel;
    private JTextPane playerOneText, playerTwoText;
    private StyledDocument textPaneDoc;
    private JButton oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton;
    private JButton newGameButton, quitButton;
    private static JButton[][] buttonGrid;
    private JOptionPane winOption, tieOption, errorOption;
    private ActionListener move = new moveListener();
    private ActionListener quit = new quitListener();
    private ActionListener newGame = new newGameListener();
    private static int ROW = 3;
    private static int COL = 3;
    public String player = "X";
    public String nextPlayer = "X";
    private static String board[][] = new String[ROW][COL];

    TicTacToeFrame()
    {
        setTitle("Tic Tac Toe");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        titlePanel = new JPanel();
        infoPanel = new JPanel();
        playerOnePanel = new JPanel();
        gamePanel = new JPanel();
        playerTwoPanel = new JPanel();
        buttonPanel = new JPanel();

        titleLabel = new JLabel("Tic Tac Toe");
        playerOneLabel = new JLabel("Player 1");
        playerTwoLabel = new JLabel("Player 2");

        SimpleAttributeSet center = new SimpleAttributeSet();

        playerOneText = new JTextPane();
        playerOneText.setEditable(false);
        textPaneDoc = playerOneText.getStyledDocument();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        textPaneDoc.setParagraphAttributes(0, textPaneDoc.getLength(), center, false);

        playerTwoText = new JTextPane();
        playerTwoText.setEditable(false);
        textPaneDoc = playerTwoText.getStyledDocument();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        textPaneDoc.setParagraphAttributes(0, textPaneDoc.getLength(), center, false);

        oneButton = new JButton("_");
        twoButton = new JButton("_");
        threeButton = new JButton("_");
        fourButton = new JButton("_");
        fiveButton = new JButton("_");
        sixButton = new JButton("_");
        sevenButton = new JButton("_");
        eightButton = new JButton("_");
        nineButton = new JButton("_");
        newGameButton = new JButton("New Game");
        buttonGrid = new JButton[ROW][COL];
        buttonGrid[0][0] = oneButton;
        buttonGrid[0][1] = twoButton;
        buttonGrid[0][2] = threeButton;
        buttonGrid[1][0] = fourButton;
        buttonGrid[1][1] = fiveButton;
        buttonGrid[1][2] = sixButton;
        buttonGrid[2][0] = sevenButton;
        buttonGrid[2][1] = eightButton;
        buttonGrid[2][2] = nineButton;

        quitButton = new JButton("Quit");
        quitButton.addActionListener(quit);

        winOption = new JOptionPane(player + " wins");
        tieOption = new JOptionPane("You tied");
        errorOption = new JOptionPane("You cannot move there!");

        add(mainPanel);
        mainPanel.setLayout(new GridLayout(3,1,0,30));
        mainPanel.add(titlePanel);
        mainPanel.add(infoPanel);
        mainPanel.add(buttonPanel);

        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.add(titleLabel);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));

        infoPanel.setLayout(new GridLayout(1,3));
        infoPanel.add(playerOnePanel);
        infoPanel.add(gamePanel);
        infoPanel.add(playerTwoPanel);

        playerOnePanel.setLayout(new GridLayout(2,1));
        playerOnePanel.add(playerOneLabel);
        playerOneLabel.setHorizontalAlignment(JLabel.CENTER);
        playerOneLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        playerOnePanel.add(playerOneText);
        playerOneText.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));

        gamePanel.setLayout(new GridLayout(3,3));
        gamePanel.add(oneButton);
        gamePanel.add(twoButton);
        gamePanel.add(threeButton);
        gamePanel.add(fourButton);
        gamePanel.add(fiveButton);
        gamePanel.add(sixButton);
        gamePanel.add(sevenButton);
        gamePanel.add(eightButton);
        gamePanel.add(nineButton);
        oneButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        twoButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        threeButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        fourButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        fiveButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        sixButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        sevenButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        eightButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        nineButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        oneButton.addActionListener(move);
        twoButton.addActionListener(move);
        threeButton.addActionListener(move);
        fourButton.addActionListener(move);
        fiveButton.addActionListener(move);
        sixButton.addActionListener(move);
        sevenButton.addActionListener(move);
        eightButton.addActionListener(move);
        nineButton.addActionListener(move);

        playerTwoPanel.setLayout(new GridLayout(2,1));
        playerTwoPanel.add(playerTwoLabel);
        playerTwoLabel.setHorizontalAlignment(JLabel.CENTER);
        playerTwoLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        playerTwoPanel.add(playerTwoText);
        playerTwoText.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));

        buttonPanel.setLayout(new GridLayout(1,2,10,0));
        buttonPanel.add(newGameButton);
        newGameButton.addActionListener(newGame);
        newGameButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        buttonPanel.add(quitButton);
        quitButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));

        playerOneText.setText("It's your turn!");
        playerTwoText.setText("");
    }

    public class moveListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            JButton src = (JButton) AE.getSource();
            player = nextPlayer;
            if(src.getText().equals("_"))
            {
                for(int row = 0; row < ROW; row++)
                {
                    for(int col = 0; col < COL; col++)
                    {
                        if (buttonGrid[row][col] == src) {
                            src.setText(player);
                            if (player.equals("X"))
                            {
                                nextPlayer = "O";
                                playerTwoText.setText("It's your turn!");
                                playerOneText.setText("");
                            }
                            else {
                                nextPlayer = "X";
                                playerOneText.setText("It's your turn!");
                                playerTwoText.setText("");
                            }
                            board[row][col] = player;
                            if (isWin("X"))
                            {
                                JOptionPane.showMessageDialog(null, "X wins!");
                                oneButton.setEnabled(false);
                                twoButton.setEnabled(false);
                                threeButton.setEnabled(false);
                                fourButton.setEnabled(false);
                                fiveButton.setEnabled(false);
                                sixButton.setEnabled(false);
                                sevenButton.setEnabled(false);
                                eightButton.setEnabled(false);
                                nineButton.setEnabled(false);
                            }
                            else if (isWin("O"))
                            {
                                JOptionPane.showMessageDialog(null, "O wins!");
                                oneButton.setEnabled(false);
                                twoButton.setEnabled(false);
                                threeButton.setEnabled(false);
                                fourButton.setEnabled(false);
                                fiveButton.setEnabled(false);
                                sixButton.setEnabled(false);
                                sevenButton.setEnabled(false);
                                eightButton.setEnabled(false);
                                nineButton.setEnabled(false);
                            }
                            else if (isTie())
                            {
                                JOptionPane.showMessageDialog(null, "It's a tie!");
                                oneButton.setEnabled(false);
                                twoButton.setEnabled(false);
                                threeButton.setEnabled(false);
                                fourButton.setEnabled(false);
                                fiveButton.setEnabled(false);
                                sixButton.setEnabled(false);
                                sevenButton.setEnabled(false);
                                eightButton.setEnabled(false);
                                nineButton.setEnabled(false);
                            }
                        }
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You cannot select this tile!");
                if(player.equals("O"))
                {
                    playerTwoText.setText("It's your turn!");
                    playerOneText.setText("");
                }
                else if (player.equals("X"))
                {
                    playerOneText.setText("It's your turn!");
                    playerTwoText.setText("");
                }
            }
        }
    }
    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COL; col++)
        {
            if(buttonGrid[0][col].getText().equals(player) && buttonGrid[1][col].getText().equals(player) && buttonGrid[2][col].getText().equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isRowWin(String player)
    {
        for(int row = 0; row < ROW; row++)
        {
            if(buttonGrid[row][0].getText().equals(player) && buttonGrid[row][1].getText().equals(player) && buttonGrid[row][2].getText().equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagonalWin(String player){
        if(buttonGrid[0][0].getText().equals(player) && buttonGrid[1][1].getText().equals(player) && buttonGrid[2][2].getText().equals(player))
        {
            return true;
        }
        else if(buttonGrid[0][2].getText().equals(player) && buttonGrid[1][1].getText().equals(player) && buttonGrid[2][0].getText().equals(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isTie()
    {
        String player = "X";
        boolean isFilled = true;
        boolean isWin = false;

        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                if(buttonGrid[row][col].getText().equals("_"))
                {
                    isFilled = false;
                }
            }
        }

        if(isWin("X") || isWin("Y"))
        {
            isWin = true;
        }

        if(isFilled && !isWin)
        {
            return true;
        }

        return false;
    }

    private class newGameListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            playerOneText.setText("It's your turn!");
            playerTwoText.setText("");
            oneButton.setText("_");
            twoButton.setText("_");
            threeButton.setText("_");
            fourButton.setText("_");
            fiveButton.setText("_");
            sixButton.setText("_");
            sevenButton.setText("_");
            eightButton.setText("_");
            nineButton.setText("_");
            player = "X";
            nextPlayer = "X";
            oneButton.setEnabled(true);
            twoButton.setEnabled(true);
            threeButton.setEnabled(true);
            fourButton.setEnabled(true);
            fiveButton.setEnabled(true);
            sixButton.setEnabled(true);
            sevenButton.setEnabled(true);
            eightButton.setEnabled(true);
            nineButton.setEnabled(true);
        }
    }
    private class quitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            System.exit(0);
        }
    }
}