package shapes;

import java.io.*;
import java.util.*;

import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) {
		Cone cone1 = new Cone(5, 2.5);
		Ellipsoid e1 = new Ellipsoid(2.0,5.0,1.3);
		Sphere s1 = new Sphere(5.3);
		File file = null;
		ObjectSaver<Shape> objSaver = null;
		
		ArrayList<Shape> list = new ArrayList<Shape>();
		list.add(cone1);
		list.add(s1);
		list.add(e1);
		
		JFileChooser fc = new JFileChooser();
		int retVal = fc.showOpenDialog(null);

		if (retVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			objSaver = new ObjectSaver<Shape>(file);
		}
		//System.out.println("LIST " + list);
		
		try {
			System.out.println(objSaver.readOneObject(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print(objSaver.readAllObjects());
		print(list);
		
		try {
			objSaver.writeAllObjects(list, true);
		} catch (NotSerializableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		objSaver.writeOneObject(s1, false);
		
//		list = ShapeUtilities.recursiveSort(list);
//		print(list);
//		
		list = ShapeUtilities.recursiveSort(list);
		print(list);
	
		System.out.println(ShapeUtilities.min(list));
		System.out.println(ShapeUtilities.max(list));
//		System.out.println("Sorted " + ShapeUtilities.recursiveSort(list));
//		System.out.println("Sorted " + ShapeUtilities.recursiveSort(list));
//		System.out.println("Sorted " + ShapeUtilities.recursiveSort(list));
////		System.out.println("Min " + ShapeUtilities.min(list));
//		System.out.println("Max " + ShapeUtilities.max(list));
//		System.out.println("LIST " + list);
		//System.out.println(objSaver.readAllObjects());
		
		
		
		
	}
	
	public static void print(ArrayList<Shape> list) {
		for (Shape s : list) {
			System.out.println(s);
		}
	}

}
