package com.chess.gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.imageio.ImageIO;
import java.io.File;
import com.chess.engine.classic.board.Move;
import com.chess.engine.classic.pieces.Piece;
import com.chess.gui.Table.MoveLog;
import com.google.common.primitives.Ints;
class TakenPiecesPanel extends JPanel{
    private final JPanel northPanel;
    private final JPanel southPanel;
    private static final long serialVersionUID=1L;
    private static final Color PANE_COLOR=Color.decode("0xFDF5E6");
    private static final Dimension TAKEN_PIECES_DIMENSION=new Dimension(40,80);
    private static final EtchedBorder PANEL_BORDER=new EtchedBorder(EtchedBorder.RAISED);

    
}
