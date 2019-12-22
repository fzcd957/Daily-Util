package com.edu.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
//模态框
public class WaittingDialog extends JDialog implements Runnable{

	private static final Font normalFont = new Font("楷体", Font.BOLD, 16);
	private static final int normalFontSize = normalFont.getSize();
	
		public WaittingDialog initDigalog(String message) {
			int width = (int) (message.length()*1.5*normalFontSize);
			int height = 5*normalFontSize;
			
			setSize(width, height);
			setLocationRelativeTo(getOwner());  //将diglog放入它的父窗体
			setUndecorated(true);   //让窗口失去边框的控制
			
			JPanel jPanel = new JPanel(new BorderLayout());
			jPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
			add(jPanel);
			
			JLabel jLabel = new JLabel(message,JLabel.CENTER);
			jLabel.setFont(normalFont);
			jPanel.add(jLabel,"Center");
				
			return this;
		}
	public void Showdialog() {
		new Thread(this,"模态对话框").start();
	}
	public void closeDialog() {
		 dispose();
	}

	
	public WaittingDialog() {
		super();
	}
	public WaittingDialog(Dialog owner, boolean modal) {
		super(owner, modal);
	}
	public WaittingDialog(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
	}
	public WaittingDialog(Dialog owner, String title, boolean modal) {
		super(owner, title, modal);
	}
	public WaittingDialog(Dialog owner, String title) {
		super(owner, title);
	}
	public WaittingDialog(Dialog owner) {
		super(owner);
	}
	public WaittingDialog(Frame owner, boolean modal) {
		super(owner, modal);
	}
	public WaittingDialog(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
	}
	public WaittingDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
	}
	public WaittingDialog(Frame owner, String title) {
		super(owner, title);
	}
	public WaittingDialog(Frame owner) {
		super(owner);
	}
	public WaittingDialog(Window owner, ModalityType modalityType) {
		super(owner, modalityType);
	}
	public WaittingDialog(Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) {
		super(owner, title, modalityType, gc);
	}
	public WaittingDialog(Window owner, String title, ModalityType modalityType) {
		super(owner, title, modalityType);
	}
	public WaittingDialog(Window owner, String title) {
		super(owner, title);
	}
	public WaittingDialog(Window owner) {
		super(owner);
	}
	@Override
	public void run() {
		setVisible(true);
		
	}
	   
}
