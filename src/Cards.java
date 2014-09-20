import java.util.ArrayList;
import java.util.Collections;


public class Cards implements Shufflable{
	public ArrayList<Integer> arrList= new ArrayList<Integer>();
    public Cards(){
		for(int i=0;i<54;i++){
			arrList.add(i);
		}
	}
    public Cards(ArrayList<Integer> source){
		for(int i=0;i<source.size();i++){
			arrList.add(source.get(i));
		}
    }
    public ArrayList<Integer> getCards(){
    	return arrList;
    }
    
    public ArrayList<Integer> Shuffle(ArrayList<Integer> source){
    	Collections.shuffle(source);
    //	for(Integer i: source){
    	//	System.out.print(i);
    //	}
    	return source;
    }
}
