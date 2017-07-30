package controller;

import java.awt.Color;

public enum PaintColor {
	BLACK {
		public Color getColor() {
			return Color.BLACK;
		}
	},
	BLUE {
		public Color getColor() {
			return Color.BLUE;
		}
	},
	CYAN {
		public Color getColor() {
			return Color.CYAN;
		}
	},
	DARK_GRAY {
		public Color getColor() {
			return Color.DARK_GRAY;
		}
		
		public String toString() {
			return "DARK GRAY";
		}
	},
	GRAY {
		public Color getColor() {
			return Color.GRAY;
		}
	},
	GREEN {
		public Color getColor() {
			return Color.GREEN;
		}
	},
	LIGHT_GRAY {
		public Color getColor() {
			return Color.LIGHT_GRAY;
		}
		
		public String toString() {
			return "LIGHT GRAY";
		}
	},
	MAGENTA {
		public Color getColor() {
			return Color.MAGENTA;
		}
	},
	ORANGE {
		public Color getColor() {
			return Color.ORANGE;
		}
	},
	PINK {
		public Color getColor() {
			return Color.PINK;
		}
	},
	RED {
		public Color getColor() {
			return Color.RED;
		}
	},
	WHITE {
		public Color getColor() {
			return Color.WHITE;
		}
	},
	YELLOW {
		public Color getColor() {
			return Color.YELLOW;
		}
	};
	
	public abstract Color getColor();
}
