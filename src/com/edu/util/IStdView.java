package com.edu.util;

import java.awt.Color;
import java.awt.Font;
//Swing界面标准化
public interface IStdView {
	Font topicFont = new Font("黑体", Font.BOLD, 32);
	Font normalFont = new Font("宋体", Font.PLAIN, 16);
	Font buttonFont = new Font("宋体", Font.PLAIN, 14);
	Font smallFont = new Font("宋体", Font.PLAIN, 12);
	Font passwordfont = new Font("微软雅黑", Font.BOLD,22);
	
	Color topicColor = new Color(8, 23, 222);
	
	default void init() {
		initView();
		reinitView();
		addEventListener();
	}
	
	void initView();
	void reinitView();
	void addEventListener();
	void showView();
	void closeView();
}