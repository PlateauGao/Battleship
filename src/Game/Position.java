package Game;

public class Position {
	int x;
	int y;
	int setable;
	int attacked=0;

	public Position(int a,int b,int c){
		x=a;
		y=b;
		setable=c;
	}
	public int getxposition(){
		return x;
	}
	public int getyposition(){
		return y;
	}
	public int shipissetable(){
		return setable;
	}
	public void setship(){
		setable=setable-1;
	}
	public void beattacked(){
		attacked++;
	}
	public int attacked(){
		return attacked;
	}
	
}
