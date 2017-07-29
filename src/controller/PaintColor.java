package controller;

import java.awt.Color;

public enum PaintColor {
	BLACK {
		public Color getColor() {
			return Color.BLACK;
		}
		
		public String toString() {
			return "BLACK";
		}
	},
	BLUE {
		public Color getColor() {
			return Color.BLUE;
		}
		
		public String toString() {
			return "BLUE";
		}
	},
	RED {
		public Color getColor() {
			return Color.RED;
		}
		
		public String toString() {
			return "RED";
		}
	},
	GREEN {
		public Color getColor() {
			return Color.GREEN;
		}
		
		public String toString() {
			return "GREEN";
		}
	};
}
