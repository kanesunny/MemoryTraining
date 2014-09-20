import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.ImageIcon;



public class Traverse {
	public ArrayList<Integer> Shuffle(ArrayList<Integer> arrayList){
		ArrayList<Integer> cards = new ArrayList<Integer>();
		for(int i=0;i<arrayList.size();i++){
			cards.add(arrayList.get(i));
		}			
		Collections.shuffle(cards);
		return cards;
	}
	
	public HashMap<Integer,ImageIcon> traverseFolder1(String path) {
		HashMap<Integer,ImageIcon> hs = new HashMap<Integer,ImageIcon>();
		int fileNum = 0, folderNum = 0;
		File file = new File(path);
		if (file.exists()) {
			LinkedList<File> list = new LinkedList<File>();
			File[] files = file.listFiles();
			int i=0;
			for (File file2 : files) {
				if (file2.isDirectory()) {
					System.out.println("文件夹:" + file2.getAbsolutePath());
					list.add(file2);
					folderNum++;
				} else {
				//	System.out.println("文件:" + file2.getAbsolutePath());
					fileNum++;
			        ImageIcon icon = new ImageIcon(file2.getAbsolutePath());
				    Image image = icon.getImage(); // transform it 
			        Image newimg = image.getScaledInstance(210, 310,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				    icon = new ImageIcon(newimg);
					hs.put(i++,icon);
				//	System.out.println(hs);
				}
			}
			File temp_file;
			while (!list.isEmpty()) {
				temp_file = list.removeFirst();
				files = temp_file.listFiles();
				for (File file2 : files) {
					if (file2.isDirectory()) {
						System.out.println("文件夹:" + file2.getAbsolutePath());
						list.add(file2);
						fileNum++;
					} else {
						System.out.println("文件:" + file2.getAbsolutePath());
						folderNum++;
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
		System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
		return hs;
	}
}
