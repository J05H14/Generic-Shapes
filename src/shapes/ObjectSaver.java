package shapes;

import java.io.*;
import java.util.*;


public class ObjectSaver <E>{

	private File file;

	public ObjectSaver(File file){
		this.file = file;
	}

	@SuppressWarnings({ "unchecked" })
	public E readOneObject(int desired) throws IOException{
		ObjectInputStream in = null;
		E object;
		E result = null;
		int count = 1;

		try{
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

			while((object = (E) in.readObject()) != null){
				result = object;
				
				if(count == desired){
					break;
				}
				count++;
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<E> readAllObjects(){
		ObjectInputStream in = null;
		ArrayList<E> list = new ArrayList<E>();
		E object;
		
		try{
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			
			while((object = (E) in.readObject()) != null) {
				list.add(object);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public void writeAllObjects(ArrayList<E> list, boolean noOverwrite) throws NotSerializableException{
		ObjectOutputStream out = null;
		
		
		if(noOverwrite){
			
		}
		else{
			try{
				out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

				for(int i = 0; i < list.size(); i++){
					out.writeObject(list.get(i));
				}
				
				out.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	} 
	
	public void writeOneObject(E writeObj, boolean noOverwrite){
		ObjectOutputStream out = null;
		
		if(noOverwrite){
			
		}
		else{
			try {
				out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				out.writeObject(writeObj);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
