package com.nosheep.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Input {
	public Input() {
	}
	
	public boolean checkRemove(){
		if(Gdx.input.isKeyJustPressed(Keys.BACKSPACE))
			return true;
		return false;
	}
	
	public char listen() {
		if (Gdx.input.isKeyJustPressed(Keys.A)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'A';
			return 'a';
		}
		else if (Gdx.input.isKeyJustPressed(Keys.B)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'B';
			return 'b';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.C)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'C';
			return 'c';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.D)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'D';
			return 'd';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.E)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'E';
			return 'e';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.F)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'F';
			return 'f';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.G)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'G';
			return 'g';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.H)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'H';
			return 'h';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.I)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'I';
			return 'i';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.J)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'J';
			return 'j';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.K)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'K';
			return 'k';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.L)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'L';
			return 'l';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.M)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'M';
			return 'm';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.N)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'N';
			return 'n';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.O)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'O';
			return 'o';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.P)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'P';
			return 'p';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.Q)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'Q';
			return 'q';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.R)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'R';
			return 'r';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.S)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'S';
			return 's';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.T)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'T';
			return 't';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.U)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'U';
			return 'u';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.V)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'V';
			return 'v';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.W)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'W';
			return 'w';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.X)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'X';
			return 'x';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.Y)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'Y';
			return 'y';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.Z)){
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
				return 'Z';
			return 'z';}
			
		else if (Gdx.input.isKeyJustPressed(Keys.PERIOD))
			return '.';
		else if (Gdx.input.isKeyPressed(Keys.ALT_LEFT) ||
				Gdx.input.isKeyPressed(Keys.ALT_RIGHT)){
			if(Gdx.input.isKeyJustPressed(Keys.NUM_2))
				return '@';
		}
		else if (Gdx.input.isKeyJustPressed(Keys.NUM_0))
			return '0';
		else if (Gdx.input.isKeyJustPressed(Keys.NUM_1))
			return '1';
		else if (Gdx.input.isKeyJustPressed(Keys.NUM_2))
			return '2';
		else if (Gdx.input.isKeyJustPressed(Keys.NUM_3))
			return '3';
		else if (Gdx.input.isKeyJustPressed(Keys.NUM_4))
			return '4';
		else if (Gdx.input.isKeyJustPressed(Keys.NUM_5))
			return '5';
		else if (Gdx.input.isKeyJustPressed(Keys.NUM_6))
			return '6';
		else if (Gdx.input.isKeyJustPressed(Keys.NUM_7))
			return '7';
		else if (Gdx.input.isKeyJustPressed(Keys.NUM_8))
			return '8';
		else if (Gdx.input.isKeyJustPressed(Keys.NUM_9))
			return '9';

		return '´';
	}

}
