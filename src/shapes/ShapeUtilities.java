package shapes;

import java.util.ArrayList;

//Couldn't figure out what was missing to make the recursiveSort method work as intended

public class ShapeUtilities{

	public static <E extends Shape> ArrayList<E> recursiveSort(ArrayList<E> shapes){
		int middle;
		E mid;

		if(shapes.size() <= 1){
			return shapes;
		}
		else{
			//if(shapes.size() % 2 == 0){
				middle = shapes.size() / 2;
			//}
			//else{
				//middle = (shapes.size() + 1) / 2;
			//}

			mid = shapes.get(middle);

			shapes.remove(mid);

			ArrayList<E> leftList = new ArrayList<E>();
			ArrayList<E> rightList = new ArrayList<E>();

			for(int i = 0; i < shapes.size(); i++){
				if(Double.compare(shapes.get(i).getVolume(), mid.getVolume()) < 0){
					rightList.add(shapes.get(i));
				}
				else{
					leftList.add(shapes.get(i));
				}
			}
			ArrayList<E> sortedList = new ArrayList<E>(recursiveSort(leftList));
			sortedList.add(mid);
			sortedList.addAll(recursiveSort(rightList));

			return sortedList;
		}
	}

	public static <E extends Shape> Shape min(ArrayList<E> shapes){
		return recursiveSort(shapes).get(shapes.size());
	}
	public static <E extends Shape> Shape max(ArrayList<E> shapes){
		return recursiveSort(shapes).get(0);
	}
}
