package game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideBar extends JPanel
{
    private static long totalTimePassed = -1;
    private static long totalTimeWhite = 0;
    private static long totalTimeBlack = 0;

    private static Font font = new Font("Serif", Font.BOLD, 26);
    private static JLabel timePassedLable;
    private static JLabel white;
    private static JLabel black;

    Border blackline = BorderFactory.createLineBorder(Color.black,5);


    public SideBar()
    {
        startTime();

        this.setBackground(new Color(72,124,70));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel timeHeader = new JLabel("Total Time");
        timeHeader.setFont(font);
        timeHeader.setForeground(Color.BLACK);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(205,0,0,0);
        this.add(timeHeader,c);

        timePassedLable = new JLabel("00:00:00");
        timePassedLable.setFont(font);
        timeHeader.setForeground(Color.BLACK);
        c.gridy = 1;
        c.insets = new Insets(10,0,40,0);
        this.add(timePassedLable,c);

        c.gridwidth = 1;
        white = new JLabel("White: 00:00:00");
        white.setFont(font);
        white.setForeground(Color.BLACK);
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(10,20,10,15);
        this.add(white,c);

        black = new JLabel("Black: 00:00:00");
        black.setFont(font);
        black.setForeground(Color.BLACK);
        c.gridy = 3;
        c.insets = new Insets(10,20,10,15);
        this.add(black,c);

        JButton undo = new JButton("Undo");
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 4;
        c.insets = new Insets(0,15,145,0);
        this.add(undo,c);

        JButton restart = new JButton("New Game");
        c.gridx = 1;
        this.add(restart,c);

        this.setBorder(blackline);

        restart.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Board.getInstance().resetBoard();
                resetTime();
            }
        });
    }

    private void startTime()
    {
        int delay = 1000; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateTotalTime();
                if(Game.getCurrentPlayer() == Team.WHITE)
                    updateWhitePlayerTime();
                else
                    updateBlackPlayerTime();
            }
        };
        new Timer(delay, taskPerformer).start();
    }

    private void updateWhitePlayerTime()
    {
        totalTimeWhite = totalTimePassed - totalTimeBlack;
        white.setText("White: " + longToDate(totalTimeWhite));
    }

    private void updateBlackPlayerTime()
    {
        totalTimeBlack = totalTimePassed - totalTimeWhite;
        black.setText("Black: " + longToDate(totalTimeBlack));
    }

    private void updateTotalTime()
    {
        ++totalTimePassed;
        timePassedLable.setText(longToDate(totalTimePassed));
    }

    private void resetTime()
    {
        totalTimePassed = 0;
        totalTimeWhite = 0;
        totalTimeBlack = 0;
        updateBlackPlayerTime();
        updateBlackPlayerTime();
        updateTotalTime();
    }

    private String longToDate(long totalSeconds)
    {
        String hour = String.format("%02d" ,(totalSeconds / 3600));
        String min = String.format("%02d" ,(totalSeconds / 60) % 60);
        String sec = String.format("%02d" ,totalSeconds % 60);
        return hour + ":" + min + ":" + sec;
    }
}
