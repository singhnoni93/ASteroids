package com.mycompany.a2.GameView;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.Border;

public class Mylabel extends Label{
	public Mylabel() {
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
	}
	public Mylabel(String label) {
		super(label);;
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
	}
}
